package metier;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.IDao;

/*
 * La couche Metier est fermée à la modification car elle dépend d'aucune classe
 * et ouverte à l'extension car on a une interface (à chaque fois que je veux
 * créer une nouvelle version, il suffit que j'implemente cette interface)
 */

//@Component
@Service
public class MetierImpl implements IMetier{
	
	/*	On ne fait pas égale à new car avec new on instancie
		une classe non une interface.
		Si on instancie une classe c'est un couplage fort.
		La bonne programmation c'est de ne pas avoir de new
		dans notre application. Sinon On a une 
		application qui n'est pas fermée à la modification. 
		Donc a chaque fois qu'il y a une nouvelle version de
		la class on est obligé de modifier le code source
	*/
	
	@Autowired //On demande à Spring de chercher un objet qu'il a déjà crée qui implemente cette interface et l'associer à dao
	private IDao dao; 
	
	

	public IDao getDao() {
		return dao;
	}


	//Permet de faire l'injection de dependance 
	public void setDao(IDao dao) {
		this.dao = dao;
	}


	@Override
	public double calcul() {
		double temp = dao.getTemperature();
		double res = temp*12;
		return res;
	}

}
