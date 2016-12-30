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
package org.netbeans.jpa.modeler.properties.classmember;

import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.JOptionPane;
import org.netbeans.jpa.modeler.core.widget.PersistenceClassWidget;
import org.netbeans.jpa.modeler.spec.ManagedClass;
import org.netbeans.jpa.modeler.spec.extend.AccessModifierType;
import org.netbeans.jpa.modeler.spec.extend.Constructor;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.ComboBoxValue;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.Entity;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.RowValue;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.internal.EntityComponent;
import static org.openide.util.NbBundle.getMessage; 

public class ConstructorPanel extends EntityComponent<Constructor> {

    private Constructor constructor;
    private final List<Constructor> constructors;
    private final PersistenceClassWidget<? extends ManagedClass> persistenceClassWidget;

    public ConstructorPanel(PersistenceClassWidget<? extends ManagedClass> persistenceClassWidget) {
        this.persistenceClassWidget = persistenceClassWidget;
        constructors = persistenceClassWidget.getBaseElementSpec().getConstructors();
    }

    @Override
    public void postConstruct() {
        initComponents();
        ((ClassMemberPanel) classMemberPanel).postConstruct();
    }

    @Override
    public void init() {
        ((ClassMemberPanel) classMemberPanel).init();
        accessModifierComboInit();
        pack();
    }
    
    private void accessModifierComboInit() {
        accessModifierComboBox.removeAllItems();
        for (AccessModifierType accessModifierType : AccessModifierType.values()) {
            accessModifierComboBox.addItem(new ComboBoxValue(accessModifierType, accessModifierType.getValue()));
        }
    }


    @Override
    public void createEntity(Class<? extends Entity> entityWrapperType) {
        this.setTitle("Create Constructor");
        if (entityWrapperType == RowValue.class) {
            this.setEntity(new RowValue(new Object[3]));
        }
        constructor = new Constructor();
        setAccessModifierType(AccessModifierType.PUBLIC);
        ((ClassMemberPanel)classMemberPanel).setPersistenceClassWidget(persistenceClassWidget);
        ((ClassMemberPanel) classMemberPanel).setValue(constructor);
        
    }

    @Override
    public void updateEntity(Entity<Constructor> entityValue) {
        this.setTitle("Update Constructor");
        if (entityValue.getClass() == RowValue.class) {
            this.setEntity(entityValue);
            Object[] row = ((RowValue) entityValue).getRow();
            constructor = (Constructor) row[0];
            ((ClassMemberPanel)classMemberPanel).setPersistenceClassWidget(persistenceClassWidget);
            ((ClassMemberPanel) classMemberPanel).setValue(constructor);
            
            setAccessModifierType(constructor.getAccessModifier());
        }
        
    }
    
