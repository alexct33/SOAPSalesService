/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap.sales;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import soap.sales.Product;
import soap.sales.SalesInterface;

/**
 *
 * @author Àlex
 */

@WebService(endpointInterface="soap.sales.SalesInterface")
public class SalesAlgorithms implements SalesInterface {
    
    List<Product> productsList;
    
    @Override
    public int totalPrice(){
        int total = 0;
        for (int i = 0; i<productsList.size(); ++i) {
            total += (productsList.get(i).getPrice()*productsList.get(i).getQuantity());
        }
        return total;
    }

    @Override
    public List<Product> getProducts() {
        return productsList;
        
    }

    @Override
    public void addProduct(Product p) {
        productsList.add(p);
    }

    @Override
    public void removeProduct(Product p) {
        productsList.remove(p);
    }
    
    
    
}
