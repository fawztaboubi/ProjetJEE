
import { ActionService } from './Services/action.service';
import { ActionplanService } from './Services/actionplan.service';
import { DepartmentService } from './Services/department.service';
import { MaresponseService } from './Services/maresponse.service';
import { OwresponseService } from './Services/owresponse.service';
import { RequestService } from './Services/request.service';
import { ResponseService } from './Services/response.service';
import { TeamService } from './Services/team.service';
import { UserService } from './Services/user.service';
import { Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, ArrayOfComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { RequestComponent } from './Landing/request/request.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { LoginComponent } from './Landing/login/login.component';
import { DashboardModule } from './Dashboard/dashboard.module';
import { ThemeService } from './Services/theme.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RequestReceivedComponent } from './Landing/request/request-received/request-received.component';
import { RefusedComponent } from './Landing/login/refused/refused.component';
import { NgApexchartsModule } from 'ng-apexcharts';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddUserComponent } from './Landing/request/add-user/add-user.component';




@NgModule({
  declarations: [
    AppComponent,
    ArrayOfComponents,
    LoginComponent,
    RequestReceivedComponent,
    RefusedComponent,
    AddUserComponent
    

  ], 
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    DashboardModule,
    FormsModule,
    HttpClientModule,
    NgApexchartsModule,
    BrowserAnimationsModule,
    
  ],
  providers: [UserService,ThemeService,TeamService,ResponseService,
              RequestService,OwresponseService,MaresponseService,
              DepartmentService,ActionplanService,ActionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
