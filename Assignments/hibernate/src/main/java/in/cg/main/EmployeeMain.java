package in.cg.main;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import in.cg.entities.Employee;

public class EmployeeMain {
	private static SessionFactory factory;
	static {
		Configuration cfg=new Configuration();
        cfg.configure("/in/cg/config/hibernateEmployee.cfg.xml");
        factory = cfg.buildSessionFactory();

	}
	public static void main(String[] args) {
		Employee e1=new Employee();
		e1.setId(101);
		e1.setName("Sumit");
		e1.setDept("Java");
		e1.setSalary(30000);
		
		insertEmployee(e1);
		getEmployee(101);
		updateEmployee(101,"Dotnet");
		deleteEmployee(101);
		
	}
	
	//Insert
	public static void insertEmployee(Employee employee) {
		Session session=factory.openSession();
		Transaction trx=session.beginTransaction();
		try {
			session.persist(employee);
			trx.commit();
			System.out.println("Record Inserted Successfully");
		}catch(Exception e) {
			trx.rollback();
			System.out.println("Insert failed");
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//get record
	public static void getEmployee(int id) {
		Session session=factory.openSession();
		
		try {
			Employee e1=session.get(Employee.class, id);
				if(e1!=null) {
					System.out.println("Record found: "+
										e1.getId()+" "+
										e1.getName()+" "+
										e1.getDept()+" "+
										e1.getSalary());
				}else {
					System.out.println("Record not found");
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error fetching record");
			}finally {
				session.close();
			}
		}
	
	
	//Update
	public static void updateEmployee(int id,String dept) {
		Session session=factory.openSession();
		Transaction trx=session.beginTransaction();
		try {
			Employee e1=session.get(Employee.class,id);
			if(e1!=null) {
				e1.setDept(dept);
				session.merge(e1);
				trx.commit();
				System.out.println("Record updated successfully");
			}else {
				System.out.println("Record not found");
			}
		}catch(Exception e) {
			trx.rollback();
			e.printStackTrace();
			System.out.println("Error updating record");
		}finally {
			session.close();
		}
	}

	//Delete
	public static void deleteEmployee(int id) {
		Session session=factory.openSession();
		Transaction trx=session.beginTransaction();
		try {
			Employee e1=session.get(Employee.class, id);
			if(e1!=null) {
				session.remove(e1);
				trx.commit();
				System.out.println("Record Deleted");
			}else {
				System.out.println("Record not deleted");
			}
		}catch(Exception e) {
			trx.rollback();
			e.printStackTrace();
			System.out.println("Error deleting record");
		}finally {
			session.close();
		}
	}
}
