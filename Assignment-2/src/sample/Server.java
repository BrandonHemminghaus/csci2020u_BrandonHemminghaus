package sample;
import java.io.*;
import java.net.*;

public class Server {
    protected Socket clientsocket = null; //Client socket
    protected ServerSocket serversocket = null; //Server socket
    protected ClientConnectionHandler[] threads = null;
    protected int numClients = 0; //Clients
    public static int SERVER_PORT = 16789; //Port
    public static int MAX_CLIENTS = 1; //Max number of clients

    public Server(){
        try{
            serversocket = new ServerSocket(SERVER_PORT);
            threads = new ClientConnectionHandler[MAX_CLIENTS];
            while (true){
                clientsocket = serversocket.accept(); //Clients are accepted to the server
                threads[numClients] = new ClientConnectionHandler();
                threads[numClients].start();
                numClients++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
