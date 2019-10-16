//package edu.auburn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerUI {

   public JFrame view;

   public JButton btnAdd = new JButton("Add");
   public JButton btnCancel = new JButton("Cancel");

   public JTextField txtCustomerID = new JTextField(20);
   public JTextField txtName = new JTextField(20);


   public AddCustomerUI()   {
      this.view = new JFrame();
      
      view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
      view.setTitle("Add Customer");
      view.setSize(600, 400);
      view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));
   
      String[] labels = {"CustomerID ", "Name "};
   
      JPanel line1 = new JPanel(new FlowLayout());
      line1.add(new JLabel("CustomerID "));
      line1.add(txtCustomerID);
      view.getContentPane().add(line1);
   
      JPanel line2 = new JPanel(new FlowLayout());
      line2.add(new JLabel("Name "));
      line2.add(txtName);
      view.getContentPane().add(line2);
   
   
      JPanel panelButtons = new JPanel(new FlowLayout());
      panelButtons.add(btnAdd);
      panelButtons.add(btnCancel);
      view.getContentPane().add(panelButtons);
   
      btnAdd.addActionListener(new AddButtonListerner());
   
      btnCancel.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               JOptionPane.showMessageDialog(null, "You click on Cancel button!!!");
            }
         });
   
   }

   public void run() {
      view.setVisible(true);
   }

   class AddButtonListerner implements ActionListener {
   
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
         CustomerModel customer = new CustomerModel();
      
         String id = txtCustomerID.getText();
      
         if (id.length() == 0) {
            JOptionPane.showMessageDialog(null, "CustomerID cannot be null!");
            return;
         }
      
         try {
            customer.mCustomerID = Integer.parseInt(id);
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CustomerID is invalid!");
            return;
         }
      
         String name = txtName.getText();
         if (name.length() == 0) {
            JOptionPane.showMessageDialog(null, "Customer name cannot be empty!");
            return;
         }
      
         customer.mName = name;
               
         switch (StoreManager.getInstance().getDataAdapter().saveCustomer(customer)) {
            case SQLiteDataAdapter.PRODUCT_DUPLICATE_ERROR:
               JOptionPane.showMessageDialog(null, "Customer NOT added successfully! Duplicate product ID!");
               break;
            default:
               JOptionPane.showMessageDialog(null, "Customer added successfully!" + customer);
         }
      }
   }

}