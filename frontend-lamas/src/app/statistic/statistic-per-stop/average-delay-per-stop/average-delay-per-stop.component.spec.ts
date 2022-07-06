import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { AverageDelayPerStopComponent } from './average-delay-per-stop.component';

describe('AverageDelayPerStopComponent', () => {
  let component: AverageDelayPerStopComponent;
  let fixture: ComponentFixture<AverageDelayPerStopComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ AverageDelayPerStopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AverageDelayPerStopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
