/**********************************************************
ReportarPaciente.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
-> Laura Tamath 19365	
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
Fecha de creación: 24/10/2019
Última fecha de modificación: 24/10/2019

Clase para que los pacientes reporten a los voluntarios
La clase ReportarPaciente hereda de Reportes.
**********************************************************/
import java.util.*;
import java.io.*;
import java.util.Scanner;


public class ReportarVoluntario extends Reportes{
	private ArrayList<String> reportesVoluntarios = new ArrayList<String>();
	//Constructor
	public ReportarVoluntario(String nombrep, String nombrev, String numero, String motivo){
		super(nombrep, nombrev, numero, motivo);
	}
	//Override
	public void meterDatos(String[] datos){
		try(FileWriter fw = new FileWriter("reportesVoluntarios.txt", true); //Se mandan los reportes de los pacientes hacia los voluntarios
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
		{
			out.println(datos[0] + " " + datos[1] + " " + datos[2] + " " + datos[3]);       
		}catch (IOException e) {
		}
	}
	public void convertiraarray(){
		txtToArray(reportesVoluntarios, "reportesVoluntarios.txt");
	}
}