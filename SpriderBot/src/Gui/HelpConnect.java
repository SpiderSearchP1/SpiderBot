/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import TCP_IP.Cliente;

/**
 *
 * @author osboxes
 */
public class HelpConnect extends javax.swing.JFrame {

    /**
     * Creates new form HelpConnect
     */
    public HelpConnect() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        OPMenu = new javax.swing.JMenu();
        OPBack = new javax.swing.JMenuItem();
        OPOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 670));
        getContentPane().setLayout(null);

        jLabel1.setText("Información");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(27, 24, 114, 25);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Puntos de interes: \n\t1. Menu de opciones: contiene varios puntos:\n\t\tA. Ayuda: accede a esta ventana, para obtener informacion de como poder \n\t\t                  usar la ventana de conexión con el servidor.\n\t\tB. Devolverse: vuelve a la pagina principal para hacer busquedas.\n\t\tC. Salir: cierra todo el programa.\n\t2. Barra para el IP: barra para ingresar el ip del servidor y realizar una conexión con este.\n\t3. Barra para el puerto: barra en la que se ingresa el numero de puerto en el que esta traba-\n\t\t               jando el servidor.\n\t4. Conectar: sirve para realizar la conexion con el servidor; emitira una respuesta si la cone-\n\t                       xion con el servidor es positiva o negativa.");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(27, 55, 1022, 174);

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/osboxes/NetBeansProjects/SpiderBot/SpriderBot/pantalla3.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 250, 620, 350);

        OPMenu.setText("Options");

        OPBack.setText("Devolverse");
        OPBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPBackActionPerformed(evt);
            }
        });
        OPMenu.add(OPBack);

        OPOut.setText("Salir");
        OPOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPOutActionPerformed(evt);
            }
        });
        OPMenu.add(OPOut);

        jMenuBar1.add(OPMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OPOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPOutActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_OPOutActionPerformed

    private void OPBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPBackActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_OPBackActionPerformed

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
            java.util.logging.Logger.getLogger(HelpConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HelpConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HelpConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HelpConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HelpConnect().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OPBack;
    private javax.swing.JMenu OPMenu;
    private javax.swing.JMenuItem OPOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
