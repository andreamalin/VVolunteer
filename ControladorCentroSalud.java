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
public class ControladorCentroSalud{
	private VistaCentroSalud vistaCentroSalud = new VistaCentroSalud();

	private String medicamento, username, password, sint1, sint2, sint3;
	private Integer[] necesitados = new Integer[3];
	private CentroSalud centro = new CentroSalud();
	//private Reportar reporte = new Reportar();
	//private Ayudar ayuda = new Ayudar();

	// Estructura de las opciones del centro de salud
	public void opcionEnCentroSalud(){
		String[] datosUsuario = new String[2];
		Integer opcionCentroSalud = 0;

		// Consiguiendo el usuario y la contraseña del usuario 
		datosUsuario = vistaCentroSalud.inicioSesion();

		// Verificando que el usuario haya logrado en su cuenta
		if(centro.accountManager(datosUsuario) == false){
			vistaCentroSalud.datosInvalidos();
		// Cuando el usuario logra ingresar al sistema se ejecuta lo siguiente:
		} else{

			do{
				opcionCentroSalud = vistaCentroSalud.menuCentroSalud();

				// Cambiando a la opcion que el usuario desea
				switch(opcionCentroSalud){
					// Ver inventario
					case 1:
						
					break;

					// Recomendaciones para la siguiente jornada
					case 2:
					break;

					// Ver medicina
					case 3:
					break;

					// Buscar medicamento por sintoma
					case 4:
					break;

					// Cerrar sesion, en donde no se mostrara nada por lo que estara vacia
					case 5:
					break;

					// Alguna ocpion invalida
					default:
						vistaCentroSalud.datosInvalidos();
					break;
				}
			}while(opcionCentroSalud != 5);
		}

	}


	// // Encontrar posición del centro de salud deseado
	// public Integer obtenerPosicionCentroSalud(){
	// 	Integer position, contador = 0;
	// 	for(int i = 0; i < centro.getGrafico().length; i++){
	// 		if((centro.getCuentas()[centro.getLoggedOnPosition()].getNumberOfIdentification()) == (centro.getGrafico()[i].getNumberOfIdentification())){
	// 			contador++;
	// 			if(contador == this.opcion){
	// 				return i;
	// 			} 
	// 		}
	// 	}
	// 	return 0;
	// }
	
	// Agregar un elemento a la lista de necesitados
	public void agregarANecesitados(Integer cantidad, Integer lugar){
		this.necesitados[lugar] = cantidad; 
	}

	// Setters de todos los atributos

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
	// public String getNombre(int i){
	// 	return centro.getGrafico()[i].getCentroSaludNombre();
	// }
	// //
	// public boolean numeroIdentificacion(){
	// 	Integer centroDeSaludSeleccionado, cantidadCentrosMostrados = 0;

	// 	for(int i = 0; i < centro.getGrafico().length; i++){
	// 		if((centro.getCuentas()[centro.getLoggedOnPosition()].getNumberOfIdentification()) == (centro.getGrafico()[i].getNumberOfIdentification())){
	// 			posicionIdentificacion = i;
	// 			return true;	
	// 		}		
	// 	} return false;
	// }
}