package Anny;

public class Animal {

	 int noOfLegs;
	 public Animal(){
		 System.out.println("Parent class Constructor");
	 }
	 
	public int getNoOfLegs() {
		return noOfLegs;
	}

	public void setNoOfLegs(int noOfLegs) {
		this.noOfLegs = noOfLegs;
	}
	
	public String name(String s){
		
		return s;
	}

	/*public int getNoOfLegs() {
		return noOfLegs;
	}

	public void setNoOfLegs(int noOfLegs) {
		this.noOfLegs = noOfLegs;
	}*/
	
	
}
