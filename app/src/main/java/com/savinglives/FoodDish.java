package com.savinglives;

public class FoodDish {
    private String productId;
    //TODO itemNumber
    private String name;
    private double price;
    private String description;
    private String imagenm; //not used
    private int imgrint;

    public FoodDish(String productId, String name, double price, String description, String imagenm, int imgrint) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagenm = imagenm; //not used
        this.imgrint = imgrint;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImagenm() {
        return imagenm;
    }

    public void setImagenm(String imagenm) {
        this.imagenm = imagenm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getImgrint() {
        return imgrint;
    }

    public void setImgrint(int imgrint) {
        this.imgrint = imgrint;
    }

    @Override
    public String toString() {
        return "FoodDish{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imagenm='" + imagenm + '\'' +
                ", imgrint=" + imgrint +
                '}';
    }
}
