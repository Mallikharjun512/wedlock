import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { ToastrService } from 'ngx-toastr';


function passwordMatchValidator(formGroup: FormGroup) {
  const password = formGroup.get('password')!.value;
  const passwordConfirmation = formGroup.get('passwordConfirmation')!.value;

  return password === passwordConfirmation ? null : { passwordsDoNotMatch: true };
}

@Component({
  selector: 'app-reset-pass',
  templateUrl: './reset-pass.component.html',
  styleUrls: ['./reset-pass.component.css']
})
export class ResetPassComponent {


  passwordForm: FormGroup;
  sharedData: string | undefined;
  emailId: any;
  user: any;


  constructor(private formBuilder: FormBuilder , private service: UserService,private toastr: ToastrService) {
    this.passwordForm = this.formBuilder.group({
      password: ['', [Validators.required]],
      passwordConfirmation: ['', [Validators.required]],
    }, { validators: passwordMatchValidator });

    this.emailId = localStorage.getItem("emailId");

  }

  onSubmit() {

    if (this.passwordForm.valid) {

      const password1 = this.passwordForm.get('password')?.value;
      console.log(password1);
      this.service.resetpassword(this.emailId,password1).subscribe((data:any)=>{
        console.log(data);
        this.user=data;
        if(this.user != null){
          this.toastr.success("password updated success fully");
        }
        else{
          this.toastr.error("error");
        }
      });
    }
    else {
      // Form is invalid; handle errors or prevent submission.
    }
  }
}
