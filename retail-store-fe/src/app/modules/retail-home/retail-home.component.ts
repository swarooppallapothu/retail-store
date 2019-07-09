import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DynamicFlatNode } from './objects-tree/objects-tree.component';

@Component({
  selector: 'app-retail-home',
  templateUrl: './retail-home.component.html',
  styleUrls: ['./retail-home.component.css']
})
export class RetailHomeComponent implements OnInit {

  view: boolean = true;

  constructor(private router: Router) { }

  ngOnInit() {
  }


  onObjectsTreeNodeClick(objectNode: DynamicFlatNode) {
    console.log(objectNode);
    if (this.view) {
      this.router.navigate(['/retail-home/location-view']);
    } else {
      this.router.navigate(['/retail-home/department-view']);
    }
    this.view = !this.view;
  }
}
