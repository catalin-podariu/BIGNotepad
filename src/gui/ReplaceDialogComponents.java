package gui;

public class ReplaceDialogComponents {

	private ReplaceDialog dialog;

	protected ReplaceDialogComponents(ReplaceDialog dialog) {
		this.dialog = dialog;
	}

	protected void initComponents() {
		dialog.replaceDialog = new javax.swing.JDialog();
		dialog.replaceDFindNext = new javax.swing.JButton();
		dialog.replaceDFindPrev = new javax.swing.JButton();
		dialog.replaceDReplace = new javax.swing.JButton();
		dialog.replaceDReplaceAll = new javax.swing.JButton();
		dialog.replaceDClose = new javax.swing.JButton();
		dialog.replaceDSearchLabel = new javax.swing.JLabel();
		dialog.replaceDSearchCombo = new javax.swing.JComboBox();
		dialog.replaceDReplaceCombo = new javax.swing.JComboBox();
		dialog.replaceDReplaceLabel = new javax.swing.JLabel();
		dialog.replaceDSelectedText = new javax.swing.JCheckBox();
		dialog.replaceDMatchWord = new javax.swing.JCheckBox();
		dialog.replaceDMatchCase = new javax.swing.JCheckBox();
		dialog.replaceDRegex = new javax.swing.JCheckBox();
		dialog.replaceDMatchWordStart = new javax.swing.JCheckBox();
		dialog.replaceGotoFind = new javax.swing.JLabel();
		dialog.highlightRSearchCombo = new javax.swing.JCheckBox();
		dialog.incrementalRSearchCombo = new javax.swing.JCheckBox();

		dialog.replaceDialog.setTitle("Find and replace");
		dialog.replaceDialog.setAlwaysOnTop(true);
		dialog.replaceDialog.setMinimumSize(new java.awt.Dimension(440, 225));
		dialog.replaceDialog.setResizable(false);
		dialog.replaceDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent evt) {
				dialog.replaceDialogComponentShown(evt);
			}
		});
		dialog.replaceDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		dialog.replaceDFindNext.setText("Find next");
		dialog.replaceDFindNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dialog.replaceDFindNextActionPerformed(evt);
			}
		});
		dialog.replaceDialog.getContentPane().add(dialog.replaceDFindNext, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 110, -1));

		dialog.replaceDFindPrev.setText("Find previeous");
		dialog.replaceDFindPrev.setEnabled(false);
		dialog.replaceDFindPrev.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dialog.replaceDFindPrevActionPerformed(evt);
			}
		});
		dialog.replaceDialog.getContentPane().add(dialog.replaceDFindPrev, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 110, -1));

		dialog.replaceDReplace.setText("Replace");
		dialog.replaceDReplace.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dialog.replaceDReplaceActionPerformed(evt);
			}
		});
		dialog.replaceDialog.getContentPane().add(dialog.replaceDReplace, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 110, -1));

		dialog.replaceDReplaceAll.setText("Replace all");
		dialog.replaceDReplaceAll.setEnabled(false);
		dialog.replaceDialog.getContentPane().add(dialog.replaceDReplaceAll, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 110, -1));

		dialog.replaceDClose.setText("Close");
		dialog.replaceDClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dialog.replaceDCloseActionPerformed(evt);
			}
		});
		dialog.replaceDialog.getContentPane().add(dialog.replaceDClose, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 110, -1));

		dialog.replaceDSearchLabel.setText("Search String");
		dialog.replaceDialog.getContentPane().add(dialog.replaceDSearchLabel, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

		dialog.replaceDSearchCombo.setEditable(true);
		dialog.replaceDSearchCombo.setMaximumRowCount(10);
		dialog.replaceDialog.getContentPane().add(dialog.replaceDSearchCombo, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 280, -1));

		dialog.replaceDReplaceCombo.setEditable(true);
		dialog.replaceDReplaceCombo.setMaximumRowCount(10);
		dialog.replaceDialog.getContentPane().add(dialog.replaceDReplaceCombo, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 280, -1));

		dialog.replaceDReplaceLabel.setText("Replace with");
		dialog.replaceDialog.getContentPane().add(dialog.replaceDReplaceLabel, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

		dialog.replaceDSelectedText.setText("Within selected text");
		dialog.replaceDSelectedText.setEnabled(false);
		dialog.replaceDialog.getContentPane().add(dialog.replaceDSelectedText, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 130, 20));

		dialog.replaceDMatchWord.setText("Match whole word only");
		dialog.replaceDMatchWord.setEnabled(false);
		dialog.replaceDialog.getContentPane().add(dialog.replaceDMatchWord, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 170, 20));

		dialog.replaceDMatchCase.setText("Match case");
		dialog.replaceDMatchCase.setEnabled(false);
		dialog.replaceDialog.getContentPane().add(dialog.replaceDMatchCase, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, 20));

		dialog.replaceDRegex.setText("Regular expresion search");
		dialog.replaceDRegex.setEnabled(false);
		dialog.replaceDialog.getContentPane().add(dialog.replaceDRegex, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 180, 20));

		dialog.replaceDMatchWordStart.setText("Match begining of word only");
		dialog.replaceDMatchWordStart.setEnabled(false);
		dialog.replaceDialog.getContentPane().add(dialog.replaceDMatchWordStart, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 170, 20));

		dialog.replaceGotoFind.setForeground(new java.awt.Color(0, 0, 204));
		dialog.replaceGotoFind.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		dialog.replaceGotoFind.setText("Goto Find(Ctrl+F)");
		dialog.replaceGotoFind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		dialog.replaceGotoFind.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dialog.replaceGotoFindMouseClicked(evt);
			}
		});
		dialog.replaceDialog.getContentPane().add(dialog.replaceGotoFind,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 100, 20));

		dialog.highlightRSearchCombo.setText("Highlight results");
		dialog.highlightRSearchCombo.setEnabled(false);
		dialog.replaceDialog.getContentPane().add(dialog.highlightRSearchCombo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 130, 20));

		dialog.incrementalRSearchCombo.setText("Incremental Search");
		dialog.incrementalRSearchCombo.setEnabled(false);
		dialog.replaceDialog.getContentPane().add(dialog.incrementalRSearchCombo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 130, 20));
	}
}
