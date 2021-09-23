import { Department } from './../classes/department';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  private departmentUrl:string;

  constructor(private http:HttpClient) {

    this.departmentUrl='http://localhost:8082/departments';
   }

   getDepartments(): Observable<Department[]>{
    return this.http.get<Department[]>(`${this.departmentUrl}/`);
  }

  createDepartment(department:Department): Observable<Object>{
    return this.http.post(`${this.departmentUrl}`, department);
  }

  getDepartmentById(id: number): Observable<Department>{
    return this.http.get<Department>(`${this.departmentUrl}/${id}`);
  }

  updateDepartment(id: number, department: Department): Observable<Object>{
    return this.http.put(`${this.departmentUrl}/${id}`, department);
  }

  deleteDepartment(id: number): Observable<Object>{
    return this.http.delete(`${this.departmentUrl}/${id}`);
  }

  getDepartmentByName(name: String): Observable<Department>{
    return this.http.get<Department>(`${this.departmentUrl}/name/${name}`);
  }

}
