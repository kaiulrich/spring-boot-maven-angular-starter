import { UserData } from './userdata';

export const USERDATA: UserData[] = [
  { personalNumber: '1234567', firstname: 'Hallo', secondname: 'Name 1', errormessage: null },
  { personalNumber: '7654321', firstname: 'Hallo', secondname: 'Name 2', errormessage: null },
  { personalNumber: '0000000', firstname: 'do', secondname: 'test', errormessage: null },
  { personalNumber: 'xxxxxxx', firstname: null, secondname: null, errormessage: 'User not found' }
];
