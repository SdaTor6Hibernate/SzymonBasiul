import model.Adress;
import model.Country;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;


import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

//       criteriaQuery.select(root).where(cb.gt(root.get("itemPrice"), 1000));
//       criteriaQuery.select(root).where(cb.lt(root.get("itemPrice"), 1000));
//       criteriaQuery.select(root).where(cb.like(root.get("itemName"), "%chair%"));
//       criteriaQuery.select(root).where(cb.between(root.get("itemPrice"), 100, 200));
//       criteriaQuery.select(root).where(cb.isNull(root.get("itemDescription")));
//       criteriaQuery.select(root).where(cb.isNotNull(root.get("itemDescription")));

public class przyklad6 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Adress> query = builder.createQuery(Adress.class);
        Root<Adress> adressRoot = query.from(Adress.class);
        adressRoot.fetch("country");
        query.select(adressRoot).where(builder.like(adressRoot.get("city"),"Gdańsk"));
        TypedQuery<Adress> q = session.createQuery(query);
        List<Adress> adressList = q.getResultList();
        session.close();
        adressList.forEach(adress -> System.out.println(adress.getCountry()));


    }
}
