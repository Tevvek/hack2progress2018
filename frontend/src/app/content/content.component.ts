import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import * as mapboxgl from 'mapbox-gl/dist/mapbox-gl';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.scss']
})
export class ContentComponent implements OnInit {

  step;

  @Output() stepCompleted = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  completeStep = ($event) => {
    console.log('Content got event from pages', $event);
    this.step = $event;
  }

}
