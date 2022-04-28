package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws Exception {
        // DÃ©claration du socket client
        Socket sockCli;
        DataInputStream in = null;
        DataOutputStream out;
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
        kg.initialize(1024);
        KeyPair kp = kg.generateKeyPair();
        PrivateKey privatek = kp.getPrivate();
        PublicKey publick = kp.getPublic();
        PublicKey pkServ = null;
        PublicKey serveurKey;
        String signe ="";
        int compteur = 0;
        byte[] positionRecu = new byte[80];
        InetAddress addr = InetAddress.getByName("localhost");
        sockCli = new Socket(addr, 1236);




        while(true)
        {
            if(compteur != 0)
            {
                in = new DataInputStream(sockCli.getInputStream());
                out = new DataOutputStream(sockCli.getOutputStream());

                byte[] mess = new byte[128];
                in.read(mess);
                System.out.println(mess.toString());
                if (mess.equals("defaite")) {
                    System.out.println("Tu as perdu dommage");
                    return;
                } else if (mess.equals("j1")) {
                    System.out.println("Vous etes le premier joueur");

                } else {
                    System.out.println("Vous ezele premier joueur");
                }
            }
            compteur++;

        }












        }
}
