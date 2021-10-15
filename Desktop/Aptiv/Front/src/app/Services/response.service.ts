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
 
   notifyCoordinator(_response:Response): Observable<Object>{
    return this.http.post<Object>(`${this.responseUrl}/pushToCoordinator`,_response);
  }

  notifyManager(_response:Response): Observable<Object>{
    return this.http.post<Object>(`${this.responseUrl}/pushToManager`,_response);
  }

  notifyGManager(_response:Response): Observable<Object>{
    return this.http.post<Object>(`${this.responseUrl}/pushToGManager`,_response);
  }
}
