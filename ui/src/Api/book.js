import axios from 'axios';
import baseURL from './base';

const BookApi = {
  getAll: async () => {
    const response = await axios.get(`${baseURL}/books`);
    return response.data.books;
  }
}

export default BookApi;