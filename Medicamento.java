
public class Medicamento{
	//Propiedades del medicamento a recetar
	private String nombre;
	private String sintoma1;
	private String sintoma2;
	private String sintoma3;
	private String dosis;
	private String similares;

	LeerMedicamento medicina = new LeerMedicamento();
	String [] listamedic = medicina.getLista(); //Se manda a llamar la lista de medicamento
	String [] nombresmedicamentos;

	public boolean buscarMedicamento(String nombremedicamento){
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

	public void separarMed(){
		int longitud = listamedic.length/5;
		int a = 0;
		nombresmedicamentos = new String[longitud];

		for (int i=0; i<longitud; i++) {
			nombresmedicamentos[i]=listamedic[a];

			a = a+5;
		}
	}

	public void buscarSimilares(){
		separarMed();
		similares = "                  ";
		int contador=0;

		for (int i=0; i<nombresmedicamentos.length; i++) {
			if (sintoma1.equalsIgnoreCase(listamedic[contador+1]) || sintoma2.equalsIgnoreCase(listamedic[contador+2]) || sintoma3.equalsIgnoreCase(listamedic[contador+3])){
				similares += nombresmedicamentos[i];	
			}
			contador=contador+5;
		}
		similares = similares.replace(nombre,"");

		if (similares.equalsIgnoreCase("                  ")) {
			similares = "          No hay medicamento similar";
		}
	}

	public String mostrarInformacion(){
		buscarSimilares();

		String a = "Medicamento no encontrado";
		if (buscarMedicamento(nombre)) {		
			a = "\n\n+-----------NOMBRE DEL MEDICAMENTO-----------+\n";
			a += "                  "+nombre;
			a += "\n\n+------------SINTOMAS QUE ALIVIA------------+\n";
			a += "     " + sintoma1 + "     " + sintoma2 + "      " + sintoma3;
			a += "\n\n+-------------DOSIS RECOMENDADA-------------+\n";
			a += dosis;
			a += "\n\n+------------MEDICAMENTO SIMILAR------------+\n";
			a += similares;

			return a;	
		}
		return a;
	}


}