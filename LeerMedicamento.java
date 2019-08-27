//Codigo adaptado de https://www.quora.com/How-do-I-read-a-file-line-by-line-in-Java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerMedicamento {
	private String txt = ""; //Cada linea de texto se metera a esta variable
	private String[] lista;

	public void meterMedicamento() {
		try {
			Scanner scanner = new Scanner(new File("medicamento.txt")); //Se lee el archivo de texto
			while (scanner.hasNextLine()) {
				txt += (scanner.nextLine()); //Mientras hayan lineas por leer se meten a la variable a
			}
			scanner.close();
		} catch (FileNotFoundException e) { //Se muestra la razon de error por la que no se encuentra el doc
			e.printStackTrace();
		}
	}

	public void listaInformativa(){
		lista = txt.split(", ");

		for (String i : lista) {
			System.out.println(i);	
		}
	}

	public String getTxt(){
		return txt;
	}
}