    private void setAccessModifierType(AccessModifierType accessModifier) {
        if (accessModifier == null) {
            accessModifierComboBox.setSelectedIndex(0);
        } else {
            for (int i = 0; i < accessModifierComboBox.getItemCount(); i++) {
                if (((ComboBoxValue<AccessModifierType>) accessModifierComboBox.getItemAt(i)).getValue() == accessModifier) {
                    accessModifierComboBox.setSelectedIndex(i);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootLayeredPane = new javax.swing.JLayeredPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        classMemberPanel = new ClassMemberPanel(org.openide.util.NbBundle.getMessage(ClassMemberPanel.class, "LBL_constructor_select"));
        jLayeredPane2 = new javax.swing.JLayeredPane();
        action_jLayeredPane = new javax.swing.JLayeredPane();
        save_Button = new javax.swing.JButton();
        cancel_Button = new javax.swing.JButton();
        accessModifierLayeredPane = new javax.swing.JLayeredPane();
        accessModifierComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        rootLayeredPane.setLayout(new java.awt.BorderLayout());

        jLayeredPane1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout classMemberPanelLayout = new javax.swing.GroupLayout(classMemberPanel);
        classMemberPanel.setLayout(classMemberPanelLayout);
        classMemberPanelLayout.setHorizontalGroup(
            classMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        classMemberPanelLayout.setVerticalGroup(
            classMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        jLayeredPane1.add(classMemberPanel, java.awt.BorderLayout.CENTER);

        rootLayeredPane.add(jLayeredPane1, java.awt.BorderLayout.CENTER);

        jLayeredPane2.setPreferredSize(new java.awt.Dimension(472, 45));

        org.openide.awt.Mnemonics.setLocalizedText(save_Button, org.openide.util.NbBundle.getMessage(ConstructorPanel.class, "ConstructorPanel.save_Button.text")); // NOI18N
        save_Button.setToolTipText(org.openide.util.NbBundle.getMessage(ConstructorPanel.class, "ConstructorPanel.save_Button.toolTipText")); // NOI18N
        save_Button.setPreferredSize(new java.awt.Dimension(50, 25));
        save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_ButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancel_Button, org.openide.util.NbBundle.getMessage(ConstructorPanel.class, "ConstructorPanel.cancel_Button.text")); // NOI18N
        cancel_Button.setToolTipText(org.openide.util.NbBundle.getMessage(ConstructorPanel.class, "ConstructorPanel.cancel_Button.toolTipText")); // NOI18N
        cancel_Button.setPreferredSize(new java.awt.Dimension(50, 23));
        cancel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_ButtonActionPerformed(evt);
            }
        });

        action_jLayeredPane.setLayer(save_Button, javax.swing.JLayeredPane.DEFAULT_LAYER);
        action_jLayeredPane.setLayer(cancel_Button, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout action_jLayeredPaneLayout = new javax.swing.GroupLayout(action_jLayeredPane);
        action_jLayeredPane.setLayout(action_jLayeredPaneLayout);
        action_jLayeredPaneLayout.setHorizontalGroup(
            action_jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(action_jLayeredPaneLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(save_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        action_jLayeredPaneLayout.setVerticalGroup(
            action_jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(action_jLayeredPaneLayout.createSequentialGroup()
                .addGroup(action_jLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLayeredPane2.add(action_jLayeredPane);
        action_jLayeredPane.setBounds(280, 10, 170, 30);

        accessModifierComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(ConstructorPanel.class, "ConstructorPanel.accessModifierComboBox.toolTipText")); // NOI18N
        accessModifierComboBox.setPreferredSize(new java.awt.Dimension(28, 23));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ConstructorPanel.class, "ConstructorPanel.jLabel1.text")); // NOI18N

        accessModifierLayeredPane.setLayer(accessModifierComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        accessModifierLayeredPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout accessModifierLayeredPaneLayout = new javax.swing.GroupLayout(accessModifierLayeredPane);
        accessModifierLayeredPane.setLayout(accessModifierLayeredPaneLayout);
        accessModifierLayeredPaneLayout.setHorizontalGroup(
            accessModifierLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accessModifierLayeredPaneLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(accessModifierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        accessModifierLayeredPaneLayout.setVerticalGroup(
            accessModifierLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accessModifierLayeredPaneLayout.createSequentialGroup()
                .addGroup(accessModifierLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(accessModifierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jLayeredPane2.add(accessModifierLayeredPane);
        accessModifierLayeredPane.setBounds(0, 10, 270, 30);

        rootLayeredPane.add(jLayeredPane2, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootLayeredPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootLayeredPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

      private boolean validateField() {
//        if (constructors.contains(constructor)){// bug : will only work for existing entry
//            JOptionPane.showMessageDialog(this, "Constructor with same signature already exist : " + constructor.getSignature(), "Duplicate Constructor", javax.swing.JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
          if(constructor.getAttributes().isEmpty() && (constructor.getAccessModifier()==AccessModifierType.DEFAULT || constructor.getAccessModifier()==AccessModifierType.PRIVATE)){
              JOptionPane.showMessageDialog(this, getMessage(ConstructorPanel.class, "NO_ARG_ACCESS_MODIFIER.text"),
                      getMessage(ConstructorPanel.class, "NO_ARG_ACCESS_MODIFIER.title"), javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
          }
          
        return true;
    }
      
    private void save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_ButtonActionPerformed
        constructor = (Constructor) ((ClassMemberPanel) classMemberPanel).getValue();
        constructor.setAccessModifier(((ComboBoxValue<AccessModifierType>) accessModifierComboBox.getSelectedItem()).getValue());
        if (!validateField()) {
            return;
        }
        
        if (this.getEntity().getClass() == RowValue.class) {
            Object[] row = ((RowValue) this.getEntity()).getRow();
            row[0] = constructor;
            row[1] = constructor.isEnable();
            row[2] = constructor.toString();
        }
        
        saveActionPerformed(evt);
    }//GEN-LAST:event_save_ButtonActionPerformed

    private void cancel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_ButtonActionPerformed
        cancelActionPerformed(evt);
    }//GEN-LAST:event_cancel_ButtonActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accessModifierComboBox;
    private javax.swing.JLayeredPane accessModifierLayeredPane;
    private javax.swing.JLayeredPane action_jLayeredPane;
    private javax.swing.JButton cancel_Button;
    private javax.swing.JPanel classMemberPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane rootLayeredPane;
    private javax.swing.JButton save_Button;
    // End of variables declaration//GEN-END:variables

}
