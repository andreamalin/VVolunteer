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

public class Medicamento{
	//Propiedades del medicamento a recetar
	private String nombre;
	private String sintoma1, sintoma2, sintoma3;
	private String dosis;
	private String similares;

	LeerMedicamento medicina = new LeerMedicamento();
	ArrayList<Integer> busquedaSintomas = new ArrayList<Integer>(); //Lista con posiciones de medicamentos

	String [] listamedic = medicina.getLista(); //Se manda a llamar la lista de medicamento
	String [] nombresmedicamentos; //Nombre de medicamentos encontrados

	public boolean buscarMedicamento(String nombremedicamento){ //Se busca el medicamento por el nombre igresado por el usuario
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
		busquedaSintomas = new ArrayList<Integer>();
		int longitud = listamedic.length/5; //Se obtiene la cantidad de medicamentos
		//Se revisan las primeras posiciones de sintomas
		for (int i=1; i<listamedic.length; i+=5) { 
			//Se revisa si es sintoma pertenece a la lista de los medicamentos
			if (sintoma1.equalsIgnoreCase(listamedic[i]) || sintoma2.equalsIgnoreCase(listamedic[i]) || sintoma3.equalsIgnoreCase(listamedic[i])) {
				Integer posicionPosible = i;
				if (posicionPosible > 5) { //Si la posicion posible es mayor de 5
					while (posicionPosible > longitud){ //Se resta 5 hasta que sea menor de la cantidad de medicamento
						posicionPosible = posicionPosible - 5; //Se restan 5 posiciones para devolver la posicion del nombre
					}
				} else {
					posicionPosible = 0; //Si la posicion posible es menor de 5, es el primer medicamento de la lista
				}
				busquedaSintomas.add(posicionPosible); //Se agrega a la lista el indice de la posicion posible
			}
		}
		//Se revisan las primeras posiciones de sintomas
		for (int j=2; j<listamedic.length; j+=5) { 
			//Se revisa si es sintoma pertenece a la lista de los medicamentos
			if (sintoma1.equalsIgnoreCase(listamedic[j]) || sintoma2.equalsIgnoreCase(listamedic[j]) || sintoma3.equalsIgnoreCase(listamedic[j])) {
				Integer posicionPosible = j;
				if (posicionPosible > 5) { //Si la posicion posible es mayor de 5
					while (posicionPosible > longitud){ //Se resta 5 hasta que sea menor de la cantidad de medicamento
						posicionPosible = posicionPosible - 5; //Se restan 5 posiciones para devolver la posicion del nombre
					}
				posicionPosible = posicionPosible - 1;
				} else {
					posicionPosible = 0; //Si la posicion posible es menor de 5, es el primer medicamento de la lista
				}
				busquedaSintomas.add(posicionPosible); //Se agrega a la lista el indice de la posicion posible
			}
		}
		//Se revisan las terceras posiciones de sintomas
		for (int k=3; k<listamedic.length; k+=5) { 
			//Se revisa si es sintoma pertenece a la lista de los medicamentos
			if (sintoma1.equalsIgnoreCase(listamedic[k]) || sintoma2.equalsIgnoreCase(listamedic[k]) || sintoma3.equalsIgnoreCase(listamedic[k])) {
				Integer posicionPosible = k;
				if (posicionPosible > 5) { //Si la posicion posible es mayor de 5
					while (posicionPosible > longitud){ //Se resta 5 hasta que sea menor de la cantidad de medicamento
						posicionPosible = posicionPosible - 5; //Se restan 5 posiciones para devolver la posicion del nombre
					}
					posicionPosible = posicionPosible - 1; 
				} else {
					posicionPosible = 0; //Si la posicion posible es menor de 5, es el primer medicamento de la lista
				}
				busquedaSintomas.add(posicionPosible); //Se agrega a la lista el indice de la posicion posible
			}
		}
	}

	public boolean eliminarRepetidos(){
		if (busquedaSintomas.size() > 0) {
			Collections.sort(busquedaSintomas); //Se ordena de menor a menor la lista de similares
			Set<Integer> listalimpia = new HashSet<Integer>(busquedaSintomas); //Se limpia la lista de los repetidos
			busquedaSintomas.clear(); //Se borra lo actual de la lista
			busquedaSintomas.addAll(listalimpia); //Se agrega a la lista la lista limpia	

			return true;	
		} else {
			return false; //No hay medicamento 
		}
	}

	public void separarMed(){ //Se realiza una lista que contenga unicamente los nombres del medicamento
		int longitud = listamedic.length/5;
		int a = 0;
		nombresmedicamentos = new String[longitud]; //Se realiza una lista con la longitud de cantidad de medicamentos

		for (int i=0; i<longitud; i++) {
			nombresmedicamentos[i]=listamedic[a];

			a = a+5; //Cada 5 posiciones se encuentra un medicamento nuevo
		}
	}

	public void buscarSimilares(){ //Se buscan los medicamentos similares
		separarMed(); //Se separa el medicamento
		similares = "                  "; //Se define similares
		int contador=0; //Contador para ingresar a la posicion de la lista

		for (int i=0; i<nombresmedicamentos.length; i++) { //Se realiza el ciclo la cantidad de medicamentos que hayan
			if (sintoma1.equalsIgnoreCase(listamedic[contador+1]) || sintoma2.equalsIgnoreCase(listamedic[contador+2]) || sintoma3.equalsIgnoreCase(listamedic[contador+3])){
				similares += nombresmedicamentos[i]; //Si coincide el sintoma con alguna medicina, se agrega la medicina a similares
			}
			contador=contador+5; //Cada 5 posiciones hay un nuevo síntoma
		}
		similares = similares.replace(nombre,""); //Se saca de similares el nombre del medicamento que metió el usuario

		if (similares.equalsIgnoreCase("                  ")) { //Si está vacío similares
			similares = "          No hay medicamento similar"; //Se muestra al usuario que no hay medicamentos similares
		}
	}

	public String mostrarInformacion(){ //Se muestra la informacion de forma ordenada
		String a = "\n\n+------------Medicamento no encontrado------------+\n"; //Si no se encuentra el medicamento
		if (buscarMedicamento(nombre)) {		//Si se encuentra el medicamento
			buscarSimilares(); //Se busca el medicamento similar

			a = "\n\n+-----------NOMBRE DEL MEDICAMENTO-----------+\n"; 
			a += "                  "+nombre;
			a += "\n\n+------------SINTOMAS QUE ALIVIA------------+\n";
			a += "     " + sintoma1 + "     " + sintoma2 + "      " + sintoma3;
			a += "\n\n+-------------DOSIS RECOMENDADA-------------+\n";
			a += dosis;
			a += "\n\n+------------MEDICAMENTO SIMILAR------------+\n";
			a += similares;

			return a;	//Se muestra en pantalla la información ordenada
		}
		return a; //Se muestra la alerta de medicamento no encontrado
	}

	public String mostrarRecomendados(){
		String a = "\n\n+-----Medicamento para sintomas escritos no encontrado en la base-----+\n"; //Si no se encuentra el medicamento
		if (eliminarRepetidos()) {
			separarMed(); //Se separa el medicamento por nombres
			a = "\n\n+-------------LISTADO MEDICAMENTOS RECOMENDADOS-------------+\n";
			for (int i=0; i<busquedaSintomas.size(); i++) {
				int indice = busquedaSintomas.get(i);
				a += "                       "+nombresmedicamentos[indice] + "\n";	
			}
			a += "+-Se recomienda buscar la informacion del medicamento listado-+\n\n";
		}
		return a;
	}

}