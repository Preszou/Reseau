package client;

import java.net.*;
import java.io.*;

/**
 * La classe player s'occupe de recevoir le message et de le renvoyer
 */
public class Player
{
    private Socket sockcli;
    private InputStream in;
    private OutputStream out;
    private boolean commencer;
    private String signe;

    /**
     * Constructeur Player()
     * @param sockcli
     * @param commencer
     * @param signe
     * @param pIn
     * @param pOut
     */
    public Player(Socket sockcli, boolean commencer, String signe, InputStream pIn, OutputStream pOut)
    {
        this.sockcli = sockcli;
        this.commencer = commencer;
        this.signe = signe;
        this.in = pIn;
        this.out = pOut;
    }

    /**
     * getIn()
     * @return InputStream
     */
    public InputStream getIn()
    {
        return this.in;
    }

    /**
     * getOut()
     * @return OutputStream
     */
    public OutputStream getOut()
    {
        return this.out;
    }


    /**
     * getCommencer()
     * @return boolean
     */
    public boolean getCommencer()
    {
        return this.commencer;
    }

    /**
     * setCommencer()
     * @param tonTour
     */
    public void setCommencer(boolean tonTour)
    {
        this.commencer = tonTour;
    }

    /**
     * getSigne()
     * @return String
     */
    public String getSigne()
    {
        return this.signe;
    }









}