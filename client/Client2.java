package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Scanner;

/**
 * Classe du 2ème Client
 */
public class Client2 {
    public static void main(String[] args) throws Exception {
        Socket sockCli; /* Déclaration du socket client */
        DataInputStream in = null;
        DataOutputStream out;
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA"); //Creating KeyPair generator object
        kg.initialize(1024); //Initializing the KeyPairGenerator
        KeyPair kp = kg.generateKeyPair(); //Generate the pair of keys
        PrivateKey privatek = kp.getPrivate(); //Getting the private key from the key pair
        PublicKey publick = kp.getPublic(); //Getting the public key from the key pair
        PublicKey pkServ = null;
        PublicKey serveurKey;
        String signe ="";
        int compteur = 0;
        byte[] positionRecu = new byte[80];
        InetAddress addr = InetAddress.getByName("localhost");
        sockCli = new Socket(addr, 1236);
        boolean peutJouer = false;
        in = new DataInputStream(sockCli.getInputStream()); // utilisé pour lire les données
        out = new DataOutputStream(sockCli.getOutputStream()); // utilisé pour écrire les données

        while(true)
        {
            byte[] mess = new byte[128]; // Tableau de Byte
            in.read(mess);
            String rep = new String(mess, java.nio.charset.StandardCharsets.UTF_8);

            /* Défini si c'est au tour de jouer du joueur ou non */
            if(signe.equals("")) {
                if (rep.contains("x") || rep.contains("o")) {
                    signe = rep;
                    if(rep.contains("x"))peutJouer = true;
                    else peutJouer = false;
                }
            }
            else
            {
                if(peutJouer)
                {
                    System.out.println("C'est votre tour");
                    Scanner sc = new Scanner(System.in);
                    String s;
                    s = sc.nextLine();
                    out.write(s.getBytes(StandardCharsets.UTF_8));
                }

                System.out.println(rep);
                if(peutJouer) peutJouer = false;
                else peutJouer = true;
            }
        }
    }
}

