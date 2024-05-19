import React from 'react';
import "../Style/Footer.css";
const Footer = () => {
  return (
    <footer className="bg-dark text-center text-lg-start">
      <div className="text-center p-3" id="footer" style={{backgroundColor: 'rgba(0, 0, 0, 0.5)', color:'white'}}>
        © 2024 Copyright: News App
      </div>
    </footer>
  );
};

export default Footer;