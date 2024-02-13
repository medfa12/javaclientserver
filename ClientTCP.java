import java.net.*;
import java.io.*;

public class ClientTCP {

    public static void main(String[] args) throws Exception {
        // Spécifier l'adresse IP et le port du serveur
        String serverAddress = "localhost"; // ou remplacer avec l'IP du serveur
        int port = 5000; 

        try {
            // Créer un socket TCP et se connecter au serveur
            Socket socket = new Socket(serverAddress, port);

            // Obtenir les flux d'entrée et de sortie
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Envoyer une requête au serveur
            String request = "Hello from client!";
            outputStream.write(request.getBytes());

            // Lire la réponse du serveur
            byte[] responseBytes = new byte[1024];
            int bytesRead = inputStream.read(responseBytes);
            String response = new String(responseBytes, 0, bytesRead);

            System.out.println("Réponse du serveur : " + response);

            // Fermeture du socket
            socket.close();

        } catch (IOException e) {
            System.err.println("Erreur de communication: " + e.getMessage());
        }
    }
}
