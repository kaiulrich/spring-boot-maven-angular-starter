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
    message = {}

    constructor(private userDataService: UserDataService) { }


    ngOnInit() {
        this.message = {type: 'info', text: 'Kein Benutzer ausgewählt! Bitte geben Sie eine Personalnummer ein.'}
    }


    onSubmit() {
        this.getUserDataRest(this.personalNummer); 
    }

    // TODO: Remove this when we're done
    get diagnostic() { return JSON.stringify(this.user) + ' ' + this.personalNummer}
    
    
    getUserDataRest(personalNummer: string): void {
        this.userDataService.getUserDataRest(personalNummer)
        .subscribe(
        u => {
            if(u){
                console.log(u);
                this.user = u
                this.message =  {type: 'success', text: 'Profil mit Personalnummer '+ personalNummer +' gefunden.' };
            }else{
                this.message =  {type: 'warning', text: 'Kein Profil mit der Personalnummer ' + personalNummer + ' gefunden!' } ;
            }
        },
        err => {
            this.message =  {type: 'danger', text: err}
        });
      }
    
    getUser(personalNummer: string): void {
        this.userDataService.getUserData(personalNummer)
        .subscribe(
        u => {
            if(u){
                console.log(u);
                this.user = u
                this.message =  {type: 'success', text: 'Profil miit Personalnummer '+ personalNummer +' gefunden.' };
            }else{
                this.message =  {type: 'warning', text: 'Kein Profil mit der Personalnummer ' + personalNummer + ' gefunden!' } ;
            }
        },
        err => {
            this.message =  {type: 'danger', text: err}
        });
      }

}
