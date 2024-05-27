package com.vti.loship.services;

import com.vti.loship.models.Cart;
import com.vti.loship.models.CartDetail;
import com.vti.loship.models.Product;

import java.util.List;

public interface CartService {
    public Cart create(Cart newCart);
    public Cart addProduct(Long id, Product product);
    public Cart removeProduct(Long id, Long idProduct);
    public List<CartDetail> getAllProductInCart(Long userID);

}
