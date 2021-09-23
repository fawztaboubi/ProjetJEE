import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from '../classes/department';
import { Theme } from '../classes/theme';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  private themeUrl:string;

  constructor(private http:HttpClient) {

    this.themeUrl='http://localhost:8082/themes';
   }
   
   getThemes(): Observable<Theme[]>{
     return this.http.get<Theme[]>(`${this.themeUrl}/`);
   }
 
   getThemesByDepartment(department:Department): Observable<Theme[]>{
    return this.http.get<Theme[]>(`${this.themeUrl}/${department}`);
  }
   createTheme(theme: Theme): Observable<Object>{
     return this.http.post(`${this.themeUrl}/`, theme);
   }
 
   getThemeById(id: number): Observable<Theme>{
     return this.http.get<Theme>(`${this.themeUrl}/${id}`);
   }
 
   updateUser(id: number, theme: Theme): Observable<Object>{
     return this.http.put(`${this.themeUrl}/${id}`, theme);
   }
 
   deleteUser(id: number): Observable<Object>{
     return this.http.delete(`${this.themeUrl}/${id}`);
   }
}
