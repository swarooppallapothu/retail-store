import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DynamicFlatNode } from './objects-tree/objects-tree.component';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-retail-home',
  templateUrl: './retail-home.component.html',
  styleUrls: ['./retail-home.component.css']
})
export class RetailHomeComponent implements OnInit {
  options: any = {
    bottom: 0,
    fixed: false,
    top: 0
  };;

  constructor(private router: Router) {

  }



  ngOnInit() {
  }


  onObjectsTreeNodeClick(objectNode: DynamicFlatNode) {
    if (!objectNode) {
      return;
    }

    if (objectNode.objectDetails.type === 'ROOT') {
      this.router.navigate(['/retail-home/root-view']);
    } else if (objectNode.objectDetails.type === 'LOCATION') {
      this.router.navigate([`/retail-home/location-view/${objectNode.objectDetails.id}`]);
    } else if (objectNode.objectDetails.type === 'DEPARTMENT') {
      this.router.navigate([`/retail-home/department-view/${objectNode.objectDetails.id}`]);
    } else if (objectNode.objectDetails.type === 'CATEGORY') {
      this.router.navigate([`/retail-home/category-view/${objectNode.objectDetails.id}`]);
    } else if (objectNode.objectDetails.type === 'SUB_CATEGORY') {
      this.router.navigate([`/retail-home/sub-category-view/${objectNode.objectDetails.id}`]);
    }
  }
}
