/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { LookupTableComponent } from './lookup-table.component';

describe('LookupTableComponent', () => {
  let component: LookupTableComponent;
  let fixture: ComponentFixture<LookupTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LookupTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LookupTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
