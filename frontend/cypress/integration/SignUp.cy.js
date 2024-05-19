
describe('Signup Form', () => {
    beforeEach(() => {
      cy.visit("http://localhost:3000/register"); // Assuming signup page is at /regiter route
    });
  
    it('displays validation errors for empty fields', () => {
      cy.get('button.btn').click(); // Click the Register button without filling any fields
      cy.contains('First Name is required').should('be.visible');
      cy.contains('Last Name is required').should('be.visible');
      cy.contains('User Email is required').should('be.visible');
      cy.contains('Password is required').should('be.visible');
      cy.contains('Contact Number is required').should('be.visible');
    });
  
    it('displays validation error for invalid email format', () => {
      cy.get('#form2').type('invalidemail'); // Type an invalid email format
      cy.get('button.btn').click();
      cy.contains('Invalid email format').should('be.visible');
    });
  
    it('displays validation error for invalid password format', () => {
      cy.get('#form3').type('pass'); // Type a password with less than 6 characters
      cy.get('button.btn').click();
      cy.contains('Password must contain at least 6 characters').should('be.visible');
    });
  
    it('displays validation error for invalid mobile number format', () => {
      cy.get('#form4').type('123'); // Type an invalid mobile number
      cy.get('button.btn').click();
      cy.contains('Invalid mobile number').should('be.visible');
    });
  
    it('successfully submits the form with valid data', () => {
      cy.get('#form1').type('komal');
      cy.get('#form5').type('Data');
      cy.get('#form2').type('komal@example.com');
      cy.get('#form3').type('Password1');
      cy.get('#form4').type('1234567890');
      cy.get('button.btn').click();
      cy.url().should('include', '/login'); // Assuming successful registration redirects to the login page
      
    });
  });
  