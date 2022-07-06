import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DelayPerLineComponent } from './delay-per-line.component';

describe('DelayPerLineComponent', () => {
  let component: DelayPerLineComponent;
  let fixture: ComponentFixture<DelayPerLineComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DelayPerLineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DelayPerLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
