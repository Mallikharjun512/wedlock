import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { ToastrModule } from 'ngx-toastr';
import { MatchesComponent } from './matches/matches.component';
import { HomeComponent } from './home/home.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AgePipe } from './age.pipe';
import { ProfileComponent } from './profile/profile.component';
import { SearchComponent } from './search/search.component';
import { ForgetPassComponent } from './forget-pass/forget-pass.component';
import { ResetPassComponent } from './reset-pass/reset-pass.component';
import { LandingComponent } from './landing/landing.component';
import { NgxCaptchaModule } from 'ngx-captcha';



@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HeaderComponent,
    LogoutComponent,
    AboutComponent,
    MatchesComponent,
    HomeComponent,
    AgePipe,
    ProfileComponent,
    SearchComponent,
    ForgetPassComponent,
    ResetPassComponent,
    LandingComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    ToastrModule.forRoot(),
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgxCaptchaModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
