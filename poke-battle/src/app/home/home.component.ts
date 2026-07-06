import { Component, OnInit } from '@angular/core';
import { PokeService } from '../service/poke.service';
import { HttpClient } from '@angular/common/http';

@Component({
  standalone: true,
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css', '../styles/css-pokemon-gameboy.css']
})
export class HomeComponent implements OnInit {
  constructor(private http: HttpClient, private pokeService: PokeService) {}

  poke1: any;
  poke2: any;
  result: any;

   ngOnInit(): void {
    this.loadRandomPokemons();
  }

  loadRandomPokemons() {
    const id1 = Math.floor(Math.random() * 151) + 1;
    const id2 = Math.floor(Math.random() * 151) + 1;

    this.pokeService.getPoke(id1).subscribe(p => this.poke1 = p);
    this.pokeService.getPoke(id2).subscribe(p => this.poke2 = p);
  }

  fight(id: number, id2: number) {
    this.http.post<number>(
      `http://localhost:8080/api/fight?id=${id}&id2=${id2}`,
      {}
    ).subscribe(winnerId => {
      this.result = winnerId;
      console.log("Winner ID:", winnerId);
    });
  }

  isWinner(poke: any): boolean {
    if(!poke){
      return false;
    }
    return this.result !== null && this.result === poke.id;
  }
}
