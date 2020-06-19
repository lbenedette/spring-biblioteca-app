import React from 'react';
import AccountApi from "../../Api/account";

class CreateAccount extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      email: '',
      password: '',
      password_confirmation: '',
      phone_number: ''
    };
  };

  onSubmit = async event => {
    event.preventDefault();

    await AccountApi.createAccount(this.state);
  };

  handleChangeFor = fieldName => event => {
    this.setState({ [fieldName]: event.target.value });
  };

  render() {
    return (
      <form onSubmit={this.onSubmit}>
        <h1>Create Account</h1>

        <label htmlFor="name">Name:</label>
        <input type="text" id="name" name="name" onChange={this.handleChangeFor('name')}/>

        <label htmlFor="email">Email:</label>
        <input type="email" id="email" name="email" onChange={this.handleChangeFor('email')}/>

        <label htmlFor="password">Password:</label>
        <input type="password" id="password" name="password" onChange={this.handleChangeFor('password')}/>

        <label htmlFor="password_confirmation">Password Confirmation:</label>
        <input type="password" id="password_confirmation" name="password_confirmation"
               onChange={this.handleChangeFor('password_confirmation')}/>

        <label htmlFor="phone_number">Phone Number:</label>
        <input type="text" id="phone_number" name="phone_number" onChange={this.handleChangeFor('phone_number')}/>

        <br/>

        <input type="submit" id="submit" value="Create Account"/>
      </form>
    );
  }
}

export default CreateAccount;