import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {

  user: any;
  oppositeGenderUsers: any[];
  gender: any;

  constructor(
    private service: UserService,
    private router: Router
  ) {
    this.gender = localStorage.getItem("gender");
    this.user = {
      userName: '',
      gender: '',
      dateOfBirth: '',
      motherTongue: '',
      location: '',
      height: '',
      education: '',
      job: '',
      salary: '',
      phoneNumber: '',
      emailId: '',
      password: ''
    };
    this.oppositeGenderUsers = [];
  }

  ngOnInit() {
      if (this.gender === "Male") {
        this.service.findFemale().subscribe((oppositeGenderData: any) => {
          this.oppositeGenderUsers = oppositeGenderData;
        });
      } else {
        this.service.findMale().subscribe((oppositeGenderData: any) => {
          this.oppositeGenderUsers = oppositeGenderData;
        });
      }
    
  }

  request() {
    // Your Google sign-in logic here
  }
}
