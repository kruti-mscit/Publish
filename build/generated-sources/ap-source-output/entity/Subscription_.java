package entity;

import entity.Customer;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-22T21:45:03", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Subscription.class)
public class Subscription_ { 

    public static volatile CollectionAttribute<Subscription, Customer> customerCollection;
    public static volatile SingularAttribute<Subscription, Integer> subscriptionID;
    public static volatile SingularAttribute<Subscription, String> title;
    public static volatile SingularAttribute<Subscription, String> type;

}