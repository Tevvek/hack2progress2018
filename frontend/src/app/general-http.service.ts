import { Injectable } from '@angular/core';

@Injectable()
export class GeneralHttpService {

  constructor() { }

  test = () => {
    console.log('hi');
  }
}
