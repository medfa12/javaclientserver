
import java.net.*;
import java.io.*;

public class ClientUDP {

    public static void main(String[] args) throws Exception {
        // Définir l'adresse IP du serveur
        InetAddress serverAddress = InetAddress.getByName("localhost");

        // Définir le port du serveur
        int port = 5000;

        // Créer un DatagramSocket
        DatagramSocket socket = new DatagramSocket();

        // Créer un DatagramPacket pour envoyer un message
        String message = "Message du client";
        byte[] data = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(data, data.length, serverAddress, port);

        // Envoyer le DatagramPacket
        socket.send(sendPacket);

        // Recevoir un message de réponse du serveur
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);

        // Extraire le message de réponse
        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());

        // Afficher le message de réponse
        System.out.println("Réponse du serveur : " + response);
    }
}