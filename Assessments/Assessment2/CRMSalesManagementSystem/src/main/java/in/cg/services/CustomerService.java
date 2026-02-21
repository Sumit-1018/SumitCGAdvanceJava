package in.cg.services;

import in.cg.entities.Address;
import in.cg.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerService {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("/in/cg/config/hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerCustomer(String name, String email, String phone) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);

            session.persist(customer);

            tx.commit();
            System.out.println("Customer Registered Successfully!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addAddressToCustomer(Long customerId, Address address) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = session.get(Customer.class, customerId);
            customer.setAddress(address);

            session.merge(customer);

            tx.commit();
            System.out.println("Address Added Successfully!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}