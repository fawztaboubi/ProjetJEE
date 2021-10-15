import { ActionService } from 'src/app/Services/action.service';
import { Action } from './../../classes/action';
import { Component, OnInit } from '@angular/core';
import { AddActionDialogComponent } from './add-action-dialog/add-action-dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-plan',
  templateUrl: './plan.component.html',
  styleUrls: ['./plan.component.css']
})
export class PlanComponent implements OnInit {

  currentActionplan=JSON.parse(sessionStorage.getItem('current-actionplan')!);
  actions:Action[]=[];
  name!:String;

  constructor(private matDialog: MatDialog, private actionService:ActionService) { }

  ngOnInit(): void {
    console.log(this.currentActionplan);
    this.actions=this.currentActionplan.actions;
    this.name=this.currentActionplan.Name;
  
  }

  openDialog():void {
    let dialogRef = this.matDialog.open(AddActionDialogComponent, {
      width: '700px',
      
    });

    dialogRef.afterClosed().subscribe(result => {
    });
  }

}
