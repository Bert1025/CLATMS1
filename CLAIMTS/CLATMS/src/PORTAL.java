
import General.ConnectionProvider;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author PC08-LAB1
 */
public class PORTAL extends javax.swing.JFrame {
     private String POSITION;
     private String ID_NUMBER;
     private String FULL_NAME;
     private String TIME_IN;
     private String TIME_OUT;
     private String DATE;
     private String PC_NUMBER;
     private String PURPOSE;
     
    
     
      


    /**
     * Creates new form PORTAL
     */
    public PORTAL() {
        initComponents();
    }
    
    // ======================================================= Start Function =========================================================//
      public void showattendance(){
         try {
            // Create the SQL query with placeholders
            String getQuery = "SELECT * FROM attendance";


            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            PreparedStatement statement = connection.prepareStatement(getQuery);

            statement.executeQuery();
           ResultSet resultSet = statement.executeQuery();
    
    // Process the result set as needed
    if (resultSet.next()) {
        this.POSITION = resultSet.getString("POSITION");
        this.FULL_NAME = resultSet.getString("FULL_NAME");
        this.TIME_IN = resultSet.getString("TIME_IN");
        this.TIME_OUT = resultSet.getString("TIME_OUT");
        this.DATE = resultSet.getString("DATE");
        this.PC_NUMBER = resultSet.getString("PC_NUMBER");
        this.PURPOSE = resultSet.getString("PURPOSE");
        this.ID_NUMBER = resultSet.getString("ID_NUMBER");

        // Display the retrieved data
        System.out.println("POSITION: " + this.POSITION);
        System.out.println("FULL_NAME: " + this.FULL_NAME);
        System.out.println("TIME_IN: " + this.TIME_IN);
        System.out.println("TIME_OUT: " + this.TIME_OUT);
        System.out.println("DATE: " + this.DATE);
        System.out.println("PC_NUMBER: " + this.PC_NUMBER);
        System.out.println("PURPOSE: " + this.PURPOSE);
        System.out.println("ID_NUMBER: " + this.ID_NUMBER);

        // Create a table model to store data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);

        // Get column names and add them to the table model
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            if (columnName.equals("POSITION") || columnName.equals("FULL_NAME") ||
                    columnName.equals("TIME_IN") || columnName.equals("TIME_OUT") || columnName.equals("DATE")
                    || columnName.equals("PC_NUMBER") || columnName.equals("PURPOSE") || columnName.equals("ID_NUMBER")) {
                tableModel.addColumn(columnName);
            }
        }

        // Add rows to the table model
        do {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        } while (resultSet.next());

    } else {
        System.out.println("No matching records found.");
        JOptionPane.showMessageDialog(null, "No record found!");
    }

    // Close resources
    resultSet.close();
    statement.close();
    connection.close();

            System.out.println("Retrieved Successfully!");

        } catch (ClassNotFoundException | SQLException e) {
          JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          e.printStackTrace();
        }
    }
    
    
    //===========================================================================================//

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        position_combo_box = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        id_number_field = new javax.swing.JTextField();
        full_name_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        time_in_field = new javax.swing.JTextField();
        time_out_field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        date_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pc_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        purpose_field = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        searchTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("PORTAL");

        jLabel2.setText("POSITION");

        position_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TEACHER", "FACULTY", "STUDENT" }));

        jLabel3.setText("ID. NO.");

        jLabel4.setText("FULLNAME");

        jLabel5.setText("TIME IN");

        jLabel6.setText("TIME OUT");

        jLabel7.setText("DATE");

        jLabel8.setText("PC.NO.");

        jLabel9.setText("PURPOSE");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "POSITION", "ID. NO.", "FULLNAME", "TIME IN", "TIME OUT", "DATE", "PC NO.", "PURPOSE"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 600, 470));

        jButton1.setBackground(new java.awt.Color(0, 204, 51));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 0));
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 0, 0));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 204, 255));
        jButton4.setText("BACK TO LOGIN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 102, 0));
        jButton5.setText("search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("EXIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(position_combo_box, 0, 161, Short.MAX_VALUE)
                                    .addComponent(id_number_field)
                                    .addComponent(full_name_field)
                                    .addComponent(time_in_field)
                                    .addComponent(time_out_field)
                                    .addComponent(date_field)
                                    .addComponent(pc_field)
                                    .addComponent(purpose_field)))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton6)
                        .addGap(29, 29, 29))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(position_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(id_number_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(full_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(time_in_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(time_out_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(date_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(pc_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(purpose_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          try {
    // Create the SQL query with placeholders
    String insertQuery = "INSERT INTO attendance (POSITION, FULL_NAME, TIME_IN, TIME_OUT, DATE, PC_NUMBER, PURPOSE, ID_NUMBER) VALUES (?, ?, ?, ?, ?, ?, ? , ?)";

    // Create a connection
    ConnectionProvider dbc = new ConnectionProvider();
    String jdbcDriver = dbc.getJdbcDriver();
    String dbConnectionURL = dbc.getDbConnectionURL();
    String dbUsername = dbc.getDbUsername();
    String dbPassword = dbc.getDbPassword();
    Class.forName(jdbcDriver);
    Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

    // Create the PreparedStatement
    PreparedStatement statement = connection.prepareStatement(insertQuery);

    // Assuming student_id_field represents a string student ID
    
    statement.setString(1, String.valueOf(position_combo_box.getSelectedItem()));
    statement.setString(2, full_name_field.getText());
    statement.setString(3, id_number_field.getText());
    statement.setString(4, time_out_field.getText());
    statement.setString(5, date_field.getText());
    statement.setString(6, pc_field.getText());
    statement.setString(7, purpose_field.getText());
    statement.setString(8, id_number_field.getText());
    
    
    statement.executeUpdate();

    // Clear the input fields
    this.position_combo_box.setSelectedItem("FACULTY");
    this.id_number_field.setText("");
    this.full_name_field.setText("");
    this.time_in_field.setText("");
    this.time_out_field.setText("");
    this.date_field.setText("");
    this.pc_field.setText("");
    this.purpose_field.setText("");
    

    DefaultTableModel tableModel = new DefaultTableModel();
    jTable1.setModel(tableModel);
    
    showattendance();
    System.out.println("Add Successfully!");

} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
    int SelectedRows = jTable1.getSelectedRow();
    position_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 0).toString());
    full_name_field.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
    time_in_field.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
    time_out_field.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
    date_field.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
    pc_field.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
    purpose_field.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
    id_number_field.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int deleteItem;
DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
int SelectedRows = jTable1.getSelectedRow();
try {
    id_number_field.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
    deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete item ", "warning", JOptionPane.YES_NO_OPTION);

    if (deleteItem == JOptionPane.YES_OPTION) {

        // Create the SQL query with placeholders
        String deleteQuery = "DELETE FROM attendance WHERE ID_NUMBER = ?";

        // Create a connection
        ConnectionProvider dbc = new ConnectionProvider();
        String jdbcDriver = dbc.getJdbcDriver();
        String dbConnectionURL = dbc.getDbConnectionURL();
        String dbUsername = dbc.getDbUsername();
        String dbPassword = dbc.getDbPassword();
        Class.forName(jdbcDriver);
        Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

        // Create the PreparedStatement
        PreparedStatement statement = connection.prepareStatement(deleteQuery);

        // Bind the parameter
        statement.setString(1, id_number_field.getText());

        // Execute the DELETE query
        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
       // Clear the input fields
        this.position_combo_box.setSelectedItem("FACULTY");
        this.id_number_field.setText("");
        this.full_name_field.setText("");
        this.time_in_field.setText("");
        this.time_out_field.setText("");
        this.date_field.setText("");
        this.pc_field.setText("");
        this.purpose_field.setText("");
        JOptionPane.showMessageDialog(this,"Record has been successfully deleted");
        } else {
            JOptionPane.showMessageDialog(this,"No record found with the given id_number.");
        }
        // Refresh the table with updated data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);
        showattendance();
    }
} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
     try {
    // Create the SQL query for update
    String updateQuery = "UPDATE attendance SET POSITION ='" + position_combo_box.getSelectedItem()+
            "', FULL_NAME='" + full_name_field.getText() +
            "', TIME_IN='" + time_in_field.getText() +
            "', TIME_OUT='" + time_out_field.getText() +
            "', DATE='" + date_field.getText() +
            "', PC_NUMBER='" + pc_field.getText() +
             "', PURPOSE='" + purpose_field.getText() +
            "' WHERE ID_NUMBER ='" + id_number_field.getText() + "'";

    // Create a connection
    ConnectionProvider dbc = new ConnectionProvider();
    String jdbcDriver = dbc.getJdbcDriver();
    String dbConnectionURL = dbc.getDbConnectionURL();
    String dbUsername = dbc.getDbUsername();
    String dbPassword = dbc.getDbPassword();
    Class.forName(jdbcDriver);
    Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

    // Create the Statement
    Statement statement = connection.createStatement();

    // Execute the UPDATE query
    int rowsAffected = statement.executeUpdate(updateQuery);

    if (rowsAffected > 0) {
        // Clear the input fields
        this.position_combo_box.setSelectedItem("FACULTY");
        this.full_name_field.setText("");
        this.time_in_field.setText("");
        this.time_out_field.setText("");
        this.date_field.setText("");
        this.pc_field.setText("");
        this.purpose_field.setText("");
        this.id_number_field.setText("");

        JOptionPane.showMessageDialog(this, "Record has been successfully updated");
    } else {
        JOptionPane.showMessageDialog(this, "No record found with the given student_id.");
    }

    // Refresh the table with updated data
    DefaultTableModel tableModel = new DefaultTableModel();
    jTable1.setModel(tableModel);
    showattendance();

    System.out.println("Update Successfully!");

} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
            try {
    // Create the SQL query with placeholders
    String searchQuery = "SELECT * FROM attendance WHERE ID_NUMBER LIKE ? OR POSITION LIKE ? OR TIME_IN LIKE ? OR TIME_OUT LIKE ? OR DATE LIKE ? OR PC_NUMBER LIKE ? OR PURPOSE LIKE ?";
    
    // Create a connection
    ConnectionProvider dbc = new ConnectionProvider();
    String jdbcDriver = dbc.getJdbcDriver();
    String dbConnectionURL = dbc.getDbConnectionURL();
    String dbUsername = dbc.getDbUsername();
    String dbPassword = dbc.getDbPassword();
    Class.forName(jdbcDriver);
    Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);
    
    // Create the PreparedStatement
    PreparedStatement statement = connection.prepareStatement(searchQuery);
    
    // Set search parameters
    String searchKeyword = "%" + searchTF.getText() + "%";
    for (int i = 1; i <= 7; i++) {
        statement.setString(i, searchKeyword);
    }
    
    // Execute the query
    ResultSet resultSet = statement.executeQuery();
    
    // Process the result set as needed
    if (resultSet.next()) {
        this.POSITION = resultSet.getString("POSITION");
        this.FULL_NAME = resultSet.getString("FULL_NAME");
        this.TIME_IN = resultSet.getString("TIME_IN");
        this.TIME_OUT = resultSet.getString("TIME_OUT");
        this.DATE = resultSet.getString("DATE");
        this.PC_NUMBER = resultSet.getString("PC_NUMBER");
        this.PURPOSE = resultSet.getString("PURPOSE");
        this.ID_NUMBER = resultSet.getString("ID_NUMBER");

        // Display the retrieved data
        System.out.println("POSITION: " + this.POSITION);
        System.out.println("FULL_NAME: " + this.FULL_NAME);
        System.out.println("TIME_IN: " + this.TIME_IN);
        System.out.println("TIME_OUT: " + this.TIME_OUT);
        System.out.println("DATE: " + this.DATE);
        System.out.println("PC_NUMBER: " + this.PC_NUMBER);
        System.out.println("PURPOSE: " + this.PURPOSE);
        System.out.println("ID_NUMBER: " + this.ID_NUMBER);

        // Create a table model to store data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);

        // Get column names and add them to the table model
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            if (columnName.equals("POSITION") || columnName.equals("FULL_NAME") ||
                    columnName.equals("TIME_IN") || columnName.equals("TIME_OUT") || columnName.equals("DATE")
                    || columnName.equals("PC_NUMBER") || columnName.equals("PURPOSE") || columnName.equals("ID_NUMBER")) {
                tableModel.addColumn(columnName);
            }
        }

        // Add rows to the table model
        do {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        } while (resultSet.next());

    } else {
        System.out.println("No matching records found.");
        JOptionPane.showMessageDialog(null, "No record found!");
    }

    // Close resources
    resultSet.close();
    statement.close();
    connection.close();
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
}

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:       
                 Login log = new Login();
                 log.setVisible(true);
                 log.pack();
                 log.setLocationRelativeTo(null);
                 this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(PORTAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PORTAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PORTAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PORTAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PORTAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date_field;
    private javax.swing.JTextField full_name_field;
    private javax.swing.JTextField id_number_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pc_field;
    private javax.swing.JComboBox<String> position_combo_box;
    private javax.swing.JTextField purpose_field;
    private javax.swing.JTextField searchTF;
    private javax.swing.JTextField time_in_field;
    private javax.swing.JTextField time_out_field;
    // End of variables declaration//GEN-END:variables
}
