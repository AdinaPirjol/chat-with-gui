package ChatGUI;

import java.net.*; 
import java.util.*; 
import java.io.*;


class Client{
    private final int port;
    private final String address;
    private final ClientGUI gui;
    private Socket clientSocket;
    private DataInputStream inputServer;		
    private DataOutputStream outputServer;
    private boolean serverIsUp;
    private String name;
    private final ArrayList<PopUp> privateConvUserList;
    private final ArrayList<String> usersInConversationList;
    
    Client(int port, String address, ClientGUI gui){
        this.port = port;
        this.address = address;
        this.gui = gui;
        privateConvUserList = new ArrayList();
        usersInConversationList = new ArrayList<>();
    }
    
    public boolean connect(){
        try{
            clientSocket = new Socket(address, port);
        }catch(IOException e){
            showServerMessage("This server is not available.\n\n");
            return false;
        }
        
        try{
            inputServer = new DataInputStream(clientSocket.getInputStream());
	    outputServer = new DataOutputStream(clientSocket.getOutputStream());
            return true;
        }catch(IOException e){
            showServerMessage("I/O streams creation failed.\n\n");
            return false;
        }
    }
    
    public void username(){
        new Username().start();
    }
    
    class Username extends Thread{
        @Override
        public void run(){
            String fromServer;
            while(true){
                try{
                    showServerMessage("Type username and password.\n");
                    fromServer = inputServer.readUTF();
                    showServerMessage(fromServer + "\n");
                    if(fromServer.equals("Name is accepted.\n") ){
                        new FromServer().start();                    
                        gui.start();
                        gui.setTitle();
                        serverIsUp = true;
                        break;
                    }
                }catch (IOException ex){
                    showServerMessage("Server is offline.\n\n");
                    gui.disconnect(); 
                    break;
                }
            }
        }
}
    
    public void disconnect(){
        try {
            if( serverIsUp ){
                serverIsUp = false;
                inputServer.close();  
                outputServer.close();
                clientSocket.close();
                gui.showServerMessage("You disconnected from the server.\n\n");
                gui.disconnect();}
            else{
                inputServer.close();  
                outputServer.close();
                clientSocket.close();
                gui.disconnect();
                }
            closePopUps();
        } catch (IOException ex) {}
    }
    
    public void sendMessageToServer(String message){
        try {    
            outputServer.writeUTF(message);
        } catch (IOException ex) {
            disconnect();
        }
    }
    
    public void showServerMessage( String message ){ 
        
        gui.showServerMessage(message); 
    }
    
    public void showChatGroupMessage( String message ){ 
        gui.showChatGroupMessage(message);
    }
    
    public void showUsersList( int users ){
    
        String user;
        ArrayList<String> onlineUsersList = new ArrayList<>();
        for( int i = 0 ; i<users ; i++ )
            try {
                user = inputServer.readUTF();
                onlineUsersList.add(user);
            } catch (IOException ex) {}
        gui.showUsersList(onlineUsersList);
    }
    
    public String getName(){
    
        return this.name;
    }
    
    public void setNume( String name ){
    
        this.name = name;
    }
    
    public void closePopUps(){
        for(int i=0;i<usersInConversationList.size();i++){
            privateConvUserList.get(i).dispose();
        }
        usersInConversationList.clear();
        privateConvUserList.clear();
    }
    
    synchronized public void closeWindow(String receiver, PopUp window){
        usersInConversationList.remove(receiver);
        privateConvUserList.remove(window);
    }
    
    public void openWindow(String receiver){
        if(usersInConversationList.indexOf(receiver) == -1)
            {
                usersInConversationList.add(receiver);
                privateConvUserList.add(new PopUp( receiver , name , this ) );
                privateConvUserList.get( privateConvUserList.size() - 1 ).setVisible(true);
            }
    }
    
    public void privateMessage( String receiver , String message ){
        int index = usersInConversationList.indexOf(receiver);
        if(index == -1){
            usersInConversationList.add(receiver);
            privateConvUserList.add(new PopUp( receiver , name , this ) );
            privateConvUserList.get(privateConvUserList.size() - 1).setVisible(true);
            privateConvUserList.get(privateConvUserList.size() - 1).showMessage(receiver + " " + message);
        }else{
            privateConvUserList.get( index ).showMessage(receiver + " " + message);
        }
    }
    
    public void changeConversationName( String newName ){
        for(PopUp window : privateConvUserList){
            window.changeNume(newName);
        }
    }
    
    class FromServer extends Thread{
        @Override
        public void run(){
            while(true){
                String fromServer = ""; 
                String message[];
                try {
                    fromServer = inputServer.readUTF();
                    message = fromServer.split(" ",2);
                    switch(message[0]){
                        case "BCAST": 
                            showChatGroupMessage(message[1]);
                            break;
                        case "SERVER": 
                            showServerMessage(message[1]);
                            break;
                        case "NAME":  
                            name = message[1];
                            gui.changeName(name);
                            changeConversationName(name);
                            sendMessageToServer("LIST");
                            break;
                        case "LIST": 
                            int usersNo = Integer.parseInt(message[1]);
                            showUsersList(usersNo);
                            break;
                        case "MSG":   
                            message = fromServer.split(" ",3);
                            privateMessage(message[1] , message[2]);
                    }
                }catch (IOException ex){ 
                    if(serverIsUp){ 
                        serverIsUp = false;
                        gui.showServerMessage("Server is now offline.\n\n");
                        disconnect();
                    }
                    break;                         
                }
            }
        }
    }
}
