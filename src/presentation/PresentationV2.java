package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.IDao;
import metier.IMetier;

/*
 * Comment faire l'instanciation dynamique sans utiliser de framwork : 
 * L'application sera fermée à la modification ouverte à l'extension
 * 
 * On va introduire la notion de fichier de configuration : 
 * Supposons que dans mon application, dans la racine de mon projet
 * je vais créer un fichier texte (confif.txt).
 * Dans ce fichier texte j'écris les classes que je vais utiliser dans 
 * mon application. Une classe qui se trouve dans mon package dao
 * et une classe qui se trouve dans le package metier.
 * Quand mon application va demarrer il va d'abord lire ce fichier 
 * texte. Il va lire le nom de la classe et l'instancier. 
 * Après on va faire l'injection des dépendances. 
 * Tout ça sera fait de façon dynamique, on utilisera pas new
 * 
 * 
 * */
public class PresentationV2 {

	public static void main(String[] args) {
		
		//Lire à partir d'un fichier
		try {
			
			Scanner scanner = new Scanner(new File("config.txt"));
			
			//Je lis la première ligne (la classe dao)
			String daoClassName = scanner.nextLine();
			System.out.println(daoClassName);
			//Chargement dynamique de la classe en mémoire
			Class cDao = Class.forName(daoClassName);
			//Création de l'instance d'une classe charger dynamiquement
			IDao dao = (IDao) cDao.newInstance();
			System.out.println(dao.getTemperature());
			
			//Je lis la deuxieme ligne(classe metier)
			String metierClassName = scanner.nextLine();
			System.out.println(metierClassName);
			//Chargement dynamique de la classe en mémoire
			Class cMetier = Class.forName(metierClassName);
			//Création de l'instance d'une classe charger dynamiquement
			IMetier metier = (IMetier) cMetier.newInstance();
			
			/*Injection de dependance : association entre l'objet 
			 * metier et dao avec la méthode setDao
			 * Le faire de façon dynamique. 
			 * Pour appeler une methode dynamiquement, on utilise 
			 * l'objet Method
			 * Ici, Je veux faire appel à une methode qui s'appele
			 *  setDao qui reçois un paramètre de type IDao
			 */
			Method m = cMetier.getMethod("setDao", IDao.class);
			//J'appelle la methode m de l'objet metier en lui transmettant 
			//l'objet dao
			m.invoke(metier, dao);
			
			System.out.println(metier.calcul());
			
		} catch (FileNotFoundException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}	
	}
}
