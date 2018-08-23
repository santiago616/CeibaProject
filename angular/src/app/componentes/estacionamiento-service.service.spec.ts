import { TestBed, inject } from '@angular/core/testing';

import { EstacionamientoServiceService } from './estacionamiento-service.service';

describe('EstacionamientoServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EstacionamientoServiceService]
    });
  });

  it('should be created', inject([EstacionamientoServiceService], (service: EstacionamientoServiceService) => {
    expect(service).toBeTruthy();
  }));
});
