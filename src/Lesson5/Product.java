package Lesson5;

/**
 * Created by Alex on 11.11.2019.
 */
public class Product {
    private int id;
    private double priceProduct;
    private String nameProduct;

    public Product(int id, double sumProduct, String nameProduct) {
        this.id = id;
        this.priceProduct = sumProduct;
        this.nameProduct = nameProduct;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", priceProduct=" + priceProduct +
                ", nameProduct='" + nameProduct + '\'' +
                '}';
    }
}
