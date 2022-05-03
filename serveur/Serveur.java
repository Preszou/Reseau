package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

/**
 * This class is just the server of our application.
 *
 */
public class Serveur {

    /**
     * This is just an excecutable method
     * @param args
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        // DÃ©claration socket serveur
        ServerSocket sockServ = null;

        // Lancement du serveur
        sockServ = new ServerSocket(1236);
        try {
            // Boucle infinie pour le chat
            try {
                while(true) {
                    Socket sockCli1 = sockServ.accept();
                    Socket sockCli2 = sockServ.accept();
                    Dialogue t = new Dialogue(sockCli1, sockCli2);
                    Thread th = new Thread(t);
                    th.start();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }finally {
            try {
                // Fermeture du socket serveur
                sockServ.close();
            } catch (IOException e) {

            }
        }

    }
}