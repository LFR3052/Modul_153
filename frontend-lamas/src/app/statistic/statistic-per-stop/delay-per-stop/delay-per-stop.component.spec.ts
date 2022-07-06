import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DelayPerStopComponent } from './delay-per-stop.component';

describe('DelayPerStopComponent', () => {
  let component: DelayPerStopComponent;
  let fixture: ComponentFixture<DelayPerStopComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DelayPerStopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DelayPerStopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
