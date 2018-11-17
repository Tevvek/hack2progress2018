import { Injectable } from '@angular/core';

@Injectable()
export class GeneralHttpService {

  constructor() { }

  test = (t) => {
    console.log('hi');
  }
}
