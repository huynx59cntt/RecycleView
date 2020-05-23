package vn.edu.ntu.tuananh.controller;

import java.util.ArrayList;

import vn.edu.ntu.tuananh.model.Product;

public interface ICartController {
    public ArrayList<Product> getListProduct();

    //tuần 5
    public boolean addToShoppingCart(Product p);
    public ArrayList<Product> getShoppingCart();
    public void clearShoppingCart();
    //tuan 6
    public String getCartQuantity();
}
