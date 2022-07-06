import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DelayPerTransportComponent } from './delay-per-transport.component';

describe('DelayPerTransportComponent', () => {
  let component: DelayPerTransportComponent;
  let fixture: ComponentFixture<DelayPerTransportComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DelayPerTransportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DelayPerTransportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
