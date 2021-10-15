import { FormGroup, FormControl, Validators } from '@angular/forms';
import { RequestService } from './../../Services/request.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Request } from 'src/app/classes/request';
import { User } from 'src/app/classes/user';

import { UserService } from 'src/app/Services/user.service';
import { MatDialog } from '@angular/material/dialog';
import { NewUserComponent } from './new-user/new-user.component';

@Component({
  selector: 'app-jointeam',
  templateUrl: './jointeam.component.html',
  styleUrls: ['./jointeam.component.css']
})
export class JointeamComponent implements OnInit {
   //get request from backend
   //how to add pop up in angular
  requests: Request[]=[];
  newrequest:Request=new Request();
  refusedRequest:Request=new Request();
  users:User[]=[];
  title = '';
  test=false;
  constructor(private requestService:RequestService,private matDialog: MatDialog,private userService:UserService) { 
   
  }
  
  async ngOnInit(): Promise<void> {
    this.retrieveRequests();

    this.users=await this.userService.getUsers().toPromise()
    console.log(this.users);
  }

  retrieveRequests(): void {
    this.requestService.getRequests()
      .subscribe(
        data => {
          this.requests = data.filter(request=>{return request.Status?.toLocaleLowerCase().match('onhold')});
          console.log(data);
        },
        error => {
          console.log(error);
        });


  }

  openDialog(request:Request): void {
    let dialogRef = this.matDialog.open(NewUserComponent, {
      width: '700px'
      
    });
    sessionStorage.setItem('approved-request',JSON.stringify(request));
    dialogRef.afterClosed().subscribe(result => {
    });
  }

  updateApprovedRequest(request:Request){
    this.newrequest=request;
    console.log(this.newrequest);
    this.newrequest.Status="refused";
    this.requestService.updateRequest(request.Id,this.newrequest).subscribe();
  }

  async refuseRequest(request:Request){
  this.refusedRequest.Status="refused";
  this.refusedRequest.Name=request.Name;
  this.refusedRequest.FamilyName=request.FamilyName;
  this.refusedRequest.Job=request.Job;
  this.refusedRequest.Email=request.Email;
  await this.requestService.updateRequest(request.Id,this.refusedRequest).toPromise();
  
  }

}


