import { BrowserModule } from '@angular/platform-browser';
import{HttpModule} from '@angular/http';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { SolicitudvacacionesComponent } from './components/solicitudvacaciones/solicitudvacaciones.component';
import { ListaSeleccionComponent } from './components/lista-seleccion/lista-seleccion.component';
import { TextoInformacionComponent } from './components/texto-informacion/texto-informacion.component';
import { DatePickerComponent} from './components/date-picker/date-picker.component';
import{FormsModule,ReactiveFormsModule} from '@angular/forms';
import { DatePipe } from '@angular/common';
import{IngresoSolicitudService} from'./services/ingreso-solicitud.service'

@NgModule({
  declarations: [
    AppComponent,
    SolicitudvacacionesComponent,
    ListaSeleccionComponent,
    TextoInformacionComponent,
    DatePickerComponent,

  ],
  imports: [
    BrowserModule ,FormsModule,HttpModule
  ],
  providers: [IngresoSolicitudService],
  bootstrap: [AppComponent]
})
export class AppModule { }
