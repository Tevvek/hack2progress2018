import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { ContentComponent } from './content/content.component';
import { WizardComponent } from './content/wizard/wizard.component';
import { PagesComponent } from './content/pages/pages.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ContentComponent,
    WizardComponent,
    PagesComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
