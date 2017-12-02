public class Frontpage extends javax.swing.JFrame {

    public Frontpage() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Heading = new javax.swing.JLabel();
        Admin_front = new javax.swing.JButton();
        SoftwareMan_front = new javax.swing.JButton();
        Developer_front = new javax.swing.JButton();
        admin = new javax.swing.JLabel();
        softwaremanager = new javax.swing.JLabel();
        dev = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome Screen");
        setLocation(new java.awt.Point(400, 200));
        setMinimumSize(new java.awt.Dimension(1045, 640));
        setResizable(false);

        jPanel1.setLayout(null);

        Heading.setFont(new java.awt.Font("Product Sans", 0, 36)); // NOI18N
        Heading.setForeground(new java.awt.Color(255, 255, 255));
        Heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Heading.setText("COMPANY PROJECTS HANDLER");
        jPanel1.add(Heading);
        Heading.setBounds(0, 60, 1040, 90);

        Admin_front.setFont(new java.awt.Font("Product Sans", 0, 24)); // NOI18N
        Admin_front.setText("Admin");
        Admin_front.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admin_frontActionPerformed(evt);
            }
        });
        jPanel1.add(Admin_front);
        Admin_front.setBounds(120, 460, 140, 46);

        SoftwareMan_front.setFont(new java.awt.Font("Product Sans", 0, 24)); // NOI18N
        SoftwareMan_front.setText("Software Manager");
        SoftwareMan_front.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoftwareMan_frontActionPerformed(evt);
            }
        });
        jPanel1.add(SoftwareMan_front);
        SoftwareMan_front.setBounds(400, 460, 240, 46);

        Developer_front.setFont(new java.awt.Font("Product Sans", 0, 24)); // NOI18N
        Developer_front.setText("Developer");
        Developer_front.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Developer_frontActionPerformed(evt);
            }
        });
        jPanel1.add(Developer_front);
        Developer_front.setBounds(770, 460, 150, 46);

        admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin-user-icon.png"))); // NOI18N
        jPanel1.add(admin);
        admin.setBounds(110, 250, 160, 170);

        softwaremanager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/software project manager.png"))); // NOI18N
        jPanel1.add(softwaremanager);
        softwaremanager.setBounds(390, 200, 240, 240);

        dev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Developer.png"))); // NOI18N
        jPanel1.add(dev);
        dev.setBounds(720, 220, 270, 240);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zeetashop_contact.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1050, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Admin_frontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admin_frontActionPerformed
        
       Admin_login a=new Admin_login();
       a.setVisible(true);    
       this.setVisible(false);
       
    }//GEN-LAST:event_Admin_frontActionPerformed

    private void SoftwareMan_frontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoftwareMan_frontActionPerformed
      Manager_login ml=new Manager_login();
      ml.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_SoftwareMan_frontActionPerformed

    private void Developer_frontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Developer_frontActionPerformed
        Developer_login dl=new Developer_login();
        dl.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Developer_frontActionPerformed

    public static void main(String args[]) {
       
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
            java.util.logging.Logger.getLogger(Frontpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frontpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frontpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frontpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frontpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Admin_front;
    private javax.swing.JButton Developer_front;
    private javax.swing.JLabel Heading;
    private javax.swing.JButton SoftwareMan_front;
    private javax.swing.JLabel admin;
    private javax.swing.JLabel dev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel softwaremanager;
    // End of variables declaration//GEN-END:variables
}
