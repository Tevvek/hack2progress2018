import { Component, OnInit, HostBinding, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  options:any;
  collapsedTitle:String = "+E";
  fullTitle:String = "+Energy";

  title:String = this.fullTitle;
  
  @Output() toggleEvent = new EventEmitter();

  isCollapsed:boolean = false;

  constructor() { }

  ngOnInit() {
    this.options = [
      {
        title: 'Calderas',
        icon: 'fa-fire'
      }
      ,
      {
        title: 'Placas solares',
        icon: 'fa-solar-panel'
      }
    ];
  }

  toggleMenu = () => {
    this.isCollapsed = !this.isCollapsed;
    if(this.isCollapsed) {
      this.title = this.collapsedTitle;
    } else {
      this.title = this.fullTitle;
    }
    this.toggleEvent.emit(this.isCollapsed);
  }

}
