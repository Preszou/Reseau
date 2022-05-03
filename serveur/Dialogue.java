package serveur;

import client.*;
import jeu.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Dialogue
 */
public class Dialogue implements Runnable{

    private Socket sockCli1;
    private Socket sockCli2;
    private byte[] mess;
    private DataInputStream in1;
    private DataOutputStream out1;
    private DataInputStream in2;
    private DataOutputStream out2;
    KeyPairGenerator kg;
    KeyPair kp;
    PrivateKey privatek;
    PublicKey publick;
    PublicKey publicJ1;
    PublicKey publicJ2;
    byte[] message = new byte[64];
    int compteur;
    String clear = "\033[H\033[2J";
    List<String> tableauDejaTouche = new ArrayList<String>();
    Player j1;
    Player j2;
    int compter = 0;
    int coups = 0;
    Grille grille = new Grille();

    /**
     * Constructeur de la classe Dialogue
     * @param sockli1
     * @param sockli2
     * @throws IOException
     */
    public Dialogue(Socket sockli1, Socket sockli2) throws IOException {
        j1 = new Player(sockli1, true, "x",new DataInputStream(sockli1.getInputStream()),new DataOutputStream (sockli1.getOutputStream())  );
        j2 = new Player(sockli2, false, "o",new DataInputStream(sockli2.getInputStream()),new DataOutputStream (sockli2.getOutputStream())  );
        j1.getOut().write(j1.getSigne().getBytes());
        j2.getOut().write(j2.getSigne().getBytes());
    }

    /**
     * envoiGrille()
     * Méthode qui appelle la grille
     * @return String
     */
    public String envoiGrille()
    {
        return grille.afficherTable();
    }

    /**
     * Génère la clé publique
     * @param pJoueur
     * @return
     * @throws Exception
     */
    public PublicKey genererClePublique(Player pJoueur) throws Exception {
        byte[] mess = new byte[1024];
        pJoueur.getIn().read(mess);
        PublicKey pK;
        pK = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(mess));
        pJoueur.getOut().write(pK.getEncoded());
        return pK;
    }

    /**
     * readMessage()
     * Méthode qui sera appelée dans le déroulement du jeu. Est primordiale
     * @return boolean
     * @throws IOException
     */
    public boolean readMessage() throws IOException {
        if(j1.getCommencer())
        {
            message = new byte[1024];
            j1.getIn().read(message);
            String rep = new String(message, java.nio.charset.StandardCharsets.UTF_8);
            if(grille.verifKeyPressed(rep))
            {
                grille.updateTable(rep,j1.getSigne());
                envoyerGrille();
                return true;
            }
        }
        else
        {
            j2.getIn().read(message);
            String rep = new String(message, java.nio.charset.StandardCharsets.UTF_8);
            if(grille.verifKeyPressed(rep))
            {
                grille.updateTable(message.toString(),j2.getSigne());
                envoyerGrille();
                return false;
            }
        }
        return false;
    }

    /**
     * envoyerGrille()
     * Méthode qui envoie la grille sur l'interface des deux clients
     * @throws IOException
     */
    private void envoyerGrille() throws IOException {
        j1.getOut().write(grille.afficherTable().getBytes(StandardCharsets.UTF_8));
        j2.getOut().write(grille.afficherTable().getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Déroulement du jeu
     */
    @Override
    public void run() {
        // On essaye d'abord d'envoyer la grille sur les clients
        try {
            envoyerGrille();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // organise les tours de jeu des clients
        while(true) {
            try {
                if (readMessage()){
                    j1.setCommencer(false);
                    j2.setCommencer(true);
                }

                else{
                    j1.setCommencer(true);
                    j2.setCommencer(false);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
