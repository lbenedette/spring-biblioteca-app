import React from 'react';
import { mount } from 'enzyme';
import { MemoryRouter } from 'react-router-dom';
import App from './App';
import NotFound from './NotFound/NotFound';
import Home from "./Home/Home";

describe('router should redirect to correct path', () => {
  it('invalid path should redirect to not found page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={['/random']}>
        <App/>
      </MemoryRouter>
    );

    expect(wrapper.find(NotFound)).toHaveLength(1);
  });

  it('default path should redirect to homepage', () => {
    const wrapper = mount(
      <MemoryRouter>
        <App/>
      </MemoryRouter>
    );

    expect(wrapper.find(Home)).toHaveLength(1);
  });
});