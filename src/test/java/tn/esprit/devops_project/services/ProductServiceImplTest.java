package tn.esprit.devops_project.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    public ProductServiceImplTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void TestaddProduct() {
        Product product = new Product();
        Stock stock = new Stock();
        Long idStock=1L;

        Mockito.when(stockRepository.save(stock)).thenReturn(stock);
        Product addNewProd = productService.addProduct(product, idStock);
        assertEquals(stock, addNewProd);
    }

    @Test
    void retrieveProduct() {
        Long id = 1L;
        Product product = new Product();
        when(productRepository.findById(id)).thenReturn(java.util.Optional.of(product));

        Product result = productService.retrieveProduct(id);

        assertEquals(product, result);
    }

    @Test
    void retreiveAllProduct() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());
        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.retreiveAllProduct();

        assertEquals(productList, result);
    }

    @Test
    void retrieveProductByCategory() {
        ProductCategory category = ProductCategory.ELECTRONICS;
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        when(productRepository.findByCategory(category)).thenReturn(productList);

        List<Product> result = productService.retrieveProductByCategory(category);

        assertEquals(productList, result);
    }

    @Test
    void deleteProduct() {
        Long id = 1L;
        productService.deleteProduct(id);

        verify(productRepository, times(1)).deleteById(id);
    }

    @Test
    void retreiveProductStock() {
        Long id = 1L;
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        when(productRepository.findByStockIdStock(id)).thenReturn(productList);

        List<Product> result = productService.retreiveProductStock(id);

        assertEquals(productList, result);
    }

}