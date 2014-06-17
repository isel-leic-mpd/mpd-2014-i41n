/*
 * Copyright 2014 Miguel Gamboa at CCISEL.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pt.isel.mpd14.sqlfw.northwind;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class Product {

    public final int productID;
    public final String productName;
    public final double unitPrice;
    public final int unitsInStock;
    public final Supplier supplier;

    public Product(int productID, String productName, double unitPrice, int unitsInStock, Supplier sup) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.supplier = sup;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", unitPrice=" + unitPrice + ", unitsInStock=" + unitsInStock + '}';
    }
    
    
}
