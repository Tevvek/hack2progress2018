import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class GeneralHttpService {

  constructor(private http: HttpClient) { }

  test = (t) => {
    var a = this.http.get('http://localhost:8080/hack2progress/pruebas')
      .toPromise().then((res) => {
        console.log(res);
      }, () => 
      {

      })
  }
}
