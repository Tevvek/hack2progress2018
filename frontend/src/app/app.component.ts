import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';
  isMenuCollapsed:boolean = false;

  toggleMenu = (isCollapsed) => {
    this.isMenuCollapsed = isCollapsed;
  }

  test = (event) => {
    console.log(event);
  }
}
