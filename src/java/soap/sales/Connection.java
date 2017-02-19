/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap.sales;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import soap.sales.SalesInterface;

/**
 *
 * @author Àlex
 */
public class Connection {
    
    public int total() throws Exception{
        URL url = new URL("http://localhost:8080/SOAPSalesService/SalesAlgorithms?wsdl");
        QName qname = new QName("http://sales.soap/", "SalesAlgorithmsService");
        Service service = Service.create(url, qname);
        SalesInterface s = service.getPort(SalesInterface.class);
        return s.totalPrice();
    }
    
    public List<Product> getProds() throws Exception{
        URL url = new URL("http://localhost:8080/SOAPSalesService/SalesAlgorithms?wsdl");
        QName qname = new QName("http://sales.soap/", "SalesAlgorithmsService");
        Service service = Service.create(url, qname);
        SalesInterface s = service.getPort(SalesInterface.class);
        return s.getProducts();
    }
    
    public void add(Product p) throws Exception {
        URL url = new URL("http://localhost:8080/SOAPSalesService/SalesAlgorithms?wsdl");
        QName qname = new QName("http://sales.soap/", "SalesAlgorithmsService");
        Service service = Service.create(url, qname);
        SalesInterface s = service.getPort(SalesInterface.class);
        s.addProduct(p);
    }
    
     public void removeAll() throws Exception {
        URL url = new URL("http://localhost:8080/SOAPSalesService/SalesAlgorithms?wsdl");
        QName qname = new QName("http://sales.soap/", "SalesAlgorithmsService");
        Service service = Service.create(url, qname);
        SalesInterface s = service.getPort(SalesInterface.class);
        s.removeAll();
     }
    
    
}
