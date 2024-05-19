package com.newsapp.newsservice.controller;

import com.newsapp.newsservice.exception.NoArticlesFoundException;
import com.newsapp.newsservice.model.NewsApiResponse;
import com.newsapp.newsservice.service.NewsServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/api/v1.0/")
public class NewsController {

	@Autowired
	private NewsServiceImpl newsService;

	public NewsController(NewsServiceImpl newsService) {
		this.newsService = newsService;
	}

	@GetMapping("/country-news")
	public NewsApiResponse getLatestNews(@RequestParam String fromCountry, @RequestParam Boolean onlyInternational)
			throws NoArticlesFoundException {
		try {
			return newsService.getNews(fromCountry, onlyInternational);
		} catch (Exception e) {
			throw new NoArticlesFoundException(e.getMessage());
		}
	}

}
