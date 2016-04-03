package ChatGUI;

import java.awt.Color;

public class PopUp extends javax.swing.JFrame{

    Client client;
    String receiver, name;
    
    PopUp(String receiver, String name, Client client){
        super(name + "'s messages with " + receiver);
        initComponents();
        setDefaultCloseOperation(PopUp.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#102E37"));
        
        this.receiver = receiver;
        this.name = name;
        this.client = client;
        textConversation.setEditable(false);
        labelConversation.setText("Private chat with " + receiver);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textClient = new javax.swing.JTextField();
        buttonSend = new javax.swing.JButton();
        JScrollPane = new javax.swing.JScrollPane();
        textConversation = new javax.swing.JTextArea();
        labelConversation = new javax.swing.JLabel();
        labelMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        textClient.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textClientActionPerformed(evt);
            }
        });

        buttonSend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonSend.setText("Send");
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });

        textConversation.setColumns(20);
        textConversation.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textConversation.setRows(5);
        JScrollPane.setViewportView(textConversation);

        labelConversation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelConversation.setForeground(new java.awt.Color(255, 255, 255));
        labelConversation.setText("Conversation");

        labelMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMessage.setForeground(new java.awt.Color(255, 255, 255));
        labelMessage.setText("Mesaj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JScrollPane)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textClient, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(buttonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelConversation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelConversation, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addComponent(labelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textClient, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textClientActionPerformed
        
        String s = textClient.getText();
        showMessage(this.name + ": " + s );
        client.sendMessageToServer("MSG " + receiver + " " + s );
        textClient.setText("");
    }//GEN-LAST:event_textClientActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendActionPerformed
        
        String s = textClient.getText();
        showMessage(name + ": " + s );
        client.sendMessageToServer("MSG " + receiver + " " + s );
        textClient.setText("");
    }//GEN-LAST:event_buttonSendActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    
        client.closeWindow(receiver, this);
    }//GEN-LAST:event_formWindowClosing

    public void showMessage(String message){
        textConversation.append(message + "\n");
        textConversation.setCaretPosition(textConversation.getText().length() - 1);
    }
    
    public void changeNume(String newName){
        this.setTitle(newName + "'s messages with" + receiver );
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton buttonSend;
    private javax.swing.JLabel labelConversation;
    private javax.swing.JLabel labelMessage;
    private javax.swing.JTextField textClient;
    private javax.swing.JTextArea textConversation;
    // End of variables declaration//GEN-END:variables
}
