package util;

//Utwórz klasę OrderDao, niech ta klasa dziedziczy po klasie
// GenericDao - stwórz odpowiedni kontruktor aby klasa mogła działać.
// napisz metody
// 1. findByDate()
// 2. findBeforeDate()
// 3. findAfterDate() - zastosuj NativeQuery dla odmiany
// 4. findAllContainingProduct()
// 5. findByUser() // 6. findByPriceLowerThan()
// Zastosuj TypedQuery następnie zaprezentuj wyniki działania
// query w klasie main za pomocą System.out.println )

import dao.OrderDao;
import model.Order;

import java.time.LocalDateTime;
import java.util.List;

public class zadanie2 {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.findByDate(LocalDateTime.of
                (2020,2,28,15,35,46));
        orders.forEach(order -> System.out.println(order.toString()));

    }
}
