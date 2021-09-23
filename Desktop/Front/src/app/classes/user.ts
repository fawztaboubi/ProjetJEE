import { Department } from 'src/app/classes/department';
export class User {
    id?: number;
    department:String='';
    FamilyName?:String;
    Job?:String;
    name!:String;
    Password?:String;
    add_Action?:Boolean=false;
    modify_Action?:Boolean=false;
    add_Action_Plan:Boolean=false;
    email:String='';
    modify_Action_Plan?:Boolean=false;
    username:String='';
    depar:Department=new Department();
    Import:Boolean=false;
    Export:Boolean=false;

}
