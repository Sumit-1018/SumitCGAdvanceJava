package in.cg.beans;

public class Student {

	private int id;
	private String name;
	private String email;
	private Address addr;

	public Student(int id, String name, String email, Address addr) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.addr = addr;
	}
	
	public void display() {
		System.out.println("Id: "+id
				+ "\nName: "+name
				+ "\nEmail: "+email
				+"\nAddress: "+addr);	
	}
}
