import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'age'
})
export class AgePipe implements PipeTransform {

  currentYear: any;
  birthYear: any;
  age: any;

  transform(value: any): any {
    
    this.currentYear = new Date().getFullYear();
    this.birthYear = new Date(value).getFullYear();
    this.age = this.currentYear - this.birthYear;
    
    return this.age;
  }


}
