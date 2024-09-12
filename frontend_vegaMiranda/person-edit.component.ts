import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-person-edit',
  templateUrl: './person-edit.component.html',
  styleUrls: ['./person-edit.component.css']
})
export class PersonEditComponent implements OnInit {
  person: any = {};

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.http.get<any>(`http://localhost:3000/persons/${id}`).subscribe(data => {
        this.person = data;
      });
    }
  }

  save(): void {
    if (this.person.id) {
      this.http.put(`http://localhost:3000/persons/${this.person.id}`, this.person).subscribe(() => {
        this.router.navigate(['/persons']);
      });
    } else {
      this.http.post('http://localhost:3000/persons', this.person).subscribe(() => {
        this.router.navigate(['/persons']);
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/persons']);
  }
}
