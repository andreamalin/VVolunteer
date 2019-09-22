/**********************************************************
Regiones.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autor de la clase:	 
-> Brandon Hernandez 19376	
Fecha de creación: 31/09/2019
Última fecha de modificación: 05/09/2019

La clase Regiones se encarga de revisar el inventario del medicamento
y generar un promedio de la medicina necesitada para la proxima jornada.
**********************************************************/
import java.util.Random;

public class Regiones{
	private String centroSaludNombre;
	private Integer numberOfIdentification;
	private Inventario[] medicinas = new Inventario[3];
	private Random random = new Random();

	public Regiones(String centroSaludNombre, Integer numberOfIdentification){
		Integer numberInInventory;
		this.centroSaludNombre = centroSaludNombre;
		this.numberOfIdentification = numberOfIdentification;

		// Generando un número aleaotreo para ver que cantidad de que medicina hay de ese tipo
		numberInInventory = random.nextInt(200) + 1;
		medicinas[0] = new Inventario("Vitaflenaco", numberInInventory); 
		numberInInventory = random.nextInt(200) + 1;
		medicinas[1] = new Inventario("Paracetamol", numberInInventory); 
		numberInInventory = random.nextInt(200) + 1;
		medicinas[2] = new Inventario("Loratadina", numberInInventory); 
	}

	// Haciendo las recomendaciones de cuanto necesita cada uno
	public String elaborarDatos(Integer[] medicinaNecesitada){
		String recomendacion = "\nSe reviso el inventario y el medicamento que se necesito y se llego a la siguiente conclusion: ";

		//Conviertiendo a positivos si estan en negativos
		for(int i = 0; i < medicinaNecesitada.length; i++){
			if(medicinaNecesitada[i] < 0){
				medicinaNecesitada[i] = medicinaNecesitada[i]*-1;
			}
		}
		//Creando la recomendacion
		for(int i = 0; i < medicinas.length; i++){
			if(medicinas[i].getCantidadEnInventario() == medicinaNecesitada[i]){
				recomendacion = recomendacion + "\nEs necesario que para el proximo turno consigan " + (medicinas[i].getCantidadEnInventario() + (5 + medicinaNecesitada[i] - medicinas[i].getCantidadEnInventario())) + " de "  + medicinas[i].getNombreMedicamento() + " porque se acabron todos los que habian en el inventario.";
				medicinas[i].setCantidadEnInventario(medicinas[i].getCantidadEnInventario() + 5 + medicinaNecesitada[i] - medicinas[i].getCantidadEnInventario());
			}else if(medicinas[i].getCantidadEnInventario() < medicinaNecesitada[i]){
				recomendacion = recomendacion + "\nEs necesario que para el proximo turno consigan " + (medicinas[i].getCantidadEnInventario() + (5 + medicinaNecesitada[i] - medicinas[i].getCantidadEnInventario())) + " de "  + medicinas[i].getNombreMedicamento() + " porque no se le pudo dar atencion a " + (medicinaNecesitada[i] - medicinas[i].getCantidadEnInventario()) + " pacientes.";
				medicinas[i].setCantidadEnInventario(medicinas[i].getCantidadEnInventario() + 5 + medicinaNecesitada[i] - medicinas[i].getCantidadEnInventario());
			}
			 else if((medicinas[i].getCantidadEnInventario() > medicinaNecesitada[i]) && ((medicinas[i].getCantidadEnInventario() - 15) < medicinaNecesitada[i])){
				recomendacion = recomendacion + "\nPara el siguiente turno se debe de mantener la cantidad de " + medicinas[i].getNombreMedicamento() + " la cual es "  +  medicinas[i].getCantidadEnInventario();
			} else if((medicinas[i].getCantidadEnInventario() - 15) > medicinaNecesitada[i]){
				recomendacion = recomendacion + "\nPara el siguiente turno se debe de reducir la cantidad de " + medicinas[i].getNombreMedicamento() + " a " + (medicinaNecesitada[i] + 5);
				medicinas[i].setCantidadEnInventario(medicinaNecesitada[i] + 5);
			} else {
				recomendacion = recomendacion + "\nEs necesario que para el proximo turno consigan " + (medicinas[i].getCantidadEnInventario() + (5 + medicinaNecesitada[i] - medicinas[i].getCantidadEnInventario())) + " de "  + medicinas[i].getNombreMedicamento() + " porque se acabron todos los que habian en el inventario.";
				medicinas[i].setCantidadEnInventario(medicinas[i].getCantidadEnInventario() + 5 + medicinaNecesitada[i] - medicinas[i].getCantidadEnInventario());
			}
		}

		return recomendacion;
	}
	
	//Getters
	public Inventario[] getInventario(){
		return this.medicinas;
	}

	public String getCentroSaludNombre(){
		return this.centroSaludNombre;
	}

	public Integer getNumberOfIdentification(){
		return this.numberOfIdentification;
	}
}