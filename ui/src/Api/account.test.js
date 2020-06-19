import axios from 'axios';
import AccountApi from './account';
jest.mock('axios');
jest.mock('./base', () => 'base.url.com');

describe('AccountApi', () => {
  describe('createAccount', () => {
    it('call api to create account', async () => {
      const account = {};

      await AccountApi.createAccount(account);

      expect(axios.post).toHaveBeenCalledWith('base.url.com/accounts', account);
    });
  });
});
