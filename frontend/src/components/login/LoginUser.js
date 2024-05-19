import React, { useState } from 'react';
import { TextField, Button, Container, Typography, Box } from '@mui/material';
import axios from 'axios';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [formData, setFormData] = useState({
    useremail: '',
    password: '',
  });
const navigate=useNavigate();
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();   

    try {
      const response = await axios.post('http://34.199.170.86:8086/api/v1.0/login', formData);
      console.log('Login successful:', response.data);
      // alert("Login Successfull");
      Swal.fire({
        icon: 'success',
        title: 'Successfully Login!',
        text: 'You have successfully login.',
      });
      localStorage.setItem("token",response.data.token);
      console.log(localStorage.getItem('token'));

      localStorage.setItem("useremail",response.data.useremail);
      console.log("userEmail",localStorage.getItem('useremail'));
      navigate("/news");
    } catch (error) {
      console.error('Login failed:', error.message);
      Swal.fire({
        icon: 'error',
        title: 'Login Error',
        text: 'An error occurred during login. Please try again.',
      });      
    }
  };

  return (
    <Container maxWidth="xs">
      <Box
        sx={{
          marginTop: 10,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
          marginBottom:'30vh',
        }}
      >
        <Typography component="h1" variant="h5">
          Login
        </Typography>
        <Box component="form" onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <TextField
            fullWidth
            label="Email"
            name="useremail"
            type="email"
            margin="normal"
            variant="outlined"
            required
            onChange={handleChange}
            value={formData.useremail}
          />
          <TextField
            fullWidth
            label="Password"
            name="password"
            type="password"
            margin="normal"
            required
            onChange={handleChange}
            value={formData.password}
          />        
          <Button type="submit" fullWidth variant="contained" sx={{ mt: 3 }}>
            Login
          </Button>
        </Box>
      </Box>
    </Container>
  );
};

export default Login;
