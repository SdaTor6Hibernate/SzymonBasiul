package dao;

import model.Order;
import model.Product;
import model.User;
import org.hibernate.Session;

import org.hibernate.query.Query;
import util.HibernateUtil;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDao extends GenericDao<Order> {
    public OrderDao() {
        super(Order.class);
    }

    private Session session;

    void openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
    }


    // 1. findByDate()
    public List<Order> findByDate(LocalDateTime dateTime) {
        openSession();
        Query query = session.createQuery("Select o from Order o where o.orderDate = :date").setParameter("date", dateTime);
        List<Order> orders = query.getResultList();
        session.close();
        return orders;
    }

    // 2. findBeforeDate()
    public List<Order> findBeforeDate(LocalDateTime dateTime) {
        openSession();
        Query query = session.createQuery("Select o from Order o where o.orderDate < :date").setParameter("date", dateTime);
        List<Order> orders = query.getResultList();
        session.close();
        return orders;
    }

    // 3. findAfterDate() - zastosuj NativeQuery dla odmiany
    public List<Order> findAfterDate(LocalDateTime dateTime) {
        openSession();
        Query query = session.createNativeQuery("Select * from `order` where ORD_DATE > :date", Order.class).setParameter("date", dateTime);
        List<Order> orders = query.getResultList();
        session.close();
        return orders;
    }

    // 4. findAllContainingProduct()
    public List<Order> findAllContainingProduct(Product product) {
        openSession();
        Query query = session.createQuery("Select o from Order o join fetch o.products p where p = :product").setParameter("product", product);
        List<Order> orders = query.getResultList();
        session.close();
        return orders;
    }

    // 5. findByUser()
    public List<Order> findByUser(User user) {
        openSession();
        Query query = session.createQuery("Select o from Order o join fetch o.user u where u = :user").setParameter("user", user);
        List<Order> orders = query.getResultList();
        session.close();
        return orders;
    }
}
