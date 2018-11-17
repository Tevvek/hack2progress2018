import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {RequestOptions} from '@angular/http';
import { SELECT_VALUE_ACCESSOR } from '@angular/forms/src/directives/select_control_value_accessor';


@Injectable()
export class GeneralHttpService {
  headers: any;

  constructor(private http: HttpClient) { }

  postCalderas = (infoCalderas) => {
   // let data = new URLSearchParams();


    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    // let options = new RequestOptions({ headers: headers });
  
    return new Promise((resolve, reject) => {
      this.http.post('http://localhost:8080/hack2progress/calcular',  {
        superficie: infoCalderas.surface,
        orientacion: infoCalderas.orientation,
        aislamiento: infoCalderas.isolation,
        posicion: {
          lat: infoCalderas.latlng[0],
          lon: infoCalderas.latlng[1]
        }
      }, { headers: headers})
      .subscribe(data => {
        resolve(data);
      }, err => {
        reject({error: err});
      })
    });
    // var a = .toPromise();
    // .subscribe((data) => {
    //   success(data);
    // }, (err) => {
    //   console.log('err', err);
    // });
    // return a;
  }

  
  postPaneles = (infoPaneles) => {
    // let data = new URLSearchParams();
 
 
     let headers = new HttpHeaders();
     headers.append('Content-Type', 'application/json');
     // let options = new RequestOptions({ headers: headers });
   
     var a = this.http.post('http://localhost:8080/hack2progress/calcularPaneles',  {
      /* superficie: infoCalderas.surface,
       orientacion: infoCalderas.orientation,
       aislamiento: infoCalderas.isolation,*/
       posicion: {
         lat: 12,
         lon: 14
       }/*,
       "elementos" : [
        {
            "nombre":"bombillas",
            "potencia":"60",
            "horasUso":"12"
        },
        {
            "nombre":"nevera",
            "potencia":"120",
            "horasUso":"6"
        }
    ],*/
     }, { headers: headers}).toPromise().then((res) => {
         console.log(res);
       }, (err) => 
       {
         console.log(err);
       })
   }
}
