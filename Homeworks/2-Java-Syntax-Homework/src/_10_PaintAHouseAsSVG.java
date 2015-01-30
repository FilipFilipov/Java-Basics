//	This program depends on the external library
//	Apache Batik, which you need to get from
//	https://mega.co.nz/#F!XZVFgK5A!OIFj5SjgYFL12Ka2_KsFVQ
//	Note: This is not the whole library, just the parts this task needs.
//	Just put the files in the project's lib directory.
//	The final result should be identical to the provided Sample.html.

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.ext.awt.geom.Polygon2D;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public class _10_PaintAHouseAsSVG {
//	Set up a static placeholder SVG graphics object
//	to do the drawing without passing it to every method.
	private static SVGGraphics2D svg2d;
	
	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.ROOT);
//		Set up an empty SVG document with the desired dimensions.
		DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
		Document doc = domImpl.createDocument(null, "svg", null);
		svg2d = new SVGGraphics2D(doc);
		svg2d.setSVGCanvasSize(new Dimension(500, 450));
		paintHouse();
		paintGrid();
		processDots();
		
//		Stream the finished SVG graphic to an
//		HTML file and print a successful exit message.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("house.html"))) {
			svg2d.stream(bw);
			System.out.println("SVG printed to \"house.html\".");
		}
		catch (IOException e) {
			System.err.println("Error");
		}
	}

	public static void paintHouse() {
//		Because we draw in the input's coordinate system (x10, so it's all integers),
//		the final picture will be too small and far to the right and a bit low.
//		These transformations correct that by offsetting and then multiplying
//		the coordinates in all the subsequent commands.
		svg2d.translate(-150, -25);
		svg2d.scale(2.5, 2.5);
		
//		Define the house's basic shape.
		Rectangle lRect = new Rectangle(125, 85, 50, 50);
		Rectangle rRect = new Rectangle(200, 85, 25, 50);
//		Using batik's own polygon implementation, because
//		native Java requires repeating the first coordinates
//		again at the end, or the figure will not close.
		Polygon2D triangle = new Polygon2D(new int[] {125, 175, 225}, new int[] {85, 35, 85}, 3);
		
//		Fill the house parts with a semi-transparent perfectly mid-tone gray color.
		svg2d.setColor(new Color(0x80808080, true));
		svg2d.fill(lRect);
		svg2d.fill(rRect);
		svg2d.fill(triangle);
		
//		Outline the house with thick dark blue lines with non-rounded un-extended corners.
		svg2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		svg2d.setColor(new Color(0x002060));
		svg2d.draw(lRect);
		svg2d.draw(rRect);
		svg2d.draw(triangle);
	}

	public static void paintGrid(){
//		Set up the resources to draw the grid of light blue dashed lines and black labels.
//		The x and y values are used to get both the drawing positions and number label text.
		int x = 100;
		int y = 35;
		Color lBlue = new Color(0x5b9bd5);		
		BasicStroke dashedStroke = new BasicStroke(0.3f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 1, new float[]{1}, 0);
		BasicStroke drawingStroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
		svg2d.setFont(new Font("Arial", Font.PLAIN, 10));
		
		for (int i = 0; i < 6; i++) {
//			Draw one vertical and one horizontal line.
			svg2d.setStroke(dashedStroke);
			svg2d.setColor(lBlue);
			Line2D vLine = new Line2D.Float(x, 25, x, 170);
			Line2D hLine = new Line2D.Float(90, y, 235, y);		
			svg2d.draw(vLine);
			svg2d.draw(hLine);
			
//			Draw the label numbers for the two line without decimal zeros
//			if they are integers.
			svg2d.setStroke(drawingStroke);
			svg2d.setColor(Color.BLACK);			
			String hLabel = (x % 10 == 0) ? ("" + x / 10) : ("" + x / 10f);
			String vLabel = (y % 10 == 0) ? ("" + y / 10) : ("" + y / 10f);
			
//			Adjust the drawing coordinates, since the
//			painting method will take the input as the upper left point
//			of the drawn object and we want center- or right-aligned text.
			int hLabelWidth = svg2d.getFontMetrics().stringWidth(hLabel);
			int vLabelWidth = svg2d.getFontMetrics().stringWidth(vLabel);
			svg2d.drawString(hLabel, x - hLabelWidth / 2f, 20);
			svg2d.drawString(vLabel, 87 - vLabelWidth, y + 3);
			
			x += 25;
			y += 25;
		}
	}

	private static void processDots() {
//		Take input coordinates and check if they are inside the house, same as the last task.
		Scanner input = new Scanner(System.in);
		System.out.print("How many dots do you want to check? ");
		int n = input.nextInt();
		System.out.println("Enter coordinates to check if points are inside house:");
		for (int i = 0; i < n; i++) {			
			double x = input.nextDouble();
			double y = input.nextDouble();		
			boolean isInside =
					isInTriangle(x, y) ||
					(x >= 12.5 && x <= 17.5 && y >= 8.5 && y<= 13.5) ||
					(x >= 20 && x <= 22.5 && y >= 8.5 && y <= 13.5);
			paintDot(x, y, isInside);
		}
	}	

	private static boolean isInTriangle(double x, double y) {
		Point2D p1 = new Point2D.Double(12.5, 8.5);
		Point2D p2 = new Point2D.Double(17.5, 3.5);
		Point2D p3 = new Point2D.Double(22.5, 8.5);		
		boolean b1 = getLineSide(x, y, p1, p2) >= 0;
		boolean b2 = getLineSide(x, y, p2, p3) >= 0;
		boolean b3 = y <= 8.5;
		return b1 && b2 && b3;
	}				

//	Positive result means the point is to the right of the line,
//	negative means to the left, zero means the point is part of the line.
//	The line's "forward" direction is defined as p1 -> p2, so in a closed
//	non-intersecting polygon, an inside point should give the
//	same-signed result for all the lines.
	private static double getLineSide(double x, double y, Point2D p1, Point2D p2) {
		return (x - p2.getX()) * (p1.getY() - p2.getY()) -
				(p1.getX() - p2.getX()) * (y - p2.getY());
	}

	private static void paintDot(double x, double y, boolean inside) {
		int diameter = 3;
		
//		Define the dot, displacing it up and to the left by half its size,
//		so the center point will match the input coordinates when drawn.
		Ellipse2D dot = new Ellipse2D.Double(x * 10 - diameter / 2f, y * 10 - diameter / 2f, diameter, diameter);
		
//		Outline the dot with a thin black line, even if it will be a
//		black circle, so that the gray and black point are the same
//		size in the end.
		svg2d.setStroke(new BasicStroke(0.3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		svg2d.setColor(Color.BLACK);
		svg2d.draw(dot);
		
//		Fill the outline with a black or gray color, depending on the earlier calculations.
		if (!inside) {
			svg2d.setColor(new Color(0xbfbfbf));			
		}
		svg2d.fill(dot);
	}
}