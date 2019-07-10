import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormGroup, FormControl } from '@angular/forms';
import { Category } from 'src/app/models/category.model';


@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit {

  categoryForm: FormGroup;
  category: Category;

  constructor(public matDialogRef: MatDialogRef<CategoryDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) private _data: any) {

    this.categoryForm = this.createcategoryForm();
    if (this._data && this._data.id) {
      this.category = this._data;
      this.categoryForm.patchValue({
        name: this.category.name,
        description: this.category.description
      });
    } else {
      this.category = new Category();
    }

  }

  ngOnInit() {
  }

  createcategoryForm() {
    return new FormGroup({
      name: new FormControl(''),
      description: new FormControl('')
    });
  }

  onSaveClick() {

    let formRawData: any = this.categoryForm.getRawValue();
    this.category.name = formRawData.name;
    this.category.description = formRawData.description;


    this.matDialogRef.close({ safeClose: true, data: this.category });

  }

}
