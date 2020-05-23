package vn.edu.ntu.tuananh.controller;

import android.app.Application;

import java.util.ArrayList;

import vn.edu.ntu.tuananh.model.Product;

public class CartController extends Application implements ICartController{
    ArrayList<Product> listProduct = new ArrayList<>();

    ArrayList<Product> shoppingCart = new ArrayList<>();

    public CartController() {
        listProduct.add(new Product("Xoài cát", 6000, "Xoài cát loại 1"));
        listProduct.add(new Product("Khoai lang", 4500, "Khoai lang tím giống Nhật"));
        listProduct.add(new Product("Me Thái", 12000, "Me Thái lan loại A"));
        listProduct.add(new Product("Ổi", 42000, "Ổi hồng "));
        listProduct.add(new Product("Mận tím", 13000, "Mận loại 2"));
        listProduct.add(new Product("Táo đỏ", 2400, "Táo đỏ Bắc Mỹ"));
        listProduct.add(new Product("Sầu riêng", 6700, "Sầu riêng Cà Mau"));
        listProduct.add(new Product("Bưởi", 1600, "Buổi 5roi"));
        listProduct.add(new Product("Mít", 30000, "Mít tố nữ"));
    }

    @Override
    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    @Override
    public boolean addToShoppingCart(Product p) {
        if(!shoppingCart.contains(p)){
            shoppingCart.add(p);
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void clearShoppingCart() {
            shoppingCart.clear();
    }

    @Override
    public String getCartQuantity() {
        if(shoppingCart.size() > 0)
            return new Integer(shoppingCart.size()).toString();
        return "";
    }
}
