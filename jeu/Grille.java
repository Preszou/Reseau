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

    public String afficherTable()
    {
        String string = "";
        string += this.tab[0][0] + " | " + this.tab[0][1] + " | " + this.tab[0][2] + "\n";
        string += this.tab[1][0] + " | " + this.tab[1][1] + " | " + this.tab[1][2] + "\n";
        string += this.tab[2][0] + " | " + this.tab[2][1] + " | " + this.tab[2][2] + "\n";
        return string;
    }

    public void updateTable(String position, String signe) // 5
    {
        if(position.contains("1"))
        {
            this.setValue(2,0,signe);
        }
        else if(position.contains("2"))
        {
            this.setValue(2,1,signe);
        }
        else if(position.contains("3"))
        {
            this.setValue(2,2,signe);

        }
        else if(position.contains("4"))
        {
            this.setValue(1,0,signe);

        }
        else if(position.contains("5"))
        {
            this.setValue(1,1,signe);

        }
        else if(position.contains("6"))
        {
            this.setValue(1,2,signe);

        }
        else if(position.contains("7"))
        {
            this.setValue(0,0,signe);

        }
        else if(position.contains("8"))
        {
            this.setValue(0,1,signe);

        }
        else if(position.contains("9"))
        {
            this.setValue(0,2,signe);

        }


    }

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

    public boolean verifAlreadyExists(String position)
    {
        if(tableauDejaTouche.contains(position))
        {
            return false;
        }
        else
        {
            tableauDejaTouche.add(position);
            return true;

        }

    }
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
