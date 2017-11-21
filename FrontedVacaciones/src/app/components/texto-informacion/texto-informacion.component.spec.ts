import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TextoInformacionComponent } from './texto-informacion.component';

describe('TextoInformacionComponent', () => {
  let component: TextoInformacionComponent;
  let fixture: ComponentFixture<TextoInformacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TextoInformacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TextoInformacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
