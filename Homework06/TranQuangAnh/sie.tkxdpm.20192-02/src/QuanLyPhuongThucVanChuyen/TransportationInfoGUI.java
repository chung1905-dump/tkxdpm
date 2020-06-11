package QuanLyPhuongThucVanChuyen;

import JDBC.DBUtilities;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import com.sun.glass.events.WindowEvent;

public class TransportationInfoGUI extends JDialog {
	TransportationInfoController controller;
	List<TransportationInfo> data = new ArrayList<TransportationInfo>();
	// private javax.swing.JComboBox<String> cboGender;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField txtByShip;
	private javax.swing.JTextField txtSiteCode;
	private javax.swing.JTextField txtSiteName;
	private javax.swing.JTextField txtByAir;
	private javax.swing.JTextField txtOthers;
	private JLabel error = new JLabel();

	boolean addRecord = false;

	public TransportationInfoGUI(java.awt.Frame parent, boolean modal, TransportationInfoController controller) {
		super(parent, modal);
		this.controller = controller;
		initComponents();
	}

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		try {
			loadRecords();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void initComponents() {

		javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
		javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
		txtSiteCode = new javax.swing.JTextField();
		javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
		txtSiteName = new javax.swing.JTextField();
		javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
		// cboGender = new javax.swing.JComboBox<>();
		javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
		txtByShip = new javax.swing.JTextField();
		javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
		txtByAir = new javax.swing.JTextField();
		javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
		txtOthers = new javax.swing.JTextField();
		javax.swing.JButton btnAddNew = new javax.swing.JButton();
		javax.swing.JButton btnUpdate = new javax.swing.JButton();
		javax.swing.JButton btnDelete = new javax.swing.JButton();
		javax.swing.JButton btnClose = new javax.swing.JButton();
		javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transportation Records Editor",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 11))); // NOI18N

		jLabel2.setText("SiteCode:");
		// txtSiteCode.setEnabled(false);
		jLabel3.setText("Site Name:");
//        jLabel4.setText("Gender:");
//        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Male", "Female"}));
		jLabel5.setText("By Ship:");
		jLabel6.setText("By Air:");
		jLabel7.setText("Others:");

		// javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		// jPanel1.setLayout(jPanel1Layout);
		JPanel formPanel = new JPanel(new GridLayout(6, 2));

		JLabel filler = new JLabel();
		// JPanel errPanel = new JPanel(10,10);
		// errPanel.add(new JLabel("ERROR!"));
		jPanel1.setLayout(new GridLayout(1, 1));
		formPanel.add(jLabel2);
		formPanel.add(txtSiteCode);
		formPanel.add(jLabel3);
		formPanel.add(txtSiteName);
		formPanel.add(jLabel5);
		formPanel.add(txtByShip);
		formPanel.add(jLabel6);
		formPanel.add(txtByAir);
		formPanel.add(jLabel7);
		formPanel.add(txtOthers);
		formPanel.add(filler);
		formPanel.add(error);

		jPanel1.add(formPanel);
		// jPanel1.add(new JLabel("ERROR!"));

		btnAddNew.setText("Add New");
		btnAddNew.addActionListener(evt -> {
			addRecord = true;
			btnUpdateActionPerformed(evt);
		});

		btnUpdate.setText("Update");
		btnUpdate.addActionListener(evt -> {
			addRecord = false;
			btnUpdateActionPerformed(evt);
		});

		btnDelete.setText("Delete");
		btnDelete.addActionListener(this::btnDeleteActionPerformed);

		btnClose.setText("Close");
		btnClose.addActionListener(this::btnCloseActionPerformed);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { {}, {}, {}, {} }, new String[] {

		}));
		jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addComponent(btnAddNew)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnUpdate)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnDelete)

						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
						.addComponent(btnClose)
				// .addComponent(new JLabel("dwfef"))
				).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(jScrollPane1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)).addComponent(jPanel1,
								javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnAddNew).addComponent(btnUpdate).addComponent(btnDelete)
								.addComponent(btnClose)
						// .addComponent(new JLabel("dwfef"))
						)

						.addContainerGap(21, Short.MAX_VALUE)));

		pack();
	}

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?",
				"Confirm Delete Record?", JOptionPane.YES_NO_OPTION);

		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				// deleteRecord();
				controller.deleteRecord(txtSiteCode.getText());
				loadRecords();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				this.error.setText(ex.getMessage());
			}
		}
	}

	private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(1);
	}

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		int dialogResult = JOptionPane.showConfirmDialog(null,
				addRecord ? "Confirm Add new record?" : "Are you sure you want to update this record?",
				addRecord ? "Confirm Add Record" : "Confirm Update Record?", JOptionPane.YES_NO_OPTION);

		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				String siteCode = txtSiteCode.getText();
				String siteName = txtSiteName.getText();
				String byShip = txtByShip.getText();
				String byAir = txtByAir.getText();
				// int byShip = Integer.getInteger(txtByShip.getText());
				// int byAir = Integer.getInteger(txtByAir.getText());
				// String siteCode = txtSiteCode.getText();
				String others = txtOthers.getText();
				if (addRecord) {
					// addNew();
					controller.addNew(siteCode, siteName, byShip, byAir, others);
					clearInputBoxes();
				} else {
					// updateRecord();
					controller.updateRecord(siteCode, siteName, byShip, byAir, others);
				}

				loadRecords();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("HELLO!");
				this.error.setText(ex.getMessage());
			}
		}
	}

	private void clearInputBoxes() {
		txtSiteCode.setText("");
		txtSiteName.setText("");
		// cboGender.setSelectedItem("");
		txtByShip.setText("");
		txtByAir.setText("");
		txtOthers.setText("");
	}

	private void loadRecords() throws SQLException {
		TransportationInfoModel tableModel = controller.loadRecords(TransportationInfoGUI.this);
//			//String sql_stmt = "SELECT * FROM transportationinfo;";
//			//System.out.println(sql_stmt);
//			// ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);
//			TransportationInfoModel tableModel = new TransportationInfoModel(sql_stmt);
//			// tableModel.getData(resultSet)
		data = tableModel.getData();
		for (TransportationInfo info: data) {
			System.out.println("wew");
			info.display();
		}
		data = tableModel.getData();
		jTable1.setModel(tableModel);
		jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (jTable1.getSelectedRow() >= 0) {
					Object siteCode = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
					Object siteName = jTable1.getValueAt(jTable1.getSelectedRow(), 1);
					Object byShip = jTable1.getValueAt(jTable1.getSelectedRow(), 2);
					Object byAir = jTable1.getValueAt(jTable1.getSelectedRow(), 3);
					Object others = jTable1.getValueAt(jTable1.getSelectedRow(), 4);
					// Object salary = jTable1.getValueAt(jTable1.getSelectedRow(), 5);

					txtSiteCode.setText(siteCode.toString());
					txtSiteName.setText(siteName.toString());
					// cboGender.setSelectedItem(gender.toString());
					txtByShip.setText(byShip.toString());
					txtByAir.setText(byAir.toString());
					txtOthers.setText(others.toString());
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				this.error.setText(ex.getMessage());
			}
		});

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
	}

