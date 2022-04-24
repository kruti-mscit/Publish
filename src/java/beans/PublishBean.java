/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kruti
 */
@Stateless
public class PublishBean implements PublishBeanLocal {

    @PersistenceContext(unitName = "FinalPublishJSFPU")
    EntityManager em;

    @Override
    public int getLatestCustomerId() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return (Integer) em.createNamedQuery("Customer.findMaxIDofCust").getSingleResult();
    }

    @Override
    public Subscription getSubscriptionById(Integer subId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.find(Subscription.class, subId);
    }
    
    @Override
    public Collection<Subscription> getAllSubscriptions() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("Subscription.findAll").getResultList();
    }

    @Override
    public Collection<Customer> getAllCustomers() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
       return em.createNamedQuery("Customer.findAll").getResultList();
    
    }

    @Override
    public void addCustomer(String firstName, String lastName) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Customer c = new Customer(firstName, lastName);
        em.persist(c);
    
    }

    @Override
    public void updateCustomer(Integer custId, String firstName, String lastName) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Customer c = (Customer) em.find(Customer.class, custId);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        em.merge(c);
    }

    @Override
    public void removeCustomer(Integer custId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
       Customer c = (Customer) em.find(Customer.class, custId);
       em.remove(c);
    }

    @Override
    public Collection<Customer> getCustomerByFirstName(String fname) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     Collection<Customer> customers = em.createNamedQuery("Customer.findByFirstName")
             .setParameter("firstName", fname)
             .getResultList();
     
     return customers;
    
    }

    @Override
    public Collection<Customer> getCustomerByLastName(String lname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getCustomerById(Integer custId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return em.find(Customer.class, custId);
    }

    @Override
    public void addAddresOfCustomer(String street, String city, String state, int zip, Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Customer c = em.find(Customer.class, custId);
    Collection<Address> addresses = c.getAddressCollection();
    
    Address address = new Address();
    address.setStreet(street);
    address.setCity(city);
    address.setState(state);
    address.setZip(zip);
    address.setCustomer(c); // Very Important
    
    addresses.add(address);
    c.setAddressCollection(addresses);
    
    em.persist(address);
    em.merge(c);
    
    
    
    }

    @Override
    public void updateAddresOfCustomer(Integer addressId, String street, String city, String state, int zip, Integer custId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Customer c = em.find(Customer.class, custId);
        Address address = em.find(Address.class, addressId);

        Collection<Address> addresses = c.getAddressCollection();
        if(addresses.contains(address))
        {
            addresses.remove(address);
        }
        
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        address.setZip(zip);
        address.setCustomer(c);
        addresses.add(address);
        c.setAddressCollection(addresses);
        
        em.merge(address);
        em.merge(c);
    }

    @Override
    public void removeAddressOfCustomer(Integer addressId, Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Customer c = em.find(Customer.class, custId);
        Address address = em.find(Address.class, addressId);

        Collection<Address> addresses = c.getAddressCollection();

        if(addresses.contains(address))
        {
            addresses.remove(address);
            c.setAddressCollection(addresses);
            em.remove(address);
            em.merge(c);
        }
    
    }

    @Override
    public Collection<Address> getAddresesOfCustomer(Integer custId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   Customer c = em.find(Customer.class, custId);
    
   return c.getAddressCollection();
    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Address> getAddressesByState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Address> getAddressesByZip(int zip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Address> getAddresses(String city, String State) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSubscription(String title, String type) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
       Subscription s = new Subscription();
       s.setTitle(title);
       s.setType(type);
       em.persist(s);
    
    }

    @Override
    public void updateSubscription(Integer subId, String title, String type) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Subscription s = em.find(Subscription.class, subId);
        s.setTitle(title);
        s.setType(type);
        em.merge(s);
    }

    @Override
    public void removeSubscription(Integer subId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Subscription s = em.find(Subscription.class, subId);
        em.remove(s);
    }

    @Override
    public Collection<Subscription> getSubscriptionsOfCustomer(Integer custId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Customer c = em.find(Customer.class, custId);
    return c.getSubscriptionCollection();
    }

    @Override
    public Collection<Subscription> getSubscriptionsByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Customer> getCustomersOfSubscription(Integer subId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   Subscription s = em.find(Subscription.class, subId);
    return s.getCustomerCollection();
    }

    @Override
    public void addSubscriptionsToCustomer(Integer custId, Collection<Integer> subIds) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Customer c = (Customer) em.find(Customer.class, custId);
    Collection<Subscription> subscriptions = c.getSubscriptionCollection();
    
    for(Integer sid : subIds)
    {
        Subscription sub = (Subscription) em.find(Subscription.class, sid);
        
        if(!subscriptions.contains(sub))
        {
            Collection<Customer> customers = sub.getCustomerCollection();
            customers.add(c);
            subscriptions.add(sub);
            c.setSubscriptionCollection(subscriptions);
            sub.setCustomerCollection(customers);
            
            em.merge(c);
        }
        
    }
    
    
    }

    @Override
    public void removeSubscriptionsOfCustomer(Integer custId, Collection<Integer> subIds) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     Customer c = (Customer) em.find(Customer.class, custId);
    Collection<Subscription> subscriptions = c.getSubscriptionCollection();
    
    for(Integer sid : subIds)
    {
        Subscription sub = (Subscription) em.find(Subscription.class, sid);
        
        if(subscriptions.contains(sub))
        {
            Collection<Customer> customers = sub.getCustomerCollection();
            customers.remove(c);
            subscriptions.remove(sub);
            c.setSubscriptionCollection(subscriptions);
            sub.setCustomerCollection(customers);
            
            em.merge(c);
        }
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    }
}
