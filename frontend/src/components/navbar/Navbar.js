import React from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import logo from "../Images/logo.png";

function NavbarHeader({ isAuthorized }) {
    return (
        <>
            <Navbar expand="lg" className="navbar-dark bg-dark-subtle">
                <Container>
                    <Navbar.Brand className="header-title">
                    <Link className="navbar-brand" to="/" style={{color:"white"}}>
                    <img src={logo} 
                         alt="NewsApp Logo" 
                         height="45" 
                         className="d-inline-block align-top" 
                         style={{color:"white", marginRight:"2vh", borderRadius:"2vh"}} />
                    News App
                </Link>
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="ms-auto">
                            <Link to="/" className="m-3">Home</Link>
                            {/* <Link to="/about" className="m-3">About</Link> */}

                            {!isAuthorized && <Link to="/login" className="m-2 btn btn-primary">Login</Link>}
                            {!isAuthorized && <Link to="/register" className="m-2 btn btn-primary">SignUp</Link>}

                            {isAuthorized && <Link to="/news" className="m-3">News</Link>}
                            {isAuthorized && <Link to="/wishlist" className="m-3">Wishlist</Link>}

                            {isAuthorized && <Link to="/logout" className="m-2 btn btn-danger">Logout</Link>}
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    )
}

export default NavbarHeader