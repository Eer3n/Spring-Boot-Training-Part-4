package com.springCourse.springBootcamp.Seller.Controller;

import com.springCourse.springBootcamp.Seller.Entity.Seller;
import com.springCourse.springBootcamp.Seller.Exception.SellerNotFoundException;
import com.springCourse.springBootcamp.Seller.Service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("/find-all")
    public List<Seller> findAllSellers() {
        return sellerService.findAll();
    }

    @GetMapping("/{Id}")
    public Seller findSellerById(@PathVariable Long Id) {
        return sellerService.findAllById(Id);
    }

    @GetMapping("/{username}/{password}")
    public Seller findByUsernameAndPassword(@PathVariable String username, @PathVariable String password) throws Exception {
        Seller seller =  sellerService.findAllByUsernameAndPassword(username, password);
        if (seller == null) {
            throw new SellerNotFoundException("sellernot found!");
        }
        return seller;
    }

    @PostMapping("/create")
    public void save(@RequestBody Seller seller) {
        sellerService.createNewSeller(seller);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Seller seller){
        sellerService.deleteGivenSeller(seller);
    }
}