import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse } from '@angular/common/http'

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';
 
import { UserData } from './userdata';
import { USERDATA } from './mock-userdatas';

@Injectable()
export class UserDataService {
 
    constructor(private _http:HttpClient){}
    
    getUserData(personalNumber: string): Observable<UserData> {
        var u = USERDATA.find(userdata => userdata.personalNumber === personalNumber)
        
        return of(u);
    }
    
    getUserDataRest(personalNumber: string): Observable<UserData>{
      return this._http
        .get<UserData>('/api/userdata/' + personalNumber)
        .do(data =>console.log('All : ' + JSON.stringify(data)))
        .catch(this.handleError);
    }
  
  
  
  private handleError(error: HttpErrorResponse)
  {
    //debugger;
    console.log(error);
    let errorMessage = '';
    if (error instanceof Error) {
        // A client-side or network error occurred. Handle it accordingly.
        errorMessage = `An error occurred: ${error.message}`;
    } else {
        // The backend returned an unsuccessful response code.
        // The response body may contain clues as to what went wrong,
        errorMessage = `Server returned code: ${error.status}, error message is: ${error.message}`;
    }
    console.log(errorMessage);
    return Observable.throw(errorMessage);
}

}
