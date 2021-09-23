import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { HomeComponent } from './home/home.component'; 
import { TeamComponent } from './team/team.component';
import { KPIComponent } from './kpi/kpi.component';
import { ProfileComponent } from './profile/profile.component';
import { DefaultComponent } from './default/default.component';
import { JointeamComponent } from './jointeam/jointeam.component';
import { ApprovedComponent } from './approved/approved.component';
import { ActionPlanComponent } from './action-plan/action-plan.component';
import { MatDialogModule } from '@angular/material/dialog';
import { AddThemeDialogComponent } from './default/add-theme-dialog/add-theme-dialog.component';
import { AddActionPlanDialogComponent } from './action-plan/add-action-plan-dialog/add-action-plan-dialog.component';
import { PlanComponent } from './plan/plan.component';
import { AddActionDialogComponent } from './plan/add-action-dialog/add-action-dialog.component';
import { NgxPaginationModule } from 'ngx-pagination';
import {MatStepperModule} from '@angular/material/stepper';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { HighchartsChartModule} from 'highcharts-angular';
import { MatCardModule} from '@angular/material/card';
import { NewUserComponent } from './jointeam/new-user/new-user.component';


@NgModule({
  declarations: [
    HomeComponent,
    TeamComponent,
    KPIComponent,
    ProfileComponent,
    DefaultComponent,
    JointeamComponent,
    ApprovedComponent,
    ActionPlanComponent,
    AddThemeDialogComponent,
    AddActionPlanDialogComponent,
    PlanComponent,
    AddActionDialogComponent,
    NewUserComponent
    
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule,
    HttpClientModule,
    MatDialogModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    MatStepperModule,
    NgxChartsModule,
    HighchartsChartModule,
    MatCardModule,
   
  ]
})
export class DashboardModule { }
