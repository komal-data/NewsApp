package com.newsapp.newsservice.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsapp.newsservice.model.NewsApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.net.URI;

@Service
public class NewsServiceImpl implements NewsService {

	private static final Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;
	private final ObjectMapper objectMapper;
	

	private static final String API_URL = "https://news67.p.rapidapi.com/v2/country-news";
	private static final String API_KEY = "badb0ebf76msha3a655e517c532fp1d1a9bjsnf738c268cdfb";
		
	public NewsServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper
									.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				                    .setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
		
	@Override
	public NewsApiResponse getNews(String fromCountry, Boolean onlyInternational) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(API_URL).queryParam("fromCountry", fromCountry)
				                               .queryParam("onlyInternational", onlyInternational);
		
		URI apiUrlWithParams = builder.build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-RapidAPI-Key", API_KEY);
		headers.add("X-RapidAPI-Host", "news67.p.rapidapi.com");
		
		RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, apiUrlWithParams);
		System.out.println("URL: " + apiUrlWithParams);
		
		try {
			String jsonResponse = restTemplate.exchange(requestEntity, String.class).getBody();
			System.out.println("Raw JSON Response: " + jsonResponse);
			
			NewsApiResponse newsApiResponse = objectMapper.readValue(jsonResponse, NewsApiResponse.class);
			
			return newsApiResponse;
		} catch (Exception e) {
//			e.printStackTrace();
			logger.error("Error during API request: " + e.getMessage());
		}
		logger.info("News Articles :");
		return new NewsApiResponse();
	}
}
