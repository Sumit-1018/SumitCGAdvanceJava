package in.cg.beans;

public class Student {
	private int id;
	private String name;
	private String email;
	private Address a;
	
	
	public Student(int id,String name,String email, Address a) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.a=a;
	}
	
	public void display() {
		System.out.println("Id: "+id);
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
		System.out.println("Address: "+a);
	}
	
}
