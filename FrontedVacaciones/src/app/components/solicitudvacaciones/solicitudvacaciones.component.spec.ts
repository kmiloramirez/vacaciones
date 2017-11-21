import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SolicitudvacacionesComponent } from './solicitudvacaciones.component';

describe('SolicitudvacacionesComponent', () => {
  let component: SolicitudvacacionesComponent;
  let fixture: ComponentFixture<SolicitudvacacionesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SolicitudvacacionesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SolicitudvacacionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
