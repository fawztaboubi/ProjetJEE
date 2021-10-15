import { Theme } from "./theme";
import { User } from "./user";

export class Department {

    id?:bigint;
    name!:String;
    themes!:Theme[];
    users!:User[];
    coordinator:String="";
    manager:String="";
    gmanager:String="";
    coordinatorEmail:String="";
    managerEmail:String="";
    gmanagerEmail:String="";
}
