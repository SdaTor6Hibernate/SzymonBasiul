package util;

        import dao.GenericDao;
        import model.Adress;
        import model.User;

        import java.time.LocalDateTime;
        import java.util.ArrayList;
        import java.util.List;

public class zadanie1 {
    public static void main(String[] args) {
        GenericDao<Adress> adressDao = new GenericDao<>(Adress.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setFirstName("Harry");
        user1.setLastName("Potter");
        user1.setPassword("buraki");
        user1.setEmail("kochamvoldemorta123@horkruks.uk");
        user1.setBirthDate(LocalDateTime.now());
        Adress adress1 = adressDao.findById(5);
        user1.setAdress(adress1);

        User user2 = new User();
        user2.setFirstName("Johnny");
        user2.setLastName("Bravo");
        user2.setPassword("majtki");
        user2.setEmail("miesnie@duze.com");
        user2.setBirthDate(LocalDateTime.now());
        Adress adress2 = adressDao.findById(10);
        user2.setAdress(adress2);

        User user3 = new User();
        user3.setFirstName("Kame");
        user3.setLastName("Hame");
        user3.setPassword("Ha");
        user3.setEmail("goku@ssj3.jp");
        user3.setBirthDate(LocalDateTime.now());
        Adress adress3 = adressDao.findById(12);
        user3.setAdress(adress3);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        users.forEach(userDao::insertUser);
        users.forEach(user -> {
            user.setLastName(user.getLastName() + " - Zakażony");
            userDao.updateUser(user);
        });

        userDao.deleteUser(users.get(0));
        userDao.deleteUser(users.get(users.size()-1));

    }
}
