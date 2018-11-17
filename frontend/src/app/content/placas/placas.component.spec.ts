import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlacasComponent } from './placas.component';

describe('PlacasComponent', () => {
  let component: PlacasComponent;
  let fixture: ComponentFixture<PlacasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlacasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlacasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
