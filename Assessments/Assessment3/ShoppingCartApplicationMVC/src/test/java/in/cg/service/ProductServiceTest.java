package in.cg.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import in.cg.model.Product;
import java.util.List;

public class ProductServiceTest {
    
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();
        assertNotNull(products);
        assertEquals(3, products.size());
    }

    @Test
    public void testGetProductById_Exists() {
        Product p = productService.getProductById(1);
        assertNotNull(p);
        assertEquals("Laptop", p.getName());
        assertEquals(90000.0, p.getPrice(),0.01);
    }

    @Test
    public void testGetProductById_NotExists() {
        Product p = productService.getProductById(99);
        assertNull(p);
    }
}