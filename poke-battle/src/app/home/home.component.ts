import { Component, OnInit } from '@angular/core';
import { PokeService } from '../service/poke.service';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { NgIf } from '@angular/common';
@Component({
  standalone: true,
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css', '../styles/css-pokemon-gameboy.css'],
  imports: [CommonModule]
})
export class HomeComponent implements OnInit {
  constructor(private http: HttpClient, private pokeService: PokeService) {}

  poke1: any;
  poke2: any;
  result: any;

  ngOnInit(): void {
    this.loadRandomPokemons();

    this.pokeService.getPoke(4).subscribe(p => this.poke3 = p);

  }

  loadRandomPokemons() {
    const id1 = Math.floor(Math.random() * 1000) + 1;
    const id2 = Math.floor(Math.random() * 1000) + 1;

   
    this.pokeService.getPoke(id1).subscribe(p => this.poke1 = p);
    this.pokeService.getPoke(id2).subscribe(p => this.poke2 = p);
  }

  fight(id: number, id2: number) {
    this.pokeService.fight(id, id2).subscribe(winnerId => {
      this.result = winnerId;
    });
  }

  isWinner(poke: any): boolean {
    if(!poke){
      return false;
    }
    return this.result !== null && this.result === poke.id;
  }
}
