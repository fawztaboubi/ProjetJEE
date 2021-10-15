import { ActionService } from './../../Services/action.service';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/classes/user';
import { AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currentUser = JSON.parse(sessionStorage.getItem('current-user')!);
  userForm: FormGroup;
  oldpass: String = this.currentUser.Password;
  newpass: string = '';
  updateduser: User = new User();
  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";
  constructor(private userService: UserService, private router: Router, private actionService: ActionService) {

    this.userForm = new FormGroup({
      lastname: new FormControl(this.updateduser?.FamilyName, [
        Validators.required,
        Validators.minLength(4)]),
      name: new FormControl(this.updateduser?.name, [
        Validators.required,
        Validators.minLength(4)]),
      email: new FormControl(this.updateduser?.email, [
        Validators.required,
        Validators.pattern(this.emailPattern)]),
      newpass: new FormControl(this.newpass, [
        Validators.required
      ]),
      oldpass: new FormControl(this.oldpass, [
        Validators.required
      ]),
      confirmnew: new FormControl(this.updateduser?.Password, [
        Validators.required]),
      job: new FormControl(this.updateduser?.Job, [
        Validators.required,
        Validators.minLength(4)]),
      username: new FormControl(this.updateduser?.username, [
        Validators.required,
        Validators.minLength(4)]),
      department: new FormControl(this.updateduser?.department, [
        Validators.required,
        Validators.minLength(4)]),
      addAction: new FormControl(this.updateduser.add_Action, [
        Validators.required
      ]),
      addActionPlan: new FormControl(this.updateduser.add_Action_Plan, [
        Validators.required
      ]),
      modifyAction: new FormControl(this.updateduser.modify_Action, [
        Validators.required
      ]),
      modifyActionPlan: new FormControl(this.updateduser.modify_Action_Plan, [
        Validators.required
      ]),
      import: new FormControl(this.updateduser.Import, [
        Validators.required
      ]),
      export: new FormControl(this.updateduser.Export, [
        Validators.required
      ])

    },

    );
    this.userForm.setValidators(this.checkPasswords())
  }
  public checkPasswords(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors => {
      const control1 = this.userForm.controls['newpass'];
      const control2 = this.userForm.controls['confirmnew'];
      if (control1.value !== control2.value) {
        control2.setErrors({ notEquivalent: true });
      } else {
        control2.setErrors(null);
      }
      return control2;
    };
  }



  ngOnInit(): void {
    console.log(this.currentUser);

  }

  //do the same as in team component to enbale update options
  async saveUser() {
    this.updateduser.id = this.currentUser.id;
    this.updateduser.name = this.userForm.value.name;
    this.updateduser.FamilyName = this.userForm.value.lastname;
    this.updateduser.email = this.userForm.value.email;
    this.updateduser.Job = this.userForm.value.job;
    this.updateduser.Password = this.userForm.value.newpass;
    this.updateduser.username = this.userForm.value.username;
    this.updateduser.department = this.userForm.value.department;
    this.updateduser.username = this.userForm.value.username;
    this.updateduser.add_Action = this.userForm.value.addAction;
    this.updateduser.add_Action_Plan = this.userForm.value.addActionPlan;
    this.updateduser.modify_Action = this.userForm.value.modifyAction;
    this.updateduser.modify_Action_Plan = this.userForm.value.modifyActionPlan;
    this.updateduser.Import = this.userForm.value.import;
    this.updateduser.Export = this.userForm.value.export;
    console.log(this.updateduser);
    //get all actions where action.user.id==currentUser.id and replace user with updateuser
    this.userService.updateUser(this.currentUser.id, this.updateduser).toPromise();

  }


}









