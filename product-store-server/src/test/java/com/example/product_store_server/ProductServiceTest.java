package com.example.product_store_server;

import com.example.product_store_server.models.Product;
import com.example.product_store_server.repositories.ProductRepository;
import com.example.product_store_server.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private List<Product> productsList;
    @BeforeEach
    void init(){
        Product product1 = new Product("Product 1","Great",1.0F);
        Product product2 = new Product("Product 2","Bad", 2.0F);
        productsList=new ArrayList<Product>();

        Collections.addAll(productsList,product1,product2);

    }

    @Test
    void testFindAllProducts(){
        Mockito.when(productRepository.findAll()).thenReturn(productsList);

        List<Product> products= productService.findAll();

        assertThat(products).isEqualTo(productsList);
    }


    @Test
    void testSaveProduct(){
        Product product= new Product("Product","gut",1.0F);

        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product productSaved= productService.save(product);

        assertThat(productSaved).isEqualTo(product);

    }


    @Test
    void testDeleteProduct(){
        Product product= productsList.getFirst();
        Long id=1L;

        Mockito.doNothing().when(productRepository).deleteById(id);
        productRepository.deleteById(id);

        Mockito.verify(productRepository,Mockito.times(1)).deleteById(id);
    }


    @Test
    void testFindProductById(){
        Product product= productsList.getFirst();
        Long id=1L;
        Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(product));

        Optional<Product> productFound= productService.findById(id);

        assertThat(productFound).isEqualTo(Optional.of(product));

    }


}
