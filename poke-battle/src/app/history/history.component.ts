import { Component, OnInit } from '@angular/core';
import { PokeService } from '../service/poke.service';

@Component({
  standalone: true,
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css', '../styles/css-pokemon-gameboy.css']
})
export class HistoryComponent implements OnInit {

  history: any[] = [];

  constructor(private service: PokeService) {}

  ngOnInit() {
    this.service.getHistory().subscribe(h => this.history = h);
  }
}