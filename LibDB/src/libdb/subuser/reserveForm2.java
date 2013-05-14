/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libdb.subuser;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author SANEM
 */
public class reserveForm2 extends javax.swing.JFrame {
    Connection con;
    String id;
    private PreparedStatement preparedStatement;
    /**
     * Creates new form reserveForm2
     */
    public reserveForm2() {
        initComponents();
    }
    public reserveForm2(Connection c, String s) {
        initComponents();
        this.con = c;
        this.id = s;
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        branchcom = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        branchcom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "                         ", "Miller, Downtown", "Domino, Mid West", "Grease, Upper East", "Helmet, Upper West", "Circle, Midtown", "Ted's, Gramercy", "Kramer, Kips Bay", "Joyce, Murray Hill", "Gyoza, Chinatown", "Kimchi, KTown", "Wall, Financial District", "Battery, Battery Park", "Shake, Harlem", "Eataly, East Willage", "Lobster Tail, Chelsea", "Dumbo, Brooklyn", "Park Slope, Brooklyn", "Sunny, Queens", "Wood, Queens", "Island, Roosevelt", "Brooklyn College, Brooklyn" }));
        branchcom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchcomActionPerformed(evt);
            }
        });

        jLabel2.setText("BRANCH");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<< BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(branchcom, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(branchcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String book = jList1.getSelectedValue().toString();
        book = book.substring(book.indexOf(':')+2,book.indexOf('T')-1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String da = dateFormat.format(date);
        try {
             // the mysql insert statement
         String query = " insert into reserve (readerid, bookid, date)"
                         + " values (?, ?, ?)";

            preparedStatement = con
                 .prepareStatement(query);
            preparedStatement.setString(1, this.id);
            preparedStatement.setString(2, book);
            preparedStatement.setString(3, da);
           

          preparedStatement.execute();
          
          dispose();
          JOptionPane op = new JOptionPane();
          op.setMessage("The book "+book+" will remain reserved for 24 hours for you!");
          op.setMessageType(1);
          JDialog dia = op.createDialog(null,"INFO");
          dia.setTitle("RESERVED");
          dia.setVisible(true);

        } catch (SQLException e) {
            System.err.println("ERROR: "+e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void branchcomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchcomActionPerformed
        try {
            List<String> books = new ArrayList();
            DefaultListModel dl = new DefaultListModel();
            jList1.setModel(dl);
            String s = branchcom.getSelectedItem().toString();
            s = s.substring(0,s.indexOf(","));
            String query = "Select * from branch where name = '"+s+"'";
            ResultSet res = this.con.createStatement().executeQuery(query);
            while(res.next()){
                String q1 = "Select * from location where branchid = '"+res.getString("branchid")+"'";
                ResultSet r1 = this.con.createStatement().executeQuery(q1);
                while(r1.next()){
                    System.out.println(r1.getString("bookid"));
                    books.add(r1.getString("bookid"));
                }r1.close();
            }res.close();
            List<String> books2 = new ArrayList();
            for(String bo:books){
                String q2 = "Select * from borrow where bookid = '"+bo+"'";
                ResultSet r3 = this.con.createStatement().executeQuery(q2);
                while(r3.next()){
                    if(r3.getString("rdate") == null){
                        books2.add(bo);
                    }
                }
            }
            System.out.println(books2.size());
            for(String bo:books){
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String da = dateFormat.format(date);
                String q2 = "Select * from reserve where bookid = '"+bo+"'";
                ResultSet r3 = this.con.createStatement().executeQuery(q2);
                while(r3.next()){
                    if( !r3.getString("date").equals(da) ){
                        books2.add(bo);
                    }
                }
            }
            books.removeAll(books2);
            for(String bf : books){
                System.out.println(books);
            }
            if(books.size() == 0){
                dispose();
                JOptionPane op = new JOptionPane();
                op.setMessage("There are no available books at this time in that branch");
                op.setMessageType(0);
                JDialog dia = op.createDialog(null,"Error");
                dia.setTitle("OOPS");
                dia.setVisible(true);
            }else{
                List<String> names = new ArrayList();
                for(String b: books){
                    String q5 = "Select * from book where bookid='"+b+"'";
                    ResultSet r5 = this.con.createStatement().executeQuery(q5);
                    while(r5.next()){
                        String q6 = "Select * from bookinfo where isbn='"+r5.getString("isbn")+"'";
                        ResultSet r6 = this.con.createStatement().executeQuery(q6);
                        while (r6.next()){
                            names.add(r6.getString("title"));
                        }r6.close();
                    }r5.close();
                }
                for(int i = 0 ; i<names.size() ; i++){
                   dl.addElement("ID: "+books.get(i)+" TITLE: "+names.get(i));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reserveForm2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_branchcomActionPerformed

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
            java.util.logging.Logger.getLogger(reserveForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reserveForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reserveForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reserveForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reserveForm2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox branchcom;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

  
    
}
