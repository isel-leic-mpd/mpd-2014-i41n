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
    public final String companyName;
    public final String contactName;
    public final String city;

    public Supplier(int supplierID, String companyName, String contactName, String City) {
        this.supplierID = supplierID;
        this.companyName = companyName;
        this.contactName = contactName;
        this.city = City;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplierID=" + supplierID + ", companyName=" + companyName + ", contactName=" + contactName + ", City=" + city + '}';
    }
    
}
