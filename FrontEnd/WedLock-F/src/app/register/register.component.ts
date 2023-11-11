import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user: any;

  constructor(
    private service: UserService,
    private toastr: ToastrService,
    private router: Router
  ) {
    this.user = {
    
      userName: '',
      gender: '',
      dateOfBirth:'',
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
  }

  onSubmit(registrationForm: any) {
    this.user.userId = registrationForm.userId;
    this.user.userName = registrationForm.userName;
    this.user.gender = registrationForm.gender;
    this.user.dateOfBirth = registrationForm.dateOfBirth;
    this.user.motherTongue = registrationForm.motherTongue;
    this.user.location = registrationForm.location;
    this.user.height = registrationForm.height;
    this.user.education = registrationForm.education;
    this.user.job = registrationForm.job;
    this.user.salary = registrationForm.salary;
    this.user.phoneNumber = registrationForm.phoneNumber;
    this.user.emailId = registrationForm.emailId;
    this.user.password = registrationForm.password;
    console.log(this.user);
    this.toastr.success('Registered Successfully!');

    this.service.registerUser(this.user).subscribe((data: any) => {
     //this.toastr.success('Registered Successfully!');
      console.log(data);
      
    });
  }

  showLogin() {
    this.router.navigate(['login']);
  }
}
