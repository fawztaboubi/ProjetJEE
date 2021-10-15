import { Owresponse } from './../classes/owresponse';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OwresponseService {

  private owresponseUrl:string;

  constructor(private http:HttpClient) {

    this.owresponseUrl='http://localhost:8082/owresponses';
   }

   getUsers(): Observable<Owresponse[]>{
    return this.http.get<Owresponse[]>(`${this.owresponseUrl}`);
  }

  createUser(owresponse: Owresponse): Observable<Object>{
    return this.http.post(`${this.owresponseUrl}`, owresponse);
  }

  getUserById(id: number): Observable<Owresponse>{
    return this.http.get<Owresponse>(`${this.owresponseUrl}/${id}`);
  }

  updateUser(id: number, owresponse: Owresponse): Observable<Object>{
    return this.http.put(`${this.owresponseUrl}/${id}`, owresponse);
  }

  deleteUser(id: number): Observable<Object>{
    return this.http.delete(`${this.owresponseUrl}/${id}`);
  }
}
