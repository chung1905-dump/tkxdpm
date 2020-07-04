package QLDSMHCanDat.view;

import QLDSMHCanDat.controller.DSMHCanDatController;
import QLDSMHCanDat.model.QLDSMHCanDatModel;
import main.Application;
import main.controller.MainController;
import main.view.IView;

import java.awt.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import org.jdesktop.swingx.JXDatePicker;

public class QLDSMHCanDatView extends Container implements IView {
	DSMHCanDatController controller;

	private javax.swing.JTable jTable1;
	private javax.swing.JTextField txtTenSanPham;
	private javax.swing.JTextField txtIdSanPham;
	private javax.swing.JTextField txtIDProduct;
	private javax.swing.JTextField txtNumber;
	private javax.swing.JTextField txtUnit;
	//private javax.swing.JTextField txtDate;
	private JXDatePicker txtDate;
	

	boolean addRecord = false;

	private void clearInputBoxes() {
		txtIDProduct.setText("");
		txtIdSanPham.setText("");
		txtTenSanPham.setText("");
		txtNumber.setText("");
		// cboGender.setSelectedItem("");
		txtUnit.setText("");
		
		txtDate.setDate(Calendar.getInstance().getTime());
		
	}

//	private void addNew() {
//		// INSERT INTO `tkxdpm`.`transportationinfo` (`SiteCode`, `SiteName`, `byShip`)
//		// VALUES ('265', '21321', '1312sadsd');
//		String sql_stmt = "INSERT INTO transportationinfo (SiteCode,SiteName,byShip,byAir,others)";
//		sql_stmt += " VALUES ('" + txtSiteCode.getText() + "','" + txtSiteName.getText() + "','" + txtByShip.getText()
//				+ "','" + txtByAir.getText() + "','" + txtOthers.getText() + "')";
//		System.out.println(sql_stmt);
//		DBUtilities.ExecuteSQLStatement(sql_stmt);
//	}
//
//	private void updateRecord() {
//		String sql_stmt = "UPDATE transportationinfo SET SiteName = '" + txtSiteName.getText() + "'";
//		// sql_stmt += ",gender = '" + cboGender.getSelectedItem().toString() + "'";
//		sql_stmt += ",byShip = '" + txtByShip.getText() + "'";
//		sql_stmt += ",byAir = '" + txtByAir.getText() + "'";
//		sql_stmt += ",others = '" + txtOthers.getText() + "'";
//		sql_stmt += " WHERE SiteCode = '" + txtSiteCode.getText() + "'";
//
//		DBUtilities.ExecuteSQLStatement(sql_stmt);
//	}
//
//	private void deleteRecord() {
//		String sql_stmt = "DELETE FROM transportationinfo WHERE SiteCode = '" + txtSiteCode.getText() + "'";
//		DBUtilities.ExecuteSQLStatement(sql_stmt);
//	}

