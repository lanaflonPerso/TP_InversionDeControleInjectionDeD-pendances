package presentation;

import dao.DaoImpl;
import metier.MetierImpl;
/*
 * La couche présentation n'est pas fermée à la modification 
 * car ici on est obligée de modifier le code source DaoIml et
 * MetierImpl
 * */
public class Presentation {

	public static void main(String[] args) {
		
		MetierImpl  metier = new MetierImpl();
		/*
		 * Dans MetierImpl La variable dao n'est pas initialiser, elle vaut null
		 * donc metier.calcul() nous retournera java.lang.NullPointerException
		 * car on appel la methode d'un objet, et cet objet n'est pas encore
		 * crée.
		 * comment resoudre le pb?
		 * Au moment de l 'execution il faut crée l'objet dao, et metier;
		 * et lier l'objet DaoImpl à l'objet MetierImpl
		 * 
		 * Ce principe s'appelle l'injection de dependance par instanciation
		 * statique(utilisation de new) car l'objet metier depend de l'objer dao
		 */
		//Initialisation
		DaoImpl dao = new DaoImpl();
		//Association
		metier.setDao(dao);
		
		System.out.println(metier.calcul());
	}

}
