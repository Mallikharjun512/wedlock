import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { MatchesComponent } from './matches/matches.component';
import { ProfileComponent } from './profile/profile.component';
import { SearchComponent } from './search/search.component';
import { ResetPassComponent } from './reset-pass/reset-pass.component';
import { ForgetPassComponent } from './forget-pass/forget-pass.component';
import { LandingComponent } from './landing/landing.component';



const routes: Routes = [
  {path:"", component:LandingComponent},
  {path:"about", component:AboutComponent},
  {path:"search", component:SearchComponent},
  {path:"profile", component:ProfileComponent},
  {path:"matches", component:MatchesComponent},
  {path:"home", component:HomeComponent},
  {path:"login", component:LoginComponent},
  {path:"register", component:RegisterComponent},
  {path:"logout",component:LogoutComponent},
  {path:"resetpassword", component:ResetPassComponent},
  {path:"home" ,component:HomeComponent},
  {path:"login/forget-pass", component:ForgetPassComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
