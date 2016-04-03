package ChatGUI;

import java.awt.Color;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Dumitru Cristian
 */

public class ClientGUI extends javax.swing.JFrame{
    private static final int OFFSET = 4;
    private Client client;
    private String address;
    private int port;
    
    ClientGUI(String address, int port) {
        super("Client");
        initComponents();
        this.getContentPane().setBackground(Color.decode("#6082b6"));
        this.port = port;
        this.address = address;
        textServer.setEditable(false);
        textGroupChat.setEditable(false);
        init();
        client = null;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textClient = new javax.swing.JTextField();
        buttonSend = new javax.swing.JButton();
        labelConnectedClients = new javax.swing.JLabel();
        labelAdress = new javax.swing.JLabel();
        textAdress = new javax.swing.JTextField();
        labelPort = new javax.swing.JLabel();
        textPort = new javax.swing.JTextField();
        buttonConnect = new javax.swing.JButton();
        labelServer = new javax.swing.JLabel();
        labelGroupChat = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        buttonName = new javax.swing.JButton();
        textName = new javax.swing.JTextField();
        buttonListFriends = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textServer = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        textGroupChat = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        listConnectedClients = new javax.swing.JList();
        labelMessage = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        labelPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textClient.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textClientActionPerformed(evt);
            }
        });

        buttonSend.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonSend.setText("Send");
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });

        labelConnectedClients.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelConnectedClients.setText("Connected Clients");

        labelAdress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAdress.setText("Adress: ");

        textAdress.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        labelPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPort.setText("Port:");

        textPort.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        buttonConnect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonConnect.setText("Connect");
        buttonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectActionPerformed(evt);
            }
        });

        labelServer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelServer.setText("Server Messages");

        labelGroupChat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelGroupChat.setText("Group Chat");

        labelName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelName.setText("Name: ");

        buttonName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonName.setText("Add");
        buttonName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNameActionPerformed(evt);
            }
        });

        textName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        buttonListFriends.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonListFriends.setText("List friends");
        buttonListFriends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListFriendsActionPerformed(evt);
            }
        });

        textServer.setColumns(20);
        textServer.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textServer.setRows(5);
        jScrollPane2.setViewportView(textServer);

        textGroupChat.setColumns(20);
        textGroupChat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textGroupChat.setRows(5);
        jScrollPane1.setViewportView(textGroupChat);

        listConnectedClients.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        listConnectedClients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listConnectedClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listConnectedClientsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listConnectedClients);

        labelMessage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelMessage.setText("Message");

        textPassword.setText("jPasswordField1");

        labelPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelPassword.setText("Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textClient))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelServer)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(textAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(labelPort, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(textPort, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonConnect))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelMessage)
                                    .addComponent(labelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textName)
                                    .addComponent(textPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(buttonName, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonListFriends))
                            .addComponent(labelGroupChat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(labelConnectedClients)
                    .addComponent(buttonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(labelAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(labelPort, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textPort, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelConnectedClients, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(labelServer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelGroupChat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(42, 42, 42))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(buttonName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(buttonListFriends, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                            .addGap(25, 25, 25)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(labelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textClient, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectActionPerformed
        
        if( client!=null ){
         client.sendMessageToServer("QUIT");
         client.disconnect();
        }else{
            address = textAdress.getText();
            try{
                port = Integer.parseInt(textPort.getText());
            }catch(NumberFormatException e){ return; }
            client = new Client(port,address,this);
            if(!client.connect()) {
                client = null;
                return;
            }
            textName.setEditable(true);
            buttonName.setEnabled(true);
            buttonName.setText("Send");
            textAdress.setEditable(false);
            textPort.setEditable(false);
            buttonConnect.setText("Disconnect");
            buttonConnect.setEnabled(false);
            client.username();
        }
    }//GEN-LAST:event_buttonConnectActionPerformed

    private void listConnectedClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listConnectedClientsMouseClicked
        
        if (evt.getClickCount() == 2 && !evt.isConsumed() ) {
            String row = (String) listConnectedClients.getSelectedValue();
            evt.consume();           
            String numeUtilizator[] = row.split("[)] ",2);
            client.openWindow( numeUtilizator[1] );
       }
    }//GEN-LAST:event_listConnectedClientsMouseClicked

    private void textClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textClientActionPerformed

            client.sendMessageToServer( "BCAST " + textClient.getText() );
            textClient.setText("");
    }//GEN-LAST:event_textClientActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendActionPerformed

            String s = textClient.getText();
            try {    
                String encrypted_message = encrypt(s, OFFSET);
                System.out.println(encrypted_message);
                client.sendMessageToServer("BCAST " + encrypted_message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            textClient.setText("");
    }//GEN-LAST:event_buttonSendActionPerformed

    private void buttonListFriendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListFriendsActionPerformed

            client.sendMessageToServer("LIST");
 
    }//GEN-LAST:event_buttonListFriendsActionPerformed

    private void buttonNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNameActionPerformed
        
        String name;
        switch(buttonName.getText())
         {
            case "Send": 
                name = textName.getText();
                client.sendMessageToServer(name);
                break;
            case "Name":   
                showServerMessage("Trying to change name:\n");
                textClient.setEditable(false);
                listConnectedClients.setEnabled(false);
                buttonListFriends.setEnabled(false);
                buttonSend.setEnabled(false);
                buttonName.setText("Change");
                textName.setEditable(true);
                listConnectedClients.setEnabled(false);
                break;
            case "Change": 
                name = textName.getText();
                client.sendMessageToServer("NAME " + name);
                textName.setText( client.getName() );
                textName.setEditable(false);
                textClient.setEditable(true);
                buttonListFriends.setEnabled(true);
                buttonSend.setEnabled(true);
                buttonName.setText("Name");
                listConnectedClients.setEnabled(true);
        }
    }//GEN-LAST:event_buttonNameActionPerformed

    public void changeName(String m){
        textName.setText(m);
        setTitle();
    }
    
    public void setTitle(){
        this.setTitle("Client " + client.getName() );
    } 
    
    public void start(){
        buttonName.setText("Name");
        buttonConnect.setEnabled(true);
        buttonListFriends.setEnabled(true);
        textClient.setEditable(true);
        buttonSend.setEnabled(true);
        textName.setEditable(false);
        listConnectedClients.setEnabled(true);
        client.setNume( textName.getText() );
        client.sendMessageToServer("LIST");
    }
    
    public void showServerMessage( String message ){
        textServer.append(message);
        textServer.setCaretPosition(textServer.getText().length() - 1);
    }
    
    public void showChatGroupMessage(String message ){
        try{
            String[] words = message.split(":");        
            words[1] = decrypt(words[1], OFFSET);
            words[0] = words[0]+": ";        
            StringBuilder builder = new StringBuilder();
            for(String s : words){
                builder.append(s);
            }
            message = builder.toString();
        }catch(Exception e) {
            e.printStackTrace();
        }
        textGroupChat.append(message+"\n");
        textGroupChat.setCaretPosition(textGroupChat.getText().length() - 1);
    }
    
    public void showUsersList(final ArrayList<String> currentUserList){
        ListModel model = new AbstractListModel(){
            ArrayList<String> list = currentUserList;

            @Override
            public int getSize(){
                return list.size();
            }

            @Override
            public Object getElementAt(int index){
                return (index+1) + ") " + list.get(index);
            }
        };
        listConnectedClients.setModel(model);
    }
    
    public void init(){
        textAdress.setText(address);
        textAdress.setEditable(true);
        textPort.setText(""+port);
        textPort.setEditable(true);
        listConnectedClients.setEnabled(false);
        buttonListFriends.setEnabled(false);
        textClient.setEditable(false);
        buttonSend.setEnabled(false);
        buttonName.setEnabled(false);
        textName.setEditable(false);
        buttonConnect.setEnabled(true);
    }
    
    public void disconnect(){
        init();
        textGroupChat.setText("");
        textName.setText("");
        setTitle();
        ArrayList<String> s = new ArrayList<>();
        showUsersList(s);
        buttonConnect.setText("Connect");
        client = null;     
        this.setTitle("Client");
    }
    
    public String encrypt(String msg, int offset) throws IOException
    {
        char chars[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','!','@','#','$','%','^','&','(',')','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','+','-','*','/','[',']','{','}','=','<','>','?','_'};
        String cipher = null;
        char[] plain = msg.toCharArray(); 

        for(int i = 0;i<plain.length;i++){
            for(int j = 0 ; j<chars.length;j++){
                if(j<=80){
                    if(plain[i]==chars[j]){
                        plain[i] = chars[j+5];
                        break;
                    }  
                }
                else if(plain[i] == chars[j]){
                    plain[i] = chars [j-81];
                } 
            } 
        } 
        cipher = String.valueOf(plain);
        System.out.println("cipher text is "+cipher);  
        return cipher;
    }
    
    
    public String decrypt(String msg, int offset) throws IOException
    {
        char chars[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','!','@','#','$','%','^','&','(',')','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','+','-','*','/','[',']','{','}','=','<','>','?','_'};
        String cipher = null;
        String empty = "empty";
        char[] cipher1 = msg.toCharArray();

        for(int i = 0;i<cipher1.length;i++){
              for(int j=0 ; j<chars.length;j++){
                if(j>=5 && cipher1[i]==chars[j]){
                    cipher1[i] = chars[j-5];
                    break;
                }
                if(cipher1[i] == chars[j] && j<5){
                    cipher1[i] = chars[81+j];
                    break;
                } 
            } 
        } 
        
        cipher=String.valueOf(cipher);
        return cipher;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new ClientGUI("localhost",44).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnect;
    private javax.swing.JButton buttonListFriends;
    private javax.swing.JButton buttonName;
    private javax.swing.JButton buttonSend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelAdress;
    private javax.swing.JLabel labelConnectedClients;
    private javax.swing.JLabel labelGroupChat;
    private javax.swing.JLabel labelMessage;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPort;
    private javax.swing.JLabel labelServer;
    private javax.swing.JList listConnectedClients;
    private javax.swing.JTextField textAdress;
    private javax.swing.JTextField textClient;
    private javax.swing.JTextArea textGroupChat;
    private javax.swing.JTextField textName;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textPort;
    private javax.swing.JTextArea textServer;
    // End of variables declaration//GEN-END:variables
}
