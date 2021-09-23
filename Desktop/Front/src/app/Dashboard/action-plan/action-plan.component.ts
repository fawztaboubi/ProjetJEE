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
  importActions: Action[] = [];
  exportActions: Action[] = [];
  currentUser = JSON.parse(sessionStorage.getItem('current-user')!);
  theme = JSON.parse(sessionStorage.getItem('ThemeIndex')!);

  constructor(private userService: UserService, private actionService: ActionService,
    private excelSrv: ExcelService, private router: Router, private themeService: ThemeService,
    private matDialog: MatDialog) { }


  ngOnInit(): void {

    this.actionplans = this.theme!.actionplans;

    for (let actionplan of this.actionplans) {
      for (let action of actionplan.actions) {

        this.all_actions.push(action);
      }

    }
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
}
