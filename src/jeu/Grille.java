package jeu;

import java.util.List;

public class Grille {

    private static final int LARGEUR_TABLEAU = 3;
    private static final int LONGUEUR_TABLEAU = 3;
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

        switch(position)
        {
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
                break;

        }
    }

    public boolean verifKeyPressed(String position)
    {
        if( position.equals("1")||
                position.equals("2")||
                position.equals("3")||
                position.equals("4")||
                position.equals("5")||
                position.equals("6")||
                position.equals("7")||
                position.equals("8")||
                position.equals("9"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean verifAlreadyExists(List<String> tableauDejaTouche, String signe)
    {
        if(tableauDejaTouche.contains(signe))
        {
            return false;
        }
        else
        {
            tableauDejaTouche.add(signe);
            return true;

        }

    }
    public boolean haveWin(String signe)
    {

        if (signe.equals(this.tab[0][0]) && signe.equals(this.tab[1][0]) && signe.equals(this.tab[2][0])) return true;
        if (signe.equals(this.tab[0][1]) && signe.equals(this.tab[1][1]) && signe.equals(this.tab[2][1])) return true;
        if (signe.equals(this.tab[0][2]) && signe.equals(this.tab[1][2]) && signe.equals(this.tab[2][2])) return true;
        if (signe.equals(this.tab[0][0]) && signe.equals(this.tab[0][1]) && signe.equals(this.tab[0][2])) return true;
        if (signe.equals(this.tab[1][0]) && signe.equals(this.tab[1][1]) && signe.equals(this.tab[1][2])) return true;
        if (signe.equals(this.tab[2][0]) && signe.equals(this.tab[2][1]) && signe.equals(this.tab[2][2])) return true;
        if (signe.equals(this.tab[0][0]) && signe.equals(this.tab[1][1]) && signe.equals(this.tab[2][2])) return true;
        if (signe.equals(this.tab[0][2]) && signe.equals(this.tab[1][1]) && signe.equals(this.tab[2][0])) return true;

        return false;
    }
}
