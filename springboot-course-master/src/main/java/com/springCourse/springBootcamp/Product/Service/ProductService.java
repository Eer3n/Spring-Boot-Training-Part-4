package com.springCourse.springBootcamp.Product.Service;

import com.springCourse.springBootcamp.Product.Dao.ProductDao;
import com.springCourse.springBootcamp.Product.Entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findAllById(Long Id) {
        return productDao.findAllById(Id);
    }

    public Product findAllByTitle(String title) {
        return productDao.findAllByTitle(title);
    }

   /* public Product List<Product> findAllBySeller(Seller seller){
        return findAllBySeller(seller);
    }*/

    public Product findAllByIsDeleted(boolean isDeleted) {
        return productDao.findAllByIsDeleted(isDeleted);
    }

    public Product createNewProduct(Product product) {
        return productDao.save(product);
    }

    public void deleteGivenProduct(Product product) {
        productDao.delete(product);
    }

}
