import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchCustomerByIdComponent } from './fetch-customer-by-id.component';

describe('FetchCustomerByIdComponent', () => {
  let component: FetchCustomerByIdComponent;
  let fixture: ComponentFixture<FetchCustomerByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FetchCustomerByIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FetchCustomerByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
