package dao;

import model.ModelClass;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class GenericDao<T extends ModelClass> {
    final Class<T> classParameter;

    public GenericDao(Class<T> classParameter){
        this.classParameter = classParameter;
    }
    public T findById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        T t = session.find(classParameter, id);
        session.close();
        return t;
    }
    public void insertUser(T t){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(t);
        session.flush();
        session.close();
    }
    public void deleteUser(T t){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(t);
        session.flush();
        session.close();
    }
    public void updateUser(T t){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if(session.find(classParameter, t.getId()) != null) {
            session.merge(t);
        }
        session.flush();
        session.close();
    }

}

