import { Actionplan } from 'src/app/classes/actionplan';
import { ActionSample } from './../../../classes/ActionSample';
import { ActionplanService } from './../../../Services/actionplan.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Action } from 'src/app/classes/action';
import { User } from 'src/app/classes/user';
import { ActionService } from 'src/app/Services/action.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-update-action-dialog',
  templateUrl: './update-action-dialog.component.html',
  styleUrls: ['./update-action-dialog.component.css']
})
export class UpdateActionDialogComponent implements OnInit {

  updateactionForm!: FormGroup;
  week!: String;
  apid!:number;
  id!: number;
  username!: String;
  newaction: ActionSample = new ActionSample();
  users:User[]=[];
  usernames: String[] = []; 
  currentAction = JSON.parse(sessionStorage.getItem('current-action')!);
  currentDepartment = JSON.parse(sessionStorage.getItem('current-department')!);
  currentActionPlan = JSON.parse(sessionStorage.getItem('current-actionplan')!);
  theme = JSON.parse(sessionStorage.getItem('ThemeIndex')!);
  Owner!: User;
  owner!: String;
  department!: String;
  actionplans:Actionplan[]=[];
  actionplan!:Actionplan;
  plan!:Actionplan;

  constructor(private userService: UserService, private actionService: ActionService,private actionplanService:ActionplanService) { 

    console.log("current",this.currentAction);
    this.users = this.currentDepartment.users;
    for (let user of this.users) {
      this.usernames.push(user.username);
    }
    this.apid=this.currentAction.Actionplan.Id;  

    this.department = JSON.stringify(this.currentDepartment.name);
    this.updateactionForm = new FormGroup({
      project: new FormControl(this.newaction?.Project, [
        Validators.required,
        Validators.minLength(4)]),

      line: new FormControl(this.newaction?.Line, [
        Validators.required,
        Validators.minLength(4)]),

      family: new FormControl(this.newaction?.Family, [
        Validators.required,
        Validators.minLength(4)]),

      responsability: new FormControl(this.newaction?.Responsability, [
        Validators.required,
        Validators.minLength(4)]),

      defectDescription: new FormControl(this.newaction?.DefectDescription, [
        Validators.required,
        Validators.minLength(4)]),

      manalysis: new FormControl(this.newaction?.Manalysis, [
        Validators.required,
        Validators.minLength(4)]),

      rootCause: new FormControl(this.newaction?.RootCause, [
        Validators.required,
        Validators.minLength(4)]),

      actionDescription: new FormControl(this.newaction?.ActionDescription, [
        Validators.required,
        Validators.minLength(4)]),

      department: new FormControl(this.newaction?.department, [
        Validators.required,
        Validators.minLength(4)]),

      startDate: new FormControl(this.newaction?.StartDate, [
        Validators.required,
        Validators.minLength(4)]),

      DueDate: new FormControl(this.newaction?.DueDate, [
        Validators.required,
        Validators.minLength(4)]),

      secondDueDate: new FormControl(this.newaction?.SecondDueDate, [
        Validators.required,
        Validators.minLength(4)]),

      thirdDueDate: new FormControl(this.newaction?.ThirdDueDate, [
        Validators.required,
        Validators.minLength(4)]),

      status: new FormControl(this.newaction?.Status, [
        Validators.required,
        Validators.minLength(4)]),

      comment: new FormControl(this.newaction?.Comment, [
        Validators.required,
        Validators.minLength(4)]),

      progress: new FormControl(this.newaction?.Progress, [
        Validators.required,
        Validators.minLength(4)]),

      kpi: new FormControl(this.newaction?.kpi, [
        Validators.required,
        Validators.minLength(4)]),

      finding: new FormControl(this.newaction?.finding, [
        Validators.required,
        Validators.minLength(4)]),

      detailedStatus: new FormControl(this.newaction?.DetailedStatus, [
        Validators.required,
        Validators.minLength(4)]),

      Wk0: new FormControl(this.newaction?.Wk0, [
        Validators.required,
        Validators.minLength(4)]),

      Wk1: new FormControl(this.newaction?.Wk1, [
        Validators.required,
        Validators.minLength(4)]),

      Wk2: new FormControl(this.newaction?.Wk2, [
        Validators.required,
        Validators.minLength(4)]),

      Wk3: new FormControl(this.newaction?.Wk3, [
        Validators.required,
        Validators.minLength(4)]),

      Wk4: new FormControl(this.newaction?.Wk4, [
        Validators.required,
        Validators.minLength(4)]),

      Wk5: new FormControl(this.newaction?.Wk5, [
        Validators.required,
        Validators.minLength(4)]),

      Wk6: new FormControl(this.newaction?.Wk6, [
        Validators.required,
        Validators.minLength(4)]),

      Wk7: new FormControl(this.newaction?.Wk7, [
        Validators.required,
        Validators.minLength(4)]),

      Wk8: new FormControl(this.newaction?.Wk8, [
        Validators.required,
        Validators.minLength(4)]),

      Wk9: new FormControl(this.newaction?.Wk9, [
        Validators.required,
        Validators.minLength(4)]),

      Wk10: new FormControl(this.newaction?.Wk10, [
        Validators.required,
        Validators.minLength(4)]),

      Wk11: new FormControl(this.newaction?.Wk11, [
        Validators.required,
        Validators.minLength(4)]),

      Wk12: new FormControl(this.newaction?.Wk12, [
        Validators.required,
        Validators.minLength(4)]),

      Wk13: new FormControl(this.newaction?.Wk13, [
        Validators.required,
        Validators.minLength(4)]),

      Wk14: new FormControl(this.newaction?.Wk14, [
        Validators.required,
        Validators.minLength(4)]),

      Wk15: new FormControl(this.newaction?.Wk15, [
        Validators.required,
        Validators.minLength(4)]),

      Wk16: new FormControl(this.newaction?.Wk16, [
        Validators.required,
        Validators.minLength(4)]),

      Wk17: new FormControl(this.newaction?.Wk17, [
        Validators.required,
        Validators.minLength(4)]),

      Wk18: new FormControl(this.newaction?.Wk18, [
        Validators.required,
        Validators.minLength(4)]),

      Wk19: new FormControl(this.newaction?.Wk19, [
        Validators.required,
        Validators.minLength(4)]),

      Wk20: new FormControl(this.newaction?.Wk20, [
        Validators.required,
        Validators.minLength(4)]),

      Wk21: new FormControl(this.newaction?.Wk21, [
        Validators.required,
        Validators.minLength(4)]),

      Wk22: new FormControl(this.newaction?.Wk22, [
        Validators.required,
        Validators.minLength(4)]),

      Wk23: new FormControl(this.newaction?.Wk23, [
        Validators.required,
        Validators.minLength(4)]),

      Wk24: new FormControl(this.newaction?.Wk24, [
        Validators.required,
        Validators.minLength(4)]),

      Wk25: new FormControl(this.newaction?.Wk25, [
        Validators.required,
        Validators.minLength(4)]),

    },

    );

  }

