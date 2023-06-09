/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Generic;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Lenovo
 */
public class Playlist extends javax.swing.JFrame {

    KoleksiMusik koleksi = new KoleksiMusik();

    private void resizeListener() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeColumns();
            }
        });
    }

    private void resizeColumns() {
        float[] columnWidthPercentage = {90.0f, 10.0f};
        int tW = tblPlaylist.getWidth();
        TableColumn column;
        TableColumnModel jTableColumnModel = tblPlaylist.getColumnModel();
        int cantCols = jTableColumnModel.getColumnCount();
        for (int i = 0; i < cantCols; i++) {
            column = jTableColumnModel.getColumn(i);
            int pWidth = Math.round(columnWidthPercentage[i] * tW);
            column.setPreferredWidth(pWidth);
            tblPlaylist.setRowHeight(27);
        }
    }

    private String fileSizeOf(File file) {
        DecimalFormat format = new DecimalFormat("#.##");
        long MB = 1024 * 1024;
        long KB = 1024;
        final double length = file.length();
        if (length > MB) {
            return format.format(length / MB) + " MB";
        }
        if (length > KB) {
            return format.format(length / KB) + " KB";
        }
        return format.format(length) + " B";
    }

    private String extensionOf(File file) {
        String fileExtension = "";
        String fileName = file.getName();
        if (fileName.contains(".") && fileName.lastIndexOf(".") != 0) {
            fileExtension
                    = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return fileExtension;
    }

    private void addFiles(File[] files) {
        for (File file : files) {
            String path = file.getAbsolutePath();
            String fn = file.getName();
            String fileName = fn.substring(0, fn.length() - 4);
            String fileSize = fileSizeOf(file);
            String extension = "";
            int i = path.lastIndexOf('.');
            if (i > 0) {
                extension = extensionOf(file);
            }
            Musik m = new Musik(path, fileName, fileSize, extension);
            koleksi.add(m);
        }
    }

    private void addFolder(File dir) {
        File[] listOfFiles = dir.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String path = listOfFile.getAbsolutePath();
                String fn = listOfFile.getName();
                String fileName = fn.substring(0, fn.length() - 4);
                String fileSize = fileSizeOf(listOfFile);
                String extension;
                int i = path.lastIndexOf('.');
                if (i > 0) {
                    extension = extensionOf(listOfFile);
                    if ("mp3".equalsIgnoreCase(extension)) {
                        Musik m = new Musik(path, fileName, fileSize, extension);
                        koleksi.add(m);
                    }
                }
            } else if (listOfFile.isDirectory()) {
                addFolder(listOfFile);
            }
        }
    }

    /**
     * Creates new form Document
     */
    public Playlist() {
        initComponents();
        tblPlaylist.setModel (koleksi);
        resizeColumns();
        resizeListener();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupTombol = new javax.swing.JPopupMenu();
        addFiles = new javax.swing.JMenuItem();
        addFolder = new javax.swing.JMenuItem();
        ClearPlaylist = new javax.swing.JMenuItem();
        pnFooter = new javax.swing.JPanel();
        btnPlaylist = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlaylist = new javax.swing.JTable();

        addFiles.setText("addFile(s)");
        addFiles.setAutoscrolls(true);
        addFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFilesActionPerformed(evt);
            }
        });
        popupTombol.add(addFiles);

        addFolder.setText("addFolder");
        addFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFolderActionPerformed(evt);
            }
        });
        popupTombol.add(addFolder);

        ClearPlaylist.setText("ClearPlaylist");
        popupTombol.add(ClearPlaylist);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnFooter.setOpaque(false);
        pnFooter.setPreferredSize(new java.awt.Dimension(495, 50));

        btnPlaylist.setText("Playlist");
        btnPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaylistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFooterLayout = new javax.swing.GroupLayout(pnFooter);
        pnFooter.setLayout(pnFooterLayout);
        pnFooterLayout.setHorizontalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPlaylist)
                .addContainerGap(417, Short.MAX_VALUE))
        );
        pnFooterLayout.setVerticalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFooterLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnPlaylist)
                .addContainerGap())
        );

        getContentPane().add(pnFooter, java.awt.BorderLayout.PAGE_END);

        tblPlaylist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPlaylist);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaylistActionPerformed
        // TODO add your handling code here:
        popupTombol.show(btnPlaylist,
                btnPlaylist.getWidth(),
                btnPlaylist.getHeight()/2);
    }//GEN-LAST:event_btnPlaylistActionPerformed

    private void addFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFilesActionPerformed


        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);
        fc.setDialogTitle("Add Files");
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileFilter(new FileNameExtensionFilter("MP# File (*.mp3)","mp3"));
        fc.setApproveButtonText("Add Files");
        int show = fc.showOpenDialog(this);
        if(show == JFileChooser.APPROVE_OPTION){
            File[] files = fc.getSelectedFiles();
            addFiles(files);
        }
        
        
    }//GEN-LAST:event_addFilesActionPerformed

    private void addFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFolderActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.DIRECTORIES_ONLY);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Add Folder0");
        fc.setApproveButtonText("Add Files");        
        int show = fc.showOpenDialog(this);
        if(show == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            addFolder(file);
        }
    }//GEN-LAST:event_addFolderActionPerformed

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
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Playlist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ClearPlaylist;
    private javax.swing.JMenuItem addFiles;
    private javax.swing.JMenuItem addFolder;
    private javax.swing.JButton btnPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnFooter;
    private javax.swing.JPopupMenu popupTombol;
    private javax.swing.JTable tblPlaylist;
    // End of variables declaration//GEN-END:variables
}
