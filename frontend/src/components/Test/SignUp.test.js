import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import SignUp from '../registration/SignUp';


jest.mock('axios');

test('registers user on button click', async () => {
  render(<SignUp />);

  // Fill in the form fields
  fireEvent.change(screen.getByPlaceholderText('First Name'), { target: { value: 'komal' } });
  fireEvent.change(screen.getByPlaceholderText('Last Name'), { target: { value: 'data' } });
  fireEvent.change(screen.getByPlaceholderText('User Email'), { target: { value: 'komal@example.com' } });
  fireEvent.change(screen.getByPlaceholderText('Password'), { target: { value: 'password123' } });
  fireEvent.change(screen.getByPlaceholderText('Contact Number'), { target: { value: '1234567890' } });

  axios.post.mockResolvedValue({ data: {} });

  // Click the register button
  fireEvent.click(screen.getByText('Register'));

  // Wait for axios.post to be called
  await waitFor(() => {
    expect(axios.post).toHaveBeenCalledWith('http://localhost:8085/api/v1.0/user/saveUser', {
      firstname: 'komal',
      lastname: 'data',
      useremail: 'komal@example.com',
      mobile: '1234567890',
      password: 'password123',
    });
  });
});
