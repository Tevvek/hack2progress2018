import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-wizard',
  templateUrl: './wizard.component.html',
  styleUrls: ['./wizard.component.scss']
})
export class WizardComponent implements OnInit {

  steps:any;

  @Input()
  set updateStep(step:String) {
    console.log('test', step);
    if(step == "geolocation") {
      this.steps[0].completed = true;
    } else {
      // alert('I should not be here!');
    }
  }

  constructor() { }

  ngOnInit() {
    this.steps = [
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
  }

}
