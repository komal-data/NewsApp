package com.newsapp.newsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsArticle {
	
	
	@JsonProperty("Title")
    private String title;
	@JsonProperty("Description")
    private String description;
	@JsonProperty("Source")
	private String source;
	@JsonProperty("Image")
	private String image;
	@JsonProperty("Url")
	private String url;
	
}
