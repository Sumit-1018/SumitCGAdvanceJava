package in.cg.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import in.cg.model.Product;

public class CartServiceTest {

    private CartService cartService;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cartService = new CartService();
        product1 = new Product(1, "Test Item 1", 100.0);
        product2 = new Product(2, "Test Item 2", 50.0);
    }

    @Test
    public void testAddToCart_NewItem() {
        cartService.addToCart(product1, 2);
        
        assertEquals(1, cartService.getCartItems().size());
        assertEquals(2, cartService.getCartItems().get(0).getQuantity());
        assertEquals(200.0, cartService.getTotalAmount(),0.01);
    }

    @Test
    public void testAddToCart_ExistingItem() {
        cartService.addToCart(product1, 1);
        cartService.addToCart(product1, 3); // Adding same product again
        
        assertEquals(1, cartService.getCartItems().size());
        assertEquals(4, cartService.getCartItems().get(0).getQuantity());
        assertEquals(400.0, cartService.getTotalAmount(),0.01);
    }

    @Test
    public void testUpdateQuantity() {
        cartService.addToCart(product1, 2);
        cartService.updateQuantity(1, 5);
        
        assertEquals(5, cartService.getCartItems().get(0).getQuantity());
        assertEquals(500.0, cartService.getTotalAmount(),0.01);
	}

    @Test
    public void testUpdateQuantity_ZeroRemovesItem() {
        cartService.addToCart(product1, 2);
        cartService.addToCart(product2, 1);
        
        cartService.updateQuantity(1, 0); // Should remove product1
        
        assertEquals(1, cartService.getCartItems().size());
        assertEquals("Test Item 2", cartService.getCartItems().get(0).getProduct().getName());
    }

    @Test
    public void testClearCart() {
        cartService.addToCart(product1, 1);
        cartService.addToCart(product2, 2);
        
        cartService.clearCart();
        
        assertTrue(cartService.getCartItems().isEmpty());
        assertEquals(0.0, cartService.getTotalAmount(),0.01);
    }
}