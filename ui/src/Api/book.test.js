import axios from 'axios';
import BookApi from './book';
import mockBooksResponse from '../Mock/books';
jest.mock('axios');
jest.mock('./base', () => 'base.url.com');

describe('BookApi', () => {
  describe('getAll', () => {
    it('makes a get request to the books endpoint', async () => {
      axios.get.mockResolvedValue({ data: {} });

      await BookApi.getAll();

      expect(axios.get).toHaveBeenCalledWith('base.url.com/books');
    });

    it('returns the data payload with a successful request', async () => {
      axios.get.mockResolvedValue({ data: mockBooksResponse });

      const result = await BookApi.getAll();

      expect(result).toEqual(mockBooksResponse.books);
    });

    it('does not hide request error', async () => {
      axios.get.mockRejectedValue(new Error());

      await expect(BookApi.getAll()).rejects.toThrow();
    });
  });
});