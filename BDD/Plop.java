package BDD;

public class Plop {
	
	
	
//	Imports System.Runtime.Serialization.Formatters.binary
//	Imports System.IO
//	
//	'On crée l'objet
//    Dim Avatar As New Film("Avatar", 2009, "Avatar, film de James Cameron sorti en décembre 2009.")
//    'On crée le fichier et récupère son flux
//    Dim FluxDeFichier As FileStream = File.Create("Film.bin")
//    Dim Serialiseur As New BinaryFormatter
//    'Sérialisation et écriture
//    Serialiseur.Serialize(FluxDeFichier, Avatar)
//    'Fermeture du fichier
//    FluxDeFichier.Close()
//	
	
	public void plop(){
		int x=6; //taille x du tableau
		int y=6; //taille y du tableau
		
		String inf = "01000000";
		String fran = "00000000";
		
		String map[][] = new String[x][y];
		
		
		for (int i =0; i <= x-1;x++){
			for (int j =0 ; j<= y-1;y++){
				map[i][j]=fran;
			}
		}
		
		for (int i = 0 ; i <=x-1; i++){
			map[0][i]=inf;
			map[x-1][i]=inf;
		}
		for (int i = 0 ; i <=y-1; i++){
			map[i][0]=inf;
			map[i][y-1]=inf;
		}
		
		map[3][1]=inf;
		map[3][2]=inf;
		map[3][3]=inf;
		map[3][4]=inf;
		map[4][2]=inf;
		map[5][4]=inf;
		
		
		/* result
		 *    0123456
		 *  0 iiiiiii
		 *  1 ifffffi
		 *  2 ifffffi
		 *  3 iiiiifi
		 *  4 ififffi
		 *  5 ifffifi
		 *  6 iiiiiii
		 */
		
	}

}
