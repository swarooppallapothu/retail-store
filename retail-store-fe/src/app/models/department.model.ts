import { AbstractModel } from './abstract.model';
import { Location } from './location.model';

export class Department extends AbstractModel {
    name?: string;
    description?: string;
    location?: Location;
}