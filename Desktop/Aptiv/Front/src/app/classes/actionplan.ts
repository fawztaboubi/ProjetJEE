import { Action } from "./action";
import { Theme } from "./theme";

export class Actionplan {
    id?:number;
    name!:String;
    actions!:Action[];
    theme!:Theme;
}
