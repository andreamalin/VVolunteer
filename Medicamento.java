
public class Medicamento{
	//Propiedades del medicamento a recetar
	private String nombre;
	private String sintoma1;
	private String sintoma2;
	private String sintoma3;
	private String dosis;

	LeerMedicamento medicina = new LeerMedicamento();
	String [] listamedic = medicina.getLista(); //Se manda a llamar la lista de medicamento

	public boolean buscarMedicamento(String nombremedicamento){
		for (int i=0; nombremedicamento.equalsIgnoreCase(listamedic[i]); i++) { //Si se encuentra el medicamento
			this.nombre = nombremedicamento; //Se define el nombre, los tres sintomas y la dosis
			this.sintoma1 = listamedic[i+1];
			this.sintoma2 = listamedic[i+2];
			this.sintoma3 = listamedic[i+3];
			this.dosis = listamedic[i+4];
			
			return true; //Si se encuentra
		}

		return false; //Si no se encuentra
	}

	public String buscarSimilares(){
		return "";
	}


}