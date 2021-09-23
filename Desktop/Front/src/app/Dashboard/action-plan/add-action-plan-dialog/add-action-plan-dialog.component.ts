import { ActionplanService } from './../../../Services/actionplan.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Actionplan } from 'src/app/classes/actionplan';

@Component({
  selector: 'app-add-action-plan-dialog',
  templateUrl: './add-action-plan-dialog.component.html',
  styleUrls: ['./add-action-plan-dialog.component.css']
})
export class AddActionPlanDialogComponent implements OnInit {
  actionplanForm!: FormGroup;
  actionplan?: Actionplan;
  currentTheme=JSON.parse(sessionStorage.getItem('ThemeIndex')!);
  newactionplan=new Actionplan();
  
  constructor(private actionplanService:ActionplanService) { 
    this.actionplanForm = new FormGroup({
      name: new FormControl(this.actionplan?.name, [
        Validators.required,
        Validators.minLength(4)])
    });
  }

  ngOnInit(): void {
  }

  saveActionplan() {
    this.newactionplan.name = this.actionplanForm.value.name;
    this.newactionplan.theme=this.currentTheme;
    console.log(this.newactionplan);
    this.actionplanService.createActionplan(this.newactionplan).subscribe();
    console.log('new plan created'); 
    console.log(this.currentTheme);

  }

}
