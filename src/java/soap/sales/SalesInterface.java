/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap.sales;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Àlex
 */

@WebService
public interface SalesInterface {
    @WebMethod
    public int totalPrice();
    
    public List<Product> getProducts();
    
    public void addProduct(Product p);
    
    public void removeProduct(Product p);
    
    
        
    
}
