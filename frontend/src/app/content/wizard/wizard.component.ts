import { Component, OnInit, Input } from '@angular/core';

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

  constructor() {
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
  }

}
