/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libdb.subadmin;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author SANEM
 */
public class addBookCopy3 extends javax.swing.JFrame {

    Connection con;
    String isbn;
    /**
     * Creates new form addBookCopy3
     */
    public addBookCopy3() {
        initComponents();
    }
    
    public addBookCopy3(Connection c, String is) {
        initComponents();
        this.con = c;
        this.isbn = is;
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
        branchcom = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        poscom = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BRANCH");

        branchcom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Miller", "Domino", "Grease", "Helmet", "Circle", "Ted's", "Kramer", "Joyce", "Gyoza", "Kimchi", "Wall", "Battery", "Shake", "Eataly", "Lobster Tail", "Dumbo", "Park Slope", "Sunny", "Wood", "Island", "Brooklyn College" }));

        jLabel2.setText("POSITION");

        jButton1.setText("NEXT>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        poscom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "001A10", "002A10", "003A10", "004A10", "005A10", "006A10", "007A10", "008A10", "009A10", "001A09", "002A09", "003A09", "004A09", "005A09", "006A09", "007A09", "008A09", "009A09" }));

        jButton2.setText("<<BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addComponent(branchcom, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(poscom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {branchcom, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(branchcom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(poscom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(27, 27, 27))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {branchcom, jLabel1, poscom});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String br = branchcom.getSelectedItem().toString();
        String pos = poscom.getSelectedItem().toString();
        String bid = "";
        Statement st;
        int autoIncKeyFromApi = -1;
        try {
            st = this.con.createStatement();
            String q = "select * from branch where name ='"+br+"'";
        ResultSet bs = st.executeQuery(q);
        while(bs.next()){
           bid = bs.getString("branchid");
        }
        bs.close();
        
        Statement stmt = this.con.createStatement();
        stmt.executeUpdate(
                 "INSERT INTO book (isbn) "
                  + "values ('"+this.isbn+"')",
                 Statement.RETURN_GENERATED_KEYS);

       ResultSet rs = stmt.getGeneratedKeys();
       if (rs.next()) {
           autoIncKeyFromApi = rs.getInt(1);
       }
            rs.close(); 
       
        String query = " insert into location (bookid, branchid, position)"
                         + " values (?, ?, ?)";

        PreparedStatement preparedStatement = con
                 .prepareStatement(query);
        preparedStatement.setInt(1, autoIncKeyFromApi);
        preparedStatement.setString(2, bid);
        preparedStatement.setString(3, pos);

        preparedStatement.execute();
        int copy = 0;
        Statement s = this.con.createStatement();
        String q1 = "select * from copy where branchid ='"+bid+"' AND isbn ='"+this.isbn+"'";
        ResultSet res = s.executeQuery(q1);
        if(res.next() == false){
            copy = 1;
            String q2 = " insert into copy (branchid, isbn, numcopy)"
                         + " values (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(q2);
            ps.setString(1, bid);
            ps.setString(2, this.isbn);
            ps.setInt(3, copy);

            ps.execute();
        }else
        {
           
             copy = res.getInt("numcopy");
             System.out.println("****"+res.getInt("numcopy"));
             copy++;
            System.out.println(copy);
            PreparedStatement updateEXP = con.prepareStatement("update copy set numcopy= '"+copy+"' where branchid='"+bid+"' AND isbn = '"+this.isbn+"'");
            
            updateEXP.execute();
        }
        res.close();
            

       
       } catch (SQLException ex) {
           Logger.getLogger(addBookCopy3.class.getName()).log(Level.SEVERE, null, ex);
       }
          dispose();
          JOptionPane op = new JOptionPane();
          op.setMessage(" A Copy of the Book has been added to the system");
          op.setMessageType(1);
          JDialog dia = op.createDialog(null,"Error");
          dia.setTitle("COMPLETED");
          dia.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(addBookCopy3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addBookCopy3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addBookCopy3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addBookCopy3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addBookCopy3().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox branchcom;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox poscom;
    // End of variables declaration//GEN-END:variables
}
