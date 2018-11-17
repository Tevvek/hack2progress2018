import { Component, OnInit, Input } from '@angular/core';
import { InfoService } from 'src/app/info.service';

@Component({
  selector: 'app-wizard',
  templateUrl: './wizard.component.html',
  styleUrls: ['./wizard.component.scss']
})
export class WizardComponent implements OnInit {

  steps:any;
  stepsCalderas:any;
  stepsPlacas:any;

  @Input() type:string;

  // @Input()
  // set updateStep(step:String) {
  //   console.log('test', step);
  //   if(step == "geolocation") {
  //     this.steps[0].completed = true;
  //   } else {
  //   }
  // }

  constructor(private infoService:InfoService) {
    this.stepsCalderas = [
      {
        title: 'Localización',
        icon: 'fa-map-marked-alt',
        completed: false
      },
      {
        title: 'Superficie',
        icon: 'fa-home',
        completed: false
      },
      {
        title: 'Aislamiento',
        icon: 'fa-star-half-alt',
        completed: false
      },
      {
        title: 'Orientación',
        icon: 'fa-compass',
        completed: false
      },
      {
        title: 'Resultado',
        icon: 'fa-chart-line',
        completed: false
      }
    ]

    this.stepsPlacas = [
      {
        title: 'Localización',
        icon: 'fa-map-marked-alt',
        completed: false
      },
      {
        title: 'Calificación energética',
        icon: 'fa-star-half-alt',
        completed: false
      },
      {
        title: 'Resultado',
        icon: 'fa-chart-line',
        completed: false
      }
    ]

  }

  ngOnInit() {
    if(this.type == 'calderas') {
      this.steps = this.stepsCalderas;
    } else if(this.type == 'placas') {
      this.steps = this.stepsPlacas;
    }

    let latlng = this.infoService.getLatLng();
    if(latlng != undefined) {
      this.setGeolocationCompleted();
    }

    let surface = this.infoService.getSurface();
    if(surface != undefined) {
      this.setSurfaceCompleted();
    }

    let isolation = this.infoService.getIsolation();
    if(isolation != undefined) {
      this.setIsolationCompleted();
    }

    let orientation = this.infoService.getOrientation();
    if(orientation != undefined) {
      this.setOrientationCompleted();
    }

    this.infoService.getData().subscribe((data:any) => {
      if(data.section == 'geolocation') {
        let latlng = data.latlng;
        if(latlng != undefined) {
          this.setGeolocationCompleted();
        }
      } else if(data.section == 'surface') {
        let surface = data.surface;
        if(surface != undefined) {
          this.setSurfaceCompleted();
        }
      } else if(data.section == 'isolation') {
        let isolation = data.isolation;
        if(isolation != undefined) {
          this.setIsolationCompleted();
        }
      } else if(data.section == 'orientation') {
        let orientation = data.orientation;
        if(orientation != undefined) {
          this.setOrientationCompleted();
        }
      }
    })
  }

  setGeolocationCompleted = () => {
    this.stepsCalderas[0].completed = true;
    this.stepsPlacas[0].completed = true;
  }

  setSurfaceCompleted = () => {
    this.stepsCalderas[1].completed = true;
  }

  setIsolationCompleted = () => {
    this.stepsCalderas[2].completed = true;
  }

  setOrientationCompleted = () => {
    this.stepsCalderas[3].completed = true;
  }

}
