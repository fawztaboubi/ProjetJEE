import { User } from './../classes/user';
import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders}from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL = "http://localhost:8082/users";

  constructor(private httpClient: HttpClient) { }
  
  getUsers(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}/`);
  }

  createUser(user: User): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/post`, user);
  }

  getUserById(id: number): Observable<User>{
    return this.httpClient.get<User>(`${this.baseURL}/${id}`);
  }

  getUserByUsername(_username:String|undefined): Observable<User>{
    return this.httpClient.get<User>(`${this.baseURL}/username/${_username}`);
  }

  getUsersByDepartment(department:String): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}/${department}`);
  }
  updateUser(id: number, user: User): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, user);
  }

  deleteUser(id: number|undefined): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  }

