import { AbstractModel } from './abstract.model';
import { Category } from './category.model';

export class SubCategory extends AbstractModel {
    name?: string;
    description?: string;
    category?: Category;
}