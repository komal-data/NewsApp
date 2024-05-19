import React, { useEffect, useState } from 'react';
import { IsLogin } from '../login/IsLogin';
import axios from 'axios';
import NewsItem from '../newslist/NewsItem';

const WishlistedNews = () => {
  const isLoggedIn = IsLogin();
  const [wishlistedNews, setWishlistedNews] = useState([]);

  useEffect(() => {
    if (isLoggedIn) {
      // Fetch wishlisted news data from the backend
      const token = localStorage.getItem('token');
      const useremail = localStorage.getItem('useremail');

      axios.get(`http://34.199.170.86:8089/api/v1.0/getNews/${useremail}`, {
        headers: {
          Authorization: `Bearer ${token}`
        }
      })
      .then(response => {
        setWishlistedNews(response.data.news);        
      })
      .catch(error => {
        console.error('Error fetching wishlisted news:', error);
      });
    }
  }, [isLoggedIn]);

  return (
    <div className="container mt-4">
    {isLoggedIn ? (
      <>
        <h2 className="mb-4">Wishlisted News</h2>
        <div className="row">
        
        {wishlistedNews && wishlistedNews.length > 0 ? (
          wishlistedNews.map((news, index) => (          
          <NewsItem key={index} news={news} />
          ))
      ) : (
        <p style={{fontSize:'5vh', marginBottom:'61vh'}}>Wishlist is Empty</p>
      )}
      </div>
      </>
    ) : (
      <h2 style={{marginBottom:'41vh',marginTop:'35vh'}}>Please log in to view wishlisted News Articles.</h2>
    )}
  </div>
  );
};

export default WishlistedNews;
