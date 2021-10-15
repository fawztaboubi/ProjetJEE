import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { TeamService } from './../../Services/team.service';
import { User } from 'src/app/classes/user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  employees: User[] = [];
  
  currentUser = JSON.parse(sessionStorage.getItem('current-user')!);
department:String=new String();
//user=sessionStorage.getItem('current-user');

  constructor(private userService:UserService ,private router:Router) {

   }

  ngOnInit() {
    this.userService.getUsersByDepartment((this.department)).subscribe(
      data => {
        this.employees = data;})         
  }

  //this user is the the input of the update method
  //gets all attributes from current_user and sets only the new attribute
  //in team.html use an update icon 
  //onclick on icon user.info='' and render an input div instead
  //ti billehi chouf exemple w a5tani

}



function userJson(userJson: any): any {
  throw new Error('Function not implemented.');
}

