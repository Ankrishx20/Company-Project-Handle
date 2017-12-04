import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
public class submit_module_date extends javax.swing.JFrame {
    
    static java.util.Date compdate=null,dline=null;

    public submit_module_date() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        doc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        deadline = new javax.swing.JLabel();
        mid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Date of completion");

        doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docActionPerformed(evt);
            }
        });

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Deadline");

        deadline.setText("Here");

        jLabel4.setText("Module ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deadline)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jButton1)))
                        .addGap(524, 524, 524))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mid, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doc))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(deadline))
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addContainerGap(249, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docActionPerformed
        
    }//GEN-LAST:event_docActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
      try 
      {
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        String comp= doc.getText();
        String moduleid=mid.getText();
        if((comp.isEmpty()) || (moduleid.isEmpty()))
	{
	  JOptionPane.showMessageDialog(null,"Empty Fields Detected");
	}
	else
	{
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/comp_project","root","ankrish123");
            PreparedStatement pstmt=con.prepareStatement("select mdeadline from module where m_id=?");
            pstmt.setString(1,moduleid);
            ResultSet rs= pstmt.executeQuery();
            String date;
            while(rs.next())
            {
                date=rs.getString("mdeadline");
                dline=format1.parse(date);
                deadline.setText(date);
            }
            }
            catch(Exception e)
            {
                
            }
        }
        
          try 
          {
              compdate=format1.parse(comp);
              if(compdate.after(dline))
              {
                 JOptionPane.showMessageDialog(null,"Completed Date Exceeded the Deadline");
                 
              }
              else if(compdate.before(dline) || compdate.equals(dline))
              {
                  JOptionPane.showMessageDialog(null,"Module Completed on Time");
                  func(comp, moduleid);
                  func1();
              }
          } 
          catch (Exception e) 
          {
          }
        
      }
      catch(Exception e)
      {}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public void func(String cdate,String mid)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/comp_project","root","ankrish123");
            PreparedStatement pstmt=con.prepareStatement("update module set assgn_m_com= 1, m_comp_date=' "+cdate+" ' where m_id='"+mid+"'");       
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Completed Date entered successfully");
            pstmt.close();
            con.close();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Problem with connection");
        }
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
            java.util.logging.Logger.getLogger(submit_module_date.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(submit_module_date.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(submit_module_date.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(submit_module_date.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new submit_module_date().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deadline;
    private javax.swing.JTextField doc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField mid;
    // End of variables declaration//GEN-END:variables
}
