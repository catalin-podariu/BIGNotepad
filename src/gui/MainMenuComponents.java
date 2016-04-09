package gui;

public class MainMenuComponents {

	private MainMenu menu;
	private BIGNotepad notepad;

	public MainMenuComponents(BIGNotepad notepad, MainMenu menu) {
		this.notepad = notepad;
		this.menu = menu;
	}

	public void initComponents() {

		menu.mainMenu = new javax.swing.JMenuBar();
		menu.fileMenu = new javax.swing.JMenu();
		menu.fileNewMenuItem = new javax.swing.JMenuItem();
		menu.fileNewEmptyWindow = new javax.swing.JMenuItem();
		menu.fileOpenMenuItem = new javax.swing.JMenuItem();
		menu.fileSeparator1 = new javax.swing.JPopupMenu.Separator();
		menu.fileSaveMenuItem = new javax.swing.JMenuItem();
		menu.fileSaveAsMenuItem = new javax.swing.JMenuItem();
		menu.fileSetReadOnlyMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.fileSeparator2 = new javax.swing.JPopupMenu.Separator();
		menu.jMenu2 = new javax.swing.JMenu();
		menu.fileEncodingANSI = new javax.swing.JMenuItem();
		menu.fileEncodingUnicode = new javax.swing.JMenuItem();
		menu.fileEncodingBE = new javax.swing.JMenuItem();
		menu.fileEncodingUTF8 = new javax.swing.JMenuItem();
		menu.fileEncodingLatin1 = new javax.swing.JMenuItem();
		menu.fileSeparator3 = new javax.swing.JPopupMenu.Separator();
		menu.filePrintMenuItem = new javax.swing.JMenuItem();
		menu.fileSeparator4 = new javax.swing.JPopupMenu.Separator();
		menu.jMenuItem8 = new javax.swing.JMenuItem();
		menu.fileSeparator5 = new javax.swing.JPopupMenu.Separator();
		menu.fileRecentMenu = new javax.swing.JMenu();
		menu.fileSeparator6 = new javax.swing.JPopupMenu.Separator();
		menu.fileExitMenuItem = new javax.swing.JMenuItem();
		menu.editMenu = new javax.swing.JMenu();
		menu.editUndoMenuItem = new javax.swing.JMenuItem();
		menu.editRedoMenuItem = new javax.swing.JMenuItem();
		menu.jSeparator1 = new javax.swing.JPopupMenu.Separator();
		menu.editCutMenuItem = new javax.swing.JMenuItem();
		menu.editCopyMenuItem = new javax.swing.JMenuItem();
		menu.editPasteMenuItem = new javax.swing.JMenuItem();
		menu.editSelectAllMenuItem = new javax.swing.JMenuItem();
		menu.editClearClipboardMenuItem = new javax.swing.JMenuItem();
		menu.jSeparator5 = new javax.swing.JPopupMenu.Separator();
		menu.findMenuItem = new javax.swing.JMenuItem();
		menu.replaceMenuItem = new javax.swing.JMenuItem();
		menu.jSeparator10 = new javax.swing.JPopupMenu.Separator();
		menu.editInsertMenu = new javax.swing.JMenu();
		menu.insertShortDate = new javax.swing.JMenuItem();
		menu.insertLongDate = new javax.swing.JMenuItem();
		menu.jSeparator2 = new javax.swing.JPopupMenu.Separator();
		menu.editConvertMenu = new javax.swing.JMenu();
		menu.editConvToLowerCase = new javax.swing.JMenuItem();
		menu.editConvToUpperCase = new javax.swing.JMenuItem();
		menu.editConvInvertCase = new javax.swing.JMenuItem();
		menu.viewMenu = new javax.swing.JMenu();
		menu.viewLongLineMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.viewWrapMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.viewDefaultFont = new javax.swing.JMenuItem();
		menu.jSeparator3 = new javax.swing.JPopupMenu.Separator();
		menu.viewQuickMMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.viewStatusBarMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.displayLineNumMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.viewThemeMenuItem = new javax.swing.JMenuItem();
		menu.viewResetZoomMenuItem = new javax.swing.JMenuItem();
		menu.settingsMenu = new javax.swing.JMenu();
		menu.settAlwaysOnTopMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.setMinToTrayMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.settingsMainWindowSizePosition = new javax.swing.JCheckBoxMenuItem();
		menu.settRecentFilesMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.settRecentSearchMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.jSeparator6 = new javax.swing.JPopupMenu.Separator();
		menu.jMenu1 = new javax.swing.JMenu();
		menu.winTitleDisplayMode0 = new javax.swing.JMenuItem();
		menu.winTitleDisplayMode1 = new javax.swing.JMenuItem();
		menu.winTitleDisplayMode2 = new javax.swing.JMenuItem();
		menu.settSaveOnExitMenuItem = new javax.swing.JCheckBoxMenuItem();
		menu.settSaveNowMenuItem = new javax.swing.JMenuItem();
		menu.jSeparator4 = new javax.swing.JPopupMenu.Separator();
		menu.settingsResetAll = new javax.swing.JMenuItem();
		menu.helpMenu = new javax.swing.JMenu();
		menu.helpTopics = new javax.swing.JMenuItem();
		menu.aboutAuthorMenuItem = new javax.swing.JMenuItem();

		menu.fileMenu.setText("File");

		menu.fileNewMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
		menu.fileNewMenuItem.setText("New..");
		menu.fileNewMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileNewMenuItemActionPerformed(evt);
			}
		});
		menu.fileMenu.add(menu.fileNewMenuItem);

		menu.fileNewEmptyWindow.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		menu.fileNewEmptyWindow.setText("New empty window");
		menu.fileNewEmptyWindow.setEnabled(false);
		menu.fileNewEmptyWindow.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileNewEmptyWindowActionPerformed(evt);
			}
		});
		menu.fileMenu.add(menu.fileNewEmptyWindow);

		menu.fileOpenMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
		menu.fileOpenMenuItem.setText("Open..");
		menu.fileOpenMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileOpenMenuItemActionPerformed(evt);
			}
		});
		menu.fileMenu.add(menu.fileOpenMenuItem);
		menu.fileMenu.add(menu.fileSeparator1);

		menu.fileSaveMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
		menu.fileSaveMenuItem.setText("Save");
		menu.fileSaveMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileSaveMenuItemActionPerformed(evt);
			}
		});
		menu.fileMenu.add(menu.fileSaveMenuItem);

		menu.fileSaveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		menu.fileSaveAsMenuItem.setText("Save as..");
		menu.fileSaveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileSaveAsMenuItemActionPerformed(evt);
			}
		});
		menu.fileMenu.add(menu.fileSaveAsMenuItem);

		menu.fileSetReadOnlyMenuItem.setText("Read only");
		menu.fileSetReadOnlyMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileSetReadOnlyMenuItemActionPerformed(evt);
			}
		});
		menu.fileMenu.add(menu.fileSetReadOnlyMenuItem);
		menu.fileMenu.add(menu.fileSeparator2);

		menu.jMenu2.setText("File encoding");

		menu.fileEncodingANSI.setText("ANSI");
		menu.fileEncodingANSI.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileEncodingANSIActionPerformed(evt);
			}
		});
		menu.jMenu2.add(menu.fileEncodingANSI);

		menu.fileEncodingUnicode.setText("Unicode");
		menu.fileEncodingUnicode.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileEncodingUnicodeActionPerformed(evt);
			}
		});
		menu.jMenu2.add(menu.fileEncodingUnicode);

		menu.fileEncodingBE.setText("Unicode Big Endian");
		menu.fileEncodingBE.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileEncodingBEActionPerformed(evt);
			}
		});
		menu.jMenu2.add(menu.fileEncodingBE);

		menu.fileEncodingUTF8.setText("UTF-8");
		menu.fileEncodingUTF8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileEncodingUTF8ActionPerformed(evt);
			}
		});
		menu.jMenu2.add(menu.fileEncodingUTF8);

		menu.fileEncodingLatin1.setText("ISO-LATIN-1");
		menu.fileEncodingLatin1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileEncodingLatin1ActionPerformed(evt);
			}
		});
		menu.jMenu2.add(menu.fileEncodingLatin1);

		menu.fileMenu.add(menu.jMenu2);
		menu.fileMenu.add(menu.fileSeparator3);

		menu.filePrintMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
		menu.filePrintMenuItem.setText("Print..");
		menu.filePrintMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.filePrintMenuItemActionPerformed(evt);
			}
		});
		menu.fileMenu.add(menu.filePrintMenuItem);
		menu.fileMenu.add(menu.fileSeparator4);

		menu.jMenuItem8.setText("File properties");
		menu.jMenuItem8.setEnabled(false);
		menu.fileMenu.add(menu.jMenuItem8);
		menu.fileMenu.add(menu.fileSeparator5);

		menu.fileRecentMenu.setText("Recent files");
		menu.fileMenu.add(menu.fileRecentMenu);
		menu.fileMenu.add(menu.fileSeparator6);

		menu.fileExitMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
		menu.fileExitMenuItem.setText("Exit");
		menu.fileExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.fileExitMenuItemActionPerformed(evt);
			}
		});
		menu.fileMenu.add(menu.fileExitMenuItem);

		menu.mainMenu.add(menu.fileMenu);

		menu.editMenu.setText("Edit");
		menu.editMenu.addMenuListener(new javax.swing.event.MenuListener() {
			public void menuCanceled(javax.swing.event.MenuEvent evt) {
			}

			public void menuDeselected(javax.swing.event.MenuEvent evt) {
			}

			public void menuSelected(javax.swing.event.MenuEvent evt) {
				menu.editMenuMenuSelected(evt);
			}
		});

		menu.editUndoMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
		menu.editUndoMenuItem.setText("Undo");
		menu.editUndoMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.editUndoMenuItemActionPerformed(evt);
			}
		});
		menu.editMenu.add(menu.editUndoMenuItem);

		menu.editRedoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		menu.editRedoMenuItem.setText("Redo");
		menu.editRedoMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.editRedoMenuItemActionPerformed(evt);
			}
		});
		menu.editMenu.add(menu.editRedoMenuItem);
		menu.editMenu.add(menu.jSeparator1);

		menu.editCutMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
		menu.editCutMenuItem.setText("Cut");
		menu.editCutMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.editCutMenuItemActionPerformed(evt);
			}
		});
		menu.editMenu.add(menu.editCutMenuItem);

		menu.editCopyMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
		menu.editCopyMenuItem.setText("Copy");
		menu.editCopyMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.editCopyMenuItemActionPerformed(evt);
			}
		});
		menu.editMenu.add(menu.editCopyMenuItem);

		menu.editPasteMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
		menu.editPasteMenuItem.setText("Paste");
		menu.editPasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.editPasteMenuItemActionPerformed(evt);
			}
		});
		menu.editMenu.add(menu.editPasteMenuItem);

		menu.editSelectAllMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
		menu.editSelectAllMenuItem.setText("Select all");
		menu.editSelectAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.editSelectAllMenuItemActionPerformed(evt);
			}
		});
		menu.editMenu.add(menu.editSelectAllMenuItem);

		menu.editClearClipboardMenuItem
				.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PERIOD,
						java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		menu.editClearClipboardMenuItem.setText("Clear clipboard");
		menu.editClearClipboardMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.editClearClipboardMenuItemActionPerformed(evt);
			}
		});
		menu.editMenu.add(menu.editClearClipboardMenuItem);
		menu.editMenu.add(menu.jSeparator5);

		menu.findMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
		menu.findMenuItem.setText("Find String..");
		menu.findMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.findMenuItemActionPerformed(evt);
			}
		});
		menu.editMenu.add(menu.findMenuItem);

		menu.replaceMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
		menu.replaceMenuItem.setText("Replace String..");
		menu.replaceMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.replaceMenuItemActionPerformed(evt);
			}
		});
		menu.editMenu.add(menu.replaceMenuItem);
		menu.editMenu.add(menu.jSeparator10);

		menu.editInsertMenu.setText("Insert..");

		menu.insertShortDate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
		menu.insertShortDate.setText("Date (short: Thu 17.08.2015 - 05:37:37)");
		menu.insertShortDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.insertShortDateActionPerformed(evt);
			}
		});
		menu.editInsertMenu.add(menu.insertShortDate);

		menu.insertLongDate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
		menu.insertLongDate.setText("Date (long: Thu Aug 27 17:37:37 GMT+02:00 2015");
		menu.insertLongDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.insertLongDateActionPerformed(evt);
			}
		});
		menu.editInsertMenu.add(menu.insertLongDate);

		menu.editMenu.add(menu.editInsertMenu);
		menu.editMenu.add(menu.jSeparator2);

		menu.editConvertMenu.setText("Convert");

		menu.editConvToLowerCase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2,
				java.awt.event.InputEvent.SHIFT_MASK));
		menu.editConvToLowerCase.setText("lowercase");
		menu.editConvToLowerCase.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.editConvToLowerCaseActionPerformed(evt);
			}
		});
		menu.editConvertMenu.add(menu.editConvToLowerCase);

		menu.editConvToUpperCase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3,
				java.awt.event.InputEvent.SHIFT_MASK));
		menu.editConvToUpperCase.setText("UPPERCASE");
		menu.editConvToUpperCase.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.editConvToUpperCaseActionPerformed(evt);
			}
		});
		menu.editConvertMenu.add(menu.editConvToUpperCase);

		menu.editConvInvertCase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4,
				java.awt.event.InputEvent.SHIFT_MASK));
		menu.editConvInvertCase.setText("iNVERT cASE");
		menu.editConvInvertCase.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.editConvInvertCaseActionPerformed(evt);
			}
		});
		menu.editConvertMenu.add(menu.editConvInvertCase);

		menu.editMenu.add(menu.editConvertMenu);

		menu.mainMenu.add(menu.editMenu);

		menu.viewMenu.setText("View");

		menu.viewLongLineMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		menu.viewLongLineMenuItem.setText("Long line marker");
		menu.viewLongLineMenuItem.setEnabled(false);
		menu.viewLongLineMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.viewLongLineMenuItemActionPerformed(evt);
			}
		});
		menu.viewMenu.add(menu.viewLongLineMenuItem);

		menu.viewWrapMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		menu.viewWrapMenuItem.setText("Word wrap");
		menu.viewWrapMenuItem.setEnabled(false);
		menu.viewWrapMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.viewWrapMenuItemActionPerformed(evt);
			}
		});
		menu.viewMenu.add(menu.viewWrapMenuItem);

		menu.viewDefaultFont.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, java.awt.event.InputEvent.ALT_MASK));
		menu.viewDefaultFont.setText("Default Font..");
		menu.viewDefaultFont.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.viewDefaultFontActionPerformed(evt);
			}
		});
		menu.viewMenu.add(menu.viewDefaultFont);
		menu.viewMenu.add(menu.jSeparator3);

		menu.viewQuickMMenuItem.setText("View quick menu");
		menu.viewQuickMMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.viewQuickMMenuItemActionPerformed(evt);
			}
		});
		menu.viewMenu.add(menu.viewQuickMMenuItem);

		menu.viewStatusBarMenuItem.setText("View status-bar");
		menu.viewStatusBarMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.viewStatusBarMenuItemActionPerformed(evt);
			}
		});
		menu.viewMenu.add(menu.viewStatusBarMenuItem);

		menu.displayLineNumMenuItem.setText("Line numbers");
		menu.displayLineNumMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.displayLineNumMenuItemActionPerformed(evt);
			}
		});
		menu.viewMenu.add(menu.displayLineNumMenuItem);

		menu.viewThemeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T,
				java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
		menu.viewThemeMenuItem.setText("Select color theme..");
		menu.viewThemeMenuItem.setEnabled(false);
		menu.viewThemeMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.viewThemeMenuItemActionPerformed(evt);
			}
		});
		menu.viewMenu.add(menu.viewThemeMenuItem);

		menu.viewResetZoomMenuItem.setAccelerator(javax.swing.KeyStroke
				.getKeyStroke(java.awt.event.KeyEvent.VK_SLASH, java.awt.event.InputEvent.CTRL_MASK));
		menu.viewResetZoomMenuItem.setText("Reset zoom");
		menu.viewResetZoomMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.viewResetZoomMenuItemActionPerformed(evt);
			}
		});
		menu.viewMenu.add(menu.viewResetZoomMenuItem);

		menu.mainMenu.add(menu.viewMenu);

		menu.settingsMenu.setText("Settings");

		menu.settAlwaysOnTopMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
		menu.settAlwaysOnTopMenuItem.setText("Always on top");
		menu.settAlwaysOnTopMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.settAlwaysOnTopMenuItemActionPerformed(evt);
			}
		});
		menu.settingsMenu.add(menu.settAlwaysOnTopMenuItem);

		menu.setMinToTrayMenuItem.setText("Minimize to tray");
		menu.setMinToTrayMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.setMinToTrayMenuItemActionPerformed(evt);
			}
		});
		menu.settingsMenu.add(menu.setMinToTrayMenuItem);

		menu.settingsMainWindowSizePosition.setText("Remember window size/position");
		menu.settingsMainWindowSizePosition.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.settingsWinSizePositionActionPerformed(evt);
			}
		});
		menu.settingsMenu.add(menu.settingsMainWindowSizePosition);

		menu.settRecentFilesMenuItem.setText("Remember recent files");
		menu.settRecentFilesMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.settRecentFilesMenuItemActionPerformed(evt);
			}
		});
		menu.settingsMenu.add(menu.settRecentFilesMenuItem);

		menu.settRecentSearchMenuItem.setText("Remember recent searches");
		menu.settRecentSearchMenuItem.setEnabled(false);
		menu.settRecentSearchMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.settRecentSearchMenuItemActionPerformed(evt);
			}
		});
		menu.settingsMenu.add(menu.settRecentSearchMenuItem);
		menu.settingsMenu.add(menu.jSeparator6);

		menu.jMenu1.setText("Window title display");

		menu.winTitleDisplayMode0.setText("File name only");
		menu.winTitleDisplayMode0.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.winTitleDisplayMode0ActionPerformed(evt);
			}
		});
		menu.jMenu1.add(menu.winTitleDisplayMode0);

		menu.winTitleDisplayMode1.setText("File name and Directory");
		menu.winTitleDisplayMode1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.winTitleDisplayMode1ActionPerformed(evt);
			}
		});
		menu.jMenu1.add(menu.winTitleDisplayMode1);

		menu.winTitleDisplayMode2.setText("Full path");
		menu.winTitleDisplayMode2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.winTitleDisplayMode2ActionPerformed(evt);
			}
		});
		menu.jMenu1.add(menu.winTitleDisplayMode2);

		menu.settingsMenu.add(menu.jMenu1);

		menu.settSaveOnExitMenuItem.setText("Save settings on exit");
		menu.settSaveOnExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.settSaveOnExitMenuItemActionPerformed(evt);
			}
		});
		menu.settingsMenu.add(menu.settSaveOnExitMenuItem);

		menu.settSaveNowMenuItem
				.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
		menu.settSaveNowMenuItem.setText("Save settings now..");
		menu.settSaveNowMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.settSaveNowMenuItemActionPerformed(evt);
			}
		});
		menu.settingsMenu.add(menu.settSaveNowMenuItem);
		menu.settingsMenu.add(menu.jSeparator4);

		menu.settingsResetAll.setText("Reset all preferences");
		menu.settingsResetAll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.settingsResetAllActionPerformed(evt);
			}
		});
		menu.settingsMenu.add(menu.settingsResetAll);

		menu.mainMenu.add(menu.settingsMenu);

		menu.helpMenu.setText("Help");

		menu.helpTopics.setText("Help topics..");
		menu.helpTopics.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.helpTopicsActionPerformed(evt);
			}
		});
		menu.helpMenu.add(menu.helpTopics);

		menu.aboutAuthorMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1,
				java.awt.event.InputEvent.SHIFT_MASK));
		menu.aboutAuthorMenuItem.setText("About..");
		menu.aboutAuthorMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu.aboutAuthorMenuItemActionPerformed(evt);
			}
		});
		menu.helpMenu.add(menu.aboutAuthorMenuItem);

		menu.mainMenu.add(menu.helpMenu);

		notepad.setJMenuBar(menu.mainMenu);
	}
}
