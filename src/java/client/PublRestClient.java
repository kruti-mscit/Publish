/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:PublRestResource [rest]<br>
 * USAGE:
 * <pre>
 *        PublRestClient client = new PublRestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author kruti
 */
public class PublRestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FinalPublishJSF/webresources";

    public PublRestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rest");
    }

    public void removeSubscriptionsOfCustomer(Object requestEntity, String custId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeSubscriptionsOfCustomer/{0}", new Object[]{custId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void removeSubscription(String subId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeSubscription/{0}", new Object[]{subId})).request().delete();
    }

    public void addAddresOfCustomer(String street, String city, String state, String zip, String custId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAddresOfCustomer/{0}/{1}/{2}/{3}/{4}", new Object[]{street, city, state, zip, custId})).request().post(null);
    }

    public void addSubscription(String title, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addSubscription/{0}/{1}", new Object[]{title, type})).request().post(null);
    }

    public void updateSubscription(String subId, String title, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateSubscription/{0}/{1}/{2}", new Object[]{subId, title, type})).request().put(Entity.json(""));
        //webTarget.path(java.text.MessageFormat.format("updateSubscription/{0}/{1}/{2}", new Object[]{subId, title, type})).request().put(null);
        
    }

    public void addSubscriptionsToCustomer(Object requestEntity, String custId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addSubscriptionsToCustomer/{0}", new Object[]{custId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addCustomer(String firstName, String lastName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCustomer/{0}/{1}", new Object[]{firstName, lastName})).request().post(null);
    }

    public <T> T getCustomerById(Class<T> responseType, String custId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCustomerById/{0}", new Object[]{custId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T getSubscriptionById(Class<T> responseType, String subId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getSubscriptionById/{0}", new Object[]{subId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeAddressOfCustomer(String addressId, String custId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeAddressOfCustomer/{0}/{1}", new Object[]{addressId, custId})).request().delete();
    }

    public <T> T getAllCustomers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCustomers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T getLatestCustomerId(Class<T> responseType) throws ClientErrorException {
        
        WebTarget resource = webTarget;
        resource = resource.path("getLatestCustomerId");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(responseType);
    }

    public <T> T getCustomersOfSubscription(Class<T> responseType, String subId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCustomersOfSubscription/{0}", new Object[]{subId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateCustomer(String custId, String firstName, String lastName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCustomer/{0}/{1}/{2}", new Object[]{custId, firstName, lastName})).request().put(Entity.json(""));
    }

    public <T> T getAllSubscriptions(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllSubscriptions");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeCustomer(String custId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCustomer/{0}", new Object[]{custId})).request().delete();
    }

    public void updateAddresOfCustomer(String addressId, String street, String city, String state, String zip, String custId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAddresOfCustomer/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{addressId, street, city, state, zip, custId})).request().put(Entity.json(""));
    }

    public <T> T getSubscriptionsOfCustomer(Class<T> responseType, String custId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getSubscriptionsOfCustomer/{0}", new Object[]{custId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAddresesOfCustomer(Class<T> responseType, String custId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAddresesOfCustomer/{0}", new Object[]{custId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
