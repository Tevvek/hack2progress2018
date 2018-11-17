import { Component, OnInit, Input, ChangeDetectorRef } from '@angular/core';
import * as mapboxgl from 'mapbox-gl/dist/mapbox-gl';
import { GeneralHttpService } from 'src/app/general-http.service';

@Component({
  selector: 'app-sections',
  templateUrl: './sections.component.html',
  styleUrls: ['./sections.component.scss']
})
export class SectionsComponent implements OnInit {

  @Input() type: string;

  //models
  calderas:any = {};

  sections:any;   
  center:any;
  marker;

  isolations;
  orientations;

  constructor(private cd: ChangeDetectorRef, private generalHttpService:GeneralHttpService) {
    this.calderas = {
      latlng: [],
      surface: '',
      isolation: '',
      orientation: ''
    }
    this.sections = {
      'location': false,
      'surface': false,
      'isolation': false,
      'orientation' : false
    }
    this.isolations = [
      {
        id: 'bueno',
        descripcion: 'Buen aislamiento: Ventanal doble y tabique doble' 
      },
      {
        id: 'sencillo',
        descripcion: 'Asilamiento sencillo: Ventanal sencillo y tabique doble o ventanal doble y tabique sencillo' 
      },
      {
        id: 'niguno',
        descripcion: 'Ninguno: Ventanal sencillo y tabique sencillo' 
      }
    ];
    this.orientations = [
      {
        id: 'N',
        descripcion: 'Norte'
      },
      {
        id: 'S',
        descripcion: 'Sur'
      },
      {
        id: 'E',
        descripcion: 'Este'
      },
      {
        id: 'O',
        descripcion: 'Oeste'
      }
    ]
  }

  ngOnInit() {
    if(this.type == 'calderas') {
      this.setCalderasSection();
    }
    this.cd.detectChanges();
    this.initMap();
  }

  initMap = () => {
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
            // to update the wizard
            // this.stepCompleted.emit("geolocation");
          this.calderas.latlng = [e.lngLat.lat, e.lngLat.lng];
        });
      }

  setCalderasSection = () => {
    this.sections.location = true;
    this.sections.surface = true;
    this.sections.isolation = true;
    this.sections.orientation = true;
  }

  onSubmit = (e) => {
    this.generalHttpService.test();
  }

}
