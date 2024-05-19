// NewsList.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import NewsItemWishlist from '../newslist/NewsItemWishlist';

const NewsList = () => {
  const [newsData, setNewsData] = useState([]);

  useEffect(() => {
    const fetchNewsData = async () => {
      try {
        const token = localStorage.getItem('token');

        if (!token) {
          console.error('Token not found.');
          return;
        }

        const response = await axios.get('http://34.199.170.86:9098/api/v1.0/country-news?fromCountry=in&onlyInternational=true', {
            headers: {
                'Authorization': `Bearer ${token}`,
                'X-RapidAPI-Key': 'badb0ebf76msha3a655e517c532fp1d1a9bjsnf738c268cdfb',
                'X-RapidAPI-Host': 'news67.p.rapidapi.com',
            },
          });

         // Log the entire response for inspection
    console.log('Full Response:', response.status);

    // Log the response headers
    // console.log('Response Headers:', response.headers);
    // Log only the response data
    console.log('Response Data:', response.data);

            setNewsData(response.data.news);           
      } catch (error) {
        console.error('Error fetching news data:', error);
      }
    };

    fetchNewsData();
  }, []);

  return (
    <div className="container">
      <h1 style={{marginTop:'50px'}}>Top Headlines</h1>
      <div className="row">
       
         {newsData && newsData.length > 0 ? (
        newsData.map((news, index) => (
          <NewsItemWishlist key={index} news={news} />
        ))
      ) : (
        <p style={{fontSize:'5vh', marginBottom:'52vh'}}>No news available</p>
      )}
      </div>
    </div>
  );
};

export default NewsList;
