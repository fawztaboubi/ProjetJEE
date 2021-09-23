
import { RequestService } from './../../Services/request.service';
import{Request} from '../../classes/request';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {
  request: Request= new Request();

  constructor(private requestService: RequestService, private router:Router) { }

  
  saveRequest(){
   this.request.Status="OnHold";
   this.requestService.createRequest(this.request).subscribe( data =>{
     console.log('request is saved in the data base');
      this.goToRequestList();
   },
    error => console.log(error));
  }



  goToRequestList(){
    this.router.navigate(['requestreceived']);
   
  }
  
  onSubmit(){
    console.log(this.request);
    this.saveRequest();
  }
  ngOnInit(): void {
  }

}
