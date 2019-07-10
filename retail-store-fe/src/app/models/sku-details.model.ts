import { AbstractModel } from './abstract.model';
import { SubCategory } from './sub-category.model';

export class SkuDetails extends AbstractModel {
    name?: string;
    description?: string;
    subCategory?: SubCategory;
}