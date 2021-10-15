import { UserService } from './../../Services/user.service';
import { User } from './../../classes/user';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
user:User=new User();
duser:User=new User();
 //this is the user we retrieved from the data using the getByUsername method
  constructor(private userService:UserService, private router:Router) {
   }
    
  invalidLogin=false;
  ngOnInit(): void {
  
  }
authenticate(){
  if(typeof this.user.username != 'undefined' && this.user.username){
    const _username=this.user.username;
    const _password=this.user.Password;
    this.userService.getUserByUsername(_username).subscribe(
    data => {
      this.duser = data;});

    if (this.duser.Password===_password){
      
      sessionStorage.setItem('current-user',JSON.stringify(this.duser));
      console.log('user is logged in');
      console.log(sessionStorage.getItem('current-user')); //check user's info in the console section
      this.router.navigate(['dashboard']);
      this.invalidLogin=false;
      //log to dashboard else render an error message
    } else
     { this.invalidLogin=true;
      this.router.navigate(['refused']); } 
      
     }  
}

isUserLoggedIn() {
  let user = sessionStorage.getItem('username')
  console.log(!(user === null))
  return !(user === null)
}

logOut() {
  sessionStorage.removeItem('username')
}
 
 
}
