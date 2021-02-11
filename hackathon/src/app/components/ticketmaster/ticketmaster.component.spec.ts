import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketmasterComponent } from './ticketmaster.component';

describe('TicketmasterComponent', () => {
  let component: TicketmasterComponent;
  let fixture: ComponentFixture<TicketmasterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketmasterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketmasterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
