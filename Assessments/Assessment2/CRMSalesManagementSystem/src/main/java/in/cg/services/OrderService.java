package in.cg.services;

import in.cg.entities.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class OrderService {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure("/in/cg/config/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public void placeOrder(Long customerId, List<Long> productIds) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, customerId);

        List<Product> products = session.createQuery(
                "from Product where id in (:ids)", Product.class)
                .setParameter("ids", productIds)
                .getResultList();

        double total = 0;
        for (Product p : products) total += p.getPrice();

        Orders order = new Orders();
        order.setCustomer(customer);
        order.setProducts(products);
        order.setOrderDate(LocalDate.now());
        order.setTotalAmount(total);

        session.persist(order);

        tx.commit();
        session.close();
    }
}