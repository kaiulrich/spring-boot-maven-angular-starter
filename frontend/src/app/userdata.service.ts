import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
 
import { UserData } from './userdata';
import { USERDATA } from './mock-userdatas';

@Injectable()
export class UserDataService {

  constructor() { }
  
  getUserData(personalNumber: string): Observable<UserData> {
      // Todo: send the message _after_ fetching the UserData
     console.log(personalNumber);
     var u = USERDATA.find(userdata => userdata.personalNumber === personalNumber)
     console.log(u);

     return of(u);
 }
  
  getUserDatas(): Observable<UserData[]> {
      // Todo: send the message _after_ fetching the heroes
      return of(USERDATA);
  }


}
