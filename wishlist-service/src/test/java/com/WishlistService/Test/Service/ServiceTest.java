package com.WishlistService.Test.Service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import com.wishlistService.Entity.News;
import com.wishlistService.Entity.UserWishlist;
import com.wishlistService.exception.UserNotFoundException;
import com.wishlistService.repository.NewsRepo;
import com.wishlistService.repository.UserWishlistRepo;
import com.wishlistService.service.UserWishlistServiceImpl;


class ServiceTest {
	@Mock
	private UserWishlistRepo userWishlistRepo;

	@Mock
	private NewsRepo newsRepo;

	@InjectMocks
	private UserWishlistServiceImpl userWishlistService;

	private UserWishlist mockUserWishlist;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockUserWishlist = createMockUserWishlist();
	}

	private UserWishlist createMockUserWishlist() {
		UserWishlist wishlist = new UserWishlist();
		wishlist.setUseremail("test@example.com");
		return wishlist;
	}

	@Test
	void testAddNews() {
		when(userWishlistRepo.findById("test@example.com")).thenReturn(Optional.empty());
		when(userWishlistRepo.save(any(UserWishlist.class))).thenReturn(mockUserWishlist);
		
		UserWishlist result = userWishlistService.addNews(mockUserWishlist);
		
		assertNotNull(result);
		assertEquals("test@example.com", result.getUseremail());
	}

	@Test
	void testFindByWishlistId() {
		when(userWishlistRepo.findById("test@example.com")).thenReturn(Optional.of(mockUserWishlist));
		
		UserWishlist result = userWishlistService.findByWishlistId("test@example.com");
		
		assertNotNull(result);
		assertEquals("test@example.com", result.getUseremail());
	}

	@Test
	void testFindByWishlistIdNotFound() {
		when(userWishlistRepo.findById("test@example.com")).thenReturn(Optional.empty());
		
		assertThrows(UserNotFoundException.class, () -> {
			userWishlistService.findByWishlistId("test@example.com");
		});
	}

	@Test
	void testRemoveNews() {
		News news = new News();
		news.setId(1L);
		mockUserWishlist.setNews(new ArrayList<>());
		mockUserWishlist.getNews().add(news);
		
		when(newsRepo.findById(1L)).thenReturn(Optional.of(news));
		when(userWishlistRepo.findById("test@example.com")).thenReturn(Optional.of(mockUserWishlist));
		doNothing().when(newsRepo).delete(news);
		
		UserWishlist result = userWishlistService.removeNews("test@example.com", 1L);
		
		assertNotNull(result);
		assertEquals("test@example.com", result.getUseremail());
		
	}

	@Test
	void testRemoveNewsNotFound() {
		when(newsRepo.findById(1L)).thenReturn(Optional.empty());
		
		assertThrows(UserNotFoundException.class, () -> {
			userWishlistService.removeNews("test@example.com", 1L);
		});
	}

}
