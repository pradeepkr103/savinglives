package com.savinglives;

public class CartItem {
    private String productId;
    private String itemNumber; //not used for POC
    private double price;
    private int quantity;
    private String description;
    private String imageurl; //not used for PO
    private int imgrint;

    public CartItem(String productId, String itemNumber, double price, int quantity,
                    String description, String imageurl, int imgrint) {
        this.productId = productId;
        this.itemNumber = itemNumber;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.imageurl = imageurl;
        this.imgrint = imgrint;
    }
    public CartItem(String productId, double price, String description, int imgrint) {
        this.productId = productId;
        this.itemNumber = itemNumber;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.imageurl = imageurl;
        this.imgrint = imgrint;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getImgrint() {
        return imgrint;
    }

    public void setImgrint(int imgrint) {
        this.imgrint = imgrint;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productId='" + productId + '\'' +
                ", itemNumber='" + itemNumber + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", imgrint=" + imgrint +
                '}';
    }
}