//	    private void updateRecord()
//	    {
//	        String sql_stmt = "UPDATE transportationinfo SET SiteName = '" + txtSiteName.getText() + "'";
//	        //sql_stmt += ",gender = '" + cboGender.getSelectedItem().toString() + "'";
//	        sql_stmt += ",byShip = '" + txtByShip.getText() + "'";
//	        sql_stmt += ",byAir = '" + txtByAir.getText() + "'";
//	        sql_stmt += ",others = '" + txtOthers.getText() + "'";
//	        sql_stmt += " WHERE SiteCode = '" + txtSiteCode.getText() + "'";
//	        System.out.println(sql_stmt);
//	        DBUtilities.ExecuteSQLStatement(sql_stmt);
//	    }
//	 
//	    private void addNew()
//	    {
//	    	//INSERT INTO `tkxdpm`.`transportationinfo` (`SiteCode`, `SiteName`, `byShip`) VALUES ('265', '21321', '1312sadsd');
//	        String sql_stmt = "INSERT INTO transportationinfo (SiteCode,SiteName,byShip,byAir,others)";
//	        sql_stmt += " VALUES ('"+txtSiteCode.getText()+"','" + txtSiteName.getText() + "','" + txtByShip.getText() + "','" + txtByAir.getText() + "','" + txtOthers.getText() + "')";
//	        System.out.println(sql_stmt);
//	        DBUtilities.ExecuteSQLStatement(sql_stmt);
//	    }

	private void deleteRecord() {
		String sql_stmt = "DELETE FROM transportationinfo WHERE SiteCode = '" + txtSiteCode.getText() + "'";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TransportationInfoGUI.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TransportationInfoGUI.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TransportationInfoGUI.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TransportationInfoGUI.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// TransportationInfoModel model = new TransportationInfoModel(null);
				TransportationInfoController controller = new TransportationInfoController();
				TransportationInfoGUI dialog = new TransportationInfoGUI(new javax.swing.JFrame(), true, controller);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}
}
