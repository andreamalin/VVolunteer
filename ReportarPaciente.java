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

Clase para que los voluntarios reporten a los pacientes
La clase ReportarPaciente hereda de Reportes.
**********************************************************/
import java.util.*;
import java.io.*;
import java.util.Scanner;


public class ReportarPaciente extends Reportes{
	private ArrayList<String> reportesPacientes = new ArrayList<String>();
	//Constructor	
	public ReportarPaciente(){
	}
	public ReportarPaciente(String nombrep, String nombrev, String numero, String motivo){
		super(nombrep, nombrev, numero, motivo);
	}
	//Override
	public void meterDatos(String[] datos){
		try(FileWriter fw = new FileWriter("reportesPacientes.txt", true); //Se mandan los reportes de los voluntarios hacia los pacientes
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
		{
			out.println(datos[0] + " " + datos[1] + " " + datos[2] + " " + datos[3]);
		}catch (IOException e) {
		}
	}
	public void borrarPeticion(Integer[] posicionaeliminar){
		reportesPacientes = new ArrayList<String>();
		txtToArray(reportesPacientes, "reportesPacientes.txt");

		Integer centrodenotificaciones = posicionaeliminar[0]; 
		Integer eliminar = posicionaeliminar[1];
		Integer tipodereporte = posicionaeliminar[2];

		if (centrodenotificaciones == 3 && tipodereporte == 1) {
			try {		
				reportesPacientes.remove((eliminar-1));
			} catch (IndexOutOfBoundsException e) {
				String error = "Notificacion invalida";
			}
			arraytoTxt(reportesPacientes, "reportesPacientes.txt");
		}
	}
	public Integer getNot(){
		reportesPacientes = new ArrayList<String>();
		txtToArray(reportesPacientes, "reportesPacientes.txt");
		return reportesPacientes.size();		
	}


}