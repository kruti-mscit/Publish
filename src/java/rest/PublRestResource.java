/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author kruti
 */
@Path("rest")
@RequestScoped
public class PublRestResource {

    @Context
    private UriInfo context;

     @EJB PublishBeanLocal pbl;

    
    /**
     * Creates a new instance of PublRestResource
     */
    public PublRestResource() {
    }


    @Path("getAllCustomers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> getAllCustomers() {
       return pbl.getAllCustomers();
    }

    @Path("addCustomer/{firstName}/{lastName}")
    @POST
    public void addCustomer(@PathParam("firstName") String firstName,@PathParam("lastName") String lastName) {
    
        pbl.addCustomer(firstName, lastName);
    }

    @Path("updateCustomer/{custId}/{firstName}/{lastName}")
    @PUT
    public void updateCustomer(@PathParam("custId") Integer custId,@PathParam("firstName") String firstName,@PathParam("lastName") String lastName) {
        pbl.updateCustomer(custId, firstName, lastName);
    }

    @Path("removeCustomer/{custId}")
    @DELETE
    public void removeCustomer(@PathParam("custId") Integer custId) {
        pbl.removeCustomer(custId);
    }

    @Path("getCustomerById/{custId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(@PathParam("custId") Integer custId) {
        return pbl.getCustomerById(custId);
    }
    
    @Path("getSubscriptionById/{subId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Subscription getSubscriptionById(@PathParam("subId") Integer subId) {
        return pbl.getSubscriptionById(subId);
    }

    @Path("addAddresOfCustomer/{street}/{city}/{state}/{zip}/{custId}")
    @POST
    public void addAddresOfCustomer(@PathParam("street") String street,@PathParam("city") String city,@PathParam("state") String state,@PathParam("zip") int zip,@PathParam("custId") Integer custId) {
        pbl.addAddresOfCustomer(street, city, state, zip, custId);
    }

    @Path("updateAddresOfCustomer/{addressId}/{street}/{city}/{state}/{zip}/{custId}")
    @PUT
    public void updateAddresOfCustomer(@PathParam("addressId") Integer addressId,@PathParam("street") String street,@PathParam("city") String city,@PathParam("state") String state,@PathParam("zip") int zip,@PathParam("custId") Integer custId) {
        pbl.updateAddresOfCustomer(addressId, street, city, state, zip, custId);
    }

    @Path("removeAddressOfCustomer/{addressId}/{custId}")
    @DELETE
    public void removeAddressOfCustomer(@PathParam("addressId") Integer addressId,@PathParam("custId") Integer custId) {
        pbl.removeAddressOfCustomer(addressId, custId);
    }

    @Path("getAddresesOfCustomer/{custId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Address> getAddresesOfCustomer(@PathParam("custId") Integer custId) {
        return pbl.getAddresesOfCustomer(custId);
    }

    @Path("addSubscription/{title}/{type}")
    @POST
    public void addSubscription(@PathParam("title") String title,@PathParam("type") String type) {
        pbl.addSubscription(title, type);
    }

    @Path("updateSubscription/{subId}/{title}/{type}")
    @PUT
    public void updateSubscription(@PathParam("subId") Integer subId,@PathParam("title") String title,@PathParam("type") String type) {
        pbl.updateSubscription(subId, title, type);
    }

    @Path("removeSubscription/{subId}")
    @DELETE
    public void removeSubscription(@PathParam("subId") Integer subId) {
        pbl.removeSubscription(subId);
    }
    
    @Path("getAllSubscriptions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Subscription> getAllSubscriptions() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return pbl.getAllSubscriptions();
    }
    
    @Path("getLatestCustomerId")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int getLatestCustomerId() {
        
        return pbl.getLatestCustomerId();
    }

    @Path("getSubscriptionsOfCustomer/{custId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Subscription> getSubscriptionsOfCustomer(@PathParam("custId") Integer custId) {
        return pbl.getSubscriptionsOfCustomer(custId);
    }

   
    @Path("getCustomersOfSubscription/{subId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> getCustomersOfSubscription(@PathParam("subId") Integer subId) {
       return pbl.getCustomersOfSubscription(subId);
    }

    @Path("addSubscriptionsToCustomer/{custId}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addSubscriptionsToCustomer(@PathParam("custId") Integer custId, Collection<Integer> subIds) {
        pbl.addSubscriptionsToCustomer(custId, subIds);
    }

    
    @Path("removeSubscriptionsOfCustomer/{custId}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void removeSubscriptionsOfCustomer(@PathParam("custId") Integer custId, Collection<Integer> subIds) {
        pbl.removeSubscriptionsOfCustomer(custId, subIds);
    }
}
