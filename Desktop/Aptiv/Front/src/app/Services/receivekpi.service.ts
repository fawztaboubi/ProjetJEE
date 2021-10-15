import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReceivekpiService {

  private baseUrl="http://localhost:8082/actions";
  constructor(private httpClient: HttpClient) { }

  //we're receiving a list(done,doing,delayed)
  getGeneralActionsKpi(): Observable<Number[]>{
    return this.httpClient.get<Number[]>(`${this.baseUrl}/generalKpi`);
  }

 //we want to draw graphs for done/doing/delayed action 


}
