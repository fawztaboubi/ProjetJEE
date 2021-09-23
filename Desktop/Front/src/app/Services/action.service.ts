import { Action } from './../classes/action';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Theme } from '../classes/theme';
import { Department } from '../classes/department';

@Injectable({
  providedIn: 'root'
})
export class ActionService {

  private actionUrl:string;

  constructor(private http:HttpClient) {

    this.actionUrl='http://localhost:8082/actions';
   }

  getActions(): Observable<Action[]>{
    return this.http.get<Action[]>(`${this.actionUrl}/`);
  }

  //check theme is passed a pathVariable or a requestBody
  getActionsByTheme(theme:String):Observable<Action[]>{
    return this.http.get<Action[]>(`${this.actionUrl}/theme/${theme}`)
  }

  getActionsByDepartment(department:String):Observable<Action[]>{
    return this.http.get<Action[]>(`${this.actionUrl}/department/${department}`)
  }

  createAction(action: Action): Observable<Object>{
    return this.http.post(`${this.actionUrl}/post`, action);
  }

  getUserById(id: number): Observable<Action>{
    return this.http.get<Action>(`${this.actionUrl}/${id}`);
  }

  updateAction(id: number, action:Action): Observable<Object>{
    return this.http.put(`${this.actionUrl}/${id}`, action);
  }

  deleteUser(id: number): Observable<Object>{
    return this.http.delete(`${this.actionUrl}/${id}`);
  }

  
  
}
