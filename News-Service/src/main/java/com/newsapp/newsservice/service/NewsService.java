package com.newsapp.newsservice.service;

import com.newsapp.newsservice.model.NewsApiResponse;
import com.newsapp.newsservice.model.NewsArticle;

import java.util.List;

public interface NewsService {

	NewsApiResponse getNews(String fromCountry, Boolean onlyInternational);
}
