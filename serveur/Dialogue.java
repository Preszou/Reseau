package serveur;

import client.Player;
import jeu.Grille;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dialogue implements  Runnable{

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

    public Dialogue(Socket sockli1, Socket sockli2) throws IOException {

        j1 = new Player(sockli1, true, "x",new DataInputStream(sockli1.getInputStream()),new DataOutputStream (sockli1.getOutputStream())  );
        j2 = new Player(sockli2, false, "o",new DataInputStream(sockli2.getInputStream()),new DataOutputStream (sockli2.getOutputStream())  );
        j1.getOut().write(j1.getSigne().getBytes());
        j2.getOut().write(j2.getSigne().getBytes());

    }

    public String envoiGrille()
    {
        return grille.afficherTable();
    }



    public PublicKey genererClePublique(Player pJoueur) throws Exception {
        byte[] mess = new byte[1024];
        pJoueur.getIn().read(mess);
        PublicKey pK;
        pK = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(mess));
        pJoueur.getOut().write(pK.getEncoded());
        return pK;
    }

    public boolean readMessage() throws IOException {

        if(j1.getCommencer())
        {
            message = new byte[1024];
            System.out.println("j1");
            j1.getIn().read(message); // bug ici
            //System.out.println(message.toString());
            String rep = new String(message, java.nio.charset.StandardCharsets.UTF_8);
            if(grille.verifKeyPressed(rep))
            {
                System.out.println("j111    ");
                grille.updateTable(rep,j1.getSigne());
                envoyerGrille();
                return true;
            }

        }
        else
        {
            System.out.println("j2");
            j2.getIn().read(message);
            String rep = new String(message, java.nio.charset.StandardCharsets.UTF_8);
            if(grille.verifKeyPressed(rep))
            {
                System.out.println("j2");
                grille.updateTable(message.toString(),j2.getSigne());
                envoyerGrille();
                return false;
            }

        }

        System.out.println("testReadMessage");
        return false;
    }

    private void envoyerGrille() throws IOException {
        j1.getOut().write(grille.afficherTable().getBytes(StandardCharsets.UTF_8));
        j2.getOut().write(grille.afficherTable().getBytes(StandardCharsets.UTF_8));
    }



    @Override
    public void run() {

        try {
            envoyerGrille();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            System.out.println("suce");



            try {


                if (readMessage()){
                    System.out.println("au tour de");
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
