import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {

  constructor(
    private service: UserService,
    private router: Router,
    private toastr: ToastrService
  ) {
    service.setUserLogout();
    router.navigate(['login']);
    this.toastr.success('logged out successfully!');
  }
}
