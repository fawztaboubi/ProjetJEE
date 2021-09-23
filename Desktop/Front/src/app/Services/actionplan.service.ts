import { Actionplan } from './../classes/actionplan';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ActionplanService {

  private actionplanUrl:string;

  constructor(private http:HttpClient) {

    this.actionplanUrl='http://localhost:8082/actionPlans';
   }

   getActionplans(): Observable<Actionplan[]>{
    return this.http.get<Actionplan[]>(`${this.actionplanUrl}`);
  }

  createActionplan(actionplanUrl: Actionplan): Observable<Object>{
    return this.http.post(`${this.actionplanUrl}/post`, actionplanUrl);
  }

  getActionplanById(id: number): Observable<Actionplan>{
    return this.http.get<Actionplan>(`${this.actionplanUrl}/${id}`);
  }

  updateActionplan(id: number, actionplanUrl: Actionplan): Observable<Object>{
    return this.http.put(`${this.actionplanUrl}/${id}`, actionplanUrl);
  }

  deleteActionplan(id: number): Observable<Object>{
    return this.http.delete(`${this.actionplanUrl}/${id}`);
  }
}
