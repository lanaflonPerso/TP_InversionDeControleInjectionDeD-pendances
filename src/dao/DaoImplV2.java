package dao;
/*Application fermée à la modification ouverte à l'extension
 * 
 * Pour utiliser cette version, on modifiera pas le code source de mon 
 * application, ni dans cette couche(creation d 'une nouvelle 
 * implementation DaoImplV2), ni dans la couche Presentation
 * car on utilise l'interface IDao. Tout sera configurer dans le fichier 
 * texte(config.txt), On remplace l'ancienne version par la nouvelle.
 * 
 */
public class DaoImplV2 implements IDao{

	@Override
	public double getTemperature() {
		/**
		 * Dans cette version je me connecte à un web service
		 * pour recuperer la temperature
		 */
		double data = 32;
		
		return data;
	}

}
