package entity;

import entity.Customer;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-22T21:45:03", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Integer> zip;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> state;
    public static volatile SingularAttribute<Address, Integer> addressID;
    public static volatile SingularAttribute<Address, Customer> customer;

}