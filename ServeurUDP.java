package javaclientserver;
import java.net.*;
import java.io.*;

public class ServeurUDP {

    public static void main(String[] args) throws Exception {
        // Définir le port d'écoute
        int port = 5000;

        // Créer un DatagramSocket sur le port spécifié
        DatagramSocket socket = new DatagramSocket(port);

        // Boucle de réception infinie
        while (true) {
            // Créer un DatagramPacket pour recevoir des données
            byte[] data = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(data, data.length);

            // Recevoir un DatagramPacket
            socket.receive(receivePacket);

            // Extraire le message du DatagramPacket
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // Afficher le message reçu
            System.out.println("Message reçu : " + message);

            // Obtenir l'adresse IP et le port du client
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            // Envoyer un message de réponse au client
            String response = "Réponse du serveur";
            byte[] responseData = response.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
            socket.send(sendPacket);
        }
    }
}