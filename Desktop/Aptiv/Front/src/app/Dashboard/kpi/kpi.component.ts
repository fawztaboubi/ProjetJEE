import { UserService } from './../../Services/user.service';
import { ThemeService } from './../../Services/theme.service';
import { ActionService } from './../../Services/action.service';
import { Department } from './../../classes/department';
import { DepartmentService } from './../../Services/department.service';

import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
import { Action } from 'src/app/classes/action';
import { stringify } from '@angular/compiler/src/util';
import { Theme } from 'src/app/classes/theme';
import { PieController } from 'chart.js';


@Component({
  selector: 'app-kpi',
  templateUrl: './kpi.component.html',
  styleUrls: ['./kpi.component.css']
})
export class KPIComponent implements OnInit {
  [x: string]: any;

  //Overall rating
  done: number = 0;
  doing: number = 0;
  delayed: number = 0;
  //departments graph
  departments: Department[] = [];
  DNames: string[] = [];
  Ddone: number[] = [];
  Ddoing: number[] = [];
  Ddelayed: number[] = [];
  Dactions: Action[] = [];

  //themes graph
  themes: Theme[] = [];
  TNames: string[] = [];
  Tprogress: number[] = [];
  Tactions: Action[] = [];

  //delay Chart
  actions: Action[] = [];
  ontime: number = 0;
  second: number = 0;
  third: number = 0;
  Dontime: number[] = [];
  Dsecond: number[] = [];
  Dthird: number[] = [];
  depNames: string[] = [];
  dontime: number = 0;
  dsecond: number = 0;
  dthird: number = 0;
  //let's set the colors firs
  red = "#CC3712";
  green = "#52BB52";
  yellow = "#E9E16E";
  black="#333";
  orange="#f84018";
  //per ownership per department
  currentDepartment = JSON.parse(sessionStorage.getItem('current-department')!);
  Owners: String[] = [];
  Owactions: Action[] = [];
  depUsers: string[] = [];
  Udone: number[] = [];
  Udoing: number[] = [];
  Udelayed: number[] = [];
  //execution rate per line
  Lines:string[]=[];
  Ldone:number[]=[];
  Ldoing:number[]=[];
  Ldelayed:number[]=[];
  depActions:Action[]=[];

