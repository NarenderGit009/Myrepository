package Anny;

public class Encapsulation {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public static void main(String[] args) {
		
		Encapsulation en = new Encapsulation();
		en.setBalance(00.12);
		System.out.println("Get balance"+en.getBalance());
		
	}
	
}
