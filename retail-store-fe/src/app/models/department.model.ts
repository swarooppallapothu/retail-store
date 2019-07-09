import { AbstractModel } from './abstract.model';

export class Department extends AbstractModel {
    name: string;
    description: string;
    location: Location;
}