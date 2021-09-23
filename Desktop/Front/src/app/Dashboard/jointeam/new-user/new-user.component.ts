import { Response } from './../../../classes/response';
import { stringify } from '@angular/compiler/src/util';
import { DepartmentService } from './../../../Services/department.service';
import { Department } from './../../../classes/department';
import { Router } from '@angular/router';
import { RequestService } from './../../../Services/request.service';
import { UserService } from 'src/app/Services/user.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/classes/user';
import { Request } from 'src/app/classes/request';
import { ResponseService } from 'src/app/Services/response.service';


@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {

  userForm!: FormGroup;
  newUser: User = new User();
  guest!: Boolean;
  currentDepartment = JSON.parse(sessionStorage.getItem('current-department')!);
  indexRequest = JSON.parse(sessionStorage.getItem('approved-request')!);
  updatedRequest:Request=new Request();
  approvedRequest:Request=new Request();
  userDepartment:Department=new Department();
  confirmEmail:Response=new Response();

  constructor(private departmentService:DepartmentService, private userService: UserService,
              private requestService:RequestService,private router:Router,private responseService:ResponseService) {
    console.log(this.currentDepartment);
    this.userForm = new FormGroup({
      username: new FormControl(this.newUser.username, [
        Validators.required
      ]),
      password: new FormControl(this.newUser.Password, [
        Validators.required
      ]),
      addAction: new FormControl(this.newUser.add_Action, [
        Validators.required
      ]),
      addActionPlan: new FormControl(this.newUser.add_Action_Plan, [
        Validators.required
      ]),
      modifyAction: new FormControl(this.newUser.modify_Action, [
        Validators.required
      ]),
      modifyActionPlan: new FormControl(this.newUser.modify_Action_Plan, [
        Validators.required
      ]),
      import: new FormControl(this.newUser.Import, [
        Validators.required
      ]),
      export: new FormControl(this.newUser.Export, [
        Validators.required
      ])

    });
  }

 async ngOnInit():Promise<void> {
 // this.approvedRequest=await this.requestService.getRequestById(this.indexRequest.Id).toPromise();
  this.approvedRequest=this.indexRequest;
  }

  async saveUser() {
    
    const data = await this.departmentService.getDepartmentByName(this.currentDepartment.name).toPromise();
    this.userDepartment = data;
    console.log('currentdepartment:',this.userDepartment);
    console.log(this.indexRequest); 
    this.newUser.name = this.approvedRequest.Name;
    this.newUser.FamilyName = this.approvedRequest.FamilyName;
    this.newUser.Job = this.approvedRequest.Job;
    this.newUser.email = this.approvedRequest.Email;
    this.newUser.Password = this.userForm.value.password;
    this.newUser.username = this.userForm.value.username;
    this.newUser.add_Action = this.userForm.value.addAction;
    this.newUser.add_Action_Plan = this.userForm.value.addActionPlan;
    this.newUser.modify_Action = this.userForm.value.modifyAction;
    this.newUser.modify_Action_Plan = this.userForm.value.modifyActionPlan;
    this.newUser.Import = this.userForm.value.import;
    this.newUser.Export = this.userForm.value.export;
    this.newUser.depar =data;// add deserializer to the backend @JSONdeserializer to map department in user
    this.newUser.department = this.userDepartment.name;
    console.log(this.newUser);
    this.userService.createUser(this.newUser).subscribe();
    this.router.navigate(['join']);
    sessionStorage.removeItem('indexRequest');
    this.updaterequest();
    this.reply();
    
  }
  reply() {
    this.confirmEmail.department=this.newUser.department;
    this.confirmEmail.toEmail=this.approvedRequest.Email;
    this.confirmEmail.password=this.newUser.Password!;
    this.confirmEmail.username=this.newUser.username;
    console.log(this.confirmEmail);
    this.responseService.replyToRequestMail(this.confirmEmail).subscribe();
  }
  async updaterequest() {
    
    this.updatedRequest.Status="accepted";
    this.updatedRequest.Name=this.approvedRequest.Name;
    this.updatedRequest.FamilyName=this.approvedRequest.FamilyName;
    this.updatedRequest.Job=this.approvedRequest.Job;
    this.updatedRequest.Email=this.approvedRequest.Email;
    await this.requestService.updateRequest(this.approvedRequest.Id,this.updatedRequest).toPromise();
    console.log(this.updatedRequest);
  }
}


