package com.newsapp.newsservice.Test.controller;

import com.newsapp.newsservice.controller.NewsController;
import com.newsapp.newsservice.exception.NoArticlesFoundException;
import com.newsapp.newsservice.model.NewsApiResponse;
import com.newsapp.newsservice.model.NewsArticle;
import com.newsapp.newsservice.service.NewsService;
import com.newsapp.newsservice.service.NewsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

public class NewsControllerTest {

	private MockMvc mockMvc;

    @Mock
    private NewsService newsService;

    @InjectMocks
    private NewsController newsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testGetLatestNews() throws Exception {
//    	when(newsService.getNews(anyString(), anyBoolean()))
//    			.thenReturn(new NewsApiResponse(Arrays.asList(new NewsArticle("Sample Title", "Sample Description","abcd.com","https://abcd.jpeg","http://img1.jpeg"))));
//    	
//    	mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/country-news")
//    			                .param("fromCountry", "USA")
//    			                .param("onlyInternational", "true"))
//    			.andExpect(MockMvcResultMatchers.status().isOk())
//    			.andExpect(MockMvcResultMatchers.jsonPath("$.news[0].Title").value("Sample Title"))
//    			.andExpect(MockMvcResultMatchers.jsonPath("$.news[0].Description").value("Sample Description"))
//    			.andExpect(MockMvcResultMatchers.jsonPath("$.news[0].Source").value("abcd.com"))
//    			.andExpect(MockMvcResultMatchers.jsonPath("$.news[0].Description").value("https://abcd.jpeg"))
//    			.andExpect(MockMvcResultMatchers.jsonPath("$.news[0].Url").value("http://img1.jpeg"));
//    }
}
