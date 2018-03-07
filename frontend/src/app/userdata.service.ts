import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
 
import { UserData } from './userdata';
import { USERDATA } from './mock-userdatas';

@Injectable()
export class UserDataService {

  constructor() { }
  
  getUserData(personalNumber: string): Observable<UserData> {
     var u = USERDATA.find(userdata => userdata.personalNumber === personalNumber)
     
     return of(u);
 }

}
