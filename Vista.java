import java.util.Scanner;

public class Vista{

	Controlador control = new Controlador();
	SegundoControlador controlA = new SegundoControlador();

	// Obtener el centro de salud con el cual quiere interactuar el usuario
	public void obtenerCentroDeSalud(Controlador control, Scanner input){
		Integer centroDeSaludSeleccionado, cantidadCentrosMostrados = 1;

		// Mostrandole los centros de salud que puede utilizar
		System.out.print("\nEstos son los centros de salud con los que posee comunicacion: ");
		for(int i = 0; i < control.getCentroSalud().getGrafico().length; i++){
			if((control.getCentroSalud().getCuentas()[control.getCentroSalud().getLoggedOnPosition()].getNumberOfIdentification()) == (control.getCentroSalud().getGrafico()[i].getNumberOfIdentification())){
				System.out.print("\n" + cantidadCentrosMostrados + ". " + control.getCentroSalud().getGrafico()[i].getCentroSaludNombre());
				cantidadCentrosMostrados++;
			}
		}

		// Obteniendo el centro de salud que quiere el usuario
		do{	
			System.out.print("\nIngrese el centro de salud con el cual desea interactuar: ");
			centroDeSaludSeleccionado = input.nextInt();
		}while((centroDeSaludSeleccionado < 0) || (centroDeSaludSeleccionado > cantidadCentrosMostrados));

		control.setOpcion(centroDeSaludSeleccionado);
	}

	// Mostrando los datos del Centro de Salud seleccionado
	public void mostrarInventario(Controlador control, Integer j){
		System.out.println("\nSe cuenta en el inventario de " + control.getCentroSalud().getGrafico()[j].getCentroSaludNombre() + " con las siguientes medicinas: ");
			for(int i = 0; i < 3; i++){
		 	System.out.print("- " + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getNombreMedicamento() + " de la cual se tiene "  + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getCantidadEnInventario() + " en el inventario\n");
		}
	}

	// Pidiendole al usuario los medicamentos utilizados en la jornada 
	public void pedirMedicinaNecesitada(Controlador control, Integer j, Scanner input){
		for(int i = 0; i < 3; i++){
		 	System.out.print("Ingrese la cantidad de medicina necesitada en esta jornada de " + (control.getCentroSalud().getGrafico()[j].getInventario())[i].getNombreMedicamento() + ": ");
			 control.agregarANecesitados(input.nextInt(),i);
	

	
	
		}
	//Vistas programa
	}
	public String mostrarinfocentroV(){
		String x ="\n_________________________________________________\n\n"+controlA.mostrarInfoCentro()+"_____________________________________________";
		return x;
	
	}
	public String mandarayudaV(){
		String j ="\n_________________________________________________\n\n"+controlA.mandarAyuda();
		return j;
	
	}
	public String mostrarrecomendacionesv(){
		String h = control.getCentroSalud().getGrafico()[control.obtenerPosicionCentroSalud()].elaborarDatos(control.getCantidadNecesitada()) + "\nActualizando inventario..... el inventario se ha actualizado" ;
		return h;
	
	}
	public String bienvenidav(){
		String r = "\n\tBienvenid@ " + control.getUsername();
		return r;
	}
	public String menuv(){
		String v = "\n\nEstas son las opciones que puede realizar:\n1. Ver inventario\n2. Recomendaciones para la siguiente jornada\n3. Ver medicinas\n4. Buscar medicina por sintomas\n5. Cerrar Sesion\nIngrese la opcion que desea realizar: ";
		return v;
	}
	public String opcionv(){
		String t = "A continacion debe de seleccionar el departamento en el que se encuentra (en numeros)" + "\n1.Ciudad de Guatemala\n" +"2.Quetzaltenango, Xela\n"+"3.Sacatequepez, Antigua Guatemala\n"+"4. Alta Verapaz, Coban\n5. Otro\nIngrese en donde se encuentra: ";
		return t;
	}

	

}
