import React from 'react';
import { shallow } from 'enzyme';
import Navbar from "./Navbar";

describe('<Navbar />', () => {
  it('should render a navbar logo name', () => {
    const wrapper = shallow(<Navbar />);
    expect(wrapper.find('.navbar__logo-name').text()).toEqual('Biblioteca')
  });

  it('should render navbar links', () => {
    const wrapper = shallow(<Navbar />);
    expect(wrapper.exists('Link')).toEqual(true);
  });
});