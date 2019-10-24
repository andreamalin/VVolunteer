//Clase para que los voluntarios reporten a los pacientes
public class Rpaciente{
	private String nombrep; //Nombre del paciente
	private String nombrev; //Nombre del voluntario
	private String numero; //En donde vive el paciente
	private String motivo; //escribe porque lo quiere reportar

	//Default
	public Rpaciente(){
	}
	
	public Rpaciente(String nombrep, String nombrev, String numero, String motivo){
		this.nombrep = nombrep;
		this.nombrev = nombrev;
		this.numero = numero;
		this.motivo = motivo;
	}
	//Override
	public String toString(){
		String m="";
		m += "\nUsted, " + nombrev;
		m += "\nCon numero te telefono "+ numero;
		m += "\nHa reportado a "+ nombrep;
		m += "\nPor el motivo: " + motivo;
		return m;
	}
}