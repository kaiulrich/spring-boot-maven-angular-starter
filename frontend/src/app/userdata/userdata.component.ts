import { Component, OnInit } from '@angular/core';
import { UserData } from '../userdata';
import { UserDataService } from '../userdata.service';

@Component({
  selector: 'userdata',
  templateUrl: './userdata.component.html',
  styleUrls: ['./userdata.component.css']
})
export class UserdataComponent implements OnInit {
    
    personalNummer: string = '';
    userdatas: UserData[];
    user: UserData;
    submitted = false;
    message = {type: 'info', text: 'Kein Benutzer ausgewählt! Bitte geben Sie eine Personalnummer ein.'}

    constructor(private userDataService: UserDataService) { }


    ngOnInit() {
        this.getUserDatas();
    }


    onSubmit() {
        this.getUser(this.personalNummer); 
    }

    // TODO: Remove this when we're done
    get diagnostic() { return JSON.stringify(this.user) + this.personalNummer}

    getUserDatas(): void {
      this.userDataService.getUserDatas()
      .subscribe(userdatas => this.userdatas = userdatas);
    }
    
    getUser(personalNummer: string): void {
        this.userDataService.getUserData(personalNummer)
        .subscribe(
        u => {
            if(u){
                console.log(u);
                this.user = u
                this.message =  {type: 'success', text: 'User found successfully !' };
            }else{
                this.message =  {type: 'warning', text: 'No User with personalnumber ' + personalNummer + ' found  ' } ;
            }
        },
        err => {
            this.message =  {type: 'info', text: err}
        });
      }

}
