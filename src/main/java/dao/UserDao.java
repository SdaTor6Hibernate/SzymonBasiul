package dao;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;


/*
Stworzyć prostego CRUDa (w klasie UserDAO) dla tabeli user używając hibernetowych
metod find(), persist(), merge(), delete() obiektu Session. Nasza klasa UserDAO powinna
zawierać 4 metody:
• insert -dodająca użytkownika przekazanego do metody
• select -znajdująca użytkownika na zadanym id
• update -aktualizująca użytkownika w bazie danych przekazanego do metody
• delete -usuwająca przekazanego do metody użytkownika
Dla chętnych - stworzyć klasę GenericDao - która te wszystkie operacje wykonywała by dla każdej tabeli - wykorzystując typy generyczne i parametr klasy przekazany w konstruktorze
Zadanie 2
Należy stworzyć w metodzie main() następujące operacje:
• Stworzyć listę 5 nowych użytkowników.
• Zapisać nowych użytkowników do bazy danych.
• Zmodyfikować nazwisko wszystkim użytkownikom, tak aby do nazwiska dopisać " - zakażony"
• Usunąć pierwszego i ostatniego użytkownika z listy.
 */
public class UserDao {
    public User findById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.find(User.class, id);
        session.close();
        return user;
    }
    public void insertUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(user);
        session.flush();
        session.close();
    }
    public void deleteUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.flush();
        session.close();
    }
    public void updateUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if(session.find(User.class, user.getId()) != null) {
            session.merge(user);
        }
        session.flush();
        session.close();
    }
}

