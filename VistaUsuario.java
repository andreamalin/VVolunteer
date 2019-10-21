public class VistaUsuario{

	public void mostrarinfocentroV(SegundoControlador controlA){
		System.out.println("\n_________________________________________________\n\n"+controlA.mostrarInfoCentro()+"_____________________________________________");
	
	}
	public void mandarayudaV(SegundoControlador controlA){
		System.out.println("\n_________________________________________________\n\n"+controlA.mandarAyuda());
	}

		public void opcionv(){
		System.out.println("A continacion debe de seleccionar el departamento en el que se encuentra (en numeros)" + "\n1.Ciudad de Guatemala\n" +"2.Quetzaltenango, Xela\n"+"3.Sacatequepez, Antigua Guatemala\n"+"4. Alta Verapaz, Coban\n5. Otro\nIngrese en donde se encuentra: ");
	}

}