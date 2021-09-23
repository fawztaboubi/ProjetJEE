import { PlanComponent } from './plan/plan.component';
import { ApprovedComponent } from './approved/approved.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TeamComponent } from './team/team.component';
import { KPIComponent } from './kpi/kpi.component';
import { DefaultComponent } from './default/default.component';
import { ProfileComponent } from './profile/profile.component';
import { JointeamComponent } from './jointeam/jointeam.component';
import { ActionPlanComponent } from './action-plan/action-plan.component';


const routes: Routes = [
  {
    path: '', component: HomeComponent, children: [
      { path: 'kpi', component: KPIComponent },
      { path: 'team', component: TeamComponent },
      {
        path: '', component: DefaultComponent
        //  [
        //    {path: 'action-plan', component: ActionPlanComponent},
        //    { path: 'plan', component: PlanComponent }
        //  ]
      },
      { path: 'profile', component: ProfileComponent },
      {
        path: 'join', component: JointeamComponent, children: [
          { path: 'sign-user', component: ApprovedComponent }
        ]
      },

      { path: 'dashboard', component: DefaultComponent },
      {path: 'action-plan', component: ActionPlanComponent},
      { path: 'plan', component: PlanComponent }

    ]

  }

];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
