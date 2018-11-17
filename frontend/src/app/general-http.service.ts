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
     

     var infoPanelesRequest = {
      posicion: {
        lat: infoPaneles.latlng[0],
        lon: infoPaneles.latlng[1]
      },
      elementos: infoPaneles.elements
     }
     return new Promise((resolve, reject) => {
      this.http.post('http://localhost:8080/hack2progress/calcularPaneles',  infoPanelesRequest, { headers: headers})
        .subscribe(data => {
          resolve(data);
        }, err => {
          reject({err: err});
        })
   }
}
