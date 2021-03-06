/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class MonopolyGameBoard1 extends javax.swing.JFrame {
    MonopolyGame mpNew = MonopolyGame.getMonopolyGame();
    /**
     * Creates new form MonopolyGameBoard1
     */
    public MonopolyGameBoard1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rollButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDisplayArea = new javax.swing.JTextPane();
        BoardImage = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Monopoly Game");
        setIconImages(null);
        setResizable(false);

        rollButton.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        rollButton.setText("Roll");
        rollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollButtonActionPerformed(evt);
            }
        });

        textDisplayArea.setEditable(false);
        textDisplayArea.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(textDisplayArea);

        BoardImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monopoly/board.jpg"))); // NOI18N
        BoardImage.setOpaque(true);

        updateButton.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(updateButton)))
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(BoardImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BoardImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*
        Observer
    */
    private void rollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollButtonActionPerformed
        playGame(mpNew);
    }//GEN-LAST:event_rollButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        List<Player> players = mpNew.getPlayers();
        
        Player p;
        if(players.get(0).getPlayerTurn() > players.get(1).getPlayerTurn())
        {
            p =  players.get(0);
        }
        else
        {
            p =  players.get(1);
        }
        
        this.textDisplayArea.setText(/*"Player "+players.get(0).getName()+ " turn, number of rounds: " + mpNew.getRoundsPlayed() + "\n " + */
                        "Player "+players.get(0).getName()+" Location: " + players.get(0).getLocation().getIndex() + "\n"
                        +"Player "+players.get(1).getName()+" Location: " + players.get(1).getLocation().getIndex() + "\n"
                        + "It is player " + p.getName() + "'s turn \n" +
                                "Round: " + mpNew.getRoundsPlayed());
        
    }//GEN-LAST:event_updateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MonopolyGameBoard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonopolyGameBoard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonopolyGameBoard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonopolyGameBoard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MonopolyGameBoard1().setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BoardImage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rollButton;
    private javax.swing.JTextPane textDisplayArea;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
public void loading(MonopolyGame load){
    mpNew = load;
}
    
    
public void playGame(MonopolyGame game)
    {
        List<Player> players = game.getPlayers();
        
        SaveCSV saveCSV = new SaveCSV();
        SaveCSVAdpater saveCSVAdapater = new SaveCSVAdpater(saveCSV); //adapater implementation
      
        game.setRoundsPlayed(game.getRoundsPlayed());
        int roundsPlayed = game.getRoundsPlayed();
        DBentry dbEntry = new DBentry();
//
//        this.textDisplayArea.setText("Player "+players.get(0).getName()+ " turn, number of rounds: " + game.getRoundsPlayed() + "\n "
//                        +"Player "+players.get(0).getName()+" Location" + players.get(0).getLocation().getIndex() + "\n "
//                        +"Player "+players.get(1).getName()+" Location" + players.get(1).getLocation().getIndex());
//        
        if(roundsPlayed < game.getRoundsTotal()){
            if(players.get(0).getPlayerTurn() == 1){
                this.textDisplayArea.setText("Player "+players.get(0).getName()+ " just went, number of rounds: " + game.getRoundsPlayed() + "\n"
                        +"Player "+players.get(0).getName()+" Location: " + players.get(0).getLocation().getIndex() + "\n"
                        +"Player "+players.get(1).getName()+" Location: " + players.get(1).getLocation().getIndex()
                        );
             //   this.textDisplayArea.setText("Player "+players.get(0).getName()+" Location" + players.get(0).getLocation().getIndex());
             //   this.textDisplayArea.setText("Player "+players.get(1).getName()+" Location" + players.get(1).getLocation().getIndex());
                players.get(0).takeTurn();
                players.get(0).setPlayerTurn(0);
                players.get(1).setPlayerTurn(1);
                game.setPlayers(players); 
                 
                try {
                    saveCSVAdapater.storeGame(players.get(0).getName(),players.get(0).getLocation(),players.get(0).getPlayerTurn(),
                    players.get(1).getName(),  players.get(1).getLocation(), players.get(1).getPlayerTurn(),game.getRoundsPlayed());
                    dbEntry.insert(players.get(0).getName(), players.get(0).getLocation().getIndex(), players.get(0).getPlayerTurn(), game.getRoundsPlayed());
                    dbEntry.insert(players.get(1).getName(), players.get(1).getLocation().getIndex(), players.get(1).getPlayerTurn(), game.getRoundsPlayed());
                } 
                catch (IOException ex){
                    Logger.getLogger(Monopoly.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else{    
                this.textDisplayArea.setText("Player "+players.get(1).getName()+ " just went, number of rounds: " + game.getRoundsPlayed() + "\n"
                        +"Player "+players.get(0).getName()+" Location: " + players.get(0).getLocation().getIndex() + "\n"
                        +"Player "+players.get(1).getName()+" Location: " + players.get(1).getLocation().getIndex()
                        );


                players.get(1).takeTurn();
                players.get(0).setPlayerTurn(1);
                players.get(1).setPlayerTurn(0);
                roundsPlayed++;
                game.setRoundsPlayed(roundsPlayed); 
                game.setPlayers(players); 
                try{
                    saveCSVAdapater.storeGame(players.get(0).getName(),players.get(0).getLocation(),players.get(0).getPlayerTurn(),
                    players.get(1).getName(),  players.get(1).getLocation(), players.get(1).getPlayerTurn(),game.getRoundsPlayed());
                    dbEntry.insert(players.get(0).getName(), players.get(0).getLocation().getIndex(), players.get(0).getPlayerTurn(), game.getRoundsPlayed());
                    dbEntry.insert(players.get(1).getName(), players.get(1).getLocation().getIndex(), players.get(1).getPlayerTurn(), game.getRoundsPlayed());
                } 
                catch (IOException ex){
                    Logger.getLogger(Monopoly.class.getName()).log(Level.SEVERE, null, ex);
                }
            }         
        }
        //Players have played the ROUNDS_TOTAL worth of turns so the game is now over
        else{
            this.textDisplayArea.setText("Game over, the max number of rounds that can be"
                    + " played is " + game.getRoundsPlayed() + ". We hope you enjoyed our game!");
            this.rollButton.setEnabled(false);
        }
    }

}
