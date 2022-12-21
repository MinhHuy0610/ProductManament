/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytm.dtos;

/**
 *
 * @author acer
 */
public class ProductDTO {
    String productID;
    String productName;
    String unit;
    float price;
    int quantity;
    String catogoryid;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String productName, String unit, float price, int quantity, String catogoryid) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.catogoryid = catogoryid;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCatogoryid() {
        return catogoryid;
    }

    public void setCatogoryid(String catogoryid) {
        this.catogoryid = catogoryid;
    }
    
    
}
