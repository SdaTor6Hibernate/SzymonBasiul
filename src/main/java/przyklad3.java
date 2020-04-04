import model.Order;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class przyklad3 {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Order> query = session.createQuery("select o from Order o where o.id=:id", Order.class)
                .setParameter("id",2);
        query.getResultList().forEach(order -> System.out.println(order.getOrderDate()));

        System.out.println("Po pierwszym Query");

        Query<Order> query1 = session.createQuery("select o from Order o join fetch o.user u where o.id=:id",Order.class)
                .setParameter("id",2);
        query1.getResultList().forEach(order -> System.out.println(order.getOrderDate()));
    }
}
