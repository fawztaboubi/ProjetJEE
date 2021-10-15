
import { Action } from "./action";
import { Actionplan } from "./actionplan";
import { Department } from "./department";


export class Theme {

    id!: bigint;
    department!:Department ;
    name!:String;
    actionplans!:Actionplan[];
}
