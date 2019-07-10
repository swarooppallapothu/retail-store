import { AbstractModel } from './abstract.model';
import { Department } from './department.model';

export class Category extends AbstractModel {
    name?: string;
    description?: string;
    department?: Department;
}