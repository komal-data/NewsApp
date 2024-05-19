import React from 'react';
import  "../Style/Home.css";
import NewsItem from '../Home/NewsItem';
const Home = ({newsData}) => {
  return (
    <>
    <section>
    <div className="container" >
      <h1>Latest News</h1>
      <div className="row">
            {newsData.map((news, index) => (
              <NewsItem key={index} news={news} />
            ))}
          </div>
    </div>
    </section>
      
    </>

  );
};

export default Home;