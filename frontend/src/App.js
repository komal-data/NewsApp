import './App.css';
import Home from './components/Home/home';
import Login from './components/login/LoginUser';
// import { BrowserRouter as Router, Route, Routes, Navigate, BrowserRouter } from "react-router-dom";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import SignUp from "./components/registration/SignUp";
import Footer from './components/Footer/Footer';
import newsData from './components/newslist/newsData';
import ErrorBoundary from "./components/navbar/ErrorBoundary";
import NewsPage from './components/fetchnews/NewsPage';
import NavBarNew from './components/navbar/navbarNew';
import WishlistedNews from './components/wishlist/WishlistedNews';
// import { IsLogin } from './components/login/IsLogin';

function App() {
  
  // const isAuthenticated = IsLogin();
  // const [authorized, setAuthorized] = useState(false);

  // useEffect(() => {
  //   const token = localStorage.getItem('token');
  //   console.log(token);
  //   if (token) {
  //     setAuthorized(true);
  //   }
  // },[]);

  return (
 
     <div className="App">      
<ErrorBoundary>
      <Router>    

        <NavBarNew/>           
                  <Routes>                    
                    <Route path="/" element={<Home newsData={newsData}/>} />
                    <Route path="/home" element={<Home newsData={newsData}/>} />
                    <Route path="/login" element={<Login/>} />
                    <Route path="/register" element={<SignUp />} />        
                    <Route path="/news" element={<NewsPage />} /> 
                    <Route path="/wishlist" element={ <WishlistedNews />} />

                    {/* <Route path="/news/*" element={<PrivateRoute />} /> */}                    
                    {/* <PrivateRoute path="/news" element={<NewsPage />} /> */}
                    {/* <PrivateRoute path="/wishlist" element={<WishlistPage />} /> */}
                 
                  </Routes>            
        <Footer/>          
      </Router>
</ErrorBoundary>





{/* <Router>
        <NavbarHeader isAuthorized={authorized} />
        <div className="container-body">
          <Routes>
            <Route path="/" element={<Home newsData={newsData}/>}></Route>
            <Route path="/news" element={<ProtectedRoute isAuthorized={authorized}><NewsPage /></ProtectedRoute>}></Route>
            <Route path="/wishlist" element={<ProtectedRoute isAuthorized={authorized}><WishlistedNews /></ProtectedRoute>}></Route>
            <Route path="/login" element={<Login data={{ authorized, setAuthorized }} />}></Route>
            <Route path="/register" element={<SignUp />}></Route>
            <Route path="/logout" element={<Logout data={{ authorized, setAuthorized }} />}></Route>
          </Routes>
        </div>
        <Footer />
      </Router> */}



     </div>
     
  );
};

export default App;