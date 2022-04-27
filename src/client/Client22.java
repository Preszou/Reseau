package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Client22 {
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

        in = new DataInputStream(sockCli.getInputStream());
        out = new DataOutputStream(sockCli.getOutputStream());


        while(true)
        {

            byte[] mess = new byte[128];
            in.read(mess);
            System.out.println("ouai");
            if (mess.equals("defaite")) {
                System.out.println("Tu as perdu dommage");
                return;
            } else if (mess.equals("j1")) {
                System.out.println("Vous ï¿½tes le premier joueur");

            } else {
                System.out.println("Vous ezele premier joueur");
            }
        }












        }
}
