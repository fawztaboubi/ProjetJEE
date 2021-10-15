import { Actionplan } from './../../classes/actionplan';
import { ThemeService } from './../../Services/theme.service';
import { ExcelService } from './../../Services/excel-service.service';
import { Theme } from './../../classes/theme';
import { ActionService } from './../../Services/action.service';
import { User } from './../../classes/user';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/Services/user.service';
import { Observable } from 'rxjs';
import { Action } from 'src/app/classes/action';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { MatDialog } from '@angular/material/dialog';
import { AddActionPlanDialogComponent } from './add-action-plan-dialog/add-action-plan-dialog.component';

@Component({
  selector: 'app-action-plan',
  templateUrl: './action-plan.component.html',
  styleUrls: ['./action-plan.component.css']
})
export class ActionPlanComponent implements OnInit {

  actionplans: Actionplan[] = [];
  all_actions: Action[] = [];
  data: Action[] = [];
  importActions: Action[] = [];
  exportActions: Action[] = [];
  currentUser = JSON.parse(sessionStorage.getItem('current-user')!);
  theme = JSON.parse(sessionStorage.getItem('ThemeIndex')!);
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
  constructor(private userService: UserService, private actionService: ActionService,
    private excelSrv: ExcelService, private router: Router, private themeService: ThemeService,
    private matDialog: MatDialog) {
      this.actionplans = this.theme!.actionplans;

    for (let actionplan of this.actionplans) {
      for (let action of actionplan.actions) {

        this.data.push(action);
      }

    }
    }


  ngOnInit(): void {

    
    this.all_actions=this.data;
    this.updateActions(this.all_actions);
    //sessionStorage.removeItem('ThemeIndex');


  }

  onFileChange(evt: any) {
    const target: DataTransfer = <DataTransfer>(evt.target);
    if (target.files.length !== 1) throw new Error('Cannot use multiple files');

    const reader: FileReader = new FileReader();
    reader.onload = (e: any) => {

      const bstr: string = e.target.result;
      const data = <any[]>this.excelSrv.importFromFile(bstr);

      const header: string[] = Object.getOwnPropertyNames(new Action());
      const importedData = data.slice(1, -1);

      this.importActions = importedData.map(arr => {
        const obj: any = {};
        for (let i = 0; i < header.length; i++) {
          const k = header[i];
          obj[k] = arr[i];
        }
        return <Action>obj;
      })

    };
    reader.readAsBinaryString(target.files[0]);

  }

  exportData(tableId: string) {
    this.excelSrv.exportToFile("actionPlan", tableId);
  }


  routeToActionPlan(actionPlan: Actionplan) {
    console.log(actionPlan);
    sessionStorage.setItem('current-actionplan', JSON.stringify(actionPlan));
    this.router.navigate(['plan']);
  }

  openDialog(): void {
    let dialogRef = this.matDialog.open(AddActionPlanDialogComponent, {
      width: '700px',
    });

    dialogRef.afterClosed().subscribe(result => {
    });
  }

  Search() {
    if (this.status == "" && this.project == "" && this.progress == "" && this.family == "" && this.line == "" && this.responsability == "" &&
      this.cause == "" && this.owner == ""&& this.start == null) {     //res.Status != null && 
      this.ngOnInit();
    } else {
      console.log(this.start);
      this.all_actions = this.all_actions.filter(res => {
        return (res.Status.toLocaleLowerCase().match(this.status.toLowerCase())
          && (res.Project.toLocaleLowerCase().match(this.project.toLowerCase()))
          && (res.Progress.toLocaleLowerCase().match(this.progress.toLowerCase()))
          && (res.Family.toLocaleLowerCase().match(this.family.toLowerCase()))
          && (res.Line.toLocaleLowerCase().match(this.line.toLowerCase()))
          && (new Date(res.StartDate)=== new Date(this.start))
         
        );
      })
    }
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
        updated_action.DetailedStatus = 'delayed with one day';
        updated_action.Status = 'delayed';
      } //primary alert
      else if (this.diff(_action.DueDate!, currentDate) === 2) {
        updated_action.Status = 'delayed';
        updated_action.DetailedStatus = 'delayed with two days';
      } //secondary alert
      else if (this.diff(_action.DueDate!, currentDate) === -1) {
        updated_action.DetailedStatus = 'due date tomorrow';
        updated_action.Status = 'doing';
      } //warning
      else if (this.diff(_action.DueDate!, currentDate) > 2) {
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
}
