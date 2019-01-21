package presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.IMetier;

public class PresentationWithSpring {

	public static void main(String[] args) {
		
		/*
		 * Spring avec les fichiers xml 
		 * 	On demande à Spring d'aller lire le fichier config.xml 
		 */
		//ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");
		
		/*Spring avec les annotations : 
		 * On demande à Spring quand il va demarrer de scanner les classes et interprete
		 * les annotations; en lui specifiant les packages*/
		ApplicationContext springContext = new AnnotationConfigApplicationContext("dao", "metier");
		
		/*
		 * On demande à Spring de nous chercher un bean qui implemente l'interfarce IMetier
		 */
		IMetier metier = springContext.getBean(IMetier.class);
		System.out.println(metier.calcul());
	}

}
