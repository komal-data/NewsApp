import React from 'react';
import NewsList from './NewsList';
import { IsLogin } from '../login/IsLogin';

const NewsPage = () => {
  const isLoggedIn = IsLogin();

  return (
    <div >
      {isLoggedIn ? (
        <div >
          <h1>Welcome to the News Page!</h1>
          <NewsList />
        </div>
      ) : (
        <h2 style={{marginBottom:'41vh',marginTop:'35vh'}}>!!Please log in to view the news!!</h2>
      )}
    </div>
  );
};

export default NewsPage;
