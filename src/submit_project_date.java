
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class submit_project_date extends javax.swing.JFrame {

    static java.util.Date compdate=null,dline=null;
    
    public submit_project_date() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pcomp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pid = new javax.swing.JTextField();
        projectdeadline = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter Project Complete date");

        jLabel2.setText("Enter Project Id");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        projectdeadline.setText("Project Deadline");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pcomp)
                            .addComponent(pid, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(projectdeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pcomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(projectdeadline)
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
      try 
      {
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        String comp= pcomp.getText();
        String projectid=pid.getText();
        if((comp.isEmpty()) || (projectid.isEmpty()))
	{
	  JOptionPane.showMessageDialog(null,"Empty Fields Detected");
	}
	else
	{
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/comp_project","root","ankrish123");
            PreparedStatement pstmt=con.prepareStatement("select deadline from project_imp where p_id=?");
            pstmt.setString(1,projectid);
            ResultSet rs= pstmt.executeQuery();
            String date;
            while(rs.next())
            {
                date=rs.getString("deadline");
                dline=format1.parse(date);
                projectdeadline.setText(date);
            }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Problem with connection");
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
                  JOptionPane.showMessageDialog(null,"Project Completed on Time");
                  func(comp,projectid);
              }
          } 
          catch (Exception e) 
          {
          }
        
      }
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,"Problem");
      }
        
    }                                        

    public void func(String cdate,String pid)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/comp_project","root","ankrish123");
            PreparedStatement pstmt=con.prepareStatement("update project_imp set assgn_p_com= 1, p_comp_date=' "+cdate+" ' where p_id='"+pid+"'");       
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Completed Date entered successfully");
            pstmt.close();
            con.close();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Problem with connection");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(submit_project_date.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(submit_project_date.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(submit_project_date.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(submit_project_date.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new submit_project_date().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField pcomp;
    private javax.swing.JTextField pid;
    private javax.swing.JLabel projectdeadline;
    // End of variables declaration//GEN-END:variables
}
