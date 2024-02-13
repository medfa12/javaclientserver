import java.net.*;
import java.io.*;

public class ServeurTCP {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Définir le port d'écoute
        int port = 5000;

        // Créer un ServerSocket sur le port spécifié
        ServerSocket serverSocket = new ServerSocket(port);

        // Accepter une connexion d'un client
        Socket clientSocket = serverSocket.accept();

        // Créer des flux d'entrée et de sortie pour communiquer avec le client
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        // Boucle de traitement infinie
        while (true) {
            // Lire un message du client
            byte[] data = new byte[1024];
            int bytesRead = inputStream.read(data);

            // Extraire le message du tableau de bytes
            String message = new String(data, 0, bytesRead);

            // Afficher le message reçu
            System.out.println("Message reçu : " + message);

            // Envoyer un message de réponse au client
            String response = "Réponse du serveur";
            byte[] responseData = response.getBytes();
            outputStream.write(responseData);
        }

        // Fermer les flux et les sockets
        // inputStream.close();
        // outputStream.close();
        // clientSocket.close();
        // serverSocket.close();
    }
}
