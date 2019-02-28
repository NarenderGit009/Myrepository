package Anny;


class First{
	
	//this instance variable is visible for any child classes
	public String name;
	
	static String sum="name ";
	static String sal="Salary :";
	// the salary variable visible in First class only.
	private double salary;
	
	//The name variable assignedin the constructor
	public First(String empName){
		name= empName;
	}
	
	//the salary variable assigned a value
	public void setSalary(double empSal){
		salary=empSal;
	}
	
	//this method will prints the employee details
	public void pirintDetails(){
		System.out.println("name "+name);
		System.out.println("Salary : "+salary);
		
	}
	
	
	public static void main(String[] args) {
	
		First f=new First("Anny");
		f.setSalary(100000);
		f.pirintDetails();
	}
	
	
	
	
	
}
