///<reference types="Cypress"/>
describe('login page', () => {
    it('passes', () => {
      cy.visit('http://localhost:3000/login')
    })

    it('performs login', () => {
      cy.visit('http://localhost:3000/login')
      cy.get('#useremail').type('komal@gmail.com')
      cy.get('#password').type('komal1234')
      cy.get('button').click()
    })
    
  })