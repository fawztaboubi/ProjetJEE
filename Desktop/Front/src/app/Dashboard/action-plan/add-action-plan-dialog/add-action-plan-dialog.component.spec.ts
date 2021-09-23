import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddActionPlanDialogComponent } from './add-action-plan-dialog.component';

describe('AddActionPlanDialogComponent', () => {
  let component: AddActionPlanDialogComponent;
  let fixture: ComponentFixture<AddActionPlanDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddActionPlanDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddActionPlanDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
