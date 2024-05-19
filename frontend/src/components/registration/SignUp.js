import React, { useState } from 'react';
import axios from 'axios';
import { MDBContainer, MDBRow, MDBCol, MDBCard, MDBCardBody, MDBIcon, MDBInput, MDBCardImage } from 'mdb-react-ui-kit';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router-dom';
import '@fortawesome/fontawesome-free/css/all.min.css';
import { Button } from 'react-bootstrap';

const SignUp = () => {
  const [firstname, setfirstname] = useState('');
  const [lastname, setlastname] = useState('');
  const [useremail, setuseremail] = useState('');
  const [mobile, setmobile] = useState('');
  const [password, setpassword] = useState('');
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();

  const validateForm = () => {
    const errors = {};

    if (!firstname.trim()) {
      errors.firstname = 'First Name is required';
    }

    if (!lastname.trim()) {
      errors.lastname = 'Last Name is required';
    }

    if (!useremail.trim()) {
      errors.useremail = 'User Email is required';
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(useremail)) {
      errors.useremail = 'Invalid email format';
    }

    if (!password.trim()) {
      errors.password = 'Password is required';
    } else if (!/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,}$/i.test(password)) {
      errors.password = 'Password must contain at least 6 characters, one letter, and one number';
    }

    if (!mobile.trim()) {
      errors.mobile = 'Contact Number is required';
    } else if (!/^\d{10}$/i.test(mobile)) {
      errors.mobile = 'Invalid mobile number';
    }

    setErrors(errors);
    return Object.keys(errors).length === 0;
  };


  const handleSubmit = async (event) => {
    event.preventDefault();

    if (!validateForm()) {
      return;
    }
    const payload = {
      firstname: firstname,
      lastname: lastname,
      useremail: useremail,
      mobile: mobile,
      password: password,
    };
   
    axios.post('http://34.199.170.86:8085/api/v1.0/user/saveUser', payload)
            .then((response) => {
                console.log(response.data);
                setfirstname('');
                setlastname('');
                setuseremail('');
                setmobile('');
                setpassword('');                
                
                Swal.fire({
                  icon: 'success',
                  title: 'Successfully registered!',
                  text: 'Your account has been successfully created.',
                });
                navigate("/login");
            })
            .catch((error) => {
                
                    console.log("Error", error.message);
                    Swal.fire({
                      icon: 'error',
                      title: 'Registration Error',
                      text: 'An error occurred during registration. Please try again.',
                    });
            });
  };

  return (
    <MDBContainer  style={{marginTop:'80px'}}fluid>
      <MDBCard className='text-black m-5' style={{ borderRadius: '25px', overflow: 'hidden',marginTop:'300px' }}>
        <MDBCardBody >
          <MDBRow>
            <MDBCol md='10' lg='6' className='order-2 order-lg-1 d-flex flex-column align-items-center'>
              <h3 className='mb-5 text-uppercase fw-bold'>Registration form</h3>

              <div className='d-flex flex-row align-items-center mb-4'>
                <MDBIcon fas icon='user me-3' size='lg' />                               
                <MDBInput                  
                  placeholder='First Name'
                  id='form1'
                  required
                  type='text'
                  className='w-100'
                  value={firstname}
                  onChange={(event) => setfirstname(event.target.value)}
                  autoFocus
                />                                               
              </div>
              <div>
              {errors.firstname && <div className='text-danger' style={{ marginBottom: '20px', marginTop:'-20px' }}>{errors.firstname}</div>}
              </div> 
              <div className='d-flex flex-row align-items-center mb-4'>
                <MDBIcon fas icon='user me-3' size='lg' />
                <MDBInput
                  
                  placeholder='Last Name'
                  required
                  id='form5'
                  type='text'
                  className='w-100'
                  value={lastname}
                  onChange={(event) => setlastname(event.target.value)}
                />                
              </div>
              <div>
              {errors.lastname && <div className='text-danger' style={{ marginBottom: '20px', marginTop:'-20px' }}>{errors.lastname}</div>}
              </div>
              <div className='d-flex flex-row align-items-center mb-4'>
                <MDBIcon fas icon='envelope me-3' size='lg' />
                <MDBInput
                 
                  placeholder='User Email'
                  id='form2'
                  type='email'
                  value={useremail}
                  onChange={(event) => setuseremail(event.target.value)}
                  required
                />
              </div>
              <div>
              {errors.useremail && <div className='text-danger' style={{ marginBottom: '20px', marginTop:'-20px' }}>{errors.useremail}</div>}
              </div>
              <div className='d-flex flex-row align-items-center mb-4'>
                <MDBIcon fas icon='lock me-3' size='lg' />
                <MDBInput
                 
                  placeholder='Password'
                  required
                  id='form3'
                  type='password'
                  value={password}
                  onChange={(event) => setpassword(event.target.value)}
                  autoComplete='password'
                />                
              </div>
              <div>
              {errors.password && <div className='text-danger' style={{ marginBottom: '20px', marginTop:'-20px' }}>{errors.password}</div>}
              </div>
              <div className='d-flex flex-row align-items-center mb-4'>
                <MDBIcon fas icon='phone' size='lg' style={{ marginRight: '10px' }} />
                <MDBInput
                  
                  placeholder='Contact Number'
                  required
                  id='form4'
                  type='tel'
                  value={mobile}
                  onChange={(event) => setmobile(event.target.value)}
                />                
              </div>
              <div>
              {errors.mobile && <div className='text-danger' style={{ marginBottom: '20px', marginTop:'-20px' }}>{errors.mobile}</div>}
              </div>
              {/* <MDBBtn className='me-1' onClick={handleSubmit}>
                Register
              </MDBBtn> */}
              <Button type="button" onClick={handleSubmit} className='btn'>Register</Button>
            </MDBCol>

            <MDBCol md='10' lg='6' className='order-1 order-lg-2 d-flex align-items-center'>
              <MDBCardImage src='https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp' fluid />
            </MDBCol>
          </MDBRow>
        </MDBCardBody>
      </MDBCard>
    </MDBContainer>
  );
};

export default SignUp;
