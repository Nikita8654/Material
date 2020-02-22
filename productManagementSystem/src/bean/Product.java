package bean;

public class Product {
	
	private String productId,colour,dimension,specification,manufacturer,productName;
	private double price;
	private int quantity,productCategory;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", colour=" + colour + ", dimension=" + dimension
				+ ", specification=" + specification + ", manufacturer=" + manufacturer + ", productName=" + productName
				+ ", price=" + price + ", quantity=" + quantity + ", productCategory=" + productCategory + "]";
	}


	public Product(String productId, String colour, String dimension, String specification, String manufacturer,
			String productName, double price, int quantity, int productCategory) {
		super();
		this.productId = productId;
		this.colour = colour;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productCategory = productCategory;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}
	
	

}
