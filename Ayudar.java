import java.util.Random;
public class Ayudar{
	private int llamar = 33449912;
	private int r2;
	private String centro;
// se creo la una matriz que contiene los centros de salud disponibles
	private String[] centroSalud = {"Centro de salud 'MarCuar' ubicado en 4avenida zona 3" , "entro de salud 'LoSano' ubicado en 12avenida zona 1","Centro de salud 'UnAbrazo' ubicado en 4ta Calle zona 9"};
// retorna el numero de la cede central
	public int getNumero(){
		return llamar;
	}
// tira un valor al azar de cero a 3 para lanzar cualquiera de los 3 centros de salud
	public String cede(){
		Random r = new Random();
		r2 = r.nextInt(3);
		if (r2 == 0){
			centro = centroSalud[0];
		}else if (r2==1){
			centro = centroSalud[1];
		}else if (r2==2){
			centro = centroSalud[2];
		}else{
			centro = "Esto no deberia pasar...";
		}
		return centro;
	}


}