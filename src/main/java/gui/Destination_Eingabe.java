/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 * Dialog für die Eingabe einer Destination
 * @author lukas
 */
public class Destination_Eingabe extends javax.swing.JDialog {

    /**
     * Creates new form Destination_Eingabe
     */
    private String destination;
    private boolean isOkay;
    
    public Destination_Eingabe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        isOkay = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfdesti = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Abbrechen = new javax.swing.JButton();
        Adden = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Destination");
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        tfdesti.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdesti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdestiActionPerformed(evt);
            }
        });
        getContentPane().add(tfdesti);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        Abbrechen.setText("Abort");
        Abbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbbrechenActionPerformed(evt);
            }
        });
        jPanel1.add(Abbrechen);

        Adden.setText("Adden");
        Adden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddenActionPerformed(evt);
            }
        });
        jPanel1.add(Adden);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdestiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdestiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdestiActionPerformed

    /**
     * Methode zum Abbrechen 
     * @param evt 
     */
    private void AbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbbrechenActionPerformed
        isOkay = false;
        dispose();
    }//GEN-LAST:event_AbbrechenActionPerformed

    /**
     * Methode zum hinzufügen einer Destination
     * @param evt 
     */
    private void AddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddenActionPerformed
        try {
            destination = tfdesti.getText();
            isOkay=false;
            dispose();
        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_AddenActionPerformed

    /**
     * Destination bekommen
     * @return 
     */
    public String getDestination() {
        return destination;
    }

    /**
     * IsOkay-Boolean für die WeatherGUI
     */
    public boolean isIsOkay() {
        return isOkay;
    }

    
    
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
            java.util.logging.Logger.getLogger(Destination_Eingabe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Destination_Eingabe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Destination_Eingabe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Destination_Eingabe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Destination_Eingabe dialog = new Destination_Eingabe(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abbrechen;
    private javax.swing.JButton Adden;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfdesti;
    // End of variables declaration//GEN-END:variables
}