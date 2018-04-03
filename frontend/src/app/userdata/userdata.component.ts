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
    dienststelle: string = '159939';
    user ? : UserData;
    submitted = false;
    message = {}
    showData: boolean = false;

    constructor(private userDataService: UserDataService) { }


    ngOnInit() {
        this.message = {type: 'info', text: 'Kein Benutzer ausgewählt! Bitte geben Sie eine Dienststelle und eine Personalnummer ein.'}
    }


    onSubmit() {
        this.getUserDataRest(this.dienststelle, this.personalNummer); 
    }

    // TODO: Remove this when we're done
    get diagnostic() { return JSON.stringify(this.user) + ' ' + this.personalNummer+ ' ' + this.dienststelle}
    
    
    getUserDataRest(dienststelle: string, personalNummer: string): void {
        this.userDataService.getUserDataRest(dienststelle, personalNummer)
        .subscribe(
        u => {
            if(u){
                console.log(u);
                this.user = u;
                this.showData = true;
                this.message =  {type: 'success', text: 'Profil mit Personalnummer '+ personalNummer +' gefunden.' };
            }else{
                this.showData = false;
                this.message =  {type: 'warning', text: 'Kein Profil mit der Personalnummer ' + personalNummer + ' gefunden!' } ;
            }
        },
        err => {
            this.showData = false;
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
                this.showData = true;
                this.message =  {type: 'success', text: 'Profil mit Personalnummer '+ personalNummer +' gefunden.' };
            }else{
                this.showData = false;
                this.message =  {type: 'warning', text: 'Kein Profil mit der Personalnummer ' + personalNummer + ' gefunden!' } ;
            }
        },
        err => {
            this.showData = false;
            this.message =  {type: 'danger', text: err}
        });
      }

}
