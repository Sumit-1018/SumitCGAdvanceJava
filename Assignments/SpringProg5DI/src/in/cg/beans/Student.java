package in.cg.beans;

public class Student {
	private int id;
	private String name;
	private String email;
	private Address a;
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setA(Address a) {
		this.a=a;
	}
	
	public void display() {
		System.out.println("Id: "+id);
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
		System.out.println("Address: "+a);
	}
	
}
