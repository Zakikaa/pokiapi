import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class PokeService {

  private baseUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) {}

  getPoke(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/poke/${id}`);
  }

  fight(id1: number, id2: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/fight`, { id1, id2 });
  }

  getHistory(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/poke/history`);
  }
}