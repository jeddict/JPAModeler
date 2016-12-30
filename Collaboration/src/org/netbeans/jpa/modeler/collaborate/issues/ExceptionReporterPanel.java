/**
 * Copyright [2016] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.jpa.modeler.collaborate.issues;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.netbeans.jpa.modeler.collaborate.issues.ExceptionUtils.ISSUES_URL;
import org.netbeans.jpa.modeler.network.social.SharingHelper;
import org.netbeans.modeler.core.ModelerFile;
import org.netbeans.modeler.properties.window.GenericDialog;
import org.openide.awt.NotificationDisplayer;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import static org.openide.util.NbBundle.getMessage;
import org.openide.windows.WindowManager;

/**
 *
 * @author Gaurav Gupta
 */
public class ExceptionReporterPanel extends GenericDialog {

    private final static String buttonText = "<html>Click here to copy logs and report bug </html>";
    private final static String buttonAttachText = "<html>Click here to copy logs and report bug (please attach modeler file)</html>";

    private final String bugDescription;

    private final ModelerFile file;
    private final Throwable throwable;

    public ExceptionReporterPanel(String bugDescription, Throwable throwable, ModelerFile file) {
        super((Frame) WindowManager.getDefault().getMainWindow(), getMessage(ExceptionReporterPanel.class, "ExceptionReporterPanel.title"),true);
        this.file = file;
        this.throwable = throwable;
        this.bugDescription = bugDescription;
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

        root = new javax.swing.JLayeredPane();
        iconLabel = new javax.swing.JLabel();
        actionPane = new javax.swing.JLayeredPane();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        bugDescriptionPane = new javax.swing.JScrollPane();
        bugDescriptionTextPane = new javax.swing.JTextPane();
        bugDescriptionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ExceptionReporterPanel.class, "ExceptionReporterPanel.title")); // NOI18N
        setAlwaysOnTop(true);
        setIconImage(null);
        setName("errorDialog"); // NOI18N

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/jpa/modeler/collaborate/resource/image/BUG_ICON.png"))); // NOI18N
        iconLabel.setLabelFor(submitButton);
        iconLabel.setToolTipText(org.openide.util.NbBundle.getMessage(ExceptionReporterPanel.class, "ExceptionReporterPanel.iconLabel.toolTipText")); // NOI18N

        actionPane.setPreferredSize(new java.awt.Dimension(900, 50));

        submitButton.setBackground(javax.swing.UIManager.getDefaults().getColor("MenuItem.selectionBackground"));
        org.openide.awt.Mnemonics.setLocalizedText(submitButton, file==null?buttonAttachText:buttonText);
        submitButton.setToolTipText(org.openide.util.NbBundle.getMessage(ExceptionReporterPanel.class, "ExceptionReporterPanel.submitButton.toolTipText")); // NOI18N
        submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(ExceptionReporterPanel.class, "ExceptionReporterPanel.cancelButton.text")); // NOI18N
        cancelButton.setToolTipText(org.openide.util.NbBundle.getMessage(ExceptionReporterPanel.class, "ExceptionReporterPanel.cancelButton.toolTipText")); // NOI18N
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionPaneLayout = new javax.swing.GroupLayout(actionPane);
        actionPane.setLayout(actionPaneLayout);
        actionPaneLayout.setHorizontalGroup(
            actionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        actionPaneLayout.setVerticalGroup(
            actionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );
        actionPane.setLayer(submitButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        actionPane.setLayer(cancelButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bugDescriptionTextPane.setForeground(new java.awt.Color(255, 255, 255));
        bugDescriptionTextPane.setText(bugDescription);
        bugDescriptionTextPane.setEnabled(false);
        bugDescriptionTextPane.setFocusable(false);
        bugDescriptionPane.setViewportView(bugDescriptionTextPane);

        org.openide.awt.Mnemonics.setLocalizedText(bugDescriptionLabel, org.openide.util.NbBundle.getMessage(ExceptionReporterPanel.class, "ExceptionReporterPanel.bugDescriptionLabel.text")); // NOI18N

        javax.swing.GroupLayout rootLayout = new javax.swing.GroupLayout(root);
        root.setLayout(rootLayout);
        rootLayout.setHorizontalGroup(
            rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootLayout.createSequentialGroup()
                .addComponent(iconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootLayout.createSequentialGroup()
                        .addComponent(bugDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 273, Short.MAX_VALUE))
                    .addComponent(bugDescriptionPane))
                .addContainerGap())
            .addComponent(actionPane, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        rootLayout.setVerticalGroup(
            rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rootLayout.createSequentialGroup()
                        .addComponent(iconLabel)
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addGroup(rootLayout.createSequentialGroup()
                        .addComponent(bugDescriptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bugDescriptionPane)))
                .addGap(18, 18, 18)
                .addComponent(actionPane, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        root.setLayer(iconLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        root.setLayer(actionPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        root.setLayer(bugDescriptionPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        root.setLayer(bugDescriptionLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(root)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(root)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        StringWriter stringWriter = new StringWriter();
        try {
            StringBuilder report = new StringBuilder();
            report.append("Message : ").append(bugDescription).append('\n').append('\n');
            throwable.printStackTrace(new PrintWriter(stringWriter));
            report.append("StackTrace : ").append('\n').append(stringWriter.toString()).append('\n').append('\n');
            if (file != null) {
                report.append("ModelerFile : ").append('\n').append("```xml").append('\n').append(file.getContent()).append("```");
            }
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            StringSelection strSel = new StringSelection(report.toString());
            clipboard.setContents(strSel, null);
            SharingHelper.openWebpage(ISSUES_URL);
            setVisible(false);
        } finally {
            try {
                stringWriter.close();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }

        }
        NotificationDisplayer.getDefault().notify("Logs coppied",
                ImageUtilities.image2Icon(file.getIcon()),
                "Logs coppied to clipboard, please report the issue with these logs", (ActionEvent e) -> {

                }, NotificationDisplayer.Priority.NORMAL, NotificationDisplayer.Category.INFO);
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane actionPane;
    private javax.swing.JLabel bugDescriptionLabel;
    private javax.swing.JScrollPane bugDescriptionPane;
    private javax.swing.JTextPane bugDescriptionTextPane;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLayeredPane root;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables

}
