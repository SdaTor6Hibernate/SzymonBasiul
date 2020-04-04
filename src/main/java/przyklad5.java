import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class przyklad5 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User selectUser = session.createNamedQuery("user.select", User.class)
                .setParameter("email", "adolf.h@ss.de").getSingleResult();
        //System.out.println(selectUser.getFullName());
    }
}
