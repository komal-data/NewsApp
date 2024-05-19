import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Logout } from "../login/Logout";
import logo from "../Images/logo.png";
import "../Style/Navbar.css";
import { Button } from "react-bootstrap"; 
import { IsLogin } from "../login/IsLogin";

const NavBarNew = () => {
    const navigate = useNavigate();
    const [login, setLogin] = useState(false);
    useEffect(() => {
        setLogin(IsLogin);
    }, []);

    const handleNavigate = (path) => {
        navigate(path);
    };

    const logout = () => {
        Logout(() => {
            setLogin(false);
            navigate("/");
        });
    };
 
    return (
        <nav className="navbar navbar-expand-sm navbar-dark bg-dark" style={{ backgroundColor: "rgba(0, 0, 0, 0.5)", color: "white" }}>
            <div className="container">
                <Link className="navbar-brand" to="/home" style={{color:"white"}}>
                    <img src={logo} alt="NewsApp Logo" height="45" className="d-inline-block align-top" style={{color:"white", marginRight:"2vh", borderRadius:"2vh"}} />
                    News App
                </Link>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
                </button>       

                <div className="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul className="navbar-nav mx-auto">
                        {!login ? (
                            <>
                                <li className="nav-item">
                                    <Button type="button" className="button" variant="dark" onClick={() => handleNavigate("/home")} style={{ color: "white" ,fontSize:'3vh'}}>Home</Button>
                                </li>
                                <li className="nav-item">
                                    <Button type="button" className="button" variant="dark" onClick={() => handleNavigate("/login")} style={{ color: "white",fontSize:'3vh'}}>Login</Button>
                                </li>
                                <li className="nav-item">
                                    <Button type="button" className="button" variant="dark" onClick={() => handleNavigate("/register")} style={{ color: "white",fontSize:'3vh' }}>Register</Button>
                                </li>
                            </>
                        ) : (
                            <>
                                <li className="nav-item">
                                    <Button type="button" className="button" variant="dark" onClick={() => handleNavigate("/news")} style={{ color: "white",fontSize:'3vh'}}>News</Button>
                                </li>
                                <li className="nav-item">
                                    <Button type="button" className="button" variant="dark" onClick={() => handleNavigate("/wishlist")} style={{ color: "white",fontSize:'3vh'}}>Wishlist</Button>
                                </li>
                            </>
                        )}
                    </ul>
                    {login && (
                        <ul className="navbar-nav ml-auto">
                            <li className="nav-item">
                                <Button type="button" className="button" variant="dark" onClick={logout} style={{ color: "white",fontSize:'3vh' }}>Logout</Button>
                            </li>
                        </ul>
                    )}
                </div>
            </div>
        </nav>
    );
}
 
export default NavBarNew;
