package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*
 * La couche DAO est fermée à la modification car elle dépend d'aucune classe
 * et ouverte à l'extension car on a une interface (à chaque fois que je veux
 * créer une nouvelle version, il suffit que j'implemente cette interface)
 */

//@Component
@Repository
public class DaoImpl implements IDao{

	@Override
	public double getTemperature() {
		/*
		 * Se connecter à la base de données pour récupérer la temperature
		 */
		double data = 24;
		return data;
	}

}
