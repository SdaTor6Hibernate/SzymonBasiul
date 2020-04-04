package util;

import dao.OrderDao;
import dao.UserCriteriaDao;
import model.Order;
import model.User;

import java.time.LocalDateTime;
import java.util.List;

public class zadanie3 {
    public static void main(String[] args) {
        UserCriteriaDao userCriteriaDao = new UserCriteriaDao();
        List<User> users = userCriteriaDao.findAllBornBetween(LocalDateTime.now().minusYears(20), LocalDateTime.now());
        users.forEach(user -> System.out.println(user.toString()));

        List<User> usersCities = userCriteriaDao.findByCityName("Berlin");
        users.forEach(user -> System.out.println(user.toString()));

        List<User> userCountries = userCriteriaDao.findAllByCountryAlias("PL");
        users.forEach(user -> System.out.println(user.toString()));
    }

}
