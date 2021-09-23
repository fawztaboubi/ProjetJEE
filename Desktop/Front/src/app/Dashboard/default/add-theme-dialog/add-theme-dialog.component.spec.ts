import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddThemeDialogComponent } from './add-theme-dialog.component';

describe('AddThemeDialogComponent', () => {
  let component: AddThemeDialogComponent;
  let fixture: ComponentFixture<AddThemeDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddThemeDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddThemeDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
