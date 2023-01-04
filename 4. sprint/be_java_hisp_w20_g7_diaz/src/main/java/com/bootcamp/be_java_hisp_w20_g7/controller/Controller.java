package com.bootcamp.be_java_hisp_w20_g7.controller;

import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostPromoCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g7.service.IFollowService;
import com.bootcamp.be_java_hisp_w20_g7.service.IPostService;
import com.bootcamp.be_java_hisp_w20_g7.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    IUserService iUserService;

    @Autowired
    IPostService postService;

    @Autowired
    IFollowService followService;

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    @PostMapping("users/{userId}/follow/{userIdToFollow}")
    ResponseEntity<String> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return ResponseEntity.ok(followService.follow(userId, userIdToFollow));
    }

    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDto> countFollowers(@PathVariable int userId){
        return new ResponseEntity<>(iUserService.countFollowers(userId),HttpStatus.OK);
    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    //US 0008: Ordenamiento alfabético ascendente y descendente
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersDto> findAllFollowers(@PathVariable int userId, @RequestParam(required = false) String order
    ) {
        UserFollowersDto userFollowersDto;
        if (order == null) {
            userFollowersDto = iUserService.userFollowers(userId, "");
        } else {
            userFollowersDto = iUserService.userFollowers(userId, order);
        }
        return new ResponseEntity<>(userFollowersDto, HttpStatus.OK);
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    //US 0008: Ordenamiento alfabético ascendente y descendente
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedDto> findUserFollowedList(@PathVariable int userId, @RequestParam(required = false) String order) {
        UserFollowedDto userFollowedDto;
        if (order == null) {
            userFollowedDto = iUserService.userFollowed(userId, "");
        } else {
            userFollowedDto = iUserService.userFollowed(userId, order);
        }
        return new ResponseEntity<>(userFollowedDto, HttpStatus.OK);
    }

    //US 0005: Dar de alta una nueva publicación
    @PostMapping("/products/post")
    ResponseEntity<String> postAdd(@RequestBody PostCreateDto post) {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas
    // (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    //US 0009: Ordenamiento por fecha ascendente y descendente
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<UserPostFollowedDto> postUsersFollowed(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.postUsersFollowed(userId, order),HttpStatus.OK);
    }

    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @PostMapping("users/{userId}/unfollow/{userIdToUnfollow}")
    ResponseEntity<String> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok(followService.unfollow(userId, userIdToUnfollow));
    }

    //US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/products/promo-post")
    ResponseEntity<String> postPromoAdd(@RequestBody PostPromoCreateDto postPromo) {
        return new ResponseEntity<>(postService.createPostPromo(postPromo), HttpStatus.OK);
    }

    //US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PostPromoCountByVendorDto> postPromoCountByVendor(@RequestParam(name = "user_id") int userId){
        return new ResponseEntity<>(postService.postPromoCountByVendor(userId),HttpStatus.OK);
    }

    //US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PostPromoByVendorDto> postPromoByVendor(@RequestParam(name = "user_id") int userId){
        return new ResponseEntity<>(postService.postPromoByVendor(userId),HttpStatus.OK);
    }
}
