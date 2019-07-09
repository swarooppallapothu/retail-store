import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormGroup, FormControl } from '@angular/forms';
import { SubCategory } from 'src/app/models/sub-category.model';

@Component({
  selector: 'app-sub-category-details',
  templateUrl: './sub-category-details.component.html',
  styleUrls: ['./sub-category-details.component.css']
})
export class SubCategoryDetailsComponent implements OnInit {

  subCategoryForm: FormGroup;
  subCategory: SubCategory;

  constructor(public matDialogRef: MatDialogRef<SubCategoryDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) private _data: any) {

    this.subCategoryForm = this.createSubCategoryForm();
    if (this._data && this._data.id) {
      this.subCategory = this._data;
      this.subCategoryForm.patchValue({
        name: this.subCategory.name,
        description: this.subCategory.description
      });
    } else {
      this.subCategory = new SubCategory();
    }

  }

  ngOnInit() {
  }

  createSubCategoryForm() {
    return new FormGroup({
      name: new FormControl(''),
      description: new FormControl('')
    });
  }

  onSaveClick() {

    let formRawData: any = this.subCategoryForm.getRawValue();
    this.subCategory.name = formRawData.name;
    this.subCategory.description = formRawData.description;


    this.matDialogRef.close({ safeClose: true, data: this.subCategory });

  }

}
