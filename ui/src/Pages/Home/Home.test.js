import React from 'react';
import { shallow } from 'enzyme';
import Greetings from "../../Components/Greetings/Greetings";
import Home from "./Home";

describe('<Home />', () => {
  it('should show greetings to users', () => {
    const wrapper = shallow(<Home />);
    expect(wrapper.contains(<Greetings />)).toEqual(true);
  });
});