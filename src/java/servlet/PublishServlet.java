/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kruti
 */
@WebServlet(name = "PublishServlet", urlPatterns = {"/PublishServlet"})
public class PublishServlet extends HttpServlet {

    @EJB PublishBeanLocal pbl;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PublishServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Collection<Customer> customers = pbl.getAllCustomers();
             
            out.println("Latest Customer ID : "+pbl.getLatestCustomerId());
            
            for(Customer c : customers)
            {
             out.println("<br/>custId : "+ c.getCustomerID() + " Name : " + c.getFirstName()+" "+ c.getLastName());
             
             Collection<Address> addresses = pbl.getAddresesOfCustomer(c.getCustomerID());
             
             for(Address a : addresses)
             {
                  out.println("<br/>AddressId : "+ a.getAddressID() + " Street : "+ a.getStreet()+ " City : " + a.getCity()+"  State : "+ a.getState());
             
             }
             
             Collection<Subscription> subscriptions = pbl.getSubscriptionsOfCustomer(c.getCustomerID());
          
             for(Subscription s : subscriptions)
             {
                 out.println("<br/>Subs Id : "+ s.getSubscriptionID()+ " Title : "+ s.getTitle()+ " Type : "+ s.getType());
             }
             
             out.println("<hr/>");
                
                
            }
            out.println("</h2>");
            
            out.println("<h1>Servlet PublishServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
