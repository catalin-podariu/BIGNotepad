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

		
		notepad.replaceDialog = new javax.swing.JDialog();
		notepad.replaceDFindNext = new javax.swing.JButton();
		notepad.replaceDFindPrev = new javax.swing.JButton();
		notepad.replaceDReplace = new javax.swing.JButton();
		notepad.replaceDReplaceAll = new javax.swing.JButton();
		notepad.replaceDClose = new javax.swing.JButton();
		notepad.replaceDSearchLabel = new javax.swing.JLabel();
		notepad.replaceDSearchCombo = new javax.swing.JComboBox();
		notepad.replaceDReplaceCombo = new javax.swing.JComboBox();
		notepad.replaceDReplaceLabel = new javax.swing.JLabel();
		notepad.replaceDSelectedText = new javax.swing.JCheckBox();
		notepad.replaceDMatchWord = new javax.swing.JCheckBox();
		notepad.replaceDMatchCase = new javax.swing.JCheckBox();
		notepad.replaceDRegex = new javax.swing.JCheckBox();
		notepad.replaceDMatchWordStart = new javax.swing.JCheckBox();
		notepad.replaceGotoFind = new javax.swing.JLabel();
		notepad.highlightRSearchCombo = new javax.swing.JCheckBox();
		notepad.incrementalRSearchCombo = new javax.swing.JCheckBox();
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
		notepad.editorScrollPane = new javax.swing.JScrollPane();
		notepad.bigEdit = new javax.swing.JTextPane();
		notepad.mainStatusPanel = new javax.swing.JPanel();
		notepad.lineColSelStatusPanel = new javax.swing.JPanel();
		notepad.lineColSelStatusLabel = new javax.swing.JLabel();
		notepad.encodingStatusPanel = new javax.swing.JPanel();
		notepad.encodingStatusLabel = new javax.swing.JLabel();
		notepad.mainMenu = new javax.swing.JMenuBar();
		notepad.fileMenu = new javax.swing.JMenu();
		notepad.fileNewMenuItem = new javax.swing.JMenuItem();
		notepad.fileNewEmptyWindow = new javax.swing.JMenuItem();
		notepad.fileOpenMenuItem = new javax.swing.JMenuItem();
		notepad.fileSeparator1 = new javax.swing.JPopupMenu.Separator();
		notepad.fileSaveMenuItem = new javax.swing.JMenuItem();
		notepad.fileSaveAsMenuItem = new javax.swing.JMenuItem();
		notepad.fileSetReadOnlyMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.fileSeparator2 = new javax.swing.JPopupMenu.Separator();
		notepad.jMenu2 = new javax.swing.JMenu();
		notepad.fileEncodingANSI = new javax.swing.JMenuItem();
		notepad.fileEncodingUnicode = new javax.swing.JMenuItem();
		notepad.fileEncodingBE = new javax.swing.JMenuItem();
		notepad.fileEncodingUTF8 = new javax.swing.JMenuItem();
		notepad.fileEncodingLatin1 = new javax.swing.JMenuItem();
		notepad.fileSeparator3 = new javax.swing.JPopupMenu.Separator();
		notepad.filePrintMenuItem = new javax.swing.JMenuItem();
		notepad.fileSeparator4 = new javax.swing.JPopupMenu.Separator();
		notepad.jMenuItem8 = new javax.swing.JMenuItem();
		notepad.fileSeparator5 = new javax.swing.JPopupMenu.Separator();
		notepad.fileRecentMenu = new javax.swing.JMenu();
		notepad.fileSeparator6 = new javax.swing.JPopupMenu.Separator();
		notepad.fileExitMenuItem = new javax.swing.JMenuItem();
		notepad.editMenu = new javax.swing.JMenu();
		notepad.editUndoMenuItem = new javax.swing.JMenuItem();
		notepad.editRedoMenuItem = new javax.swing.JMenuItem();
		notepad.jSeparator1 = new javax.swing.JPopupMenu.Separator();
		notepad.editCutMenuItem = new javax.swing.JMenuItem();
		notepad.editCopyMenuItem = new javax.swing.JMenuItem();
		notepad.editPasteMenuItem = new javax.swing.JMenuItem();
		notepad.editSelectAllMenuItem = new javax.swing.JMenuItem();
		notepad.editClearClipboardMenuItem = new javax.swing.JMenuItem();
		notepad.jSeparator5 = new javax.swing.JPopupMenu.Separator();
		notepad.findMenuItem = new javax.swing.JMenuItem();
		notepad.replaceMenuItem = new javax.swing.JMenuItem();
		notepad.jSeparator10 = new javax.swing.JPopupMenu.Separator();
		notepad.editInsertMenu = new javax.swing.JMenu();
		notepad.insertShortDate = new javax.swing.JMenuItem();
		notepad.insertLongDate = new javax.swing.JMenuItem();
		notepad.jSeparator2 = new javax.swing.JPopupMenu.Separator();
		notepad.editConvertMenu = new javax.swing.JMenu();
		notepad.editConvToLowerCase = new javax.swing.JMenuItem();
		notepad.editConvToUpperCase = new javax.swing.JMenuItem();
		notepad.editConvInvertCase = new javax.swing.JMenuItem();
		notepad.viewMenu = new javax.swing.JMenu();
		notepad.viewLongLineMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.viewWrapMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.viewDefaultFont = new javax.swing.JMenuItem();
		notepad.jSeparator3 = new javax.swing.JPopupMenu.Separator();
		notepad.viewQuickMMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.viewStatusBarMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.displayLineNumMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.viewThemeMenuItem = new javax.swing.JMenuItem();
		notepad.viewResetZoomMenuItem = new javax.swing.JMenuItem();
		notepad.settingsMenu = new javax.swing.JMenu();
		notepad.settAlwaysOnTopMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.setMinToTrayMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.settingsMainWindowSizePosition = new javax.swing.JCheckBoxMenuItem();
		notepad.settRecentFilesMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.settRecentSearchMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.jSeparator6 = new javax.swing.JPopupMenu.Separator();
		notepad.jMenu1 = new javax.swing.JMenu();
		notepad.winTitleDisplayMode0 = new javax.swing.JMenuItem();
		notepad.winTitleDisplayMode1 = new javax.swing.JMenuItem();
		notepad.winTitleDisplayMode2 = new javax.swing.JMenuItem();
		notepad.settSaveOnExitMenuItem = new javax.swing.JCheckBoxMenuItem();
		notepad.settSaveNowMenuItem = new javax.swing.JMenuItem();
		notepad.jSeparator4 = new javax.swing.JPopupMenu.Separator();
		notepad.settingsResetAll = new javax.swing.JMenuItem();
		notepad.helpMenu = new javax.swing.JMenu();
		notepad.helpTopics = new javax.swing.JMenuItem();
		notepad.aboutAuthorMenuItem = new javax.swing.JMenuItem();

		
		
		
		
		
		
		notepad.replaceDialog.setTitle("Find and replace");
		notepad.replaceDialog.setAlwaysOnTop(true);
		notepad.replaceDialog.setMinimumSize(new java.awt.Dimension(440, 225));
		notepad.replaceDialog.setResizable(false);
		notepad.replaceDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent evt) {
				notepad.replaceDialogComponentShown(evt);
			}
		});
		notepad.replaceDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		notepad.replaceDFindNext.setText("Find next");
		notepad.replaceDFindNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.replaceDFindNextActionPerformed(evt);
			}
		});
		notepad.replaceDialog.getContentPane().add(notepad.replaceDFindNext, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 110, -1));

		notepad.replaceDFindPrev.setText("Find previeous");
		notepad.replaceDFindPrev.setEnabled(false);
		notepad.replaceDFindPrev.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.replaceDFindPrevActionPerformed(evt);
			}
		});
		notepad.replaceDialog.getContentPane().add(notepad.replaceDFindPrev, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 110, -1));

		notepad.replaceDReplace.setText("Replace");
		notepad.replaceDReplace.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.replaceDReplaceActionPerformed(evt);
			}
		});
		notepad.replaceDialog.getContentPane().add(notepad.replaceDReplace, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 110, -1));

		notepad.replaceDReplaceAll.setText("Replace all");
		notepad.replaceDReplaceAll.setEnabled(false);
		notepad.replaceDialog.getContentPane().add(notepad.replaceDReplaceAll, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 110, -1));

		notepad.replaceDClose.setText("Close");
		notepad.replaceDClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.replaceDCloseActionPerformed(evt);
			}
		});
		notepad.replaceDialog.getContentPane().add(notepad.replaceDClose, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 110, -1));

		notepad.replaceDSearchLabel.setText("Search String");
		notepad.replaceDialog.getContentPane().add(notepad.replaceDSearchLabel, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

		notepad.replaceDSearchCombo.setEditable(true);
		notepad.replaceDSearchCombo.setMaximumRowCount(10);
		notepad.replaceDialog.getContentPane().add(notepad.replaceDSearchCombo, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 280, -1));

		notepad.replaceDReplaceCombo.setEditable(true);
		notepad.replaceDReplaceCombo.setMaximumRowCount(10);
		notepad.replaceDialog.getContentPane().add(notepad.replaceDReplaceCombo, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 280, -1));

		notepad.replaceDReplaceLabel.setText("Replace with");
		notepad.replaceDialog.getContentPane().add(notepad.replaceDReplaceLabel, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

		notepad.replaceDSelectedText.setText("Within selected text");
		notepad.replaceDSelectedText.setEnabled(false);
		notepad.replaceDialog.getContentPane().add(notepad.replaceDSelectedText, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 130, 20));

		notepad.replaceDMatchWord.setText("Match whole word only");
		notepad.replaceDMatchWord.setEnabled(false);
		notepad.replaceDialog.getContentPane().add(notepad.replaceDMatchWord, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 170, 20));

		notepad.replaceDMatchCase.setText("Match case");
		notepad.replaceDMatchCase.setEnabled(false);
		notepad.replaceDialog.getContentPane().add(notepad.replaceDMatchCase, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, 20));

		notepad.replaceDRegex.setText("Regular expresion search");
		notepad.replaceDRegex.setEnabled(false);
		notepad.replaceDialog.getContentPane().add(notepad.replaceDRegex, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 180, 20));

		notepad.replaceDMatchWordStart.setText("Match begining of word only");
		notepad.replaceDMatchWordStart.setEnabled(false);
		notepad.replaceDialog.getContentPane().add(notepad.replaceDMatchWordStart, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 170, 20));

		notepad.replaceGotoFind.setForeground(new java.awt.Color(0, 0, 204));
		notepad.replaceGotoFind.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		notepad.replaceGotoFind.setText("Goto Find(Ctrl+F)");
		notepad.replaceGotoFind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		notepad.replaceGotoFind.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				notepad.replaceGotoFindMouseClicked(evt);
			}
		});
		notepad.replaceDialog.getContentPane().add(notepad.replaceGotoFind,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 100, 20));

		notepad.highlightRSearchCombo.setText("Highlight results");
		notepad.highlightRSearchCombo.setEnabled(false);
		notepad.replaceDialog.getContentPane().add(notepad.highlightRSearchCombo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 130, 20));

		notepad.incrementalRSearchCombo.setText("Incremental Search");
		notepad.incrementalRSearchCombo.setEnabled(false);
		notepad.replaceDialog.getContentPane().add(notepad.incrementalRSearchCombo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 130, 20));

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

		notepad.fileMenu.setText("File");

		notepad.fileNewMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
		notepad.fileNewMenuItem.setText("New..");
		notepad.fileNewMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileNewMenuItemActionPerformed(evt);
			}
		});
		notepad.fileMenu.add(notepad.fileNewMenuItem);

		notepad.fileNewEmptyWindow.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		notepad.fileNewEmptyWindow.setText("New empty window");
		notepad.fileNewEmptyWindow.setEnabled(false);
		notepad.fileNewEmptyWindow.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileNewEmptyWindowActionPerformed(evt);
			}
		});
		notepad.fileMenu.add(notepad.fileNewEmptyWindow);

		notepad.fileOpenMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
		notepad.fileOpenMenuItem.setText("Open..");
		notepad.fileOpenMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileOpenMenuItemActionPerformed(evt);
			}
		});
		notepad.fileMenu.add(notepad.fileOpenMenuItem);
		notepad.fileMenu.add(notepad.fileSeparator1);

		notepad.fileSaveMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
		notepad.fileSaveMenuItem.setText("Save");
		notepad.fileSaveMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileSaveMenuItemActionPerformed(evt);
			}
		});
		notepad.fileMenu.add(notepad.fileSaveMenuItem);

		notepad.fileSaveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		notepad.fileSaveAsMenuItem.setText("Save as..");
		notepad.fileSaveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileSaveAsMenuItemActionPerformed(evt);
			}
		});
		notepad.fileMenu.add(notepad.fileSaveAsMenuItem);

		notepad.fileSetReadOnlyMenuItem.setText("Read only");
		notepad.fileSetReadOnlyMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileSetReadOnlyMenuItemActionPerformed(evt);
			}
		});
		notepad.fileMenu.add(notepad.fileSetReadOnlyMenuItem);
		notepad.fileMenu.add(notepad.fileSeparator2);

		notepad.jMenu2.setText("File encoding");

		notepad.fileEncodingANSI.setText("ANSI");
		notepad.fileEncodingANSI.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileEncodingANSIActionPerformed(evt);
			}
		});
		notepad.jMenu2.add(notepad.fileEncodingANSI);

		notepad.fileEncodingUnicode.setText("Unicode");
		notepad.fileEncodingUnicode.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileEncodingUnicodeActionPerformed(evt);
			}
		});
		notepad.jMenu2.add(notepad.fileEncodingUnicode);

		notepad.fileEncodingBE.setText("Unicode Big Endian");
		notepad.fileEncodingBE.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileEncodingBEActionPerformed(evt);
			}
		});
		notepad.jMenu2.add(notepad.fileEncodingBE);

		notepad.fileEncodingUTF8.setText("UTF-8");
		notepad.fileEncodingUTF8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileEncodingUTF8ActionPerformed(evt);
			}
		});
		notepad.jMenu2.add(notepad.fileEncodingUTF8);

		notepad.fileEncodingLatin1.setText("ISO-LATIN-1");
		notepad.fileEncodingLatin1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileEncodingLatin1ActionPerformed(evt);
			}
		});
		notepad.jMenu2.add(notepad.fileEncodingLatin1);

		notepad.fileMenu.add(notepad.jMenu2);
		notepad.fileMenu.add(notepad.fileSeparator3);

		notepad.filePrintMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
		notepad.filePrintMenuItem.setText("Print..");
		notepad.filePrintMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.filePrintMenuItemActionPerformed(evt);
			}
		});
		notepad.fileMenu.add(notepad.filePrintMenuItem);
		notepad.fileMenu.add(notepad.fileSeparator4);

		notepad.jMenuItem8.setText("File properties");
		notepad.jMenuItem8.setEnabled(false);
		notepad.fileMenu.add(notepad.jMenuItem8);
		notepad.fileMenu.add(notepad.fileSeparator5);

		notepad.fileRecentMenu.setText("Recent files");
		notepad.fileMenu.add(notepad.fileRecentMenu);
		notepad.fileMenu.add(notepad.fileSeparator6);

		notepad.fileExitMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
		notepad.fileExitMenuItem.setText("Exit");
		notepad.fileExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.fileExitMenuItemActionPerformed(evt);
			}
		});
		notepad.fileMenu.add(notepad.fileExitMenuItem);

		notepad.mainMenu.add(notepad.fileMenu);

		notepad.editMenu.setText("Edit");
		notepad.editMenu.addMenuListener(new javax.swing.event.MenuListener() {
			public void menuCanceled(javax.swing.event.MenuEvent evt) {
			}

			public void menuDeselected(javax.swing.event.MenuEvent evt) {
			}

			public void menuSelected(javax.swing.event.MenuEvent evt) {
				notepad.editMenuMenuSelected(evt);
			}
		});

		notepad.editUndoMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
		notepad.editUndoMenuItem.setText("Undo");
		notepad.editUndoMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.editUndoMenuItemActionPerformed(evt);
			}
		});
		notepad.editMenu.add(notepad.editUndoMenuItem);

		notepad.editRedoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		notepad.editRedoMenuItem.setText("Redo");
		notepad.editRedoMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.editRedoMenuItemActionPerformed(evt);
			}
		});
		notepad.editMenu.add(notepad.editRedoMenuItem);
		notepad.editMenu.add(notepad.jSeparator1);

		notepad.editCutMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
		notepad.editCutMenuItem.setText("Cut");
		notepad.editCutMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.editCutMenuItemActionPerformed(evt);
			}
		});
		notepad.editMenu.add(notepad.editCutMenuItem);

		notepad.editCopyMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
		notepad.editCopyMenuItem.setText("Copy");
		notepad.editCopyMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.editCopyMenuItemActionPerformed(evt);
			}
		});
		notepad.editMenu.add(notepad.editCopyMenuItem);

		notepad.editPasteMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
		notepad.editPasteMenuItem.setText("Paste");
		notepad.editPasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.editPasteMenuItemActionPerformed(evt);
			}
		});
		notepad.editMenu.add(notepad.editPasteMenuItem);

		notepad.editSelectAllMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
		notepad.editSelectAllMenuItem.setText("Select all");
		notepad.editSelectAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.editSelectAllMenuItemActionPerformed(evt);
			}
		});
		notepad.editMenu.add(notepad.editSelectAllMenuItem);

		notepad.editClearClipboardMenuItem
				.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PERIOD,
						java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		notepad.editClearClipboardMenuItem.setText("Clear clipboard");
		notepad.editClearClipboardMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.editClearClipboardMenuItemActionPerformed(evt);
			}
		});
		notepad.editMenu.add(notepad.editClearClipboardMenuItem);
		notepad.editMenu.add(notepad.jSeparator5);

		notepad.findMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
		notepad.findMenuItem.setText("Find String..");
		notepad.findMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.findMenuItemActionPerformed(evt);
			}
		});
		notepad.editMenu.add(notepad.findMenuItem);

		notepad.replaceMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
		notepad.replaceMenuItem.setText("Replace String..");
		notepad.replaceMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.replaceMenuItemActionPerformed(evt);
			}
		});
		notepad.editMenu.add(notepad.replaceMenuItem);
		notepad.editMenu.add(notepad.jSeparator10);

		notepad.editInsertMenu.setText("Insert..");

		notepad.insertShortDate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
		notepad.insertShortDate.setText("Date (short: Thu 17.08.2015 - 05:37:37)");
		notepad.insertShortDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.insertShortDateActionPerformed(evt);
			}
		});
		notepad.editInsertMenu.add(notepad.insertShortDate);

		notepad.insertLongDate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
		notepad.insertLongDate.setText("Date (long: Thu Aug 27 17:37:37 GMT+02:00 2015");
		notepad.insertLongDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.insertLongDateActionPerformed(evt);
			}
		});
		notepad.editInsertMenu.add(notepad.insertLongDate);

		notepad.editMenu.add(notepad.editInsertMenu);
		notepad.editMenu.add(notepad.jSeparator2);

		notepad.editConvertMenu.setText("Convert");

		notepad.editConvToLowerCase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2,
				java.awt.event.InputEvent.SHIFT_MASK));
		notepad.editConvToLowerCase.setText("lowercase");
		notepad.editConvToLowerCase.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.editConvToLowerCaseActionPerformed(evt);
			}
		});
		notepad.editConvertMenu.add(notepad.editConvToLowerCase);

		notepad.editConvToUpperCase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3,
				java.awt.event.InputEvent.SHIFT_MASK));
		notepad.editConvToUpperCase.setText("UPPERCASE");
		notepad.editConvToUpperCase.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.editConvToUpperCaseActionPerformed(evt);
			}
		});
		notepad.editConvertMenu.add(notepad.editConvToUpperCase);

		notepad.editConvInvertCase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4,
				java.awt.event.InputEvent.SHIFT_MASK));
		notepad.editConvInvertCase.setText("iNVERT cASE");
		notepad.editConvInvertCase.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.editConvInvertCaseActionPerformed(evt);
			}
		});
		notepad.editConvertMenu.add(notepad.editConvInvertCase);

		notepad.editMenu.add(notepad.editConvertMenu);

		notepad.mainMenu.add(notepad.editMenu);

		notepad.viewMenu.setText("View");

		notepad.viewLongLineMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		notepad.viewLongLineMenuItem.setText("Long line marker");
		notepad.viewLongLineMenuItem.setEnabled(false);
		notepad.viewLongLineMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.viewLongLineMenuItemActionPerformed(evt);
			}
		});
		notepad.viewMenu.add(notepad.viewLongLineMenuItem);

		notepad.viewWrapMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		notepad.viewWrapMenuItem.setText("Word wrap");
		notepad.viewWrapMenuItem.setEnabled(false);
		notepad.viewWrapMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.viewWrapMenuItemActionPerformed(evt);
			}
		});
		notepad.viewMenu.add(notepad.viewWrapMenuItem);

		notepad.viewDefaultFont.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, java.awt.event.InputEvent.ALT_MASK));
		notepad.viewDefaultFont.setText("Default Font..");
		notepad.viewDefaultFont.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.viewDefaultFontActionPerformed(evt);
			}
		});
		notepad.viewMenu.add(notepad.viewDefaultFont);
		notepad.viewMenu.add(notepad.jSeparator3);

		notepad.viewQuickMMenuItem.setText("View quick menu");
		notepad.viewQuickMMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.viewQuickMMenuItemActionPerformed(evt);
			}
		});
		notepad.viewMenu.add(notepad.viewQuickMMenuItem);

		notepad.viewStatusBarMenuItem.setText("View status-bar");
		notepad.viewStatusBarMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.viewStatusBarMenuItemActionPerformed(evt);
			}
		});
		notepad.viewMenu.add(notepad.viewStatusBarMenuItem);

		notepad.displayLineNumMenuItem.setText("Line numbers");
		notepad.displayLineNumMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.displayLineNumMenuItemActionPerformed(evt);
			}
		});
		notepad.viewMenu.add(notepad.displayLineNumMenuItem);

		notepad.viewThemeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T,
				java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
		notepad.viewThemeMenuItem.setText("Select color theme..");
		notepad.viewThemeMenuItem.setEnabled(false);
		notepad.viewThemeMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.viewThemeMenuItemActionPerformed(evt);
			}
		});
		notepad.viewMenu.add(notepad.viewThemeMenuItem);

		notepad.viewResetZoomMenuItem.setAccelerator(javax.swing.KeyStroke
				.getKeyStroke(java.awt.event.KeyEvent.VK_SLASH, java.awt.event.InputEvent.CTRL_MASK));
		notepad.viewResetZoomMenuItem.setText("Reset zoom");
		notepad.viewResetZoomMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.viewResetZoomMenuItemActionPerformed(evt);
			}
		});
		notepad.viewMenu.add(notepad.viewResetZoomMenuItem);

		notepad.mainMenu.add(notepad.viewMenu);

		notepad.settingsMenu.setText("Settings");

		notepad.settAlwaysOnTopMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
		notepad.settAlwaysOnTopMenuItem.setText("Always on top");
		notepad.settAlwaysOnTopMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.settAlwaysOnTopMenuItemActionPerformed(evt);
			}
		});
		notepad.settingsMenu.add(notepad.settAlwaysOnTopMenuItem);

		notepad.setMinToTrayMenuItem.setText("Minimize to tray");
		notepad.setMinToTrayMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.setMinToTrayMenuItemActionPerformed(evt);
			}
		});
		notepad.settingsMenu.add(notepad.setMinToTrayMenuItem);

		notepad.settingsMainWindowSizePosition.setText("Remember window size/position");
		notepad.settingsMainWindowSizePosition.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.settingsWinSizePositionActionPerformed(evt);
			}
		});
		notepad.settingsMenu.add(notepad.settingsMainWindowSizePosition);

		notepad.settRecentFilesMenuItem.setText("Remember recent files");
		notepad.settRecentFilesMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.settRecentFilesMenuItemActionPerformed(evt);
			}
		});
		notepad.settingsMenu.add(notepad.settRecentFilesMenuItem);

		notepad.settRecentSearchMenuItem.setText("Remember recent searches");
		notepad.settRecentSearchMenuItem.setEnabled(false);
		notepad.settRecentSearchMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.settRecentSearchMenuItemActionPerformed(evt);
			}
		});
		notepad.settingsMenu.add(notepad.settRecentSearchMenuItem);
		notepad.settingsMenu.add(notepad.jSeparator6);

		notepad.jMenu1.setText("Window title display");

		notepad.winTitleDisplayMode0.setText("File name only");
		notepad.winTitleDisplayMode0.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.winTitleDisplayMode0ActionPerformed(evt);
			}
		});
		notepad.jMenu1.add(notepad.winTitleDisplayMode0);

		notepad.winTitleDisplayMode1.setText("File name and Directory");
		notepad.winTitleDisplayMode1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.winTitleDisplayMode1ActionPerformed(evt);
			}
		});
		notepad.jMenu1.add(notepad.winTitleDisplayMode1);

		notepad.winTitleDisplayMode2.setText("Full path");
		notepad.winTitleDisplayMode2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.winTitleDisplayMode2ActionPerformed(evt);
			}
		});
		notepad.jMenu1.add(notepad.winTitleDisplayMode2);

		notepad.settingsMenu.add(notepad.jMenu1);

		notepad.settSaveOnExitMenuItem.setText("Save settings on exit");
		notepad.settSaveOnExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.settSaveOnExitMenuItemActionPerformed(evt);
			}
		});
		notepad.settingsMenu.add(notepad.settSaveOnExitMenuItem);

		notepad.settSaveNowMenuItem
				.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
		notepad.settSaveNowMenuItem.setText("Save settings now..");
		notepad.settSaveNowMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.settSaveNowMenuItemActionPerformed(evt);
			}
		});
		notepad.settingsMenu.add(notepad.settSaveNowMenuItem);
		notepad.settingsMenu.add(notepad.jSeparator4);

		notepad.settingsResetAll.setText("Reset all preferences");
		notepad.settingsResetAll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.settingsResetAllActionPerformed(evt);
			}
		});
		notepad.settingsMenu.add(notepad.settingsResetAll);

		notepad.mainMenu.add(notepad.settingsMenu);

		notepad.helpMenu.setText("Help");

		notepad.helpTopics.setText("Help topics..");
		notepad.helpTopics.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.helpTopicsActionPerformed(evt);
			}
		});
		notepad.helpMenu.add(notepad.helpTopics);

		notepad.aboutAuthorMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1,
				java.awt.event.InputEvent.SHIFT_MASK));
		notepad.aboutAuthorMenuItem.setText("About..");
		notepad.aboutAuthorMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				notepad.aboutAuthorMenuItemActionPerformed(evt);
			}
		});
		notepad.helpMenu.add(notepad.aboutAuthorMenuItem);

		notepad.mainMenu.add(notepad.helpMenu);

		notepad.setJMenuBar(notepad.mainMenu);

		notepad.pack();
	}

	private BIGNotepad notepad;
}
