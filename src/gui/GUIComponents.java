package gui;

/**
 * 
 * @author catalin.podariu[at]gmail.com
 *
 */
public class GUIComponents {

	public GUIComponents(BIGNotepad notepad) {
		this.notepad = notepad;
	}

	protected void initComponents() {

		
		notepad.findDialog = new javax.swing.JDialog();
		notepad.findDFindNext = new javax.swing.JButton();
		notepad.findDFindPrev = new javax.swing.JButton();
		notepad.findDClose = new javax.swing.JButton();
		notepad.findDSearchLabel = new javax.swing.JLabel();
		notepad.findDSearchCombo = new javax.swing.JComboBox();
		notepad.highlightSearchCombo = new javax.swing.JCheckBox();
		notepad.incrementalSearchCombo = new javax.swing.JCheckBox();
		notepad.findDSelectedText = new javax.swing.JCheckBox();
		notepad.findDMatchWord = new javax.swing.JCheckBox();
		notepad.findDMatchCase = new javax.swing.JCheckBox();
		notepad.findDRegex = new javax.swing.JCheckBox();
		notepad.findDMatchWordStart = new javax.swing.JCheckBox();
		notepad.findGotoReplace = new javax.swing.JLabel();

		notepad.quickIconsPanel = new javax.swing.JPanel();
		notepad.newFileIcon = new javax.swing.JLabel();
		notepad.separatorLabel = new javax.swing.JLabel();
		notepad.openFileIcon = new javax.swing.JLabel();
		notepad.separatorLabel1 = new javax.swing.JLabel();
		notepad.saveFileIcon = new javax.swing.JLabel();
		notepad.separatorLabel2 = new javax.swing.JLabel();
		notepad.findStringIcon = new javax.swing.JLabel();
		notepad.separatorLabel3 = new javax.swing.JLabel();
		notepad.bigEdit = new javax.swing.JTextPane();
		notepad.mainStatusPanel = new javax.swing.JPanel();
		notepad.lineColSelStatusPanel = new javax.swing.JPanel();
		notepad.lineColSelStatusLabel = new javax.swing.JLabel();
		notepad.editorScrollPane = new javax.swing.JScrollPane();
		notepad.encodingStatusPanel = new javax.swing.JPanel();
		notepad.encodingStatusLabel = new javax.swing.JLabel();

		

		notepad.findDialog.setTitle("Find String");
		notepad.findDialog.setAlwaysOnTop(true);
		notepad.findDialog.setMinimumSize(new java.awt.Dimension(440, 180));
		notepad.findDialog.setName("findDialog"); // NOI18N
		notepad.findDialog.setResizable(false);
		notepad.findDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent evt) {
				notepad.findDialogComponentShown(evt);
			}
		});
		notepad.findDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		notepad.findDFindNext.setText("Find next");
		notepad.findDFindNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.findDFindNextActionPerformed(evt);
			}
		});
		notepad.findDialog.getContentPane().add(notepad.findDFindNext, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 110, -1));

		notepad.findDFindPrev.setText("Find previeous");
		notepad.findDFindPrev.setEnabled(false);
		notepad.findDFindPrev.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.findDFindPrevActionPerformed(evt);
			}
		});
		notepad.findDialog.getContentPane().add(notepad.findDFindPrev, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 110, -1));

		notepad.findDClose.setText("Close");
		notepad.findDClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.findDCloseActionPerformed(evt);
			}
		});
		notepad.findDialog.getContentPane().add(notepad.findDClose, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 110, -1));

		notepad.findDSearchLabel.setText("Search String");
		notepad.findDialog.getContentPane().add(notepad.findDSearchLabel, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

		notepad.findDSearchCombo.setEditable(true);
		notepad.findDSearchCombo.setMaximumRowCount(10);
		notepad.findDialog.getContentPane().add(notepad.findDSearchCombo, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 280, -1));

		notepad.highlightSearchCombo.setText("Highlight results");
		notepad.highlightSearchCombo.setEnabled(false);
		notepad.findDialog.getContentPane().add(notepad.highlightSearchCombo, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 130, 20));

		notepad.incrementalSearchCombo.setText("Incremental Search");
		notepad.incrementalSearchCombo.setEnabled(false);
		notepad.findDialog.getContentPane().add(notepad.incrementalSearchCombo, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 130, 20));

		notepad.findDSelectedText.setText("Within selected text");
		notepad.findDSelectedText.setEnabled(false);
		notepad.findDialog.getContentPane().add(notepad.findDSelectedText, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 130, 20));

		notepad.findDMatchWord.setText("Match whole word only");
		notepad.findDMatchWord.setEnabled(false);
		notepad.findDialog.getContentPane().add(notepad.findDMatchWord, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 170, 20));

		notepad.findDMatchCase.setText("Match case");
		notepad.findDMatchCase.setEnabled(false);
		notepad.findDialog.getContentPane().add(notepad.findDMatchCase, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, 20));

		notepad.findDRegex.setText("Regular expresion search");
		notepad.findDRegex.setEnabled(false);
		notepad.findDialog.getContentPane().add(notepad.findDRegex, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 180, 20));

		notepad.findDMatchWordStart.setText("Match begining of word only");
		notepad.findDMatchWordStart.setEnabled(false);
		notepad.findDialog.getContentPane().add(notepad.findDMatchWordStart, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 20));

		notepad.findGotoReplace.setForeground(new java.awt.Color(0, 0, 204));
		notepad.findGotoReplace.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		notepad.findGotoReplace.setText("Goto Replace(Ctrl+H)");
		notepad.findGotoReplace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		notepad.findGotoReplace.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				notepad.findGotoReplaceMouseClicked(evt);
			}
		});
		notepad.findDialog.getContentPane().add(notepad.findGotoReplace, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 130, 20));

		notepad.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		notepad.setTitle("Untitled document  |  BIGNotepad");
		notepad.setMinimumSize(new java.awt.Dimension(300, 99));
		notepad.setName("mainWindow");
		notepad.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				notepad.formWindowClosing(evt);
			}

			public void windowOpened(java.awt.event.WindowEvent evt) {
				notepad.formWindowOpened(evt);
			}
		});

		notepad.quickIconsPanel.setBackground(new java.awt.Color(204, 204, 204));
		notepad.quickIconsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		notepad.quickIconsPanel.setMaximumSize(new java.awt.Dimension(600, 24));
		notepad.quickIconsPanel.setMinimumSize(new java.awt.Dimension(600, 24));
		notepad.quickIconsPanel.setPreferredSize(new java.awt.Dimension(600, 24));
		notepad.quickIconsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

		notepad.newFileIcon.setBackground(new java.awt.Color(230, 230, 230));
		notepad.newFileIcon.setIcon(new javax.swing.ImageIcon( //
				"E:\\#JABA\\Copy\\#JAVA\\#APP\\Big Text Editor\\TextEditor\\src\\Resources\\images\\newFile.png"));
		notepad.newFileIcon.setToolTipText("New");
		notepad.newFileIcon.setOpaque(true);
		notepad.newFileIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				notepad.newFileIconMouseClicked(evt);
			}
		});
		notepad.quickIconsPanel.add(notepad.newFileIcon);

		notepad.separatorLabel.setBackground(new java.awt.Color(153, 153, 153));
		notepad.separatorLabel.setMaximumSize(new java.awt.Dimension(2, 20));
		notepad.separatorLabel.setMinimumSize(new java.awt.Dimension(2, 20));
		notepad.separatorLabel.setOpaque(true);
		notepad.separatorLabel.setPreferredSize(new java.awt.Dimension(2, 20));
		notepad.quickIconsPanel.add(notepad.separatorLabel);

		notepad.openFileIcon.setIcon(new javax.swing.ImageIcon(//
				"E:\\#JABA\\Copy\\#JAVA\\#APP\\Big Text Editor\\TextEditor\\src\\Resources\\images\\openFile.png")); // NOI18N
		notepad.openFileIcon.setToolTipText("Open");
		notepad.openFileIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				notepad.openFileIconMouseClicked(evt);
			}
		});
		notepad.quickIconsPanel.add(notepad.openFileIcon);

		notepad.separatorLabel1.setBackground(new java.awt.Color(153, 153, 153));
		notepad.separatorLabel1.setMaximumSize(new java.awt.Dimension(2, 20));
		notepad.separatorLabel1.setMinimumSize(new java.awt.Dimension(2, 20));
		notepad.separatorLabel1.setOpaque(true);
		notepad.separatorLabel1.setPreferredSize(new java.awt.Dimension(2, 20));
		notepad.quickIconsPanel.add(notepad.separatorLabel1);

		notepad.saveFileIcon.setIcon(new javax.swing.ImageIcon(//
				"E:\\#JABA\\Copy\\#JAVA\\#APP\\Big Text Editor\\TextEditor\\src\\Resources\\images\\saveFile.png")); // NOI18N
		notepad.saveFileIcon.setToolTipText("Save");
		notepad.saveFileIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				notepad.saveFileIconMouseClicked(evt);
			}
		});
		notepad.quickIconsPanel.add(notepad.saveFileIcon);

		notepad.separatorLabel2.setBackground(new java.awt.Color(153, 153, 153));
		notepad.separatorLabel2.setMaximumSize(new java.awt.Dimension(2, 20));
		notepad.separatorLabel2.setMinimumSize(new java.awt.Dimension(2, 20));
		notepad.separatorLabel2.setOpaque(true);
		notepad.separatorLabel2.setPreferredSize(new java.awt.Dimension(2, 20));
		notepad.quickIconsPanel.add(notepad.separatorLabel2);

		notepad.findStringIcon.setIcon(new javax.swing.ImageIcon(//
				"E:\\#JABA\\Copy\\#JAVA\\#APP\\Big Text Editor\\TextEditor\\src\\Resources\\images\\findFile.png")); // NOI18N
		notepad.findStringIcon.setToolTipText("Search");
		notepad.findStringIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				notepad.findStringIconMouseClicked(evt);
			}
		});
		notepad.quickIconsPanel.add(notepad.findStringIcon);

		notepad.separatorLabel3.setBackground(new java.awt.Color(153, 153, 153));
		notepad.separatorLabel3.setMaximumSize(new java.awt.Dimension(2, 20));
		notepad.separatorLabel3.setMinimumSize(new java.awt.Dimension(2, 20));
		notepad.separatorLabel3.setOpaque(true);
		notepad.separatorLabel3.setPreferredSize(new java.awt.Dimension(2, 20));
		notepad.quickIconsPanel.add(notepad.separatorLabel3);

		notepad.getContentPane().add(notepad.quickIconsPanel, java.awt.BorderLayout.NORTH);

		notepad.editorScrollPane.setBackground(new java.awt.Color(0, 51, 51));
		notepad.editorScrollPane.setBorder(null);
		notepad.editorScrollPane.setForeground(new java.awt.Color(204, 204, 204));
		notepad.editorScrollPane.setDoubleBuffered(true);
		notepad.editorScrollPane.setName("scroller"); // NOI18N
		notepad.editorScrollPane.setWheelScrollingEnabled(false);

		notepad.bigEdit.setBorder(null);
		notepad.bigEdit.setForeground(new java.awt.Color(51, 51, 51));
		notepad.bigEdit.setDoubleBuffered(true);
		notepad.bigEdit.setMaximumSize(new java.awt.Dimension(3600, 3000));
		notepad.bigEdit.setMinimumSize(new java.awt.Dimension(700, 500));
		notepad.bigEdit.setName("Edit1"); // NOI18N
		notepad.bigEdit.setPreferredSize(new java.awt.Dimension(700, 500));
		notepad.bigEdit.addCaretListener(new javax.swing.event.CaretListener() {
			public void caretUpdate(javax.swing.event.CaretEvent evt) {
				notepad.bigEditCaretUpdate(evt);
			}
		});
		notepad.bigEdit.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
			public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
				notepad.bigEditMouseWheelMoved(evt);
			}
		});
		notepad.bigEdit.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				notepad.bigEditMouseClicked(evt);
			}
		});
		notepad.editorScrollPane.setViewportView(notepad.bigEdit);

		notepad.getContentPane().add(notepad.editorScrollPane, java.awt.BorderLayout.CENTER);

		notepad.mainStatusPanel.setAlignmentX(0.0F);
		notepad.mainStatusPanel.setAlignmentY(0.0F);
		notepad.mainStatusPanel.setMaximumSize(new java.awt.Dimension(600, 25));
		notepad.mainStatusPanel.setMinimumSize(new java.awt.Dimension(600, 25));
		notepad.mainStatusPanel.setPreferredSize(new java.awt.Dimension(600, 25));
		notepad.mainStatusPanel.setLayout(new java.awt.BorderLayout());

		notepad.lineColSelStatusPanel.setBackground(new java.awt.Color(204, 204, 204));
		notepad.lineColSelStatusPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		notepad.lineColSelStatusPanel.setMaximumSize(new java.awt.Dimension(300, 25));
		notepad.lineColSelStatusPanel.setMinimumSize(new java.awt.Dimension(300, 25));
		notepad.lineColSelStatusPanel.setPreferredSize(new java.awt.Dimension(300, 25));
		java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0);
		flowLayout2.setAlignOnBaseline(true);
		notepad.lineColSelStatusPanel.setLayout(flowLayout2);

		notepad.lineColSelStatusLabel.setBackground(new java.awt.Color(102, 102, 102));
		notepad.lineColSelStatusLabel.setText("Ln 1 : 1  |  Chars: 0  |  Sel: 0");
		notepad.lineColSelStatusLabel.setMaximumSize(new java.awt.Dimension(295, 20));
		notepad.lineColSelStatusLabel.setMinimumSize(new java.awt.Dimension(295, 20));
		notepad.lineColSelStatusLabel.setPreferredSize(new java.awt.Dimension(295, 20));
		notepad.lineColSelStatusPanel.add(notepad.lineColSelStatusLabel);

		notepad.mainStatusPanel.add(notepad.lineColSelStatusPanel, java.awt.BorderLayout.CENTER);

		notepad.encodingStatusPanel.setBackground(new java.awt.Color(204, 204, 204));
		notepad.encodingStatusPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		notepad.encodingStatusPanel.setMaximumSize(new java.awt.Dimension(100, 25));
		notepad.encodingStatusPanel.setMinimumSize(new java.awt.Dimension(100, 25));
		notepad.encodingStatusPanel.setPreferredSize(new java.awt.Dimension(100, 25));
		notepad.encodingStatusPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		notepad.encodingStatusLabel.setBackground(new java.awt.Color(102, 102, 102));
		notepad.encodingStatusLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		notepad.encodingStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		notepad.encodingStatusLabel.setText("ENCODING");
		notepad.encodingStatusLabel.setPreferredSize(new java.awt.Dimension(95, 20));
		notepad.encodingStatusPanel.add(notepad.encodingStatusLabel);

		notepad.mainStatusPanel.add(notepad.encodingStatusPanel, java.awt.BorderLayout.WEST);

		notepad.getContentPane().add(notepad.mainStatusPanel, java.awt.BorderLayout.SOUTH);

		notepad.pack();
	}

	private BIGNotepad notepad;
}
