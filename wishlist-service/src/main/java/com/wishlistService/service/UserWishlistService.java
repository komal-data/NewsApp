package com.wishlistService.service;


import com.wishlistService.Entity.UserWishlist;


public interface UserWishlistService {

UserWishlist addNews(UserWishlist wishlist);
UserWishlist removeNews(String id, Long newsId);
UserWishlist findByWishlistId(String id);
}
