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
				opcionCentroSalud = vistaCentroSalud.menuCentroSalud((centro.getCuentas()[centro.getLoggedOnPosition()]).getUsername());

				// Cambiando a la opcion que el usuario desea
				switch(opcionCentroSalud){
					// Ver inventario
					case 1:
						opcion1CentroSalud();
					break;

					// Recomendaciones para la siguiente jornada
					case 2:
						opcion2CentroSalud();
					break;

					// Ver medicina
					case 3:
						 opcion3CentroSalud();
					break;

					// Buscar medicamento por sintoma
					case 4:
						opcion4CentroSalud();
					break;
					// Centro de notificaciones
					case 5:
						opcion5CentroNotificaciones();
					break;
					// Cerrar sesion
					case 6:
						vistaCentroSalud.mostrandoMensaje(mensaje);
					break;

					// Alguna ocpion invalida
					default:
						vistaCentroSalud.datosInvalidos();
					break;
				}
			}while(opcionCentroSalud != 6);
		}

	}

	// Realizando las operaciones para poder obtener los datos de la opcion 1
	private void opcion1CentroSalud(){
		Integer seleccionado;
		seleccionado = conseguirPosicionSalud();
		vistaCentroSalud.mostrandoMensaje(mostrarInventario(seleccionado));
	}

	private String mostrarInventario(Integer seleccionado){
		Integer j = seleccionado;
		String mensaje;
		mensaje = "|\n| Se cuenta en el inventario de " + centro.getGrafico()[j].getCentroSaludNombre() + " con las siguientes medicinas:\n";
		for(int i = 0; i < 3; i++){
		 	mensaje += "| - " + (centro.getGrafico()[j].getInventario())[i].getNombreMedicamento() + " de la cual se tiene "  + (centro.getGrafico()[j].getInventario())[i].getCantidadEnInventario() + " en el inventario\n";
		}

		return mensaje;
	}


	// Realizando las operaciones para poder obtener los datos de la opcion 2
	private void opcion2CentroSalud(){
		String[] nombreMedicamento;
		Integer[] cantidadNecesitada;
		Integer seleccionado;

		seleccionado = conseguirPosicionSalud();
		
		// Creando los arrays en donde estaran los nombres y la cantidad necesitada
		nombreMedicamento = new String[3];
		cantidadNecesitada = new Integer[3];

		// Consiguiendo los datos del inventario y pidiendole al usuario que elija cuantos se necesitaron
		nombreMedicamento = (centro.getGrafico()[seleccionado]).getMedicamentos();
		cantidadNecesitada = vistaCentroSalud.pedirMedicinaNecesitada(nombreMedicamento);

		// Utilizando la informacion recogida y mostrandole al usuario lo obtenido
		vistaCentroSalud.mostrandoMensaje((centro.getGrafico()[seleccionado]).elaborarDatos(cantidadNecesitada));
	}

	private Integer conseguirPosicionSalud(){
		Integer centroSaludSeleccionado;

		// Consiguiendo el centro de salud con el que desea interactuar
		centroSaludSeleccionado = vistaCentroSalud.obtenerCentroDeSalud(obtenerCentroDeSalud());
		centroSaludSeleccionado = obtenerPosicionCentroSalud(centroSaludSeleccionado);

		return centroSaludSeleccionado;
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

	private void opcion5CentroNotificaciones(){
		vistaCentroSalud.notificaciones(peticionAyuda.getInfo());
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

	// METODOS PARA OBTENER INFORMACION DEL USUARIO  A QUE CENTRO DE SALUD HACER REFERENCIA
	// Consiguiendo los centros de salud que puede elegir el usuario 
	private String[] obtenerCentroDeSalud(){
		Integer cantidadCentrosMostrados = 0;
		String[] mensaje = new String[centro.getGrafico().length];
		for(int i = 0; i < centro.getGrafico().length; i++){
			if((numeroIdentificacion())){
				mensaje[i] = "\n| " + (cantidadCentrosMostrados + 1) + ". " + (centro.getGrafico()[i]).getCentroSaludNombre();
				cantidadCentrosMostrados++;
			}
		}
		return mensaje;
	}

	// Encontrar posición del centro de salud deseado
	private Integer obtenerPosicionCentroSalud(Integer opcion){
		Integer contador = 0;
		for(int i = 0; i < centro.getGrafico().length; i++){
			if((centro.getCuentas()[centro.getLoggedOnPosition()].getNumberOfIdentification()) == (centro.getGrafico()[i].getNumberOfIdentification())){
				contador++;
				if(contador == opcion){
					return i;
				} 
			}
		}
		return 0;
	}

	// Viendo si el numero de identificacion es igual al de 
	private boolean numeroIdentificacion(){
		for(int i = 0; i < centro.getGrafico().length; i++){
			if((centro.getCuentas()[centro.getLoggedOnPosition()].getNumberOfIdentification()) == (centro.getGrafico()[i].getNumberOfIdentification())){
				return true;	
			}		
		} return false;
	}
}