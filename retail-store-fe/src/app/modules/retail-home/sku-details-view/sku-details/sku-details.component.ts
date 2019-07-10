import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormGroup, FormControl } from '@angular/forms';
import { SkuDetails } from 'src/app/models/sku-details.model';

@Component({
  selector: 'app-sku-details',
  templateUrl: './sku-details.component.html',
  styleUrls: ['./sku-details.component.css']
})
export class SkuDetailsComponent implements OnInit {
  skuDetailsForm: FormGroup;
  skuDetails: SkuDetails;

  constructor(public matDialogRef: MatDialogRef<SkuDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) private _data: any) {

    this.skuDetailsForm = this.createSkuDetailsForm();
    if (this._data && this._data.id) {
      this.skuDetails = this._data;
      this.skuDetailsForm.patchValue({
        name: this.skuDetails.name,
        description: this.skuDetails.description
      });
    } else {
      this.skuDetails = new SkuDetails();
    }

  }

  ngOnInit() {
  }

  createSkuDetailsForm() {
    return new FormGroup({
      name: new FormControl(''),
      description: new FormControl('')
    });
  }

  onSaveClick() {

    let formRawData: any = this.skuDetailsForm.getRawValue();
    this.skuDetails.name = formRawData.name;
    this.skuDetails.description = formRawData.description;


    this.matDialogRef.close({ safeClose: true, data: this.skuDetails });

  }
}
