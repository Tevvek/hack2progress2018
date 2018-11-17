import { Component, OnInit, Input, ChangeDetectorRef, Output, EventEmitter } from '@angular/core';
import * as mapboxgl from 'mapbox-gl/dist/mapbox-gl';
import { GeneralHttpService } from 'src/app/general-http.service';
import { InfoService } from 'src/app/info.service';

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

  rows;

  // @Output() stepCompleted:any = new EventEmitter();

  constructor(private cd: ChangeDetectorRef, private generalHttpService:GeneralHttpService, private infoService:InfoService) {
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
      'orientation' : false,
      'elements': false
    }
    this.isolations = [
      {
        id: 'bueno',
        descripcion: 'Buen aislamiento: Ventanal doble y tabique doble' 
      },
      {
        id: 'sencillo',
        descripcion: 'Aislamiento sencillo: Ventanal sencillo y tabique doble o ventanal doble y tabique sencillo' 
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
    } else if(this.type == 'placas') {
      this.setPlacasSection();
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
            // this.infoService.setLatlng();
            // this.stepCompleted.emit({
            // });
            this.infoService.udpateData({
              section: 'geolocation',
              latlng: [e.lngLat.lat, e.lngLat.lng]
            });
          this.calderas.latlng = [e.lngLat.lat, e.lngLat.lng];
        });

        if(this.infoService.getLatLng() != undefined) {
          let latlng:any = this.infoService.getLatLng();
          this.marker = new mapboxgl.Marker()
            .setLngLat([latlng[1], latlng[0]])
            .addTo(map);
          this.calderas.latlng = [latlng[1], latlng[0]];
        }

        if(this.infoService.getSurface() != undefined) {
          this.calderas.surface = this.infoService.getSurface();
        }

        if(this.infoService.getIsolation() != undefined) {
          this.calderas.isolation = this.infoService.getIsolation();
        }

        if(this.infoService.getOrientation() != undefined) {
          this.calderas.orientation = this.infoService.getOrientation();  
        }
      }

  setCalderasSection = () => {
    this.sections.location = true;
    this.sections.surface = true;
    this.sections.isolation = true;
    this.sections.orientation = true;
    this.sections.elements = false;
  }

  setPlacasSection = () => {
    this.sections.location = true;
    this.sections.surface = false;
    this.sections.isolation = false;
    this.sections.orientation = false;
    this.sections.elements = true;
  }

  result = false;
  onSubmit = (e) => {
    if(this.type == 'calderas')
      this.generalHttpService.postCalderas(this.calderas).then(calderasRes => {
        this.setResultCharts(calderasRes);
        this.rows = calderasRes;
        this.infoService.udpateData({
          section: 'result',
        })
        this.result = true;
      });
    else if(this.type == 'placas')
      this.generalHttpService.postPaneles(null);
  }

  setSurface = (e) => {
    this.infoService.udpateData({
      section: 'surface',
      surface: this.calderas.surface
    })
  }

  onChangeIsolation = (e) => {
    this.infoService.udpateData({
      section: 'isolation',
      isolation: this.calderas.isolation
    })
  }

  onChangeOrientation = (e) => {
    this.infoService.udpateData({
      section: 'orientation',
      orientation: this.calderas.orientation
    })
  }

  public lineChartLabels:Array<any> = ['2018', '2019', '2020', '2021', '2022', '2023', '2024', '2025', '2026', '2027'];
  public lineChartOptions:any = {
    responsive: true
  };

  public lineChartColors:Array<any> = [
    { // grey 
      backgroundColor: 'rgb(255, 161, 181)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    },
    { // dark grey rgb(134, 199, 243)
      backgroundColor: 'rgb(134, 199, 243)',
      borderColor: 'rgba(77,83,96,1)',
      pointBackgroundColor: 'rgba(77,83,96,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(77,83,96,1)'
    },
    { // grey rgb(255, 226, 154) rgb(255, 226, 154) rgb(255, 226, 154)
      backgroundColor: 'rgb(255, 226, 154)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'  
    },
    { // grey
      backgroundColor: 'rgb(236, 237, 240)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'  
    },
    { // grey
      backgroundColor: 'rgb(147, 217, 217)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'  
    }
  ];
  public lineChartLegend:boolean = true;
  public lineChartType:string = 'line';
  public barChartType:string = 'bar';

    // events
    public chartClicked(e:any):void {
      console.log(e);
    }
   
    public chartHovered(e:any):void {
      console.log(e);
    }

    public lineChartData:Array<any> = [];
  
    setResultCharts = (res) => {
      var chartData:Array<any> = [];
      for(let i in res) {
        let caldera = res[i];
        var data = {
          data: [caldera.inversionInicialEstimada],
          label: caldera.tipoCaldera
        }
        var gasto = caldera.gastoAnualEstimado;
        for(var j=0;j<9;++j){
          var nuevoValor = data.data[data.data.length-1]+gasto;
          data.data.push(nuevoValor);
        }
        chartData.push(data);
      }
      this.lineChartData = chartData;
    }

}
