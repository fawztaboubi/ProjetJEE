import { ThemeService } from './../../../Services/theme.service';
import { DepartmentService } from './../../../Services/department.service';
import { Theme } from './../../../classes/theme';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Department } from 'src/app/classes/department';



@Component({
  selector: 'app-add-theme-dialog',
  templateUrl: './add-theme-dialog.component.html',
  styleUrls: ['./add-theme-dialog.component.css']
})
export class AddThemeDialogComponent implements OnInit {
  themeForm!: FormGroup;
  
  theme?: Theme;
  newtheme = new Theme();
 //newtheme=new Theme();
  currentUser = JSON.parse(sessionStorage.getItem('current-user')!);
  currentDepartment=JSON.parse(sessionStorage.getItem('current-department')!);
  department?: Department;

  constructor(private departmentService: DepartmentService, private themeService: ThemeService) {
    this.themeForm = new FormGroup({
      name: new FormControl(this.theme?.name, [
        Validators.required,
        Validators.minLength(4)])
    });
  }

  ngOnInit(): void {
  }


  saveTheme() {

    this.newtheme.name = this.themeForm.value.name;
    this.newtheme.department=this.currentDepartment;
    console.log(this.newtheme);
    this.themeService.createTheme(this.newtheme).subscribe();
    console.log('new theme created'); 
    console.log(this.currentDepartment);

  }


}

