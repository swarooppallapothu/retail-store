import { Component } from '@angular/core';
import { Router, ActivatedRoute, NavigationStart } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {

  showLogoutButton: boolean = false;

  title = 'retail-store-fe';

  constructor(private router: Router) {
    this.router.events.forEach((event) => {
      if (event instanceof NavigationStart) {
        if (event.url === '/login') {
          this.showLogoutButton = false;
        } else {
          this.showLogoutButton = true;
        }
      }
      // NavigationEnd
      // NavigationCancel
      // NavigationError
      // RoutesRecognized
    });
  }

  onLogoutClick() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
