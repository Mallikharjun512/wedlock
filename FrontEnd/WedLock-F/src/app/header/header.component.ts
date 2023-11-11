import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent  {

  constructor(private serive:UserService){

  }

  userloggedstatus():boolean{
    return this.serive.getUserLoggedStatus();
  }


}
