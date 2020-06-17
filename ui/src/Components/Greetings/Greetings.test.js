import React from 'react';
import {mount} from 'enzyme';
import Greetings from './Greetings';


describe('<Greeting />', () => {
  it('should show greeting message', () => {
    const wrapper = mount(<Greetings />);
    expect(wrapper.text()).toEqual('Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!');
  });
})