import { delayinfo } from './../../classes/delayinfo';
import { ResponseService } from 'src/app/Services/response.service';
import { UpdateActionDialogComponent } from './update-action-dialog/update-action-dialog.component';
import { DepartmentService } from './../../Services/department.service';
import { Department } from './../../classes/department';
import { Router } from '@angular/router';
import { ThemeService } from './../../Services/theme.service';
import { Component, OnInit } from '@angular/core';
import { Theme } from 'src/app/classes/theme';
import { Action } from 'src/app/classes/action';
import { ActionService } from 'src/app/Services/action.service';
import { MatDialog } from '@angular/material/dialog';
import { AddThemeDialogComponent } from './add-theme-dialog/add-theme-dialog.component';

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.css']
})
export class DefaultComponent implements OnInit {
  mes = '';
  currentUser = JSON.parse(sessionStorage.getItem('current-user')!);
  department: String = this.currentUser.department;
  themes: Theme[] = [];
  actions: Action[] = [];
  all_actions: Action[] = [];
  current_date: Date = new Date();
  data: Department = new Department();
  coordinator:String="";
  manager:String="";
  gmanager:String="";


  //input data filters
  status: String = '';
  project: String = '';
  progress: String = '';
  description: String = '';
  defect: String = '';
  analysis: String = '';
  cause: String = '';
  family: String = '';
  line: String = '';
  owner: String = '';
  responsability: String = '';
  start!: Date;
  end!: Date;
  second!: Date;
  third!: Date;
  Wk0: String = '';
  Wk1: String = '';
  Wk2: String = '';
  Wk3: String = '';
  Wk4: String = '';
  Wk5: String = '';
  Wk6: String = '';
  Wk7: String = '';
  Wk8: String = '';
  Wk9: String = '';
  Wk10: String = '';
  Wk11: String = '';
  Wk12: String = '';
  Wk13: String = '';
  Wk14: String = '';
  Wk15: String = '';
  Wk16: String = '';
  Wk17: String = '';
  Wk18: String = '';
  Wk19: String = '';
  Wk20: String = '';
  Wk21: String = '';
  Wk22: String = '';
  Wk23: String = '';
  Wk24: String = '';
  Wk25: String = '';


  constructor(private themeService: ThemeService, private router: Router,
    private actionService: ActionService, private departmentService: DepartmentService,
    private matDialog: MatDialog, private responseService:ResponseService) { }

  async ngOnInit(): Promise<void> {
    this.all_actions=await this.actionService.getActionsByDepartment(this.department).toPromise()
  
    console.log(this.all_actions);
    console.log(this.department);
    this.updateActions(this.all_actions);
    this.departmentService.getDepartmentByName(this.department).subscribe(
      response => {
        this.data = response;
        sessionStorage.setItem('current-department', JSON.stringify(this.data));
      }
    )

    console.log(this.data);
    this.coordinator=this.data.coordinatorEmail;
    this.manager=this.data.managerEmail;
    this.gmanager=this.data.gmanagerEmail;
  }

  routeToTheme(theme: Theme) {
    sessionStorage.setItem('ThemeIndex', JSON.stringify(theme));
    this.router.navigate(['action-plan']);
    console.log(theme);
  }

  displayActionsByTheme(theme: Theme) {
    this.actionService.getActionsByTheme(theme.name!).subscribe(
      data => {
        this.actions = data;
      }
    );
    return this.actions;
  }
  
  

  updateActions(actions: Action[]) {

    const currentDate = new Date(Date.now());
    for (let _action of this.all_actions) {
      let updated_action: Action = new Action();
      updated_action = _action;

      if (_action.Status === 'done') {
        updated_action.Status = 'done';
        updated_action = _action;
      }
      else if (_action.DueDate! === currentDate) {
        updated_action.DetailedStatus = 'due date is today';
        updated_action.Status = 'doing';
      }//just on time
      else if (this.diff(_action.DueDate!, currentDate) === 1) {
        //notify coordinator
        let message:delayinfo=new delayinfo();
        message.toEmail=this.coordinator;
        message.action=_action;
        updated_action.DetailedStatus = 'delayed with one day';
        updated_action.Status = 'delayed';
      }                                    
      else if (this.diff(_action.SecondDueDate!, currentDate) === 1) {
        //send emailto manager
        let message:delayinfo=new delayinfo();
        message.toEmail=this.manager;
        message.action=_action;
      }
      else if (this.diff(_action.ThirdDueDate!, currentDate) === 1) {
        //send emailto gmanager
        let message:delayinfo=new delayinfo();
        message.toEmail=this.gmanager;
        message.action=_action;
      }//primary alert
      else if (this.diff(_action.DueDate!, currentDate) === 2) {
        //send email
        updated_action.Status = 'delayed';
        updated_action.DetailedStatus = 'delayed with two days';
      } //secondary alert
      else if (this.diff(_action.DueDate!, currentDate) === -1) {
        //send email
        updated_action.DetailedStatus = 'due date tomorrow';
        updated_action.Status = 'doing';
      } //warning
      else if (this.diff(_action.DueDate!, currentDate) > 2) {
        //send warning email
        updated_action.DetailedStatus = 'delayed with more than two days';
        updated_action.Status = 'delayed';
      }

      this.actionService.updateAction(_action.id!, updated_action);
      console.log('actions updated');
    }
  }
  diff(deadline: Date, today: Date) {
    const due_date = new Date(deadline).getTime();
    const this_day = new Date(today).getTime();
    return (this_day - due_date) / 86400000;
  }

  openDialog(): void {
    let dialogRef = this.matDialog.open(AddThemeDialogComponent, {
      width: '700px',
    });

    dialogRef.afterClosed().subscribe(result => {
    });
  }

  deleteAction(action:Action){
   this.actionService.deleteAction(action.id).subscribe();
  }

  openUpdateDialog(action:Action):void {
    let dialogRef = this.matDialog.open(UpdateActionDialogComponent, {
      width: '700px',
      
    });
    sessionStorage.setItem('current-action',JSON.stringify(action));
    dialogRef.afterClosed().subscribe(result => {
    });
  }

  Search() {
    if (this.status == "" && this.project == "" && this.progress == "" && this.family == "" && this.line == "" && this.responsability == "" &&
      this.cause == "" && this.owner == "") {     //res.Status != null && 
      this.ngOnInit();
    } else {
      this.all_actions = this.all_actions.filter(res => {
        return (res.Status.toLocaleLowerCase().match(this.status.toLowerCase())
          && (res.Project.toLocaleLowerCase().match(this.project.toLowerCase()))
          && (res.Progress.toLocaleLowerCase().match(this.progress.toLowerCase()))
          && (res.Family.toLocaleLowerCase().match(this.family.toLowerCase()))
          && (res.Line.toLocaleLowerCase().match(this.line.toLowerCase()))
          && (res.Responsability.toLocaleLowerCase().match(this.responsability.toLowerCase()))
          && (res.RootCause.toLocaleLowerCase().match(this.cause.toLowerCase()))
          && (res.user.name.toLocaleLowerCase().match(this.owner.toLowerCase()))

        );
      })
    }
  }

  //check this link for angularCharts tutorial
  //https://davidwalsh.name/angular-charts
  //1:download angularJS here:https://angularjs.org/
  //2:get fusion charts file from here:https://www.fusioncharts.com/download/fusioncharts-suite-xt?framework=js
  //3:get angular charts plugin:https://www.fusioncharts.com/angularjs-charts/
}


function updateActionDialogComponent(updateActionDialogComponent: any, arg1: { width: string; }) {
  throw new Error('Function not implemented.');
}

