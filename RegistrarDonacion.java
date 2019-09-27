/**********************************************************
RegistrarDonacion.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
-> Diego Alvarez 19498
-> Laura Tamath 19365
Fecha de creación: 31/09/2019
Última fecha de modificación: 05/09/2019

Esta clase se encarga de mostrar los numeros y direcciones de
las cedes para que la población pueda donar medicamento.
**********************************************************/
import java.util.Random;
public class RegistrarDonacion{
	private String tel, direccion;
	// se creo la una matriz que contiene los numeros de telefono de los centros de salud disponibles
	private String[] telefonos =  {"1234-5678", "2345-5676", "9087-6543", "5467-8932", "7685-9403"};
	// se creo la una matriz que contiene las direcciones de los centros de salud disponibles
	private String[] direcciones = {"9 calle 7-33 zona 1", "8 avenida 8-77 zona 5", "2 avenida 3-17 zona 9", "3 calle 8-24 zonna 6", "No contamos con sede en su ubicacion, sin embargo podemos brindarle informacion."};
	// se obtiene la informacion del centro pedido
	public void generarInformacion(int lugar){
		int posicion = lugar-1;
		direccion = direcciones[posicion];
		tel = telefonos[posicion];
	}
	//Se muestra al usuario la informacion
	public String mostrarInformacion(){
		String mensaje = "";
		mensaje +="Nos encontramos en: " + direccion +"\n";
		mensaje += "El telefono al que se puede comunicar en este momento es al "+ tel + "\n";
		return mensaje;
	}

}