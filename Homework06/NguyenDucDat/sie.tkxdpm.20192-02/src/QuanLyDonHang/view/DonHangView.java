package QuanLyDonHang.view;

import util.DBUtilities;
import QuanLyDonHang.controller.DonHangController;
import QuanLyDonHang.entity.DonHang;
import QuanLyDonHang.model.DonHangModel;
import main.view.*;

import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DonHangView extends Container implements IView {
	DonHangController controller;

	private javax.swing.JTable jTable1;
	private javax.swing.JTextField txtMaDonHang;
	private javax.swing.JTextField txtNgayNhan;

	boolean addRecord = false;
	private JTextField txtSiteCode;

	private void clearInputBoxes() {
		txtMaDonHang.setText("");
		txtNgayNhan.setText("");;
		// cboGender.setSelectedItem("");
		txtByShip.setText("");
		txtByAir.setText("");
		txtOthers.setText("");
	}

	private void addNew() {
		// INSERT INTO `tkxdpm`.`transportationinfo` (`SiteCode`, `SiteName`, `byShip`)
		// VALUES ('265', '21321', '1312sadsd');
		String sql_stmt = "INSERT INTO donhang (maDonHang,ngayNhan)";
		sql_stmt += " VALUES ('" + txtMaDonHang.getText() + "','" + txtNgayNhan.getText() + "','" + txtByShip.getText()
				+ "','" + txtByAir.getText() + "','" + txtOthers.getText() + "')";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}

	private void updateRecord() {
		String sql_stmt = "UPDATE donHang SET ngayNhan = '" + txtNgayNhan.getText() + "'";
		// sql_stmt += ",gender = '" + cboGender.getSelectedItem().toString() + "'";
		sql_stmt += ",byShip = '" + txtByShip.getText() + "'";
		sql_stmt += ",byAir = '" + txtByAir.getText() + "'";
		sql_stmt += ",others = '" + txtOthers.getText() + "'";
		sql_stmt += " WHERE SiteCode = '" + txtMaDonHang.getText() + "'";

		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}

	private void deleteRecord() {
		controller.deleteRecord(txtID.getText());
//		String sql_stmt = "DELETE FROM transportationinfo WHERE id = '" + txtID.getText() + "'";
//		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}

	private void loadRecords() throws SQLException {
		// String sql_stmt = "SELECT * FROM transportationinfo;";
		DonHangModel tableModel = controller.loadRecords();
		jTable1.setModel(tableModel);
		jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (jTable1.getSelectedRow() >= 0) {
					Object maDonHang = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
					Object ngayNhan = jTable1.getValueAt(jTable1.getSelectedRow(), 1);
					Object byShip = jTable1.getValueAt(jTable1.getSelectedRow(), 2);
					Object byAir = jTable1.getValueAt(jTable1.getSelectedRow(), 3);
					Object others = jTable1.getValueAt(jTable1.getSelectedRow(), 4);
					Object id = jTable1.getValueAt(jTable1.getSelectedRow(), 5);
					// Object salary = jTable1.getValueAt(jTable1.getSelectedRow(), 5);

					txtMaDonHang.setText(maDonHang.toString());
					txtNgayNhan.setText(ngayNhan.toString());
					// cboGender.setSelectedItem(gender.toString());
					txtByShip.setText(byShip.toString());
					txtByAir.setText(byAir.toString());
					txtOthers.setText(others.toString());
					txtID.setText(id.toString());
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		});

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
	}

	public DonHangView() {
		this.controller = new DonHangController();
		initComponents();
	}

	public DonHangView(DonHangController ctrlr) {
		this.controller = ctrlr;

		initComponents();
	}

	private void initComponents() {

		javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
		javax.swing.JLabel jLabel4 = new javax.swing.JLabel();

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

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transportation Records Editor",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 11))); // NOI18N
		GridBagLayout gbl_jPanel1 = new GridBagLayout();
		gbl_jPanel1.columnWidths = new int[]{209, 209, 0};
		gbl_jPanel1.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 0};
		gbl_jPanel1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_jPanel1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		jPanel1.setLayout(gbl_jPanel1);
				javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
				
						jLabel2.setText("MaDonHang:");
						GridBagConstraints gbc_jLabel2 = new GridBagConstraints();
						gbc_jLabel2.fill = GridBagConstraints.BOTH;
						gbc_jLabel2.insets = new Insets(0, 0, 5, 5);
						gbc_jLabel2.gridx = 0;
						gbc_jLabel2.gridy = 0;
						jPanel1.add(jLabel2, gbc_jLabel2);
		
				txtMaDonHang = new javax.swing.JTextField();
				GridBagConstraints gbc_txtMaDonHang = new GridBagConstraints();
				gbc_txtMaDonHang.fill = GridBagConstraints.BOTH;
				gbc_txtMaDonHang.insets = new Insets(0, 0, 5, 0);
				gbc_txtMaDonHang.gridx = 1;
				gbc_txtMaDonHang.gridy = 0;
				jPanel1.add(txtMaDonHang, gbc_txtMaDonHang);
		javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
		jLabel3.setText("NgayNhan:");
		GridBagConstraints gbc_jLabel3 = new GridBagConstraints();
		gbc_jLabel3.fill = GridBagConstraints.BOTH;
		gbc_jLabel3.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel3.gridx = 0;
		gbc_jLabel3.gridy = 1;
		jPanel1.add(jLabel3, gbc_jLabel3);
		txtNgayNhan = new javax.swing.JTextField();
		GridBagConstraints gbc_txtNgayNhan = new GridBagConstraints();
		gbc_txtNgayNhan.fill = GridBagConstraints.BOTH;
		gbc_txtNgayNhan.insets = new Insets(0, 0, 5, 0);
		gbc_txtNgayNhan.gridx = 1;
		gbc_txtNgayNhan.gridy = 1;
		jPanel1.add(txtNgayNhan, gbc_txtNgayNhan);
		// cboGender = new javax.swing.JComboBox<>();
		javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
		//        jLabel4.setText("Gender:");
		//        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Male", "Female"}));
				jLabel5.setText("SiteCode:");
				GridBagConstraints gbc_jLabel5 = new GridBagConstraints();
				gbc_jLabel5.anchor = GridBagConstraints.EAST;
				gbc_jLabel5.fill = GridBagConstraints.VERTICAL;
				gbc_jLabel5.insets = new Insets(0, 0, 5, 5);
				gbc_jLabel5.gridx = 0;
				gbc_jLabel5.gridy = 2;
				jPanel1.add(jLabel5, gbc_jLabel5);

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
		btnDelete.setText("Delete");
		btnDelete.addActionListener(this::btnDeleteActionPerformed);

		btnClose.setText("Close");
		btnClose.addActionListener(this::btnCloseActionPerformed);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { {}, {}, {}, {} }, new String[] {

		}));
		jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(btnAddNew)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdate)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete)
							.addPreferredGap(ComponentPlacement.UNRELATED, 152, Short.MAX_VALUE)
							.addComponent(btnClose))
						.addGroup(layout.createSequentialGroup()
							.addGap(5)
							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddNew)
						.addComponent(btnUpdate)
						.addComponent(btnDelete)
						.addComponent(btnClose))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		txtSiteCode = new JTextField();
		GridBagConstraints gbc_txtSiteCode = new GridBagConstraints();
		gbc_txtSiteCode.insets = new Insets(0, 0, 5, 0);
		gbc_txtSiteCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSiteCode.gridx = 1;
		gbc_txtSiteCode.gridy = 2;
		jPanel1.add(txtSiteCode, gbc_txtSiteCode);
		this.setLayout(layout);
	}

	private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
		controller.moveToHome();
		// addBtn("Mat hang kinh doanh", e -> controller.moveToMHKD());
		// System.exit(1);
	}

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?",
				"Confirm Delete Record?", JOptionPane.YES_NO_OPTION);

		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				deleteRecord();

				loadRecords();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		String maDonHang = txtMaDonHang.getText();
		Date ngayNhan = Date.valueOf(txtNgayNhan.getText());
		String byShip = txtByShip.getText();
		String byAir = txtByAir.getText();
		String others = txtOthers.getText();
		String id = txtID.getText();
		// System.out.println(siteCode);

		if (maDonHang.length() == 0 || ngayNhan == null) {
			System.out.println("ERROR");
			JOptionPane.showMessageDialog(null, "Dien du thong tin.");
			// Alert()
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(null,
					addRecord ? "Confirm Add new record?" : "Are you sure you want to update this record?",
					addRecord ? "Confirm Add Record" : "Confirm Update Record?", JOptionPane.YES_NO_OPTION);

			if (dialogResult == JOptionPane.YES_OPTION) {
				DonHang data = new DonHang(maDonHang, ngayNhan);
				try {
					if (addRecord) {
						// addNew();
						// txtSiteCode.setd

						controller.addNew(data);
						clearInputBoxes();
					} else {

						controller.updateRecord(data, id);
						// updateRecord();
					}

					loadRecords();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	}

	@Override
	public Container draw() {
//		try {
//			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					javax.swing.UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException ex) {
//			java.util.logging.Logger.getLogger(TransportationWindow.class.getName()).log(java.util.logging.Level.SEVERE,
//					null, ex);
//		}
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
