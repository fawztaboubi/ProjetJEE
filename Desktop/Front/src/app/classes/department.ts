import { Theme } from "./theme";
import { User } from "./user";

export class Department {

    id?:bigint;
    name!:String;
    themes!:Theme[];
    users!:User[];
}
