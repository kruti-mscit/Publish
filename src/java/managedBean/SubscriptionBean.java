/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import client.PublRestClient;
import entity.Subscription;
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
@Named(value = "subBean")
@ApplicationScoped
public class SubscriptionBean {

   private Subscription subscription=new Subscription();
    private Integer subscriptionID;
    private String title;
    private String type;
    
    PublRestClient pc; 
    Response res;
    GenericType<List<Subscription>> gSubs;
    
    @PostConstruct
    public void Init(){
        pc=new PublRestClient();
        gSubs=new GenericType<List<Subscription>>(){}; 
    }
    
    public SubscriptionBean() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public List<Subscription> findAllSub(){
        res=pc.getAllSubscriptions(Response.class);
        return (List<Subscription>) res.readEntity(gSubs);
    }
    
    public String addSub(){
        
        pc.addSubscription(title, type);
        this.subscriptionID=0;
        this.title="";
        this.type="";
        
        return "Index";
    }
    
    public String editSub(Subscription s){
        this.subscription=s;
        this.subscriptionID=s.getSubscriptionID();
        this.title=s.getTitle();
        this.type=s.getType();
        
        return "Update";
    }
    
    public String editSub(){
        System.out.println(subscriptionID.toString()+"  "+ title+"  "+ type);
        pc.updateSubscription(subscriptionID.toString(), title, type);
        this.subscriptionID=0;
        this.title="";
        this.type="";
        return "Index";
    }
    
    public void deleteSub(Integer id){
        pc.removeSubscription(id.toString());
    }
    
}
