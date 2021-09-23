import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from '../classes/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private teamUrl:string;

  constructor(private http:HttpClient) {

    this.teamUrl='http://localhost:8082/teams';
   }
   
   getUsers(): Observable<Team[]>{
     return this.http.get<Team[]>(`${this.teamUrl}`);
   }
 
   createUser(team:Team): Observable<Object>{
     return this.http.post(`${this.teamUrl}`, team);
   }
 
   getUserById(id: number): Observable<Team>{
     return this.http.get<Team>(`${this.teamUrl}/${id}`);
   }
 
   updateUser(id: number, team:Team): Observable<Object>{
     return this.http.put(`${this.teamUrl}/${id}`, team);
   }
 
   deleteUser(id: number): Observable<Object>{
     return this.http.delete(`${this.teamUrl}/${id}`);
   }
}
