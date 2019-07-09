import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormGroup, FormControl } from '@angular/forms';
import { Department } from 'src/app/models/department.model';

@Component({
  selector: 'app-department-details',
  templateUrl: './department-details.component.html',
  styleUrls: ['./department-details.component.css']
})
export class DepartmentDetailsComponent implements OnInit {

  departmentForm: FormGroup;
  department: Department;

  constructor(public matDialogRef: MatDialogRef<DepartmentDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) private _data: any) {

    this.departmentForm = this.createdepartmentForm();
    if (this._data && this._data.id) {
      this.department = this._data;
      this.departmentForm.patchValue({
        name: this.department.name,
        description: this.department.description
      });
    } else {
      this.department = new Department();
    }

  }

  ngOnInit() {
  }

  createdepartmentForm() {
    return new FormGroup({
      name: new FormControl(''),
      description: new FormControl('')
    });
  }

  onSaveClick() {

    let formRawData: any = this.departmentForm.getRawValue();
    this.department.name = formRawData.name;
    this.department.description = formRawData.description;


    this.matDialogRef.close({ safeClose: true, data: this.department });

  }

}
