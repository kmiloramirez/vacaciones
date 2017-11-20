package utilidadFecha;

public class main {

	public static void main(String[] args) {
		
		for(int i=1;i<(FestivosColombia.DiasFestivos(2019)).size();i++){
			
			System.out.println(FestivosColombia.diasFestivos.get(i).getTime());
		}
		

	}

}
