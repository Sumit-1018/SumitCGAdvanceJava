package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Student;

@Configuration
public class JavaConfigFile {
	
	@Bean
	public Address createAddressObj() {
		Address a=new Address();
		a.sethNo(123);
		a.setCity("Pune");
		a.setPincode(411045);
		return a;
	}
	
	@Bean
	public Student stdId() {
		Student std=new Student();
		std.setId(101);
		std.setName("Sumit");
		std.setEmail("random@email.com");
		std.setAddr(createAddressObj());
		return std;	
	}
	
	
}
