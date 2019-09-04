import java.util.Random;
public class Ayuda{
	Random aleatorio = new Random(System.currentTimeMillis());
	//Declaracion de atributos
	private String direccion;
	String[] telefonos = {"1234-5678", "2345-5676", "9087-6543", "5467-8932", "7685-9403"};


	//Constructor default de los atributos
	public Ayuda(){
		direccion = "Guatemala, 8 calle 13-23 zona 14";
		
	}

	public Ayuda(String direccion){
	this.direccion = direccion;
	}

	//declaracion de Sets
	public void setDireccion (String direccion){
		this.direccion = direccion;
	}
	
	//Gets
	public String getDireccion(){
		return direccion;
	}
	int tel = aleatorio.nextInt(4);
	
	//too String
	public String toString(){
		String mensaje = "";
		mensaje +="Nos encontramos en: " + direccion +"\n";
		mensaje += "El telefono al que se puede comunicar en este momento es al "+ telefonos[tel] + "\n";
		return mensaje;
	}
}
