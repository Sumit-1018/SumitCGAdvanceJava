package in.cg.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Student;
import in.cg.resources.SpringJavaConfigFile;

public class MainMethod {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringJavaConfigFile.class);
		
		//Student std=(Student) context.getBean(Student.class); // if we have only one bean of type Student then we can use this method to get the bean without mentioning the name of the bean
		Student s1=(Student) context.getBean("StdId");
		Student s2=(Student) context.getBean("StdId2");
		Student std=(Student) context.getBean("StdId",Student.class); // if we have multiple beans of type Student then we have to mention the name of the bean along with the type of the bean to get the bean
		Student std1=(Student) context.getBean("StdId2",Student.class);
		//std.display();
		s1.display();
		s2.display();
		std.display();
		std1.display();
	}
	
	
}
