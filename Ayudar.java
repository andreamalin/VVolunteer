import java.util.Random;
public class Ayudar{
	private String tel;
	private String direccion;
	// se creo la una matriz que contiene los numeros de telefono de los centros de salud disponibles
	private String[] telefonos =  {"1234-5678", "2345-5676", "9087-6543", "5467-8932", "7685-9403"};
	// se creo la una matriz que contiene las direcciones de los centros de salud disponibles
	private String[] direcciones = {"9 calle 7-33 zona 1", "8 avenida 8-77 zona 5", "2 avenida 3-17 zona 9", "3 calle 8-24 zonna 6", "No contamos con sede en su ubicacion, sin embargo podemos brindarle informacion."}
	// se obtiene la informacion del centro pedido
	public void generarInformacion(int lugar){
		int posicion = lugar-1;
		direccion = direcciones[posicion];
		tel = telefonos[posicion]
	}
	//Se muestra al usuario la informacion
	public String mostrarInformacion(){
		String mensaje = "";
		mensaje +="Nos encontramos en: " + direccion +"\n";
		mensaje += "El telefono al que se puede comunicar en este momento es al "+ tel + "\n";
		return mensaje;
	}

}