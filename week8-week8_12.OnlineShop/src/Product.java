/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */
public class Product {

    private String product;
    private int price;
    private int stock;

    public Product(String product, int price, int stock) {
        this.product = product;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Product product = (Product) obj;

        if (this.product == null) {
            return false;
        }

        return this.product.equals(product.product) && (price == product.price) && (stock == product.stock);
    }
}
