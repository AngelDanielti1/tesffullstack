import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {
  persons: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:3000/persons').subscribe(data => {
      this.persons = data;
    });
  }

  deletePerson(id: number): void {
    this.http.delete(`http://localhost:3000/persons/${id}`).subscribe(() => {
      this.persons = this.persons.filter(person => person.id !== id);
    });
  }
}
