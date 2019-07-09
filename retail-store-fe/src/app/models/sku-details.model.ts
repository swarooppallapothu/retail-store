import { AbstractModel } from './abstract.model';
import { SubCategory } from './sub-category.model';

export class Category extends AbstractModel {
    name?: string;
    description?: string;
    subCategory?: SubCategory;
}