public class Product implements Comparable<Product>{
	private String name;
	private double price;
	
	public String getName() {
		return name;
	}	
	public double getPrice() {
		return price;
	}
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public int compareTo(Product product) {
		if (this.price > product.getPrice()) {
			return 1;
		}
		else if (this.price < product.getPrice()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}