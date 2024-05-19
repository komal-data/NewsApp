package com.wishlistService.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wishlists")
public class UserWishlist {

@Id
//private long wishlistId;
@JsonProperty("useremail")
private String useremail;
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "email_fk",referencedColumnName = "useremail")
private List<News> news;

}
