package com.wishlistService.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "News")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
