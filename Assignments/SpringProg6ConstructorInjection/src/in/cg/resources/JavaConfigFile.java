package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Student;

@Configuration
public class JavaConfigFile {
	
	@Bean
	public Address createAddressObj() {
		Address a=new Address(232,"Delhi",110045);
		return a;
	}
	
	@Bean
	public Student stdId() {
		Student std=new Student(101,"Sumit","randomci@email.com",createAddressObj());
		return std;	
	}
	
	
}
