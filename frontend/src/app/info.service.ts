import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable()
export class InfoService {

  private obs$ = new Subject();

  latlng;
  surface;
  isolation;
  orientation;

  constructor() { }

  getData = () => {
    return this.obs$;
  }

  udpateData = (data) => {
    if(data.section == 'geolocation') {
      this.latlng = data.latlng;
    } else if(data.section == 'surface') {
      this.surface = data.surface;
    } else if(data.section == 'isolation') {
      this.isolation = data.isolation;
    } else if(data.section == 'orientation') {
      this.orientation = data.orientation;
    }
    this.obs$.next(data);
  }

  setLatlng = (latlng) => {
    this.latlng = latlng;
  }
  
  getLatLng = () => {
    return this.latlng;
  }

  getSurface = () => {
    return this.surface;
  }

  getIsolation = () => {
    return this.isolation;
  }

  getOrientation = () => {
    return this.orientation;
  }
  
}
