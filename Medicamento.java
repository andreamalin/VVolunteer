public class Medicamento{
	//Propiedades del medicamento a recetar
	private String nombre;
	private String sintoma1, sintoma2, sintoma3;
	private String dosis;
	private String similares;

	LeerMedicamento medicina = new LeerMedicamento();
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
		return false; //Si no se encuentra
	}

	public void separarMed(){ //Se realiza una lsita que contenga unicamente los nombres del medicamento
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
		buscarSimilares(); //Se busca el medicamento similar

		String a = "Medicamento no encontrado"; //Si no se encuentra el medicamento
		if (buscarMedicamento(nombre)) {		//Si se encuentra el medicamento
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


}