package Meme;

public class Laptop{// implements Comparable<Laptop>{

	private String brand;
	private int ram;
	private int price;
	
	
	public Laptop(String brand, int ram, int price) {
		super();
		this.brand = brand;
		this.ram = ram;
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", ram=" + ram + ", price=" + price + "]";
	}
	/*@Override
	public int compareTo(Laptop lap1) {
		//this>lap1 = 1
		//this<lap1=-1
		//this==ap1 == 0
		
		if(this.getRam()<lap1.getRam())
			return 1;
			else
				return -1;
		
		
	}*/
	
	
}
