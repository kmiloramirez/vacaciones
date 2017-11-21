import {  Component, OnInit,Output,Input,EventEmitter} from '@angular/core';
import{ IngresoSolicitudService } from '../../services/ingreso-solicitud.service'
import swal from 'sweetalert2';

@Component({
  selector: 'app-solicitudvacaciones',
  templateUrl: './solicitudvacaciones.component.html',
  styleUrls: ['./solicitudvacaciones.component.css']
})
export class SolicitudvacacionesComponent implements OnInit{
  selectedoption: string = "En días";
  fechaInicio:any; 
  fechaFin:any; 
  cond:string ="En días";
  dias:any=0;
  fechaRegreso:Date;
  options: string[] = ["En días", "En dinero"]; 


  constructor(private _service:IngresoSolicitudService) { }
  public solicitud={
    placa:''
  };
  ingresoSolicitud(obj){
    console.log(obj);
    swal({
      title: 'Excelente!',
      text: 'Su Solicitud se ha guarado Correctamente',
      type: 'success',
      confirmButtonColor: '##117b66',
      confirmButtonText: 'Aceptar'
      
    })
    this. _service.create(obj.solicitud).subscribe(res=>{
        
    });
  }
  diferenciaDias(){

  var fechaDiaDeVacacion = new Date(this.fechaInicio);
  var fechaSolicitudFinVacaciones = new Date(this.fechaFin);
  this.fechaRegreso= new Date(this.fechaInicio);
  this.dias=0;

  if(fechaDiaDeVacacion>fechaSolicitudFinVacaciones){
    swal({
      title: 'Atencion!',
      text: 'la Fecha Inicial es mayor a la Final',
      type: 'warning',
      confirmButtonColor: '#117b66',
      confirmButtonText: 'Aceptar'
    })
  }
  else{
    while((fechaDiaDeVacacion<=fechaSolicitudFinVacaciones)){
      var diasemana=fechaDiaDeVacacion.getDay();
      if(this.dias==15){
        swal({
          title: 'Atencion!',
          text: 'Solo Puedes Sacar 15 dias de vacaciones',
          type: 'warning',
          confirmButtonColor: '#117b66',
          confirmButtonText: 'Aceptar'
        })
        break;
      }
      if (!((diasemana==6)||(diasemana==5))){
        this.dias+=1;
      } 
      this.fechaRegreso.setDate(fechaDiaDeVacacion.getDate())+1;    
      fechaDiaDeVacacion.setDate(fechaDiaDeVacacion.getDate()+1);
    }
    var diasemana2=fechaDiaDeVacacion.getDay();
    if ((diasemana2==5)){
      this.fechaRegreso.setDate(fechaDiaDeVacacion.getDate()+3);
    }
    else if ((diasemana2==6)){
      this.fechaRegreso.setDate(fechaDiaDeVacacion.getDate()+2);
    }
    else{
      this.fechaRegreso.setDate(fechaDiaDeVacacion.getDate()+1);
    }
  
  }    
 
  }
  ngOnInit() {
    
  }

}
