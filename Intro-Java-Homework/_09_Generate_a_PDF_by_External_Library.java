//	This program depends on the external itextpdf library, which you need to get from
//	https://mega.co.nz/#F!zIVhgYpD!cfgkETSYgD9HJZmItP8Vsg
//	Just put the files in the project's lib directory.
//	This is also needed to make the "Generate_a_PDF_by_External_Library"
//	jar and exe files run correctly.
//	The final result should be identical to the provided Sample.pdf.

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Font;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class _09_Generate_a_PDF_by_External_Library {
	public static void main(String[] args) throws
	FileNotFoundException, DocumentException, IOException {
//		Prepare a PdfWriter and open an empty document for editing.
		Document doc = new Document();
		try (FileOutputStream fos = new FileOutputStream("Cards.pdf")) {
			PdfWriter.getInstance(doc, fos);
			doc.open();
//			Create the table placeholder.
			PdfPTable table = null;
//			Start with a black card.
			boolean isRed = false;
//			Generate the deck.
			for (int cardIndex = 0; cardIndex < 52; cardIndex++) {
				String card = getCard(cardIndex);
				if (cardIndex % 4 == 0) {
					table = makeNewTable();
				}			
				PdfPCell cardCell = drawCard(card, isRed);
//				Add the current card's cell to the table and if the
//				current face is not yet complete also add a spacer without border.
				table.addCell(cardCell);
				if (cardIndex % 4 != 3) {					
					PdfPCell spacerCell = new PdfPCell();
					spacerCell.setBorderWidth(0);
					table.addCell(spacerCell);
				}
//				If the current face is complete, add the finished table to the document.
				else {
					doc.add(table);
				}
//				Swap the color for the next card.
				isRed = !isRed;
			}
//			Close document and print successful exit message.
			doc.close();
			System.out.println("Cards printed to \"Cards.pdf\".");
		}		
	}
	
//	Generate a string with the card's face and suite from its index.
	private static String getCard(int cardIndex) {
		String card;
		
		int faceNum = (cardIndex / 4) + 2;
		switch (faceNum) {
		case 11:
			card = "J"; break;
		case 12:
			card = "Q"; break;
		case 13:
			card = "K"; break;
		case 14:
			card = "A"; break;
		default:
			card = Integer.toString(faceNum); break;
		}
		
		int suiteNum = cardIndex % 4;
		switch (suiteNum) {
		case 0:
			card += "♠"; break;
		case 1:
			card += "♥"; break;
		case 2:
			card += "♣"; break;
		case 3:
			card += "♦"; break;
		}
		return card;
	}

//	Format a table to hold the next 4 cards and 3 narrower spacer cells in-between.
	private static PdfPTable makeNewTable() throws DocumentException {
		PdfPTable table;
		table = new PdfPTable(7);
		table.setWidths(new int[] {3, 2, 3, 2, 3, 2, 3});
		table.setWidthPercentage(80);
		table.setSpacingAfter(10);
		return table;
	}
	
//	Create the actual card cell.
	private static PdfPCell drawCard(String card, boolean isRed) throws
	DocumentException, IOException {
//		Pick and set up a unicode font with card suite symbols.
		BaseFont dejaVu = BaseFont.createFont("DejaVuSans.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font dejaVuB = new Font(dejaVu, 15, Font.BOLD);
//		Default font is black, so change it to red if necessary.
		if (isRed) {
			dejaVuB.setColor(255, 0, 0);
		}
//		Format the cell with a border and center the text.
		PdfPCell cardCell = new PdfPCell(new Phrase(card, dejaVuB));
		cardCell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
		cardCell.setVerticalAlignment(Phrase.ALIGN_MIDDLE);
		cardCell.setFixedHeight(100);
		cardCell.setBorderWidth(1);
		return cardCell;
	}
}