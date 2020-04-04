package dao;


import model.*;
import model.Adress_;
import model.Country_;
import model.User_;
import org.hibernate.Session;
import util.HibernateUtil;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

//Dopisz kolejne implementacje metod do klasy UserCriteriaDao i wyświetl ich rezultaty
// 1. findAllBornBetween()
// 2. findByEmail()
// 3. findAllByCityName(); tak aby obiekty user zawierały jednocześnie informacje o adresie
// 4. findAllByCountryAlias(); tak aby obiekty user zawierały informacje zawarte w tabeli user
// 5. TRUDNE findAllWhoBoughtProduct();

public class UserCriteriaDao {
    private Session session;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery criteriaQuery;
    private Root<User> user;

    private void configureFrom() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(User.class);
        user = criteriaQuery.from(User.class);

    }

    public List<User> findAllBornBetween(LocalDateTime date1, LocalDateTime date2){
        configureFrom();
        criteriaQuery.select(user).where(criteriaBuilder.between(user.get("birthDate"), date1, date2));
        TypedQuery<User> query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }
    public List<User> findByEmail(String email){
        configureFrom();
        criteriaQuery.select(user).where(criteriaBuilder.equal(user.get("email"), email));
        TypedQuery<User> query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }
    public List<User> findByCityName(String city){
        configureFrom();
        Join<User, Adress> adress = user.join("adress");
        criteriaQuery.select(user).where(criteriaBuilder.equal(adress.get("city"), city));
        TypedQuery<User> query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }
    public List<User> findAllByCountryAlias(String alias){
        configureFrom();
        Join<User, Adress> adress = user.join("adress");
        Join<Adress, Country> country = adress.join("country");
        criteriaQuery.select(user).where(criteriaBuilder.equal(country.get("alias"), alias));
        TypedQuery<User> query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

}
