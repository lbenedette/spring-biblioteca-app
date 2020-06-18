import React from 'react';
import { shallow } from 'enzyme';
import Books from './Books';
import BookApi from '../../Api/book';
import mockBooks from '../../Mock/books';
jest.mock('../../Api/book');

describe('<Books />', () => {
  const flushPromises = () => new Promise(setImmediate);

  it('should fetch all books', async () => {
    shallow(<Books />);
    await flushPromises();

    expect(BookApi.getAll).toHaveBeenCalledTimes(1);
  });

  it('should render correct number of books in books page', async () => {
    BookApi.getAll.mockResolvedValue(mockBooks.books);
    const wrapper = shallow(<Books />);

    await flushPromises();
    wrapper.update();

    expect(wrapper.find('.book')).toHaveLength(3);
  });
});