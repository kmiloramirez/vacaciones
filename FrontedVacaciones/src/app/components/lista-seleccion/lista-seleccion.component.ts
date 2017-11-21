import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-seleccion',
  templateUrl: './lista-seleccion.component.html',
  styleUrls: ['./lista-seleccion.component.css']
})
export class ListaSeleccionComponent implements OnInit {
 public options=[{value:'0',name:'En días'},{value:'1',name:'En dinero'}];
  
 private selected;
  constructor() {
  }

  ngOnInit() {
  }

}
