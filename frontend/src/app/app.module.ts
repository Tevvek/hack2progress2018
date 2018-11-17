import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { ContentComponent } from './content/content.component';
import { WizardComponent } from './content/wizard/wizard.component';

import { RouterModule, Routes } from '@angular/router';
import { CalderasComponent } from './content/calderas/calderas.component';
import { PlacasComponent } from './content/placas/placas.component';
import { SectionsComponent } from './content/sections/sections.component';

import { FormsModule }   from '@angular/forms';
import { GeneralHttpService } from './general-http.service';
import { HttpClientModule, } from '@angular/common/http';
import { InfoService } from './info.service';


const appRoutes: Routes = [
  { path: 'calderas', component: CalderasComponent },
  { path: 'placas', component: PlacasComponent },
  { path: '',
    redirectTo: '/calderas',
    pathMatch: 'full'
  }
  // ,
  // { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ContentComponent,
    WizardComponent,
    CalderasComponent,
    PlacasComponent,
    SectionsComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [GeneralHttpService, InfoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
