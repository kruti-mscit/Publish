/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import client.PublRestClient;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


/**
 *
 * @author kruti
 */
@Named(value = "custBean")
@ApplicationScoped
public class CustomerBean {
    
    PublRestClient prc;
    Response res;

    private Customer customer=new Customer();
    private Subscription subscription=new Subscription();
    private Integer subscriptionID;
    private Integer customerID;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zip;
    private Collection<Address> addresses;
    private Collection<Subscription> subscriptions;
    
    private GenericType<List<Customer>> gcustomers;
    private GenericType<List<Address>> gaddresses;
    private GenericType<List<Subscription>> gsubscriptions;
    private GenericType<Collection<Subscription>> gsubscriptionss;
    private GenericType<Subscription> gSubs;
    
    @PostConstruct
    public void Init(){
        prc=new PublRestClient();
        gcustomers=new GenericType<List<Customer>>(){};
        gaddresses=new GenericType<List<Address>>(){};
        gsubscriptions=new GenericType<List<Subscription>>(){};
        gsubscriptionss=new GenericType<Collection<Subscription>>(){};
        gSubs=new GenericType<Subscription>(){};
        
        res=prc.getAllSubscriptions(Response.class);
        subscriptions=res.readEntity(gsubscriptionss);
    } 
    
    public CustomerBean() {
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Integer getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(Integer subscriptionID) {
        this.subscriptionID = subscriptionID;
    }
    

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public Collection<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Collection<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
    
    public List<Customer> findAll(){
        res=prc.getAllCustomers(Response.class);
        return (List<Customer>) res.readEntity(gcustomers);
    }
    
    public List<Address> findAddressofCust(Integer cid){
        res=prc.getAddresesOfCustomer(Response.class, cid.toString());
        return (List<Address>) res.readEntity(gaddresses);
    }
    
    public List<Subscription> findSubscriptionofCust(Integer cid){
        res=prc.getSubscriptionsOfCustomer(Response.class, cid.toString());
        return (List<Subscription>) res.readEntity(gsubscriptions);
    }
    
    public String addCust(){
        
        prc.addCustomer(firstName, lastName);
        Integer custId=prc.getLatestCustomerId(Integer.class);
        
        prc.addAddresOfCustomer(street, city, state, String.valueOf(zip), custId.toString());
       
        
        Collection subIds = new ArrayList<Integer>();
        subIds.add(subscriptionID);
        
        prc.addSubscriptionsToCustomer(subIds, custId.toString());
        
        return "Index";
    }
    
    public String editCust(Customer c){
        return "";
    }
    
    public String editCust(){
        return "";
    }
    
    public void deleteCust(Integer cid){
        prc.removeCustomer(cid.toString());
    }
    
}
