import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { AverageDelayPerTransportComponent } from './average-delay-per-transport.component';

describe('AverageDelayPerTransportComponent', () => {
  let component: AverageDelayPerTransportComponent;
  let fixture: ComponentFixture<AverageDelayPerTransportComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ AverageDelayPerTransportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AverageDelayPerTransportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
