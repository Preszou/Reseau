package jeu;

import java.util.ArrayList;
import java.util.List;

public class Grille {

    private static final int LARGEUR_TABLEAU = 3;
    private static final int LONGUEUR_TABLEAU = 3;
    private List<String> tableauDejaTouche = new ArrayList<>( );
    private String tab[][] = new String[LARGEUR_TABLEAU][LONGUEUR_TABLEAU];

    public void setValue(int pAbscisse, int pOrdonnee, String signe)
    {
        this.tab[pAbscisse][pOrdonnee] = signe;
    }

    /**
     * Constructeur de la classe Grille()
     * Création de la grille -> tableau 2 dimmensions (3x3)
     */
    public Grille()
    {
        int m = 3;
        int n = 3;

        for (int i = 0; i < tab.length; i++)
        {
            for (int j = 0; j < tab[0].length; j++)
            {
                tab[i][j] = " ";
            }
        }
    }

    /**
     * afficherTable()
     * Affiche la grille du jeu
     * @return String
     */
    public String afficherTable()
    {
        String string = "";
        string += this.tab[0][0] + " | " + this.tab[0][1] + " | " + this.tab[0][2] + "\n";
        string += this.tab[1][0] + " | " + this.tab[1][1] + " | " + this.tab[1][2] + "\n";
        string += this.tab[2][0] + " | " + this.tab[2][1] + " | " + this.tab[2][2] + "\n";
        return string;
    }

    /**
     * updateTable()
     * Fonction qui met à jour la grille de jeu à l'aide d'un switch/case
     * @param position
     * @param signe
     */
    public void updateTable(String position, String signe) // 5
    {
        switch(position){

            case "1":
                this.setValue(2,0,signe);
                break;

            case "2":
                this.setValue(2,1,signe);
                break;

            case "3":
                this.setValue(2,2,signe);
                break;

            case "4":
                this.setValue(1,0,signe);
                break;

            case "5":
                this.setValue(1,1,signe);
                break;

            case "6":
                this.setValue(1,2,signe);
                break;

            case "7":
                this.setValue(0,0,signe);
                break;

            case "8":
                this.setValue(0,1,signe);
                break;

            case "9":
                this.setValue(0,2,signe);
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        }
    }

    /**
     * verifKeyPressed()
     * Regarde quelle touche a été saisie.
     * @param position
     * @return boolean
     */
    public boolean verifKeyPressed(String position)
    {
        if( position.contains("1")||
            position.contains("2")||
            position.contains("3")||
            position.contains("4")||
            position.contains("5")||
            position.contains("6")||
            position.contains("7")||
            position.contains("8")||
            position.contains("9"))
        {
            if(verifAlreadyExists(position))
            {
                return true;
            };
            return false;
        }
        else
        {
            return false;
        }
    }

    /**
     * verifAlreadyExists()
     * Méthode qui regarde si un emplacement est déjà prit sur le jeu du morpion
     *  pour ne pas écrire un signe par dessus.
     * @param position
     * @return boolean
     */
    public boolean verifAlreadyExists(String position)
    {
        if(tableauDejaTouche.contains(position)) return false;
        else tableauDejaTouche.add(position); return true;
    }

    /**
     * haveWin()
     * Méthode qui détecte une combinaison gagnante, renvoie true si il y a une correspondance
     * @param signe
     * @return boolean
     */
    public boolean haveWin(String signe)
    {
        if (signe.contains(this.tab[0][0]) && signe.contains(this.tab[1][0]) && signe.contains(this.tab[2][0])) return true;
        if (signe.contains(this.tab[0][1]) && signe.contains(this.tab[1][1]) && signe.contains(this.tab[2][1])) return true;
        if (signe.contains(this.tab[0][2]) && signe.contains(this.tab[1][2]) && signe.contains(this.tab[2][2])) return true;
        if (signe.contains(this.tab[0][0]) && signe.contains(this.tab[0][1]) && signe.contains(this.tab[0][2])) return true;
        if (signe.contains(this.tab[1][0]) && signe.contains(this.tab[1][1]) && signe.contains(this.tab[1][2])) return true;
        if (signe.contains(this.tab[2][0]) && signe.contains(this.tab[2][1]) && signe.contains(this.tab[2][2])) return true;
        if (signe.contains(this.tab[0][0]) && signe.contains(this.tab[1][1]) && signe.contains(this.tab[2][2])) return true;
        if (signe.contains(this.tab[0][2]) && signe.contains(this.tab[1][1]) && signe.contains(this.tab[2][0])) return true;

        return false;
    }
}
