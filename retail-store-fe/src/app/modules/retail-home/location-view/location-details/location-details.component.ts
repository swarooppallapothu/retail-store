import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormGroup, FormControl } from '@angular/forms';
import { Location } from 'src/app/models/location.model';

@Component({
  selector: 'app-location-details',
  templateUrl: './location-details.component.html',
  styleUrls: ['./location-details.component.css']
})
export class LocationDetailsComponent implements OnInit {

  detailsForm: FormGroup;
  location: Location;

  constructor(public matDialogRef: MatDialogRef<LocationDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) private _data: any) {
    this.detailsForm = this.createDetailsForm();

    if (this._data && this._data.id) {
      this.location = this._data;
      this.detailsForm.patchValue({
        name: this.location.name,
        description: this.location.description
      });
    } else {
      this.location = new Location();
    }

  }

  ngOnInit() {
  }

  createDetailsForm() {
    return new FormGroup({
      name: new FormControl(''),
      description: new FormControl('')
    });
  }

  onSaveClick() {

    let formRawData: any = this.detailsForm.getRawValue();
    this.location.name = formRawData.name;
    this.location.description = formRawData.description;


    this.matDialogRef.close({ safeClose: true, data: this.location });

  }

}
