/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.sqlfw.northwind;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class Supplier {
    public final int supplierID;
    private String companyName;
    private String contactName;
    private String city;
    private Iterable<Product> products;
    
    public Supplier(int supplierID, String companyName, String contactName, String City, Iterable<Product> products) {
        this.supplierID = supplierID;
        this.companyName = companyName;
        this.contactName = contactName;
        this.city = City;
        this.products = products;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Iterable<Product> getProducts() {
        return products;
    }

    public void setProducts(Iterable<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplierID=" + supplierID + ", companyName=" + companyName + ", contactName=" + contactName + ", City=" + city + '}';
    }
    
}
