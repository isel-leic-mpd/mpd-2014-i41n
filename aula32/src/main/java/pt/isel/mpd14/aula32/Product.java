/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.aula32;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
class Product {

    final int productId;
    final String productName;
    final double unitPrice;
    final int unitsInStock;

    public Product(int productId, String productName, double unitPrice, int unitsInStock) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", unitPrice=" + unitPrice + ", unitsInStock=" + unitsInStock + '}';
    }
            
    
}
