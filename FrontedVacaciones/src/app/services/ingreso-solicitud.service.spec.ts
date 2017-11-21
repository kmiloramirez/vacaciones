import { TestBed, inject } from '@angular/core/testing';

import { IngresoSolicitudService } from './ingreso-solicitud.service';

describe('IngresoSolicitudService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [IngresoSolicitudService]
    });
  });

  it('should be created', inject([IngresoSolicitudService], (service: IngresoSolicitudService) => {
    expect(service).toBeTruthy();
  }));
});
