/*
 * Classe Joueur.
 * Cette classe nous permet dinstancier dans la classe Dialogue
 * 2 joueurs. Ceci prennent comme paramètre une socket, un attribut boolean commencer,
 * qui nous permet de définir un ordre de jeu et enfin un signe qui correspond au signe
 * du joueur qui va être dessiner sur la grille.
 */

package client;

import java.net.*;
import java.io.*;

public class Player // S'occupe de recevoir le message et de le renvoyer
{
    private Socket sockcli;
    private InputStream in;
    private OutputStream out;
    private boolean commencer;
    private String signe;

    public Player(Socket sockcli, boolean commencer, String signe, InputStream pIn, OutputStream pOut)
    {
        this.sockcli = sockcli;
        this.commencer = commencer;
        this.signe = signe;
        this.in = pIn;
        this.out = pOut;
    }

    public InputStream getIn()
    {
        return this.in;
    }

    public OutputStream getOut()
    {
        return this.out;
    }


    public boolean getCommencer()
    {
        return this.commencer;
    }

    public void setCommencer(boolean tonTour)
    {
        this.commencer = tonTour;
    }

    public String getSigne()
    {
        return this.signe;
    }









}