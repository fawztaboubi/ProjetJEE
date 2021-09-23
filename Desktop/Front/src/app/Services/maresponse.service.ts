import { Maresponse } from './../classes/maresponse';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MaresponseService {

  private maresponseUrl:string;

  constructor(private http:HttpClient) {

    this.maresponseUrl='http://localhost:8082/maresponses';
   }

   getUsers(): Observable<Maresponse[]>{
    return this.http.get<Maresponse[]>(`${this.maresponseUrl}`);
  }

  createUser(maresponse: Maresponse): Observable<Object>{
    return this.http.post(`${this.maresponseUrl}`, maresponse);
  }

  getUserById(id: number): Observable<Maresponse>{
    return this.http.get<Maresponse>(`${this.maresponseUrl}/${id}`);
  }

  updateUser(id: number, maresponse: Maresponse): Observable<Object>{
    return this.http.put(`${this.maresponseUrl}/${id}`, maresponse);
  }

  deleteUser(id: number): Observable<Object>{
    return this.http.delete(`${this.maresponseUrl}/${id}`);
  }
}
