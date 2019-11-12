/**********************************************************
Medicamento.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autor de la clase:
-> Andrea Amaya 19357

Fecha de creación: 31/09/2019
Última fecha de modificación: 05/09/2019

La clase Medicamento se encarga de mostrar al usuario la información
sobre un medicamento presente en el inventario o mostrar que
no está disponible.
**********************************************************/
import java.util.*; 
import java.io.*;

public class Medicamento{
	//Propiedades del medicamento a recetar
	private String nombre;
	private String sintoma1, sintoma2, sintoma3;
	private String dosis;
	private String similares;

	private static LeerMedicamento medicina = new LeerMedicamento();
	private static ArrayList<Integer> busquedaSintomas = new ArrayList<Integer>(); //Lista con posiciones de medicamentos

	static String [] listamedic; //Se manda a llamar la lista de medicamento
	static String [] nombresmedicamentos; //Nombre de medicamentos encontrados

	public boolean buscarMedicamento(String nombremedicamento){ //Se busca el medicamento por el nombre igresado por el usuario
		listamedic = medicina.getLista(); //Se manda a llamar la lista de medicamento
		for (int i=0; i<listamedic.length; i++) { //Si se encuentra el medicamento
			if (nombremedicamento.equalsIgnoreCase(listamedic[i])) {
				this.nombre = nombremedicamento; //Se define el nombre, los tres sintomas y la dosis
				this.sintoma1 = listamedic[i+1];
				this.sintoma2 = listamedic[i+2];
				this.sintoma3 = listamedic[i+3];
				this.dosis = listamedic[i+4];
				
				return true; //Si se encuentra	
			}
		}
		this.nombre = "No existe";
		return false; //Si no se encuentra
	}

	public void buscarSintomas(String sintoma1, String sintoma2, String sintoma3){
		listamedic = medicina.getLista(); //Se manda a llamar la lista de medicamento
		int posicionactual = 0;
		int longitud = listamedic.length/5; //Se obtiene la cantidad de medicamentos
		//Se revisan las primeras posiciones de sintomas
		for (int i=0; i<longitud; i++) { //Cantidad de medicamentos
			for (int j=0; j<5; j++) { //Se recorre fila por fila
				//Se busca el sintoma en esa fila
				if (sintoma1.equalsIgnoreCase(listamedic[posicionactual]) || sintoma2.equalsIgnoreCase(listamedic[posicionactual]) || sintoma3.equalsIgnoreCase(listamedic[posicionactual])) {
					busquedaSintomas.add(i); //Se agrega a la lista el indice de la posicion posible	
				}
				posicionactual ++;
			}
		}
	}

	private boolean eliminarRepetidos(){
		if (busquedaSintomas.size() > 0) {
			//Se eliminan sintomas repetidos
			Collections.sort(busquedaSintomas); //Se ordena de menor a menor la lista de similares
			Set<Integer> listalimpia = new HashSet<Integer>(busquedaSintomas); //Se limpia la lista de los repetidos
			busquedaSintomas.clear(); //Se borra lo actual de la lista
			busquedaSintomas.addAll(listalimpia); //Se agrega a la lista la lista limpia

			return true;	
		} else {
			return false; //No hay medicamento 
		}
	}

	private void separarMed(){ //Se realiza una lista que contenga unicamente los nombres del medicamento
		int longitud = listamedic.length/5;
		int a = 0;
		nombresmedicamentos = new String[longitud]; //Se realiza una lista con la longitud de cantidad de medicamentos

		for (int i=0; i<longitud; i++) {
			nombresmedicamentos[i]=listamedic[a];
			a += 5; //Cada 5 posiciones se encuentra un medicamento nuevo
		}
		//Se eliminan nombres repetidos
		for (int j=0; j<busquedaSintomas.size(); j++) {
			String posicionactual = nombresmedicamentos[busquedaSintomas.get(j)];
			for (int i=1; i<busquedaSintomas.size(); i++) {
				String posicionposible = nombresmedicamentos[busquedaSintomas.get(i)];
				if (posicionactual.equalsIgnoreCase(posicionposible)) {
					busquedaSintomas.remove(i);
				}
			}				
		}
	}

	private void buscarSimilares(){ //Se buscan los medicamentos similares
		separarMed(); //Se separa el medicamento
	
		similares = "                  "; //Se define similares
		int contador=0; //Contador para ingresar a la posicion de la lista

		for (int i=0; i<nombresmedicamentos.length; i++) { //Se realiza el ciclo la cantidad de medicamentos que hayan
			if (sintoma1.equalsIgnoreCase(listamedic[contador+1]) || sintoma2.equalsIgnoreCase(listamedic[contador+2]) || sintoma3.equalsIgnoreCase(listamedic[contador+3])){
				similares += nombresmedicamentos[i] + "       "; //Si coincide el sintoma con alguna medicina, se agrega la medicina a similares
			}
			contador+=5; //Cada 5 posiciones hay un nuevo síntoma
		}
		similares = similares.replace(nombre,""); //Se saca de similares el nombre del medicamento que metió el usuario

		if (similares.equalsIgnoreCase("                  ")) { //Si está vacío similares
			similares = "|          No hay medicamento similar"; //Se muestra al usuario que no hay medicamentos similares
		}
	}

	public String mostrarInformacion(){ //Se muestra la informacion de forma ordenada
		String a = "|\n|\n|+------------Medicamento no encontrado------------+\n"; //Si no se encuentra el medicamento
		if (buscarMedicamento(nombre)) {		//Si se encuentra el medicamento
			buscarSimilares(); //Se busca el medicamento similar

			a = "|\n|\n|+-----------NOMBRE DEL MEDICAMENTO-----------+\n"; 
			a += "|                  "+nombre;
			a += "\n|\n|+------------SINTOMAS QUE ALIVIA------------+\n";
			a += "|     " + sintoma1 + "     " + sintoma2 + "      " + sintoma3;
			a += "\n|\n|+-------------DOSIS RECOMENDADA-------------+\n";
			a += "|" +dosis;
			a += "\n|\n|+------------MEDICAMENTO SIMILAR------------+\n";
			a += "|" +similares;

			return a;	//Se muestra en pantalla la información ordenada
		}
		return a; //Se muestra la alerta de medicamento no encontrado
	}

	public String mostrarRecomendados(){
		String a = "|\n|\n|+-----Medicamento para sintomas escritos no encontrado en la base-----+\n"; //Si no se encuentra el medicamento
		if (eliminarRepetidos()) {
			separarMed(); //Se separa el medicamento por nombres
			a = "|\n|\n|+-------------LISTADO MEDICAMENTOS RECOMENDADOS-------------+\n";
			for (int i=0; i<busquedaSintomas.size(); i++) {
				int indice = busquedaSintomas.get(i);
				a += "|"+nombresmedicamentos[indice] + "\n";	
			}
			a += "|+-Se recomienda buscar la informacion del medicamento listado-+\n|\n";
		}
		busquedaSintomas.clear(); //Se limpia la lista
		return a;
	}
	public void agregarMed(String[] med){
	    try(FileWriter fw = new FileWriter("medicamento.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		    {
		    	out.print(med[0]+ ", " + med[1]+ ", "+med[2]+ ", "+med[3]+ ", "+med[4]+ ", \n");       
		}catch (IOException e) {
		}
	}

}