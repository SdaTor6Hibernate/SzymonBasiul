package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, BigDecimal> orderPrice;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile SingularAttribute<Order, LocalDateTime> orderDate;
	public static volatile SingularAttribute<Order, User> user;
	public static volatile SetAttribute<Order, Product> products;

	public static final String ORDER_PRICE = "orderPrice";
	public static final String ID = "id";
	public static final String ORDER_DATE = "orderDate";
	public static final String USER = "user";
	public static final String PRODUCTS = "products";

}

