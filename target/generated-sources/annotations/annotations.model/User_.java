package model;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Adress> adress;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, LocalDateTime> birthDate;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SetAttribute<User, Order> order;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String PASSWORD = "password";
	public static final String ADRESS = "adress";
	public static final String ID = "id";
	public static final String BIRTH_DATE = "birthDate";
	public static final String EMAIL = "email";
	public static final String ORDER = "order";

}

