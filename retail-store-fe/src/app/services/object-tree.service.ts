import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { DynamicFlatNode } from '../modules/retail-home/objects-tree/objects-tree.component';

@Injectable()
export class ObjectTreeService {

    onNodeModified: BehaviorSubject<any>;
    selectedNode: DynamicFlatNode;

    constructor(

    ) {
        // Set the defaults
        this.onNodeModified = new BehaviorSubject([]);
        this.selectedNode = null;
    }

    setSelectedNode(selectedNode: DynamicFlatNode) {
        this.selectedNode = selectedNode;
    }

    nodeModified() {
        this.onNodeModified.next(this.selectedNode);
    }

}