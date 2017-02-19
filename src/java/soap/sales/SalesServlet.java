/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap.sales;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Àlex
 */
@WebServlet(name = "SalesServlet", urlPatterns = {"/SalesServlet"})
public class SalesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
        Connection c = new Connection();
        try {
            List<Product> l = c.getProds();
            request.setAttribute("productsList",l);
        } catch (Exception ex) {
            Logger.getLogger(SalesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

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
        
      if (request.getParameter("add") != null) {          
        String name = request.getParameter("name");
        String quant = request.getParameter("quantity");
        int quantity = Integer.parseInt(quant);
        Product p = new Product();
        p.setName(name);
        p.setQuantity(quantity);
        int randomNum = ThreadLocalRandom.current().nextInt(10, 100);
        p.setPrice(randomNum);
        
        Connection c = new Connection();
        try {
            c.add(p);
            System.out.println("Product " + p.getName() + "added");
        } catch (Exception ex) {
            Logger.getLogger(SalesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      else if (request.getParameter("finishOrder") != null) {
          Connection c = new Connection();
            try {
                int price = c.total();
                request.setAttribute("price", price);
                System.out.println("Final price: " + price);
                
            } catch (Exception ex) {
                Logger.getLogger(SalesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      
      else if (request.getParameter("removeAll") != null) {
          Connection c = new Connection();
            try {
                c.removeAll();
            } catch (Exception ex) {
                Logger.getLogger(SalesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      doGet(request, response);
        
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
