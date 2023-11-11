import { Component } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  searchQuery: string = '';
  selectedCriteria: string = '';
  searchResults: any; // Replace 'any[]' with the actual user data type you have.

  constructor(private userService: UserService) {}

  searchUsers() {
    if (!this.searchQuery) {
      return; // Don't perform an empty search.
    }

    // Call the appropriate method in the userService based on the selected criteria.
    switch (this.selectedCriteria) {
      
      case 'name' :
        
        this.userService.findByName(this.searchQuery).subscribe((data : any) => {
          this.searchResults = data;
          console.log(data);
        });
        break;
      case 'gender':
        this.userService.findByGender(this.searchQuery).subscribe((data : any) => {
          this.searchResults = data;
        });
        break;
      case 'location':
        this.userService.findByLocation(this.searchQuery).subscribe((data : any) => {
          this.searchResults = data;
        });
        break;
      case 'education':
        this.userService.findByEducation(this.searchQuery).subscribe((data : any) => {
          this.searchResults = data;
        });
        break;
      case 'job':
        this.userService.findByJob(this.searchQuery).subscribe((data : any) => {
          this.searchResults = data;
        });
        break;
      case 'motherTongue':
        this.userService.findBymotherTongue(this.searchQuery).subscribe((data : any) => {
          this.searchResults = data;
        });
        break;
      default:
        // Handle invalid selection or other criteria.
        this.searchResults = []; // Clear any previous results.
      this.searchResults.push({ message: 'Data not found' });
    }
  }


  request() {
    // Your Google sign-in logic here
  }
}
