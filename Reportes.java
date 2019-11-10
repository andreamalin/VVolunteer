/**********************************************************
Reportes.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
-> Andrea Amaya 19357
Fecha de creación: 24/10/2019
Última fecha de modificación: 24/10/2019

La clase madre de los reportes.
**********************************************************/
import java.util.*;
import java.io.*;


public class Reportes{
	protected String nombrep; //Nombre del paciente
	protected String nombrev; //Nombre del voluntario
	protected String numero;	//Numero del reportador
	protected String motivo;	//Razon del reporte
	//Constructor
	public Reportes(){
	}
	//Constructor
	public Reportes(String nombrep, String nombrev, String numero, String motivo){
		this.nombrep = nombrep;
		this.nombrev = nombrev;
		this.numero = numero;
		this.motivo = motivo;
	}
	//Todos los reportes ingresan a un txt dependiendo del tipo
	public void meterDatos(String[] datos){
	}
	//Se pasa de archivo de texto a array
	public void txtToArray(ArrayList<String> list, String filename){
		try {
			Scanner scanner = new Scanner(new File(filename)); //Se lee el archivo de texto
			while (scanner.hasNextLine()) {
				list.add(scanner.nextLine()); //Mientras hayan lineas por leer se meten a la lista
			}
			scanner.close();
		} catch (FileNotFoundException e) { //Se muestra la razon de error por la que no se encuentra el doc
			e.printStackTrace();
		}
	}
	//Se pasa de array a text
	public void arraytoTxt(ArrayList<String> list, String filename){
		try {
			PrintWriter not = new PrintWriter(filename);
			not.close();

			FileWriter writer = new FileWriter(filename, true);
			for (int i = 0; i < list.size(); i++) {
				writer.write(list.get(i));
				writer.write("\n");
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Se borra peticion
	public void borrarPeticion(Integer[] posicion){
	}
	//Cantidad de notificaciones en array
	public Integer getNot(){
		return 0;
	}
	// se retorna la informacion
	public String getReportes(String filename){
		String info = "|\n";
		int contador = 0;
		// se concatenan los datos ingresados por el usuario y con sus especificaciones en una variable de tipo texto para mostrarla
		File f = new File(filename);
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
}
