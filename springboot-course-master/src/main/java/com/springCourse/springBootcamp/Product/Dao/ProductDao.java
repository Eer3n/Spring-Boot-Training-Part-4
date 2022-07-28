package com.springCourse.springBootcamp.Product.Dao;

import com.springCourse.springBootcamp.Product.Entity.Product;
//import com.springCourse.springBootcamp.Seller.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    @Query("select product from Product product")
    List<Product> findAll();

    @Query("select product from Product product where product.Id=:Id")
    Product findAllById(@Param("Id") Long Id);

    @Query("select product from Product product where product.title=:title")
    Product findAllByTitle(@Param("title") String title);

    //@Query("select product from Product product where product.seller=:seller")
    //Product findAllBySeller(@Param("seller") Seller seller);

    @Query("select product from Product product where product.shortText=:shortText and product.longText=:longText")
    Product findAllByShortTextAndLongText(@Param("shortText") String shortText, @Param("longText") String longText);

    @Query("select product from Product product where product.insDate=:insDare and product.updDate=:updDate")
    Product findAllByInsDateAndUpdDate(@Param("insDate") Date insDate, @Param("updDate") Date updDate);

    @Query("select product from Product  product where product.displayPrice=:displayPrice and product.discountPrice=:discountPrice ")
    Product findAllByDisplayPriceAndDiscountPrice(@Param("displayPrice") double displayPrice, @Param("discountPrice") double discountPrice);

    @Query("select product from Product product where product.isDeleted=:isDeleted")
    Product findAllByIsDeleted(@Param("isDeleted") boolean isDeleted);

    Product save(Product product);

    @Query("delete from Product product where product.Id=:productId")
    void deleteById(@Param("productId") Long Id);

}