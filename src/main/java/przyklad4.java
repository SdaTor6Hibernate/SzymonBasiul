import model.User;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import util.HibernateUtil;

public class przyklad4 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        NativeQuery<User> nativeQuery = session.createNativeQuery("select * from user where usr_id>:id", User.class)
                .setParameter("id",5);
        nativeQuery.getResultList().forEach(user -> System.out.println(user.toString()));


        session.close();
    }


}