  async ngOnInit(): Promise<void> {
    console.log("current department",this.department);
    console.log("current department",this.currentDepartment.name);
    this.usernames= (await this.userService.getUsers().toPromise()).filter(user => {
      return (user.department?.toLocaleLowerCase().match(this.currentDepartment.name));
    }).map(element => element.username.toString());
    console.log(this.users);

   // for (let user of this.users) {
   //   this.usernames.push(user.username);
   // }
    console.log(this.usernames);
    console.log("currentAction: ",this.currentAction);
    
  //  let  actionplans=await this.actionplanService.getActionplans().toPromise();  
	//	    for(let actionplan of  actionplans){
	//	      for(let act of actionplan.actions)
	//	        if(act.id===this.currentAction.id){
	//	          this.apid!=actionplan.id;
	//	        
	//	      }
	//	    }

  
   
  }


  async catchUser() {
    console.log(this.owner);
    const data = await this.userService.getUserByUsername(this.owner).toPromise();

    this.Owner = data;
    console.log(this.Owner);
    this.newaction.user = this.Owner;

    this.saveAction();

  
  }

  async saveAction() {
    
    this.newaction.department = this.currentDepartment.name;
  //  this.newaction.id = this.currentAction.id;
    
  //  console.log(this.newaction.department);

    
    console.log("actplan",this.apid);    
    this.plan=await this.actionplanService.getActionplanById(this.apid).toPromise();
    this.newaction.actionplan=this.plan;



    this.updateactionForm.value.project!=null?this.newaction.Project = this.updateactionForm.value.project:this.newaction.Project=this.currentAction.Project;
    this.updateactionForm.value.family!=null?this.newaction.Family = this.updateactionForm.value.family:this.newaction.Family=this.currentAction.Family;
    this.updateactionForm.value.line!=null?this.newaction.Line = this.updateactionForm.value.line:this.newaction.Line=this.currentAction.Line;
    this.updateactionForm.value.responsability!=null?this.newaction.Responsability = this.updateactionForm.value.responsability:this.newaction.Responsability=this.currentAction.Responsability;
    this.updateactionForm.value.defectDescription!=null?this.newaction.DefectDescription = this.updateactionForm.value.defectDescription:this.newaction.DefectDescription=this.currentAction.DefectDescription;
    this.updateactionForm.value.actionDescription!=null?this.newaction.ActionDescription = this.updateactionForm.value.actionDescription:this.newaction.ActionDescription=this.currentAction.ActionDescription;
    this.updateactionForm.value.rootCause!=null?this.newaction.RootCause = this.updateactionForm.value.rootCause:this.newaction.RootCause=this.currentAction.RootCause;
    this.updateactionForm.value.progress!=null?this.newaction.Progress = this.updateactionForm.value.progress:this.newaction.Progress=this.currentAction.Progress;
    this.updateactionForm.value.comment!=null?this.newaction.Comment = this.updateactionForm.value.comment:this.newaction.Comment=this.currentAction.Comment;
    this.updateactionForm.value.status!=null?this.newaction.Status = this.updateactionForm.value.status:this.newaction.Status=this.currentAction.Status;
    this.updateactionForm.value.detailedStatus!=null?this.newaction.DetailedStatus = this.updateactionForm.value.detailedStatus:this.newaction.DetailedStatus=this.currentAction.DetailedStatus;
    this.updateactionForm.value.DueDate!=null?this.newaction.DueDate = this.updateactionForm.value.DueDate:this.newaction.DueDate=this.currentAction.DueDate;
    this.updateactionForm.value.startDate!=null?this.newaction.StartDate = this.updateactionForm.value.startDate:this.newaction.StartDate=this.currentAction.StartDate;
    this.updateactionForm.value.secondDueDate!=null?this.newaction.SecondDueDate = this.updateactionForm.value.secondDueDate:this.newaction.SecondDueDate=this.currentAction.SecondDueDate;
    this.updateactionForm.value.thirdDueDate!=null?this.newaction.ThirdDueDate = this.updateactionForm.value.thirdDueDate:this.newaction.ThirdDueDate=this.currentAction.ThirdDueDate;
    this.updateactionForm.value.kpi!=null?this.newaction.kpi = this.updateactionForm.value.kpi:this.newaction.kpi=this.currentAction.kpi;
    this.updateactionForm.value.finding!=null?this.newaction.finding = this.updateactionForm.value.finding:this.newaction.finding=this.currentAction.finding;
    this.updateactionForm.value.manalysis!=null?this.newaction.Manalysis = this.updateactionForm.value.manalysis:this.newaction.Manalysis=this.currentAction.Manalysis;
    this.updateactionForm.value.Wk0!=null?this.newaction.Wk0 = this.updateactionForm.value.Wk0:this.newaction.Wk0=this.currentAction.Wk0;


    this.updateactionForm.value.Wk1!=null?this.newaction.Wk1 = this.updateactionForm.value.Wk1:this.newaction.Wk1=this.currentAction.Wk1;
    this.updateactionForm.value.Wk2!=null?this.newaction.Wk2 = this.updateactionForm.value.Wk2:this.newaction.Wk2=this.currentAction.Wk2;
    this.updateactionForm.value.Wk3!=null?this.newaction.Wk3 = this.updateactionForm.value.Wk3:this.newaction.Wk3=this.currentAction.Wk3;
    this.updateactionForm.value.Wk4!=null?this.newaction.Wk4 = this.updateactionForm.value.Wk4:this.newaction.Wk4=this.currentAction.Wk4;
    this.updateactionForm.value.Wk5!=null?this.newaction.Wk5 = this.updateactionForm.value.Wk5:this.newaction.Wk5=this.currentAction.Wk5;
    this.updateactionForm.value.Wk6!=null?this.newaction.Wk6 = this.updateactionForm.value.Wk6:this.newaction.Wk6=this.currentAction.Wk6;
    this.updateactionForm.value.Wk7!=null?this.newaction.Wk7 = this.updateactionForm.value.Wk7:this.newaction.Wk7=this.currentAction.Wk7;
    this.updateactionForm.value.Wk8!=null?this.newaction.Wk8 = this.updateactionForm.value.Wk8:this.newaction.Wk8=this.currentAction.Wk8;
    this.updateactionForm.value.Wk9!=null?this.newaction.Wk9 = this.updateactionForm.value.Wk9:this.newaction.Wk9=this.currentAction.Wk9;
    this.updateactionForm.value.Wk10!=null?this.newaction.Wk10 = this.updateactionForm.value.Wk10:this.newaction.Wk10=this.currentAction.Wk10;
    this.updateactionForm.value.Wk11!=null?this.newaction.Wk11 = this.updateactionForm.value.Wk11:this.newaction.Wk11=this.currentAction.Wk11;


    this.updateactionForm.value.Wk12!=null?this.newaction.Wk12 = this.updateactionForm.value.Wk12:this.newaction.Wk12=this.currentAction.Wk12;
    this.updateactionForm.value.Wk13!=null?this.newaction.Wk13 = this.updateactionForm.value.Wk13:this.newaction.Wk13=this.currentAction.Wk13;
    this.updateactionForm.value.Wk14!=null?this.newaction.Wk14 = this.updateactionForm.value.Wk14:this.newaction.Wk14=this.currentAction.Wk14;
    this.updateactionForm.value.Wk15!=null?this.newaction.Wk15 = this.updateactionForm.value.Wk15:this.newaction.Wk15=this.currentAction.Wk15;
    this.updateactionForm.value.Wk16!=null?this.newaction.Wk16 = this.updateactionForm.value.Wk16:this.newaction.Wk16=this.currentAction.Wk16;
    this.updateactionForm.value.Wk17!=null?this.newaction.Wk17 = this.updateactionForm.value.Wk17:this.newaction.Wk17=this.currentAction.Wk17;
    this.updateactionForm.value.Wk18!=null?this.newaction.Wk18 = this.updateactionForm.value.Wk18:this.newaction.Wk18=this.currentAction.Wk18;
    this.updateactionForm.value.Wk19!=null?this.newaction.Wk19 = this.updateactionForm.value.Wk19:this.newaction.Wk19=this.currentAction.Wk19;
    this.updateactionForm.value.Wk20!=null?this.newaction.Wk20 = this.updateactionForm.value.Wk20:this.newaction.Wk20=this.currentAction.Wk20;
    this.updateactionForm.value.Wk21!=null?this.newaction.Wk21 = this.updateactionForm.value.Wk21:this.newaction.Wk21=this.currentAction.Wk21;
    this.updateactionForm.value.Wk22!=null?this.newaction.Wk22 = this.updateactionForm.value.Wk22:this.newaction.Wk22=this.currentAction.Wk22;
    this.updateactionForm.value.Wk23!=null?this.newaction.Wk23 = this.updateactionForm.value.Wk23:this.newaction.Wk23=this.currentAction.Wk23;
    this.updateactionForm.value.Wk24!=null?this.newaction.Wk24 = this.updateactionForm.value.Wk24:this.newaction.Wk24=this.currentAction.Wk24;
    this.updateactionForm.value.Wk25!=null?this.newaction.Wk25 = this.updateactionForm.value.Wk25:this.newaction.Wk25=this.currentAction.Wk25;

    console.log("new action",this.newaction);
    //console.log("ap",this.newaction.actionplan);
    console.log("action id",this.currentAction.Id);
    sessionStorage.setItem('new-action', JSON.stringify(this.newaction));
    this.actionService.updateAction(this.currentAction.Id,this.newaction).subscribe();
    // }).catch((message) => {
    //   console.log('request failed');
    // })

  };

} 
