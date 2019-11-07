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
import java.util.Random;
public class PeticionAyuda{
	private boolean bandera;
	// se crearon variables 

	public void setInfo(String[] datosUsuario){
	    int contador = 0;
	    contador += 1;
	    try(FileWriter fw = new FileWriter("notificaciones.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		    {

		        out.println("\n" + contador + "." + datosUsuario[0] + " " + datosUsuario[1] + " " + datosUsuario[2] + " " + datosUsuario[3]+ ". ");       
		}catch (IOException e) {
		}
	}
	//Se agregan los cambios de medicamento
	public void setRecomendaciones(String recomendacion, String nombrecentro){
	    try(FileWriter fw = new FileWriter("notificaciones.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		    {
		    	out.println("\nRecomendaciones para la siguiente jornada en "+ nombrecentro + "\n" + recomendacion);       
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
					info += "| "+ contador  +" \t" + entrada.readLine() + "\n";

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
					contador +=1;
					info += "| "+ contador  +" \t" + entrada.readLine() + "\n";

				}
				
		}catch (IOException e) {
			e.printStackTrace();
		}
		return info;
	}	
	// Eliminar
	public void eliminarNoti(int o){
		// se concatenan los datos ingresados por el usuario y con sus especificaciones en una variable de tipo texto para mostrarla
		File f = new File( "C:notificaciones.txt" );
		File m = new File( "C:mod.txt" );
		BufferedReader entrada;
		//Arraylist<String> notificaciones = new Arraylist<String>();
		/*PrintWriter out = new PrintWriter(new FileWriter(m));
		File.lines(f.toPath()).filter(line -> !line.contains(lineContent).forEach(out::println));
		out.flush();
		out.close();
		m.renameTo(f);
		*/
		/*try {
			entrada = new BufferedReader(new FileReader(f));
				

				/*while(entrada.ready()){
					notificaciones.add(entrada.readLine());

				}
								
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}



	// se crea un numero aleatorio para verificar si se puede ayudar 
	// a la persona inmediatamente 
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

