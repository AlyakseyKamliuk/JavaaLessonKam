package com.lesson6;

/**
 * Created by Alex on 11.11.2019.
 */
public class Product {
    private int id;
    private double priceProduct;
    private String nameProduct;

    public Product(int id, double sumProduct, String nameProduct) {
        try {
            this.id = id;
            this.priceProduct = sumProduct;
            this.nameProduct = nameProduct;
        } catch (Exception e) {

        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }


    public String toString() {
        return "Product{" +
                "id=" + id +
                ", priceProduct=" + priceProduct +
                ", nameProduct='" + nameProduct + '\'' +
                '}';
    }


    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (Double.compare(product.getPriceProduct(), getPriceProduct()) != 0) return false;
        return true;
    }


    public int hashCode() {
        int result;
        long temp;
        result = getId();
        temp = Double.doubleToLongBits(getPriceProduct());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getNameProduct().hashCode();
        return result;
    }

}
