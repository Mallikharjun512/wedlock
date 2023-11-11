import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  isUserLogged: boolean;
  loginStatus: any;
  user :any;

  constructor(private http: HttpClient) {
    this.loginStatus = new Subject();
  
    this.isUserLogged=false;
    this.user = {
      "userId":"",
      "userName": "",
      "gender": "",
      "dateOfBirth":"", 
      "motherTongue": "",
      "location": "",
      "height": "",
      "education": "",
      "job": "",
      "salary": "",
      "phoneNumber": "",
      "emailId": "",
      "password": "",
  }

  }

  //Successfully Logged In
  setUserLoggedIn() {
    this.isUserLogged = true;
    this.loginStatus.next(true);
  }
  setUserLogout(){
    this.isUserLogged=false;
  }

  getUserLoggedStatus(){
    return this.isUserLogged;
  }

  getLoginStatus() {
    return this.loginStatus.asObservable();
  }

  registerUser(user: any) {
    return this.http.post('registerUser', user);
  }

  getUsers(): any {
    return this.http.get('getUsers');
  }

  login(user:any){
    console.log(user.emailId);
    console.log(user.password);
    return this.http.get("login"+"/"+ user.emailId + "," + user.password).toPromise();
  }

  getUserById(userId:any): any{
    return this.http.get("getUserById"+"/"+ userId);
  }

  findByEmail(emailId :any): any{
    return this.http.get("findByEmail"+"/"+ emailId);
  }


  findByName(userName :any):any{
    console.log(userName);
    return this.http.get("findByName"+"/"+ userName);
  }

  findByGender(gender :any): any{
    return this.http.get("findByGender"+"/"+ gender);
  }

  findByJob(job :any): any{
    return this.http.get("findByJob"+"/"+ job);
  }

  findByEducation(education :any): any{
    return this.http.get("findByEducation"+"/"+ education);
  }

  findByLocation(location :any): any{
    return this.http.get("findByLocation"+"/"+ location);
  }

  findBymotherTongue(motherTongue :any): any{
    return this.http.get("findBymotherTongue"+"/"+ motherTongue);
  }

  findMale()
  {
    return this.http.get('findMale');
  }

  findFemale()
  {
    return this.http.get('findFemale');
  }


  updateUser(user:any)
  {
    return this.http.put('updateUser', user);
  }


  forgetOtp(emailId: any) {
    return this.http.post("getEmailOtp", emailId);
  }

  otpVerify(emailId: any, otp: any) {
    return this.http.put("validateEmailOtp/" + emailId + "/" + otp, null);
  }

  resetpassword(emailid:any,password:any){
    return this.http.put("passwordReset/"+emailid+","+ password,null);
  }
}
