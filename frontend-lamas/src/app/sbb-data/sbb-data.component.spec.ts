import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { SbbDataComponent } from './sbb-data.component';

describe('SbbDataComponent', () => {
  let component: SbbDataComponent;
  let fixture: ComponentFixture<SbbDataComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ SbbDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SbbDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
