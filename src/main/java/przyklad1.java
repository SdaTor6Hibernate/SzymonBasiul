import model.*;
import org.hibernate.Session;
import util.HibernateUtil;

public class przyklad1 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.find(User.class, 1);
        session.close();
        System.out.println(user.toString());
    }

}
