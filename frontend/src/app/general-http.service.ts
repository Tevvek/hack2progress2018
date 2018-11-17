import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {RequestOptions} from '@angular/http';


@Injectable()
export class GeneralHttpService {
  headers: any;

  constructor(private http: HttpClient) { }

  test = (t) => {
   // let data = new URLSearchParams();


    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    // let options = new RequestOptions({ headers: headers });
  
    var a = this.http.post('http://localhost:8080/hack2progress/calcular',  {
      "superficie": 20
    }, { headers: headers}).toPromise().then((res) => {
        console.log(res);
      }, (err) => 
      {
        console.log(err);
      })
  }
}