	private void loadRecords() throws SQLException {
		// String sql_stmt = "SELECT * FROM transportationinfo;";
		QLDSMHCanDatModel tableModel = controller.loadRecords();
		jTable1.setModel(tableModel);
		jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (jTable1.getSelectedRow() >= 0) {
					Object idProduct = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
					Object idSanPham = jTable1.getValueAt(jTable1.getSelectedRow(), 1);
					Object SoLuong = jTable1.getValueAt(jTable1.getSelectedRow(), 2);
					Object DonVi = jTable1.getValueAt(jTable1.getSelectedRow(), 3);
					Object date = jTable1.getValueAt(jTable1.getSelectedRow(), 4);
					Date d =  new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());

					txtIDProduct.setText(idProduct.toString());
					txtIdSanPham.setText(idSanPham.toString());
					txtNumber.setText(SoLuong.toString());
					txtUnit.setText(DonVi.toString());
					txtDate.setDate(d);
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		});

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
	}

	public QLDSMHCanDatView() {
		initComponents();
	}

	public QLDSMHCanDatView(DSMHCanDatController ctrlr) {
		this.controller = ctrlr;

		initComponents();
	}

	private void initComponents() {

		javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
		javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
		txtIDProduct = new javax.swing.JTextField();
		javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
		txtIdSanPham = new javax.swing.JTextField();
		javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
		txtTenSanPham = new javax.swing.JTextField();
		javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
		
		txtNumber = new javax.swing.JTextField();
		javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
		// cboGender = new javax.swing.JComboBox<>();
		javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
		txtUnit = new javax.swing.JTextField();
		javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
		//txtDate = new javax.swing.JTextField();
		txtDate = new JXDatePicker();
		txtDate.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		txtDate.setDate(Calendar.getInstance().getTime());
		javax.swing.JButton btnAddNew = new javax.swing.JButton();
		javax.swing.JButton btnUpdate = new javax.swing.JButton();
		javax.swing.JButton btnDelete = new javax.swing.JButton();
		javax.swing.JButton btnClose = new javax.swing.JButton();
		javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
//        try {
//        	System.out.println("loadRecords");
//			loadRecords();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
//		addWindowListener(new java.awt.event.WindowAdapter() {
//			public void windowOpened(java.awt.event.WindowEvent evt) {
//				formWindowOpened(evt);
//			}
//		});

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DSMHCanDat Records Editor",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 11))); // NOI18N

		jLabel2.setText("ID Product:");
		txtIDProduct.setEnabled(false);
		jLabel7.setText("ID San Pham:");
		jLabel8.setText("Ten San Pham:");
		jLabel3.setText("So Luong:");
//        jLabel4.setText("Gender:");
//        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Male", "Female"}));
		jLabel5.setText("Don Vi:");
		jLabel6.setText("Ngay Nhan:");
		

		// javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		// jPanel1.setLayout(jPanel1Layout);
		jPanel1.setLayout(new GridLayout(10, 2));
		jPanel1.add(jLabel2);
		jPanel1.add(txtIDProduct);
		jPanel1.add(jLabel7);
		jPanel1.add(txtIdSanPham);
		jPanel1.add(jLabel8);
		jPanel1.add(txtTenSanPham);
		jPanel1.add(jLabel3);
		jPanel1.add(txtNumber);
		jPanel1.add(jLabel5);
		jPanel1.add(txtUnit);
		jPanel1.add(jLabel6);
		jPanel1.add(txtDate);
	
		

		btnAddNew.setText("Them moi");
		btnAddNew.addActionListener(evt -> {
			addRecord = true;
			btnUpdateActionPerformed(evt);
		});

		btnUpdate.setText("Cap nhat");
		btnUpdate.addActionListener(evt -> {
			addRecord = false;
			btnUpdateActionPerformed(evt);
		});
//		addContainerListener(new ContainerListener() {
//
//			@Override
//			public void componentRemoved(ContainerEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void componentAdded(ContainerEvent e) {
//				// TODO Auto-generated method stub
//		        try {
//		        	System.out.println("loadRecords");
//					loadRecords();
//				} catch (SQLException err) {
//					// TODO Auto-generated catch block
//					err.printStackTrace();
//				}
//			}
//		});
		btnDelete.setText("Xoa");
		btnDelete.addActionListener(this::btnDeleteActionPerformed);

		btnClose.setText("Dong");
		btnClose.addActionListener(this::btnCloseActionPerformed);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { {}, {}, {}, {} }, new String[] {

		}));
		jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(btnAddNew)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnUpdate)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnDelete)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90,
												Short.MAX_VALUE)
										.addComponent(btnClose))
								.addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
								.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(btnAddNew)
						.addComponent(btnUpdate).addComponent(btnDelete).addComponent(btnClose))
				.addContainerGap(21, Short.MAX_VALUE)));
	}
	

	private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
		Application.runController(new MainController(), Application.ANIM_SWIPE_RIGHT);
		controller.moveToHome();
	}

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?",
				"Confirm Delete Record?", JOptionPane.YES_NO_OPTION);

		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				//deleteRecord();
				controller.deleteRecord(txtIDProduct.getText());
				loadRecords();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		int dialogResult = JOptionPane.showConfirmDialog(null,
				addRecord ? "Confirm Add new record?" : "Are you sure you want to update this record?",
				addRecord ? "Confirm Add Record" : "Confirm Update Record?", JOptionPane.YES_NO_OPTION);

		if (dialogResult == JOptionPane.YES_OPTION) {
		
			String idDSMHCD = txtIDProduct.getText();
			String idSanPham = txtIdSanPham.getText();
//			String TenSanPham = txtTenSanPham.getText();
			String number = txtNumber.getText();
			String unit = txtUnit.getText();
			//@SuppressWarnings("deprecation");
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(txtDate.getDate());
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int date = calendar.get(Calendar.DAY_OF_MONTH);
			String datestr = year+"-"+month+"-"+date;
			
			//Calendar c = new Ca
			try {
				if (addRecord) {
					// addNew();
					//txtSiteCode.setd
					controller.addNew(idSanPham, number, unit, datestr);
					clearInputBoxes();
				} else {
					controller.updateRecord(idDSMHCD, idSanPham, number, unit, datestr);
					// updateRecord();
				}

				loadRecords();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	@Override
	public Container draw() {
		try {
			loadRecords();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return this;
	}

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		try {
			loadRecords();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

