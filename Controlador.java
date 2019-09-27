/**********************************************************
Controlador.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autores de la clase:
-> Andrea Amaya 19357
-> Brandon Hernandez 19376
-> Diego Alvarez 19498
Fecha de creación: 31/09/2019
Última fecha de modificación: 24/09/2019

Esta clase se encarga de mostrar los numeros y direcciones de
las cedes para que la población pueda donar medicamento.
**********************************************************/
public class Controlador{
	private Integer opcion, posicionIdentificacion;
	private String medicamento, username, password, sint1, sint2, sint3;
	private boolean bandera;
	private Integer[] necesitados = new Integer[3];
	private CentroSalud centro = new CentroSalud();

	// Encontrar posición del centro de salud deseado
	public Integer obtenerPosicionCentroSalud(){
		Integer position, contador = 0;
		for(int i = 0; i < centro.getGrafico().length; i++){
			if((centro.getCuentas()[centro.getLoggedOnPosition()].getNumberOfIdentification()) == (centro.getGrafico()[i].getNumberOfIdentification())){
				contador++;
				if(contador == this.opcion){
					return i;
				} 
			}
		}
		return 0;
	}
	
	// Agregar un elemento a la lista de necesitados
	public void agregarANecesitados(Integer cantidad, Integer lugar){
		this.necesitados[lugar] = cantidad; 
	}

	// defensiva contra strings
	public boolean defensa(String op){
	// se verifica si lo ingresado es un entero 
		try{
			Integer.parseInt(op);
			bandera = true;
		}catch(NumberFormatException nfe){
			bandera = false;
		}
		if (bandera == true){
			this.opcion = Integer.parseInt(op);
		}
	return bandera;
	}

	// Setters de todos los atributos
	public void setOpcion(Integer opcion){
		this.opcion = opcion;
	}	
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password; 
	}
	public void setMedicamento(String medicamento){
		this.medicamento = medicamento;
	}
	
	//Setters opcion buscar por sintomas
	public void setSintoma1(String sintoma1){
		this.sint1 = sintoma1;
	}
	public void setSintoma2(String sintoma2){
		this.sint2 = sintoma2;
	}
	public void setSintoma3(String sintoma3){
		this.sint3 = sintoma3;
	}
	
	//Getters de todos los atributos
	public Integer getOpcion(){
		return this.opcion;
	}
	public boolean getBandera(){
		return this.bandera;
	}
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
	public Integer[] getCantidadNecesitada(){
		return this.necesitados;
	}
	public String getMedicamento(){
		return this.medicamento;
	}
	public CentroSalud getCentroSalud(){
		return this.centro;
	}
	public String getSint1(){
		return this.sint1;
	}
	public String getSint2(){
		return this.sint2;
	}
	public String getSint3(){
		return this.sint3;
	}
	//Metodos para la vista
	public Integer getLength(){
		return centro.getGrafico().length;
	}
	public String getNombre(int i){
		return centro.getGrafico()[i].getCentroSaludNombre();
	}
	public String getInventario(){
		Integer j = obtenerPosicionCentroSalud();
		return centro.getGrafico()[j].getCentroSaludNombre();
	}
	public String getMed(){
		String a = "";
		Integer j = obtenerPosicionCentroSalud();
		for(int i = 0; i < 3; i++){
			a += "- " + centro.getGrafico()[j].getInventario()[i].getNombreMedicamento() + " de la cual se tiene "  + centro.getGrafico()[j].getInventario()[i].getCantidadEnInventario()  + " en el inventario\n";
		}
		return a;
	}
	public String getJornada(int i){
		String a = "";
		Integer j = obtenerPosicionCentroSalud();
	 	a += "Ingrese la cantidad de medicina necesitada en esta jornada de " + centro.getGrafico()[j].getInventario()[i].getNombreMedicamento() + ": ";
	 	return a;
	}
	public String getTotal(){
		Integer j = obtenerPosicionCentroSalud();
		return centro.getGrafico()[j].elaborarDatos(getCantidadNecesitada());
	}
	//
	public boolean numeroIdentificacion(){
		Integer centroDeSaludSeleccionado, cantidadCentrosMostrados = 0;

		for(int i = 0; i < getLength(); i++){
			if((centro.getCuentas()[centro.getLoggedOnPosition()].getNumberOfIdentification()) == (centro.getGrafico()[i].getNumberOfIdentification())){
				posicionIdentificacion = i;
				return true;	
			}		
		} return false;
	}

}