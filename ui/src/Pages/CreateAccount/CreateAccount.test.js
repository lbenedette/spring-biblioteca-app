import React from 'react';
import { mount } from 'enzyme';
import CreateAccount from './CreateAccount';
import AccountApi from '../../Api/account';

jest.mock('../../Api/account');

describe('<CreateAccount />', () => {
  const validInputs = {
    name: 'John Doe',
    email: 'newEmail@example.com',
    password: '@Password1',
    password_confirmation: '@Password1',
    phone_number: '5516998877885'
  };

  it('should create account with entered values', () => {
    const wrapper = mount(<CreateAccount/>);

    wrapper
      .find('#name')
      .simulate('change', { target: { value: validInputs.name } });
    wrapper
      .find('#email')
      .simulate('change', { target: { value: validInputs.email } });
    wrapper
      .find('#password')
      .simulate('change', { target: { value: validInputs.password } });
    wrapper
      .find('#password_confirmation')
      .simulate('change', { target: { value: validInputs.password_confirmation } });
    wrapper
      .find('#phone_number')
      .simulate('change', { target: { value: validInputs.phone_number } });

    // https://github.com/enzymejs/enzyme/issues/308
    wrapper.find('#submit').simulate('submit');

    expect(AccountApi.createAccount).toHaveBeenCalledWith(validInputs);
  });
});