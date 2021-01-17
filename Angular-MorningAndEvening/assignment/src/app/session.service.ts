import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private http: HttpClient) { }
  getDataByID(id: string | number) {
    console.log("fetching data");
    const url = 'https://jsonplaceholder.typicode.com/todos/' + id;
    return this.http.get(url);
  }
  getData() {
    console.log("fetching data");
    const url = 'https://jsonplaceholder.typicode.com/todos/';
    return this.http.get(url);
  }
}
