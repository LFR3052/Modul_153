import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { AverageDelayPerLineComponent } from './average-delay-per-line.component';

describe('AverageDelayPerLineComponent', () => {
  let component: AverageDelayPerLineComponent;
  let fixture: ComponentFixture<AverageDelayPerLineComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ AverageDelayPerLineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AverageDelayPerLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
