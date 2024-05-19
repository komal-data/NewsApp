package com.wishlistService.controller;

import com.wishlistService.Entity.UserWishlist;
import com.wishlistService.service.UserWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1.0")
public class UserWishlistController {

	private UserWishlistService wishlistservice;
	public UserWishlistController(UserWishlistService wishlistservice) {
		super();
		this.wishlistservice = wishlistservice;
	}

	@PostMapping("/addNews")
	public ResponseEntity<UserWishlist> addNews(@RequestBody UserWishlist wishlist) {
		System.out.println("Received UserWishlist object: " + wishlist);
		return new ResponseEntity<>(wishlistservice.addNews(wishlist), HttpStatus.CREATED);		
	}

	@DeleteMapping("/removeNews/{wishlistId}/{newsId}")
	public ResponseEntity<String> removeNews(@PathVariable String wishlistId,@PathVariable Long newsId) {
		wishlistservice.removeNews(wishlistId,newsId);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Access-Control-Allow-Origin", "http://localhost:3000");
//	    headers.add("Access-Control-Allow-Methods", "DELETE,GET,POST,PUT");
//	    headers.add("Access-Control-Allow-Headers", "*");
	    return new ResponseEntity<>("News article removed from wishlist.", HttpStatus.OK);
//		return new ResponseEntity<>(wishlistservice.removeNews(wishlistId,newsId), HttpStatus.OK);
		
	}

	@GetMapping("/getNews/{wishlistId}")
	public ResponseEntity<UserWishlist> getNews(@PathVariable String wishlistId) {
		 UserWishlist wishlist = wishlistservice.findByWishlistId(wishlistId);
		    System.out.println("Wishlist data for ID " + wishlistId + ": " + wishlist);
		    return new ResponseEntity<>(wishlist, HttpStatus.OK);
	}
}
