package in.cg.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.cg.entities.Student;

public class App {

    private static SessionFactory factory;
    static {
        Configuration cfg = new Configuration();
        cfg.configure("/in/cg/config/hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
    }

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setId(101);
        s1.setName("Sumit");
        s1.setCity("Delhi");
        s1.setEmail("random@email.com");

        insertStudent(s1);
        getStudent(101);
        updateStudentCity(101, "Mumbai");
        deleteStudent(101);
    }

    // Insert
    public static void insertStudent(Student student) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.persist(student);
            tx.commit();
            System.out.println("Record inserted successfully");
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Insert failed");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Select
    public static void getStudent(int id) {
        Session session = factory.openSession();

        try {
            Student s = session.get(Student.class, id);
            if (s != null) {
                System.out.println("Record found: " +
                        s.getName() + " " +
                        s.getCity() + " " +
                        s.getEmail());
            } else {
                System.out.println("Record not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error fetching record");
        } finally {
            session.close();
        }
    }

    // Update
    public static void updateStudentCity(int id, String newCity) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Student s = session.get(Student.class, id);
            if (s != null) {
                s.setCity(newCity);
                session.merge(s);
                tx.commit();
                System.out.println("Record updated successfully");
            } else {
                System.out.println("Record not found for update");
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error updating record");
        } finally {
            session.close();
        }
    }

    // Delete
    public static void deleteStudent(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Student s = session.get(Student.class, id);
            if (s != null) {
                session.remove(s);
                tx.commit();
                System.out.println("Record deleted successfully");
            } else {
                System.out.println("Record not found for delete");
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error deleting record");
        } finally {
            session.close();
        }
    }
}
