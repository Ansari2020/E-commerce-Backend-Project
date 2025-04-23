//package org.example.ecommerce.Controller;
//
//import org.example.ecommerce.Exception.ProductNotFoundException;
//import org.example.ecommerce.Model.Product;
//import org.example.ecommerce.Repository.ProductRepository;
//import org.example.ecommerce.Service.ProductService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class ProductControllerTest {
//    @Autowired
//    private ProductController productController;
//
//    @MockitoBean
//    private ProductService productService;
//    @Mock
//    private ProductRepository productRepository;
//
//    @Test
//    void validateProductById() throws ProductNotFoundException {
//
//        Product product = new Product();
//        product.setId(1L);
//        product.setTitle("Product Title");
//        product.setPrice(155000.0);
//
//        when(productService.getProductById(1L)).
//                thenReturn(product);
//
//        Product actualProduct = productController.getProductById(1L).getBody();
//        assertEquals(product, actualProduct);
//    }
//
////    @Test
////    void testInValidProduct() throws ProductNotFoundException {
////
////        when(productRepository.findById(999L)).
////                thenReturn(Optional.empty());
////        assertThrows (ProductNotFoundException.class, () ->{
////            productService.getProductById(999L);
////        });
////
////    }
//
//    @Test
//    void testGetAllProducts() throws ProductNotFoundException {
//        List<Product> expectedProducts = new ArrayList<>();
//        Product p1= new Product();
//        p1.setId(1L);
//        p1.setTitle("Iphone 11");
//        p1.setPrice(155000.0);
//
//        Product p2= new Product();
//        p2.setId(2L);
//        p2.setTitle("Iphone 12");
//        p2.setPrice(155000.0);
//
//        Product p3= new Product();
//        p3.setId(3L);
//        p3.setTitle("Iphone 13");
//        p3.setPrice(155000.0);
//
//        expectedProducts.add(p1);
//        expectedProducts.add(p2);
//        expectedProducts.add(p3);
//
//        when(productService.getAllProducts()).
//                thenReturn(expectedProducts);
//
//        List<Product> products = productService.getAllProducts();
//        assertIterableEquals(expectedProducts, products);
//
//    }
//}