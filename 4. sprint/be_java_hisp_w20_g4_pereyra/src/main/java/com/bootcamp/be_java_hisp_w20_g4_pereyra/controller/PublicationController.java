package com.bootcamp.be_java_hisp_w20_g4_pereyra.controller;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.product.ProductDTORequest;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.publication.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.publication.PostDiscountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.PromoProductsCountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.ListedPublicationDiscountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.ListedPublicationsDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.PublicationDiscountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.service.publication.IServicePublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class PublicationController {
    @Autowired
    IServicePublication servicePublication;

    @PostMapping("/post")
    public ResponseEntity<PublicationDTO> add(@RequestBody PostDTO publicationDTO){
        return ResponseEntity.ok().body(servicePublication.addPublication(publicationDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ProductTwoWeeksResponseDTO> last2WeeksPublications(@PathVariable int userId, @RequestParam(value="order",required = false) String order){
        return ResponseEntity.ok().body(servicePublication.getLastTwoWeeksPublications(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PublicationDiscountDTO> addPromo (@RequestBody(required = false) PostDiscountDTO postDiscountDTO){
        return ResponseEntity.ok().body(servicePublication.addPromoPublication(postDiscountDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDTO> promoProductsOfSellerCount(@RequestParam(value="user_id") int userId){
        return ResponseEntity.ok().body(servicePublication.getCountProductsWithDiscount(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<ListedPublicationDiscountDTO> promoProductsOfSeller(@RequestParam(value="user_id") int userId){
        return ResponseEntity.ok().body(servicePublication.getProductsWithDiscount(userId));
    }

    @PostMapping("/post_product")
    public ResponseEntity<ProductDTO> postProduct(@RequestBody ProductDTORequest productDTORequest){
        return ResponseEntity.ok().body(servicePublication.createProduct(productDTORequest));
    }

    @GetMapping("/list")
    public ResponseEntity<ListedPublicationsDTO> getPublications(){
        return ResponseEntity.ok().body(servicePublication.getAllPublications());
    }

}
