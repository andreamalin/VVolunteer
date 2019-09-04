import java.util.Random;
public class Ayudar{
	private int llamar = 33449912;
	private String tel;
	private String direccion = "Guatemala, 8 calle 13-23 zona 14";
// se creo la una matriz que contiene los centros de salud disponibles
	private String[] telefonos =  {"1234-5678", "2345-5676", "9087-6543", "5467-8932", "7685-9403"};
// retorna el numero de llamada de la cede central
	public int getNumero(){
		return llamar;
	}
// tira un valor al azar de cero a 3 para lanzar cualquiera de los 3 centros de salud
	public String cede(){
		Random r = new Random();
		int r2 = r.nextInt(3);
		if (r2 == 0){
			tel = telefonos[0];
		}else if (r2==1){
			tel = telefonos[1];
		}else{
			tel = telefonos[2];
		}
		return tel;
	}
	//to String
	public String toString(){
		String mensaje = "";
		mensaje +="Nos encontramos en: " + direccion +"\n";
		mensaje += "El telefono al que se puede comunicar en este momento es al "+ tel + "\n";
		return mensaje;
	}

}