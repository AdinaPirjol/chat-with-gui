package ChatGUI;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Dumitru Cristian
 */

public class Server{

    private final ArrayList<DataOutputStream> socketList;
    private final ArrayList<String> connectedClientsNameList;  
    private final ArrayList<MyConnection> connectionsList;
    private ServerSocket serverSocket; 
    private Socket clientSocket;
    private final int port;
    private final ServerGUI gui;
    private boolean serverIsUp;
    
    Server( int port , ServerGUI gui ){
        socketList = new ArrayList<>();
        connectedClientsNameList = new ArrayList<>();
        connectionsList = new ArrayList<>();
        this.port = port;
        this.gui = gui;
    }
    
    
    public void start(){
        serverIsUp = true;
        try{
            serverSocket = new ServerSocket(port);  
            showActivity("Server is up and ready for receiving clients through port " + port + "\n");
            while(serverIsUp) 
                try{
                    clientSocket = serverSocket.accept(); 
                    if(serverIsUp)
                        connectionsList.add(new MyConnection(clientSocket, socketList, connectedClientsNameList));                         
                }catch(IOException e){
                    showActivity("Server connection was lost. Something went wrong.\n\n"); 
                }
            showActivity("Server connection closed.\n\n");    
        }catch(IOException e){
            showActivity("Port " + port + " is not available\n");
        }
    }
    
    
    public void showActivity(String message){
        gui.showActivity(message);
    }
    
    
    public  void showList( ){
        gui.showList(connectedClientsNameList);
    }
    
    
    synchronized void stop(){
        serverIsUp = false;
        try {
            Socket socket = new Socket("localhost", port);
            serverSocket.close();
            if(connectionsList!=null)
                for(MyConnection conn : connectionsList) {
                    conn.closeConnection();
            }
            connectionsList.clear();
            showList();
        }catch (IOException ex) {
            showActivity("Something went wrong. Connection closed gracefully.\n\n");
        }
    }
    
    
    class MyConnection extends Thread{ 
   
        private String name;
        private boolean clientIsUp = true;
        private Socket clientSocket = null; 
        private DataInputStream inputClient = null;  
        private DataOutputStream outputClient = null; 
        private ArrayList<String> connectedUsers;
        private ArrayList<DataOutputStream> Sockets;

        MyConnection(Socket client, ArrayList<DataOutputStream> socketList,  ArrayList<String> connectedClientsList ) throws IOException {    

            clientSocket = client; 
            Sockets = socketList;  
            connectedUsers = connectedClientsList;
            inputClient = new DataInputStream( clientSocket.getInputStream() ); 
            outputClient = new DataOutputStream( clientSocket.getOutputStream() );

            while(serverIsUp){
                try{
                    name = inputClient.readUTF();
                    if(serverIsUp && username(name)){
                        outputClient.writeUTF("Name is accepted.\n");
                        showActivity("New user - Client Name: " + name + "\n");
                        start(); 
                        break;
                    }
                    else{
                        if(serverIsUp)
                            outputClient.writeUTF("This name is already used.\n");
                        else {
                            inputClient.close();
                            outputClient.close(); 
                            clientSocket.close();
                            break;
                        }
                    }
                }catch(IOException e) { 
                    inputClient.close();
                    outputClient.close(); 
                    clientSocket.close();
                    break;
                }
            }
        }

        @Override
        public void run(){ 
            try{
                while(clientIsUp){    
                    String message = inputClient.readUTF();
                    String[] words = message.split(" ",3);
                    switch(words[0]){
                        case "LIST" : 
                            list();
                            break;
                        case "NAME" : 
                            if(words[1].trim() != null)
                                changeName(words[1]);
                            else 
                                outputClient.writeUTF("SERVER You didn't type a name\n" );
                            break;
                        case "BCAST" : 
                            if(words.length == 3 )
                                broadcast(words[1] + " " + words[2]);
                            else 
                                if(!words[1].equals(""))  
                                    broadcast(words[1]);
                                else 
                                    outputClient.writeUTF("SERVER You didn't type a message\n" );
                            break;
                        case "QUIT" : 
                            quit();    
                            break;   
                        case "MSG" :  
                            if(!msg(words[1] , words[2]))
                                outputClient.writeUTF("SERVER You didn't type a message\n" );
                            break;
                    }
                }
            }catch(IOException e) { 
              if(clientIsUp)
                quit(); 
            }
        }

        synchronized boolean username(String name){
            if(!connectedClientsNameList.contains(name)){
                connectedClientsNameList.add(name);  
                try{ 
                    Sockets.add(new DataOutputStream( clientSocket.getOutputStream()));
                }catch (IOException ex){ 
                    return false;
                }
                showList();  
                return true;
            }else{ 
                return false;
            }
        }

        synchronized void list(){
            try{
                outputClient.writeUTF("LIST " + connectedUsers.size());
                for (String name : connectedUsers) {
                    outputClient.writeUTF(name);
                }
            }catch(IOException e){
                quit();
            }

        }

        synchronized void changeName(String newName){
            int index = connectedClientsNameList.indexOf(name);
            try{
                if(!connectedClientsNameList.contains(newName)){
                    connectedClientsNameList.remove(index);
                    connectedClientsNameList.add(index, newName );
                    showActivity("User " + name + " changed his name to " + newName + "\n");
                    name = newName;
                    showList();
                    outputClient.writeUTF("SERVER Name " + newName + " is accepted\n" ); 
                    outputClient.writeUTF("NAME " + newName );
                }else{
                    outputClient.writeUTF("SERVER Name " + newName + " is already used\n" );
                }
            }catch(IOException e){  
                quit();
            }
        }

        synchronized void broadcast(String message){
            for(DataOutputStream socket : Sockets) {
                try {
                    socket.writeUTF("BCAST " + name + " : " + message + "\n" );
                }catch(IOException e) {}
            }
        }

        synchronized void quit(){
            int index = connectedClientsNameList.indexOf(name);
            connectedClientsNameList.remove(index);
            Sockets.remove(index);
            connectionsList.remove(index);
            showList();
            clientIsUp = false;

            try{
                outputClient.close();
                inputClient.close();
                clientSocket.close();
            }catch (IOException ex) {}

            showActivity("User " + name + " is now offline\n");
        }

        public void closeConnection(){
            int index = connectedClientsNameList.indexOf(name);
            connectedClientsNameList.remove(index);
            Sockets.remove(index);
            clientIsUp = false;

            try {
                outputClient.close();
                inputClient.close();
                clientSocket.close();
            }catch (IOException ex) {}
        }

        synchronized Boolean msg(String name , String message){

            int index = connectedUsers.indexOf(name);
            if( index != -1 && message != null )
                try{
                     Sockets.get(index).writeUTF( "MSG " + name + " : " + message );
                     return true;
                }catch(IOException e){
                    try {
                         outputClient.writeUTF("MSG " + name + " is now offline");
                    }catch (IOException ex) {}
                    return true;

                }
            else 
                if(index == -1){
                        try {
                             outputClient.writeUTF("MSG " + name + " is not online");
                        }catch (IOException ex) {}
                        return true;
                }else{
                    return false;
                }
        }

    }
}