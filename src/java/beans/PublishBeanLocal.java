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
import javax.ejb.Local;

/**
 *
 * @author kruti
 */
@Local
public interface PublishBeanLocal {
    // ====  Customer =========
    Collection<Customer> getAllCustomers();
    void addCustomer(String firstName, String lastName);
    void updateCustomer(Integer custId, String firstName, String lastName);
    void removeCustomer(Integer custId);
    Collection<Customer> getCustomerByFirstName(String fname);
     Collection<Customer> getCustomerByLastName(String lname);
     Customer getCustomerById(Integer custId);
     int getLatestCustomerId();
     
     //==== Address =================
     
     void addAddresOfCustomer(String street, String city, String state, int zip, Integer custId);
     void updateAddresOfCustomer(Integer addressId,String street, String city, String state, int zip, Integer custId);
     void removeAddressOfCustomer(Integer addressId, Integer custId);
     Collection<Address> getAddresesOfCustomer(Integer custId);
     Collection<Address> getAddressesByCity(String city);
     Collection<Address> getAddressesByState(String state);
     Collection<Address> getAddressesByZip(int zip);
     Collection<Address> getAddresses(String city, String State);
     
     //=============  Subscription ======
     
     void addSubscription(String title, String type);
     void updateSubscription(Integer subId, String title, String type);
     void removeSubscription(Integer subId);
     Subscription getSubscriptionById(Integer subId);
     Collection<Subscription> getAllSubscriptions();
     Collection<Subscription> getSubscriptionsOfCustomer(Integer custId);
     Collection<Subscription> getSubscriptionsByType(String type);
     Collection<Customer> getCustomersOfSubscription(Integer subId);
     void addSubscriptionsToCustomer(Integer custId, Collection<Integer> subIds);
      void removeSubscriptionsOfCustomer(Integer custId, Collection<Integer> subIds);
    
}
