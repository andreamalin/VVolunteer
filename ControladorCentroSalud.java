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
	private PeticionAyuda peticionAyuda = new PeticionAyuda();
	private VistaCentroSalud vistaCentroSalud = new VistaCentroSalud();
	private CentroSalud centro = new CentroSalud();
	private Integer[] necesitados = new Integer[3];

	// Estructura de las opciones del centro de salud
	public void opcionEnCentroSalud(){
		String[] datosUsuario = new String[2];
		Integer opcionCentroSalud = 0;
		String mensaje = "| Ha cerrado sesion\n|___________________________________________________";

		// Consiguiendo el usuario y la contraseña del usuario 
		datosUsuario = vistaCentroSalud.inicioSesion();

		// Verificando que el usuario haya logrado en su cuenta
		if(centro.accountManager(datosUsuario) == false){
			vistaCentroSalud.datosInvalidos();
		// Cuando el usuario logra ingresar al sistema se ejecuta lo siguiente:
		} else{

			do{
				opcionCentroSalud = vistaCentroSalud.menuCentroSalud((centro.getCuentas()[centro.getLoggedOnPosition()]).getUsername(),peticionAyuda.getInfo());

				// Cambiando a la opcion que el usuario desea
				switch(opcionCentroSalud){
					// Ver inventario
					case 1:
						//vistaCentroSalud.obtenerCentroDeSalud();
					break;

					// Recomendaciones para la siguiente jornada
					case 2:
					break;

					// Ver medicina
					case 3:
						 opcion3CentroSalud();
					break;

					// Buscar medicamento por sintoma
					case 4:
						opcion4CentroSalud();
					break;

					// Cerrar sesion
					case 5:
						vistaCentroSalud.mostrandoMensaje(mensaje);
					break;

					// Alguna ocpion invalida
					default:
						vistaCentroSalud.datosInvalidos();
					break;
				}
			}while(opcionCentroSalud != 5);
		}

	}




	// Sirve para mostrarle al usuario la informacion de la medicina
	private void opcion3CentroSalud(){
		centro.getMedicamento().buscarMedicamento(vistaCentroSalud.pidiendoMedicamento());
		vistaCentroSalud.mostrandoMensaje(centro.getMedicamento().mostrarInformacion());  
	}
	
	// Sirve para pedirle los datos al usuario, conseguir la información y mostrarla; por medio de su vista
	private void opcion4CentroSalud(){
		String[] sintomas = new String[3];
		sintomas = vistaCentroSalud.obtenerSintomas();

		// Obteniendo los resultados de la busqueda y mostrandosela al usuario
		centro.getMedicamento().buscarSintomas(sintomas[0], sintomas[1], sintomas[2]);
		vistaCentroSalud.mostrandoMensaje(centro.getMedicamento().mostrarRecomendados());
	}
	// retorna las notificaciones ingresadas
	

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
		
	public Integer[] getCantidadNecesitada(){
		return this.necesitados;
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