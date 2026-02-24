package in.cg.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Student;
import in.cg.resources.JavaConfigFile;

public class MainMethod {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigFile.class);
		Student std = context.getBean(Student.class);
		std.display();
	}
}
