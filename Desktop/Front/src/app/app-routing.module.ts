import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

import { LoginComponent } from './Landing/login/login.component';
import { RequestComponent } from './Landing/request/request.component';
import { HomeComponent } from './Dashboard/home/home.component';
import { KPIComponent } from './Dashboard/kpi/kpi.component';
import { TeamComponent } from './Dashboard/team/team.component';
import { RequestReceivedComponent } from './Landing/request/request-received/request-received.component';
import { RefusedComponent } from './Landing/login/refused/refused.component';

const routes: Routes = [
  
  { path:'',component: LoginComponent,children:[
    { path:'refused', component:RefusedComponent}]},
  
  { path:'createacount', component: RequestComponent, children:[
    { path:'requestreceived', component:RequestReceivedComponent}
  ]},
    
  { path: 'dashboard',loadChildren:()=>import('./Dashboard/dashboard.module').then(m=>m.DashboardModule)}
  
 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const ArrayOfComponents = [LoginComponent,RequestComponent, AppComponent]
