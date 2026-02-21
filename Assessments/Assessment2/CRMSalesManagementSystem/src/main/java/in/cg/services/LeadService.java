package in.cg.services;

import in.cg.entities.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class LeadService {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure("/in/cg/config/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public void createLead(String name, String source, String contactInfo) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Lead lead = new Lead();
        lead.setName(name);
        lead.setSource(source);
        lead.setContactInfo(contactInfo);

        session.persist(lead);

        tx.commit();
        session.close();
    }

    public void assignLeadToEmployee(Long leadId, Long empId) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Lead lead = session.get(Lead.class, leadId);
        SalesEmployee emp = session.get(SalesEmployee.class, empId);

        lead.setEmployee(emp);

        session.merge(lead);

        tx.commit();
        session.close();
    }

    public void convertLeadToCustomer(Long leadId) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Lead lead = session.get(Lead.class, leadId);

        Customer customer = new Customer();
        customer.setName(lead.getName());
        customer.setEmail(lead.getContactInfo());
        customer.setPhone("0000000000");

        session.persist(customer);

        tx.commit();
        session.close();
    }
}