import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/classes/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user=sessionStorage.getItem('current-User');

  constructor(private userService:UserService, private router:Router) { }
  
  ngOnInit(): void {

  }
  //do the same as in team component to enbale update options
  

}
