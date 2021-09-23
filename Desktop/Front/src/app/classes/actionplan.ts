import { Action } from "./action";
import { Theme } from "./theme";

export class Actionplan {
    id?:bigint;
    name!:String;
    actions!:Action[];
    theme!:Theme;
}
