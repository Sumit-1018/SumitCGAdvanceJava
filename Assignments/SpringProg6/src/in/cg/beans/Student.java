package in.cg.beans;

public class Student {

	private int id;
	private String name;
	private String email;
	private Address addr;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	public void display() {
		System.out.println("Id: "+id
				+ "\nName: "+name
				+ "\nEmail: "+email
				+"\nAddress: "+addr);	
	}
}
