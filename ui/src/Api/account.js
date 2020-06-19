import axios from 'axios';
import baseURL from './base';

const AccountApi = {
  createAccount: async account => {
    await axios.post(`${baseURL}/accounts`, account);
  }
}

export default AccountApi;