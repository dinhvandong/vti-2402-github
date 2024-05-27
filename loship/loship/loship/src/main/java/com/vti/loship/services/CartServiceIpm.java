package com.vti.loship.services;

import com.vti.loship.database.SequenceGeneratorService;
import com.vti.loship.models.Cart;
import com.vti.loship.models.CartDetail;
import com.vti.loship.models.Product;
import com.vti.loship.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartServiceIpm implements CartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;



    @Override
    public Cart create(Cart newCart) {
        return cartRepository.insert( newCart);
    }

    @Override
    public Cart addProduct(Long id, Product product) {

        Optional<Cart> optional = cartRepository.findById(id);
        if(optional.isEmpty()) return null;

        Cart foundCart = optional.get();
        List<CartDetail> cartDetailList = foundCart.getCartDetailList();
        CartDetail cartDetail = new CartDetail();
        cartDetail.setProductID(product.getId());
        cartDetail.setCategoryName(product.getCategoryName());
        cartDetail.setProductName(product.getName());
        cartDetail.setPrice(product.getPrice());
        cartDetail.setId(sequenceGeneratorService.generateSequence(CartDetail.SEQUENCE_NAME));
        cartDetailList.add(cartDetail);
        foundCart.setCartDetailList(cartDetailList);


        return cartRepository.save(foundCart);
    }

    @Override
    public Cart removeProduct(Long id, Long idProduct) {
        Optional<Cart> optional = cartRepository.findById(id);
        if(optional.isEmpty()) return null;

        Cart foundCart = optional.get();
        List<CartDetail> cartDetailList = foundCart.getCartDetailList();

        cartDetailList.removeIf(cartDetail -> cartDetail.getProductID().equals(idProduct));
        foundCart.setCartDetailList(cartDetailList);
        return cartRepository.save(foundCart);
    }
    @Override
    public List<CartDetail> getAllProductInCart(Long userID) {

        Optional<Cart> optional = cartRepository.findById(userID);
        if(optional.isEmpty()) return null;
        Cart foundCart = optional.get();
        return foundCart.getCartDetailList();

    }
}
