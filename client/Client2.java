package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Locale;
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
        boolean peutJouer = false;
        in = new DataInputStream(sockCli.getInputStream());
        out = new DataOutputStream(sockCli.getOutputStream());



        while(true)
        {

            byte[] mess = new byte[128];
            in.read(mess);
            String rep = new String(mess, java.nio.charset.StandardCharsets.UTF_8);
            System.out.println("ouai");
            if(signe.equals("")) {
                if (rep.contains("x") || rep.contains("o")) {
                    signe = rep;
                    if(rep.contains("x"))
                    {
                        System.out.println("test3");
                        peutJouer = true;
                    }
                    else
                    {
                        System.out.println("test4");
                        peutJouer = false;
                    }
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
                if(peutJouer)
                {
                    System.out.println("test");
                    peutJouer = false;
                }
                else
                {
                    System.out.println("test2");
                    peutJouer = true;
                }
            }




        }


    }
}
