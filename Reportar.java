	//Yo digo que es mejor si en el Driver, agregar una opcion exta que sea 4. Reportar voluntario y que el 5 sea Salir. 

//Si es voluntario y quiere reportar al paciente
import java.util.Scanner;
public class Reportar{
	public static void main(String args[]){
	 Scanner op = new Scanner(System.in);//Para las opciones 
	 Scanner enter = new Scanner(System.in);//Para los datos ingresados
	 String propio;
	 String otro; 
	 String direc;
	 String motivo;
	 String ca;
	 int car;
	 int acc;
	 acc =0;
	 while(acc<=2){
	 System.out.println("\n------- A quien desea reportar? -------\n1.A pacientes\n2.A voluntario\n3.Salir");
	 acc = op.nextInt();

		 if(acc ==1){
		 Rpaciente reportarP = new Rpaciente();
		 System.out.println("\t\t\t\t<<<< R E P O R T A R >>>>\n");
		 //System.out.println("-Ingrese su nombre ");
		 //reportarP.setNombrev(propio);
		 //System.out.println("-Ingrese el nombre de la persona a reportar ");
		 //otro = enter.nextLine();
		 //reportarP.setNombrep(otro);
		 //System.out.println("Ingrese la direccion en donde vive " + otro);
		 //direc = enter.nextLine();
		 //reportarP.setDireccion(direc);
		 //System.out.println("Ingrese el motivo por el cual el paciente lo hizo sentir incomodo");
		 //motivo = enter.nextLine();
		 //reportarP.setMotivo(motivo);
		 //System.out.println(reportarP);
		 }

		 public String Rnombre(String nombreq)
		 {
			String propio;
			System.out.println("-Ingrese su nombre ");
			propio = enter.nextLine();
			reportarP.setNombrev(propio);
		 }
		 public String Rotro(String otroq)
		 {
			 String otro;
			System.out.println("-Ingrese el nombre de la persona a reportar ");
			otro = enter.nextLine();
			reportarP.setNombrep(otro);
		 }
		 public String rdirrecion(String direcq)
		 {
			String direcx;
			System.out.println("Ingrese la direccion en donde vive la persona a reportar");
			direcx = enter.nextLine();
			reportarP.setDireccion(direc);
		 }
		 public String rmotivo(String motivoq)
		 {
			String motivo;
			System.out.println("Ingrese el motivo por el cual el paciente lo hizo sentir incomodo");
			motivo = enter.nextLine();
			reportarP.setMotivo(motivo);
			System.out.println(reportarP);    //Verificar si este print va en este metodo

		}


		 if(acc==2){
		 RVoluntario reportarV = new RVoluntario();
		 System.out.println("\t<<<< R E P O R T A R >>>>\n");
		 //System.out.println("-Ingrese su nombre ");
		 //propio = enter.nextLine();
		 //reportarV.setNombrep(propio);
		 //System.out.println("-Ingrese el nombre de la persona a reportar ");
		 //otro = enter.nextLine();
		 //reportarV.setNombrev(otro);
		 //System.out.println("Ingrese el carne de "+ otro);
		 //ca = enter.nextLine();
		 //car = Integer.parseInt(ca);
		 //reportarV.setCarne(car);
		 //System.out.println("Ingrese la direccion en donde vive usted ");
		 //direc = enter.nextLine();
		 //reportarV.setDireccion(direc);
		 //System.out.println("Ingrese el motivo por el cual el paciente lo hizo sentir incomodo");
		 //motivo = enter.nextLine();
		 //reportarV.setMotivo(motivo);
		 //System.out.println(reportarV);

		 }
		 public String Vnombre(String nombreq)
		 {
			String propio;
			System.out.println("-Ingrese su nombre ");
			propio = enter.nextLine();
			reportarV.setNombrep(propio);
		 }
		 public String Votro(String otroq)
		 {
			 String otro;
			System.out.println("-Ingrese el nombre de la persona a reportar ");
			otro = enter.nextLine();
			reportarV.setNombrev(otro);
		 }
		 public String Vcarnet(String carq)
		 {
			String car;
			System.out.println("Ingrese el carnet de la persona a reportar");
			car = enter.nextLine();
			car = Integer.parseInt(ca);
			reportarV.setCarne(car);
		}
		public String Vdirrecion(String direcq)
		{
		   String direcx;
		   System.out.println("Ingrese la direccion en donde vive usted ");
		   direcx = enter.nextLine();
		   reportarV.setDireccion(direcx);
		}
		 public String Vmotivo(String motivoq)
		 {
			String motivo;
			System.out.println("Ingrese el motivo por el cual el paciente lo hizo sentir incomodo");
			motivo = enter.nextLine();
			reportarV.setMotivo(motivo);
			System.out.println(reportarV);			//Verificar si este print va en este metodo

		}
















		 if(acc==3){
			// System.out.println("------------Se tomaran cartas en el asunto------------\n");
			public void Qsalir()
			{
				System.out.println("------------Se tomaran cartas en el asunto------------\n");

			}
		 }
	 	}
	}
}