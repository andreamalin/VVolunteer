/**********************************************************
PeticionAyuda.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autor de la clase:
-> Diego Alvarez 19498

Fecha de creación: 31/09/2019
Última fecha de modificación: 05/09/2019

La clase PeticionAyuda se encarga de pedir los datos del usuario que
reporta ayuda y mandar la ayuda lo antes posible.
**********************************************************/
import java.util.*;
import java.io.*;

public class PeticionAyuda{
	private boolean bandera;
	private int contadorRec;
	private ArrayList<String> peticiones = new ArrayList<String>(); //Lista con las peticiones de ayuda 
	private ArrayList<String> recomendaciones = new ArrayList<String>(); //Lista con las recomendaciones de inventario
	// se crearon variables 

	public void setInfo(String[] datosUsuario){
	  
	    try(FileWriter fw = new FileWriter("notificaciones.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		    {

		        out.println(datosUsuario[0] + " " + datosUsuario[1] + " " + datosUsuario[2] + " " + datosUsuario[3]+ ". ");       
		}catch (IOException e) {
		}
	}
	//Se agregan los cambios de medicamento
	public void setRecomendaciones(String recomendacion, String nombrecentro){
		contadorRec += 1;
	    try(FileWriter fw = new FileWriter("notificaciones.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		    {
		    	out.println("|\n|"+contadorRec+"Recomendaciones para la siguiente jornada en "+ nombrecentro + "\n" + recomendacion);       
		}catch (IOException e) {
		}
	}
	// se retorna la informacion
	public String getInfo(){
		String info = "";
		int contador = 0;
		// se concatenan los datos ingresados por el usuario y con sus especificaciones en una variable de tipo texto para mostrarla
		File f = new File( "C:notificaciones.txt" );
		BufferedReader entrada;
		try {
			entrada = new BufferedReader(new FileReader(f));
				
				while(entrada.ready()){
					contador +=1;
					info += "|\t"+ contador + ". " + entrada.readLine() + "\n";

				}
				
		}catch (IOException e) {
			e.printStackTrace();
		}
		return info;
	}
	// se retorna las recomendaciones
	public String getRecomendaciones(){
		String info = "";
		int contador = 0;
		// se concatenan los datos ingresados por el usuario y con sus especificaciones en una variable de tipo texto para mostrarla
		File f = new File( "C:Recomendaciones.txt" );
		BufferedReader entrada;
		try {
			entrada = new BufferedReader(new FileReader(f));
				
				while(entrada.ready()){
					info += "|\t" + entrada.readLine() + "\n";

				}
				
		}catch (IOException e) {
			e.printStackTrace();
		}
		return info;
	}
	//Se elimina la notificacion pedida
	public void eliminar(int[] posicionaeliminar){
		boolean bandera = false;
		txtToArray(); //Se pasa a array ambos centros
		String error;
		int centrodenotificaciones = posicionaeliminar[0]; 
		int eliminar = posicionaeliminar[1]; 

		if (centrodenotificaciones == 1) {
			try {
				peticiones.remove(eliminar-1);
			} catch (IndexOutOfBoundsException e) {
				error = "Notificacion invalida";
			}
		} else if (centrodenotificaciones == 2) {
			try {
				recomendaciones.remove(eliminar-1);
				bandera = true;
			} catch (IndexOutOfBoundsException e) {
				error = "Notificacion invalida";
			}
		}
		arraytoTxt(); //Se pasa el array nuevo a txt
	}
	//Se pasa de archivo de texto a array
	private void txtToArray(){
		//Notificaciones
		peticiones = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File("notificaciones.txt")); //Se lee el archivo de texto
			while (scanner.hasNextLine()) {
				peticiones.add(scanner.nextLine()); //Mientras hayan lineas por leer se meten a la lista
			}
			scanner.close();
		} catch (FileNotFoundException e) { //Se muestra la razon de error por la que no se encuentra el doc
			e.printStackTrace();
		}
		//Recomendaciones
		recomendaciones = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File("Recomendaciones.txt")); //Se lee el archivo de texto
			while (scanner.hasNextLine()) {
				recomendaciones.add(scanner.nextLine()); //Mientras hayan lineas por leer se meten a la lista
			}
			scanner.close();
		} catch (FileNotFoundException e) { //Se muestra la razon de error por la que no se encuentra el doc
			e.printStackTrace();
		}
	}
	//Se pasa de array a archivo de texto
	private void arraytoTxt(){
		try {
			PrintWriter not = new PrintWriter("notificaciones.txt");
			not.close();

			FileWriter writer = new FileWriter("notificaciones.txt", true);
			PrintWriter pw = new PrintWriter("notificaciones.txt");
			for (int i = 0; i < peticiones.size(); i++) {
				writer.write(peticiones.get(i));
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			PrintWriter rec = new PrintWriter("Recomendaciones.txt");
			rec.close();

			FileWriter writer = new FileWriter("Recomendaciones.txt", true);
			for (int i = 0; i < recomendaciones.size(); i++) {
				writer.write(recomendaciones.get(i));
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// se crea un numero aleatorio para verificar si se puede ayudar 
	public boolean enCamino(){
		Random r = new Random();
		int r1 = r.nextInt(10);
		if (r1 == 5){
			bandera = true;
		}
		else{
			bandera = false;
		}
	return bandera;

	}
}

