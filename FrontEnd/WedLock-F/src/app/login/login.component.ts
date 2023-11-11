import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup ,Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: any;
  isCaptchaResolved: boolean = false;
  protected aFormGroup: FormGroup | undefined;
  siteKey: string = '6LckD7UoAAAAAG86gJixXJkcdhNQFKjSBR0SFVM_';

  constructor(
    private router: Router,
    private service: UserService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService  ) {this.aFormGroup = this.formBuilder.group({
      recaptcha: ['', Validators.required]
    });}

  async onSubmit(loginform: any) {
    console.log(loginform);

    if (loginform.emailId == 'admin@admin.com' && loginform.password == 'Admin@123') {
      this.service.setUserLoggedIn();
      this.toastr.success('Login successful!');
    } else {
      await this.service.login(loginform).then((data: any) => {
        console.log(data);
        this.user = data;
        console.log(this.user.gender);
        //Implementing LocalStorage
        localStorage.setItem("gender",this.user.gender );
        console.log(this.user.emailId);
        console.log(this.user.emailId);
        //Implementing LocalStorage
        localStorage.setItem("emailId",this.user.emailId );
        
      });

      if (this.user != null) {
        this.service.setUserLoggedIn();
        // this.toastr.success('Login successful!');
        this.router.navigate(['home']);
      } 
      else {
        this.toastr.error('Invalid Credentials');
      }

    }
    
  }

  handleCaptchaResolved(event: any): void {
    this.isCaptchaResolved = true;
}

   handleCaptchaExpired(event: any): void {
     // Handle the expired event if needed.
     // You can reset the isCaptchaResolved flag here.
     this.isCaptchaResolved = false;
  }



  showRegister() {
    this.router.navigate(['register']);
  }

  signInWithGoogle() {
    // Your Google sign-in logic here
  }

  ngOnInit() {
    this.aFormGroup = this.formBuilder.group({
      recaptcha: ['', Validators.required]
    });
  }

  
}
