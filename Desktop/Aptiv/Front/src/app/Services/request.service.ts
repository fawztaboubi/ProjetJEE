import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Request} from '../classes/request';


@Injectable({
  providedIn: 'root'
})
export class RequestService {




  private requestUrl:string;

  constructor(private http:HttpClient) {

    this.requestUrl='http://localhost:8082/requests';
   }

   
   getRequests(): Observable<Request[]>{
     return this.http.get<Request[]>(`${this.requestUrl}/`);
   }
 

   createRequest(request:Request): Observable<Object>{
     return this.http.post(`${this.requestUrl}/post`, request );
   }
 
   getRequestById(id: number): Observable<Request>{
     return this.http.get<Request>(`${this.requestUrl}/${id}`);
   }
   updateRequest(id: number,request:Request): Observable<Object>{
     return this.http.put(`${this.requestUrl}/update/${id}`, request);
   }
 
   deleteRequest(id: number): Observable<Object>{
     return this.http.delete(`${this.requestUrl}/${id}`);
   }
}
