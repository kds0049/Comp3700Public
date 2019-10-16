//package edu.auburn;

import javax.swing.*;

public class StoreManager {
   public static final String DBMS_SQ_LITE = "SQLite";
   public static final String DB_FILE = "/Users/Karl_Sprayberry/Documents/store.db";
   
   IDataAdapter adapter = null;
   private static StoreManager instance = null;

   public static StoreManager getInstance() {
      if (instance == null) {
      
         String dbfile = DB_FILE;
         JFileChooser fc = new JFileChooser();
         if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            dbfile = fc.getSelectedFile().getAbsolutePath();
            
         instance = new StoreManager(DBMS_SQ_LITE, DB_FILE);
      }
      return instance;
   }

   private StoreManager(String db, String dbfile) {
      if (db.equals("Oracle"))
         adapter = new OracleDataAdapter();
      else
         if (db.equals("SQLite"))
            adapter = new SQLiteDataAdapter();
   
      adapter.connect(dbfile);
      ProductModel product = adapter.loadProduct(3);
   
      System.out.println("Loaded product: " + product);
   
   }

   public IDataAdapter getDataAdapter() {
      return adapter;
   }

   public void setDataAdapter(IDataAdapter a) {
      adapter = a;
   }
   
   public void run() {
      MainUI ui = new MainUI();
      ui.view.setVisible(true);
   }

   public static void main(String[] args) {
      System.out.println("Hello class!");
      //StoreManager.getInstance().init(); //If you want to initialize something, create init function first
      StoreManager.getInstance().run();
   }

}
