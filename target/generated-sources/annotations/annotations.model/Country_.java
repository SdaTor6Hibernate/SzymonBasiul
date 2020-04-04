package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Country.class)
public abstract class Country_ {

	public static volatile SingularAttribute<Country, String> name;
	public static volatile SingularAttribute<Country, String> alias;
	public static volatile SingularAttribute<Country, Integer> id;

	public static final String NAME = "name";
	public static final String ALIAS = "alias";
	public static final String ID = "id";

}

