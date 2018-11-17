import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.scss']
})
export class ContentComponent implements OnInit {

  step;

  constructor() { }

  ngOnInit() {
  }

  completeStep = ($event) => {
    console.log('Content got event from pages', $event);
    this.step = $event;
  }

}
