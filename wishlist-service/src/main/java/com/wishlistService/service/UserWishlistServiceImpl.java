package com.wishlistService.service;

import com.wishlistService.Entity.News;
import com.wishlistService.Entity.UserWishlist;
import com.wishlistService.exception.UserNotFoundException;
import com.wishlistService.repository.NewsRepo;
import com.wishlistService.repository.UserWishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserWishlistServiceImpl implements UserWishlistService {
private final UserWishlistRepo userWishlistRepo;
private final NewsRepo newsRepo;

@Autowired
public UserWishlistServiceImpl(UserWishlistRepo userWishlistRepo, NewsRepo newsRepo) {
	this.userWishlistRepo = userWishlistRepo;
	this.newsRepo = newsRepo;
}

@Override
public UserWishlist addNews(UserWishlist wishlist) {
	String userEmail = wishlist.getUseremail();
	Optional<UserWishlist> existingWishlistOptional = userWishlistRepo.findById(userEmail);
	if (existingWishlistOptional.isPresent()) {
		UserWishlist existingWishlist = existingWishlistOptional.get();
		existingWishlist.getNews().addAll(wishlist.getNews());
		return userWishlistRepo.save(existingWishlist);
	} else {
		return userWishlistRepo.save(wishlist);
	}
}

@Override
public UserWishlist findByWishlistId(String wishlistId) {
	
	Optional<UserWishlist> wishlist1 = userWishlistRepo.findById(wishlistId);
	if (wishlist1.isPresent()) {
		return wishlist1.get();
	} else {
		throw new UserNotFoundException("Did not find News");
	}
}

@Override
public UserWishlist removeNews(String wishlistId,Long newsId) {

	Optional<News> news = newsRepo.findById(newsId);
	if (news.isPresent()) {
		newsRepo.delete(news.get());
		return userWishlistRepo.findById(wishlistId).get();
	} else {
		throw new UserNotFoundException("Did not find News");
	}
	
}

	
}