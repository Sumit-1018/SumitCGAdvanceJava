package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Student;

@Configuration
public class SpringJavaConfigFile {
	
	@Bean
	public Student StdId() {
		Student std=new Student();
		std.setId(101);
		std.setName("Sumit");
		std.setEmail("random@email.com");
		
		return std;
	}
		@Bean("StdId2")
		public Student createStudent() {
			Student s1=new Student();
			s1.setId(102);
			s1.setName("Rohit");
			s1.setEmail("random2@email.com");
			
			return s1;
			
	}
}
	
