package utilidadFecha;

import java.util.ArrayList;
import java.util.Calendar;

public class FestivosColombia {
	public static ArrayList<Calendar> diasFestivos = new ArrayList<>();
	public static int DIA_LUNES = Calendar.MONDAY;
	public static int DIA_JUEVES= Calendar.THURSDAY;
	public static int DIA_VIERNES = Calendar.FRIDAY;
	public static int DIA_DOMINGO = Calendar.SUNDAY;
	
	public static ArrayList<Calendar> DiasFestivos(int anio) {
		diasFestivos.clear();
		Calendar Pascua = calcularPascua(anio);
		Calendar diaFestivo = Calendar.getInstance();
		
		diaFestivo.set(anio, 0, 1); //1 de enero
		incluirFecha(diaFestivo); 
		
		diaFestivo.set(anio, 0,6); //reyes magos
		incluirFecha(siguienteDiaSemana(DIA_LUNES, diaFestivo,false,true)); 
		
		diaFestivo.set(anio, 2,19);// san jose
		incluirFecha(siguienteDiaSemana(DIA_LUNES, diaFestivo,false,true));

		incluirFecha(siguienteDiaSemana(DIA_DOMINGO, Pascua, true, false)); //Domingo de Ramos
		
		incluirFecha(siguienteDiaSemana(DIA_JUEVES, Pascua, true,true)); //Jueves Santo
		
        incluirFecha(siguienteDiaSemana(DIA_VIERNES, Pascua, true,true)); //Viernes Santo
        
        incluirFecha(Pascua); //Pascua
        System.out.println("pascua "+Pascua.getTime());
		
		diaFestivo.set(anio, 4,1);//dia del trabajo
		incluirFecha(diaFestivo); 
		
		diaFestivo=siguienteDiaSemana(DIA_LUNES, Pascua,false,true);
		diaFestivo.add(diaFestivo.DAY_OF_YEAR,42);
		incluirFecha( diaFestivo); //Ascensión de Jesús
		
		diaFestivo=siguienteDiaSemana(DIA_LUNES, Pascua,false,true);
		diaFestivo.add(diaFestivo.DAY_OF_YEAR,63);
	    incluirFecha( diaFestivo); //Corpus Christi
	    
	    diaFestivo=siguienteDiaSemana(DIA_LUNES, Pascua,false,true);
		diaFestivo.add(diaFestivo.DAY_OF_YEAR,70);
	    incluirFecha(diaFestivo); //Sagrado Corazón

		
		
		diaFestivo.getTime();
		diaFestivo.set(anio, Calendar.JUNE, 29);//san pedro y pablo
		incluirFecha(siguienteDiaSemana(DIA_LUNES, diaFestivo,false,true)); 
		
		
		diaFestivo.set(anio, 6,20);//Independencia
		incluirFecha(diaFestivo); 

		
		diaFestivo.set(anio, 7,7);//batalla de boyaca
		incluirFecha(diaFestivo); 

		
		diaFestivo.set(anio, 7,15);//ascension de la virgen
		incluirFecha(siguienteDiaSemana(DIA_LUNES, diaFestivo,false,true)); 

		
		diaFestivo.set(anio, 9,12);//dia de la raza
		incluirFecha(siguienteDiaSemana(DIA_LUNES, diaFestivo,false,true)); 

		
		diaFestivo.set(anio, 10,1);//todos los santos
		incluirFecha(siguienteDiaSemana(DIA_LUNES, diaFestivo,false,true)); 

		
		diaFestivo.set(anio, 10,11);//independencia cartagena
		incluirFecha(siguienteDiaSemana(DIA_LUNES, diaFestivo,false,true)); 

		
		diaFestivo.set(anio, 11,8);//inmaculada concepcion
		incluirFecha(diaFestivo); 

		
		diaFestivo.set(anio, 11,25);//navdad
		incluirFecha(diaFestivo); 

		
		return diasFestivos;

	}

	private static void incluirFecha(Calendar diaFestivo) {
		 if (!diasFestivos.contains(diaFestivo)){
			 diasFestivos.add(diaFestivo);
		 }

	}

	private static Calendar calcularPascua(int anio) {
		int a, b, c, d, e;
		int m = 24, n = 5;

		if (anio >= 1583 && anio <= 1699) {
			m = 22;
			n = 2;
		} else if (anio >= 1700 && anio <= 1799) {
			m = 23;
			n = 3;
		} else if (anio >= 1800 && anio <= 1899) {
			m = 23;
			n = 4;
		} else if (anio >= 1900 && anio <= 2099) {
			m = 24;
			n = 5;
		} else if (anio >= 2100 && anio <= 2199) {
			m = 24;
			n = 6;
		} else if (anio >= 2200 && anio <= 2299) {
			m = 25;
			n = 0;
		}

		a = anio % 19;
		b = anio % 4;
		c = anio % 7;
		d = ((a * 19) + m) % 30;
		e = ((2 * b) + (4 * c) + (6 * d) + n) % 7;

		int dia = d + e;

		Calendar inicioPascua = Calendar.getInstance();
		if (dia < 10) { // Marzo
			inicioPascua.set(anio, Calendar.MARCH, dia + 22);
			System.out.println(inicioPascua.getTime());
			return inicioPascua;
		} else // Abril
		{

			if (dia == 26) {
				dia = 19;
			} else if (dia == 25 && d == 28 && e == 6 && a > 10) {
				dia = 18;
			} else {
				dia -= 9;
			}
			inicioPascua.set(anio, Calendar.APRIL, dia);
			return inicioPascua;
		}
	}

	private static Calendar siguienteDiaSemana(int diaSemana, Calendar fechaReferencia,boolean haciaAtras,boolean inclusive) {
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(fechaReferencia.getTime());
		if (inclusive){
			if (fecha.get(Calendar.DAY_OF_WEEK) == diaSemana) {
				return fecha;
			}
		}
		else{
			if(haciaAtras){
				fecha.add(fecha.DAY_OF_YEAR, -1);
			}
			else{
				fecha.add(fecha.DAY_OF_YEAR, 1);
			}
		}
		while (fecha.get(Calendar.DAY_OF_WEEK) != diaSemana) {
			if(haciaAtras){
				fecha.add(fecha.DAY_OF_YEAR, -1);
			}
			else{
				fecha.add(fecha.DAY_OF_YEAR, 1);
			}
		}
		return fecha;
	}

}
