import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import * as mapboxgl from 'mapbox-gl/dist/mapbox-gl';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.scss']
})
export class ContentComponent implements OnInit {

  step;
  center:any;
  marker;

  @Output() stepCompleted = new EventEmitter();

  constructor() { }

  ngOnInit() {
    // create map
    mapboxgl.accessToken = 'pk.eyJ1IjoidGV2dmVrIiwiYSI6ImNqbXc2MjBvZjE3cHcza3F5bGt6cGk2bnQifQ.Eg0yKWIiP2OeJss90olzEQ';
    var map = new mapboxgl.Map({
      container: 'map',
      style: 'mapbox://styles/mapbox/streets-v10',
      zoom: 10
    });

    // center to user location
    if("geolocation" in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        map.setCenter([position.coords.longitude, position.coords.latitude]);
      })
    }

    // add geolocation control
    map.addControl(new mapboxgl.GeolocateControl({
      positionOptions: {
          enableHighAccuracy: true
      },
      trackUserLocation: true
    }));

    // on click set living location
    map.on('click', (e) => {
      if(this.marker != null) {
        this.marker.remove();
      }
      this.marker = new mapboxgl.Marker()
        .setLngLat([e.lngLat.lng, e.lngLat.lat])
        .addTo(map);
        this.stepCompleted.emit("geolocation");
    })
  }

  completeStep = ($event) => {
    console.log('Content got event from pages', $event);
    this.step = $event;
  }

}
