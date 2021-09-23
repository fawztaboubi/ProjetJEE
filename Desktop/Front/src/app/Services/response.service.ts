import { Response } from './../classes/response';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ResponseService {

  private responseUrl:string;

  constructor(private http:HttpClient) {

    this.responseUrl='http://localhost:8082/emails';
   }
   
   
   replyToRequestMail(_response:Response): Observable<Object>{
     return this.http.post<Object>(`${this.responseUrl}/reply`,_response);
   }
 

}