  highcharts = Highcharts;
  Options: Highcharts.Options = {
    chart: {
      height: 350,
      width: 700
    },
    title: {
      text: "Average Temprature"
    },
    xAxis: {
      title: {
        text: 'Tokyo'
      },
      categories: ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
    },
    yAxis: {
      title: {
        text: "Temprature"
      }
    }, series: [{
      data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 24.4, 19.3, 16.0, 18.4, 17.9],
      type: 'spline'
    }]
  };



  //Progress per theme chart
  themechart = Highcharts;
  themeOptions: Highcharts.Options = {

  }

  constructor(private departmentService: DepartmentService, private actionService: ActionService, private themeService: ThemeService,
    private userService: UserService) {



  }

  async ngOnInit(): Promise<void> {

    //Execution rate per department
    this.departments = await this.departmentService.getDepartments().toPromise();
    for (let dep of this.departments) {
      this.DNames.push((dep.name).toString());
      console.log(dep.name);                                 
      this.Dactions = await this.actionService.getActionsByDepartment(dep.name).toPromise();
      //filter by function, to be added as a columnza
      console.log(this.Dactions);
      if (this.Dactions!=null){
      this.Ddone.push(
        this.Dactions.filter(
          res => {
            return (res.Status.toLocaleLowerCase().match("done"))
          }).length / (this.Dactions.length)
      );
      this.Ddoing.push(
        this.Dactions.filter(
          res => {
            return (res.Status.toLocaleLowerCase().match("doing"))
          }).length / (this.Dactions.length)
      );
      this.Ddelayed.push(
        this.Dactions.filter(
          res => {
            return (res.Status.toLocaleLowerCase().match("delayed"))
          }).length / (this.Dactions.length)
      ); } else{}

      console.log(this.Ddoing);
      console.log(this.Ddelayed);
      console.log(this.DNames);
      console.log(this.Ddone);

    }
    this.barChartdepartments();

    //actionplan execution rate per theme 
    this.themes = await this.themeService.getThemes().toPromise();
    for (let theme of this.themes) {
      this.Tactions=[];
      this.TNames.push((theme.name).toString());
      for (let actionplan of theme.actionplans) {
        for (let action of actionplan.actions) {
          this.Tactions.push(action);
        }
      }
      this.Tprogress.push(this.CalculateProgress(this.Tactions));
    }
    this.barChartthemes();

    //delaychart
    this.actions = await this.actionService.getActions().toPromise();
    console.group(this.actions);
    for (let action of this.actions) {
      if (action.Status === "done" && action.SecondDueDate === null && action.ThirdDueDate === null) {
        this.ontime = this.ontime + 1;
      } else if (action.Status === "done" && action.SecondDueDate !== null && action.ThirdDueDate === null) {
        this.second += 1;
      } else if (action.Status === "done" && action.SecondDueDate !== null && action.ThirdDueDate === null) {
        this.third += 1;
      }
    }
    this.barChartdelay();

    //delay per Department
    for (let department of this.departments) {
      let depontime = 0;
      let depsecond = 0;
      let depthird = 0;
      this.depNames.push(department.name.toString());
      let actiondep = await this.actionService.getActionsByDepartment(department.name).toPromise();
      if (actiondep!=null){
      for (let action of actiondep) {
        if (action.Status === "done" && action.SecondDueDate === null && action.ThirdDueDate === null) {
          depontime += 1;
        } else if (action.Status === "done" && action.SecondDueDate !== null && action.ThirdDueDate === null) {
          depsecond += 1;
        } else if (action.Status === "done" && action.SecondDueDate !== null && action.ThirdDueDate === null) {
          depthird += 1;
        }
      }} else{}
      if( actiondep!=null){
      let nb = actiondep.filter(action => {
        return (action.Status.toLowerCase().match("done"))
      }).length;
      this.Dontime.push(depontime / nb);
      this.Dsecond.push(depsecond / nb);
      this.Dthird.push(depthird / nb);}
      else{}
    }
    this.barChartdelaydep();


    this.done = this.actions.filter(res => {
      return (res.Status.toLowerCase().match("done"))
    }).length / (this.actions.length)
    this.doneDonutChart();

    this.doing = this.actions.filter(res => {
      return (res.Status.toLowerCase().match("doing"))
    }).length / (this.actions.length)
    this.doingDonutChart();

    this.delayed = this.actions.filter(res => {
      return (res.Status.toLowerCase().match("delayed"))
    }).length / (this.actions.length)
    this.delayedDonutChart();

    //Progress per ownership
    this.Owactions = await this.actionService.getActionsByDepartment(this.currentDepartment.name).toPromise();
    this.depUsers = (await this.userService.getUsers().toPromise()).filter(user => {
      return (user.department?.toLocaleLowerCase().match(this.currentDepartment.name));
    }).map(element => element.name.toString());
    console.log("users of the current department:", this.depUsers);
    for (let name of this.depUsers) {
      let sumdone = 0;
      let sumdoing = 0;
      let sumdelayed = 0;
      let sumactions=0;
      for (let action of this.Owactions) {
        if (action.Status === "done" && action.user.name === name) {
          sumdone += 1;
          sumactions+=1;
        } else if (action.Status === "doing" && action.user.name === name) {
          sumdoing += 1;
          sumactions+=1;
        } else if (action.Status === "delayed" && action.user.name === name) {
          sumdelayed += 1;
          sumactions+=1;
        }
      }
      this.Udone.push(sumdone/sumactions);
      this.Udoing.push(sumdoing/sumactions);
      this.Udelayed.push(sumdelayed/sumactions);
    }
    this.executionOwnerbar();


    //Execution rate per line
    this.Lines=((await this.actionService.getActionsByDepartment(this.currentDepartment.name).toPromise()).map(action=>{return action.Line.toString()}));
    console.log(this.Owactions);
    this.depActions=await this.actionService.getActionsByDepartment(this.currentDepartment.name).toPromise();
    for(let line of this.Lines){
      let sumdone=0;
      let sumdoing=0;
      let sumdelayed=0;
      let sumactions=0
     for(let action of this.depActions){
       if(action.Line.toString().match(line) && action.Status==="done")
       {  sumactions+=1;
          sumdone+=1;
       }else if (action.Line.toString().match(line) && action.Status==="doing"){
         sumactions+=1;
         sumdoing+=1;
       }else if(action.Line.toString().match(line) && action.Status==="delayed"){
         sumactions+=1;
         sumdelayed+=1;
       }
     }
     this.Ldone.push(sumdone/sumactions);
     this.Ldoing.push(sumdoing/sumactions);
     this.Ldelayed.push(sumdelayed/sumactions);
    }
    console.log(this.Ldone);
    console.log(this.Ldelayed);
    console.log(this.Ldoing);
    console.log(this.Lines);
    this.lineProgressChart();
  }

  //change doing to on going in all charts
  lineProgressChart(){
    Highcharts.chart( {
      chart: {
        renderTo:'linedepchart',
        type: 'column',
        height: 300,
        width: 600
      },
      title: {
        text: 'Execution rate per line'
      },
      subtitle: {
        text: 'these lines belong to the current department'
      },
      xAxis: {
        categories: this.Lines,
        crosshair: true
      },
      yAxis: {
        min: 0,
        title: {
          text: 'Rainfall (mm)'
        }
      },
      tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
          '<td style="padding:0"><b>{point.y:.1f} %</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
      },
      plotOptions: {
        column: {
          pointPadding: 0.2,
          borderWidth: 0
        }
      },
      series: [{
        name: 'Done',
        type: 'column',
        data: this.Ldone,
        color: this.green

      }, {
        name: 'Doing',
        type: 'column',
        data: this.Ldoing,
        color: this.yellow
      }, {
        name: 'Delayed',
        type: 'column',
        data: this.Ldelayed,
        color: this.red
      }]
    });

  }
  executionOwnerbar() {
    Highcharts.chart( {
      chart: {
        renderTo:'ownerdepchart',
        type: 'column',
        height: 300,
        width: 600
      },
      title: {
        text: 'Execution Rate Per Owner'
      },
      subtitle: {
        text: 'Only engineers from the curret department'
      },
      xAxis: {
        categories: this.depUsers,
        crosshair: true
      },
      yAxis: {
        min: 0,
        title: {
          text: 'Rainfall (mm)'
        }
      },
      tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
          '<td style="padding:0"><b>{point.y:.1f} %</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
      },
      plotOptions: {
        column: {
          pointPadding: 0.2,
          borderWidth: 0
        }
      },
      series: [{
        name: 'Done',
        type: 'column',
        data: this.Udone,
        color: this.green

      }, {
        name: 'Doing',
        type: 'column',
        data: this.Udoing,
        color: this.yellow
      }, {
        name: 'Delayed',
        type: 'column',
        data: this.Udelayed,
        color: this.red
      }]
    });

  }


  delayedDonutChart() {
  }
  doingDonutChart() {

  }
  doneDonutChart() {

  }



  barChartdelaydep() {
    Highcharts.chart('delaydepchart', {
      chart: {
        type: 'column',
        height: 300,
        width: 600
      },
      title: {
        text: 'Execution Rate /Department'
      },
      subtitle: {
        text: 'Only done action are taking into consideration here'
      },
      xAxis: {
        categories: this.DNames,
        crosshair: true
      },
      yAxis: {
        min: 0,
        title: {
          text: 'Rainfall (mm)'
        }
      },
      tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
          '<td style="padding:0"><b>{point.y:.1f} %</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
      },
      plotOptions: {
        column: {
          pointPadding: 0.2,
          borderWidth: 0
        }
      },
      series: [{
        name: 'On time',
        type: 'column',
        data: this.Dontime,
        color: this.green

      }, {
        name: 'With 2nd due date',
        type: 'column',
        data: this.Dsecond,
        color: this.yellow
      }, {
        name: 'With 3rd due date',
        type: 'column',
        data: this.Dthird,
        color: this.red
      }]
    });


  }



  barChartdelay() {
    Highcharts.chart('delaychart', {
      chart: {
        type: 'column',
        height: 300,
        width: 600
      },
      title: {
        text: 'Execution Rate'
      },
      subtitle: {
        text: 'all actions are considered in this chart'
      },
      xAxis: {
        categories: ['On time', 'With 2nd due date', 'With 3rd due date'],//tables of theme names
        crosshair: true

      },
      yAxis: {
        min: 0,
        title: {
          text: 'Rainfall (mm)'
        }
      },
      tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
          '<td style="padding:0"><b>{point.y:.1f} %</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
      },
      plotOptions: {
        column: {
          pointPadding: 0.2,
          borderWidth: 0
        }
      },
      series: [{
        name: 'On time',
        type: 'column',
        color:this.black,
        data: [this.ontime / this.actions.length, this.second / this.actions.length, this.third / this.actions.length]

      }]
    })
  }


  barChartthemes() {
    Highcharts.chart('themechart', {
      chart: {
        type: 'column',
        height: 300,
        width: 600
      },
      title: {
        text: 'Action plan progress per theme '
      },
      subtitle: {
        text: 'Evaluation metric is set to progress rate'
      },
      xAxis: {
        categories: this.TNames,//tables of theme names
        crosshair: true
      },
      yAxis: {
        min: 0,
        title: {
          text: 'Progress (%)'
        }
      },
      tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
          '<td style="padding:0"><b>{point.y:.1f} %</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
      },
      plotOptions: {
        column: {
          pointPadding: 0.2,
          borderWidth: 0
        }
      },
      series: [{
        name: 'Progress rate',
        type: 'column',
        color:this.black,
        data: this.Tprogress //progress rate for every theme

      }]
    })
  }

  barChartdepartments() {
    Highcharts.chart('depchart', {
      chart: {
        type: 'column',
        height: 300,
        width: 600
      },
      title: {
        text: 'Monthly Average Rainfall'
      },
      subtitle: {
        text: 'Source: WorldClimate.com'
      },
      xAxis: {
        categories: this.DNames,
        crosshair: true
      },
      yAxis: {
        min: 0,
        title: {
          text: 'Rainfall (mm)'
        }
      },
      tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
          '<td style="padding:0"><b>{point.y:.1f} %</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
      },
      plotOptions: {
        column: {
          pointPadding: 0.2,
          borderWidth: 0
        }
      },
      series: [{
        name: 'Done',
        type: 'column',
        data: this.Ddone,
        color: this.green

      }, {
        name: 'Doing',
        type: 'column',
        data: this.Ddoing,
        color: this.yellow
      }, {
        name: 'Delayed',
        type: 'column',
        data: this.Ddelayed,
        color: this.red
      }]
    });


  }
  CalculateProgress(list: Action[]): number {
    let rates: number[] = [];
    for (let action of list) {
      rates.push(parseInt(action.Progress.replace('%', '').replace(' ', '')));
      
    }
    console.log("rates:",rates);
    return ((rates.reduce((a, b) => a + b)) / list.length)
  }

  //execution rate per department chart
  //newchart = Highcharts;
  //newOptions: Highcharts.Options = {
  //  chart: {

  //}

}
