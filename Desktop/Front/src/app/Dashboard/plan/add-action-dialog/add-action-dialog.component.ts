import { ThemeService } from './../../../Services/theme.service';
import { ActionplanService } from './../../../Services/actionplan.service';
import { Router } from '@angular/router';
import { UserService } from './../../../Services/user.service';
import { Department } from './../../../classes/department';
import { ActionService } from './../../../Services/action.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Action } from 'src/app/classes/action';
import { User } from 'src/app/classes/user';
import { Actionplan } from 'src/app/classes/actionplan';



@Component({

  selector: 'app-add-action-dialog',
  templateUrl: './add-action-dialog.component.html',
  //templateUrl: './action-pop-up.html',
  styleUrls: ['./add-action-dialog.component.css']
})
export class AddActionDialogComponent implements OnInit {

  week!: String;
  id!: number;
  username!: String;
  actionForm!: FormGroup;
  newaction: Action = new Action();
  currentUser = JSON.parse(sessionStorage.getItem('current-user')!);
  currentActionPlan = JSON.parse(sessionStorage.getItem('current-actionplan')!);
  currentDepartment = JSON.parse(sessionStorage.getItem('current-department')!);
  theme = JSON.parse(sessionStorage.getItem('ThemeIndex')!);
  usernames: String[] = [];
  users: User[] = [];
  owner!: String;
  Owner!: User;
  department!: String;
  currentActionPlanObject: Actionplan = new Actionplan();
  constructor(private userService: UserService, private actionService: ActionService,
    private router: Router, private actionplanService: ActionplanService,private themeService:ThemeService) {

    console.log(this.currentDepartment);
    this.users = this.currentDepartment.users;
    for (let user of this.users) {
      this.usernames.push(user.username);
    }
    this.department = JSON.stringify(this.currentDepartment.name);
    this.actionForm = new FormGroup({
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

  ngOnInit(): void {
    this.newaction.actionplan = this.currentActionPlan!;
    this.id = this.currentActionPlan.id;
    console.log(this.currentActionPlan);

  }


  async catchUser() {
    console.log(this.owner);
    const data = await this.userService.getUserByUsername(this.owner).toPromise();

    this.Owner = data;
    console.log(this.Owner);
    this.newaction.user = this.Owner;

    this.saveAction();
    //to refresh the data right after creation of new action we need to remove the action-plan from
    //session Storage and  store the new one with the new action
    sessionStorage.removeItem('current-actionplan');
    this.actionplanService.getActionplanById(this.id).subscribe(
      response => {
        sessionStorage.setItem('current-actionplan', JSON.stringify(response));
      })

    sessionStorage.removeItem('ThemeIndex');
    this.themeService.getThemeById(this.theme.id).subscribe(
      response => {
        sessionStorage.setItem('ThemeIndex', JSON.stringify(response));
      })
    this.router.navigate(['plan']);
  }

  saveAction() {

    this.newaction.department = "quality";
    console.log(this.newaction.department);
    this.newaction.Project = this.actionForm.value.project;
    this.newaction.Family = this.actionForm.value.family;
    this.newaction.Line = this.actionForm.value.line;
    this.newaction.Responsability = this.actionForm.value.responsability;
    this.newaction.DefectDescription = this.actionForm.value.defectDescription;
    this.newaction.ActionDescription = this.actionForm.value.actionDescription;
    this.newaction.RootCause = this.actionForm.value.rootCause;
    this.newaction.Progress = this.actionForm.value.progress;
    this.newaction.Comment = this.actionForm.value.comment;
    this.newaction.Status = this.actionForm.value.status;
    this.newaction.DetailedStatus = this.actionForm.value.detailedStatus;
    this.newaction.DueDate = this.actionForm.value.DueDate;
    this.newaction.StartDate = this.actionForm.value.startDate;
    this.newaction.SecondDueDate = this.actionForm.value.secondDueDate;
    this.newaction.ThirdDueDate = this.actionForm.value.thirdDueDate;
    this.newaction.kpi = this.actionForm.value.kpi;
    this.newaction.finding = this.actionForm.value.finding;
    this.newaction.Manalysis = this.actionForm.value.manalysis;
    this.newaction.Wk0 = this.actionForm.value.Wk0;
    this.newaction.Wk1 = this.actionForm.value.Wk1;
    this.newaction.Wk2 = this.actionForm.value.Wk2;
    this.newaction.Wk3 = this.actionForm.value.Wk3;
    this.newaction.Wk4 = this.actionForm.value.Wk4;
    this.newaction.Wk5 = this.actionForm.value.Wk5;
    this.newaction.Wk6 = this.actionForm.value.Wk6;
    this.newaction.Wk7 = this.actionForm.value.Wk7;
    this.newaction.Wk8 = this.actionForm.value.Wk8;
    this.newaction.Wk9 = this.actionForm.value.Wk9;
    this.newaction.Wk10 = this.actionForm.value.Wk10;
    this.newaction.Wk11 = this.actionForm.value.Wk11;
    this.newaction.Wk12 = this.actionForm.value.Wk12;
    this.newaction.Wk13 = this.actionForm.value.Wk13;
    this.newaction.Wk14 = this.actionForm.value.Wk14;
    this.newaction.Wk15 = this.actionForm.value.Wk15;
    this.newaction.Wk16 = this.actionForm.value.Wk16;
    this.newaction.Wk17 = this.actionForm.value.Wk17;
    this.newaction.Wk18 = this.actionForm.value.Wk18;
    this.newaction.Wk19 = this.actionForm.value.Wk19;
    this.newaction.Wk20 = this.actionForm.value.Wk20;
    this.newaction.Wk21 = this.actionForm.value.Wk21;
    this.newaction.Wk22 = this.actionForm.value.Wk22;
    this.newaction.Wk23 = this.actionForm.value.Wk23;
    this.newaction.Wk24 = this.actionForm.value.Wk24;
    this.newaction.Wk25 = this.actionForm.value.Wk25;

    // this.newaction.user = this.Owner!;
    //console.log(this.newaction);
    //this.actionService.createAction(this.newaction);

    //const promise = new Promise((resolve, reject) => {
    //  if (this.userService.getUserByUsername(this.owner).subscribe(
    //   response => {
    //     this.Owner = response;
    //    console.log(this.Owner);
    //   })) {
    //   resolve(this.newaction.user = this.Owner!)
    //  } else {
    //    reject('Failed')
    //  }
    // })
    // promise.then(() => {
    //   console.log(this.newaction);
    sessionStorage.setItem('new-action', JSON.stringify(this.newaction));
    this.actionService.createAction(this.newaction).subscribe();
    // }).catch((message) => {
    //   console.log('request failed');
    // })

  };


}





