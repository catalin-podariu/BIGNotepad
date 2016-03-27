package gui;

public class QuickMenuComponents {

	public QuickMenuComponents(BIGNotepad notepad, QuickMenu menuGUI) {
		this.notepad = notepad;
		this.menuGUI = menuGUI;
	}

	public void initComponents() {

		menuGUI.popupMenu = new javax.swing.JPopupMenu();
		menuGUI.quickUndo = new javax.swing.JMenuItem();
		menuGUI.quickRedo = new javax.swing.JMenuItem();
		menuGUI.quickMenuS1 = new javax.swing.JPopupMenu.Separator();
		menuGUI.quickCut = new javax.swing.JMenuItem();
		menuGUI.quickCopy = new javax.swing.JMenuItem();
		menuGUI.quickCopyAll = new javax.swing.JMenuItem();
		menuGUI.quickPaste = new javax.swing.JMenuItem();
		menuGUI.quickSwap = new javax.swing.JMenuItem();
		menuGUI.quickClear = new javax.swing.JMenuItem();
		menuGUI.quickMenuS2 = new javax.swing.JPopupMenu.Separator();
		menuGUI.quickSelectAll = new javax.swing.JMenuItem();

		menuGUI.popupMenu.setBackground(new java.awt.Color(0, 51, 51));
		menuGUI.popupMenu.setForeground(new java.awt.Color(204, 204, 204));
		menuGUI.popupMenu.setInvoker(notepad.bigEdit);
		menuGUI.popupMenu.setLabel("quick menu");
		menuGUI.popupMenu.setMaximumSize(new java.awt.Dimension(100, 200));
		menuGUI.popupMenu.setMinimumSize(new java.awt.Dimension(100, 200));
		menuGUI.popupMenu.setPreferredSize(new java.awt.Dimension(100, 160));

		menuGUI.quickUndo.setText("Undo");
		menuGUI.quickUndo.setMaximumSize(new java.awt.Dimension(100, 20));
		menuGUI.quickUndo.setMinimumSize(new java.awt.Dimension(107, 20));
		menuGUI.quickUndo.setPreferredSize(new java.awt.Dimension(107, 15));
		menuGUI.quickUndo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuGUI.quickUndoActionPerformed(evt);
			}
		});
		menuGUI.popupMenu.add(menuGUI.quickUndo);

		menuGUI.quickRedo.setText("Redo");
		menuGUI.quickRedo.setMaximumSize(new java.awt.Dimension(100, 20));
		menuGUI.quickRedo.setMinimumSize(new java.awt.Dimension(107, 20));
		menuGUI.quickRedo.setPreferredSize(new java.awt.Dimension(107, 15));
		menuGUI.quickRedo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuGUI.quickRedoActionPerformed(evt);
			}
		});
		menuGUI.popupMenu.add(menuGUI.quickRedo);
		menuGUI.popupMenu.add(menuGUI.quickMenuS1);

		menuGUI.quickCut.setText("Cut");
		menuGUI.quickCut.setMaximumSize(new java.awt.Dimension(100, 20));
		menuGUI.quickCut.setMinimumSize(new java.awt.Dimension(107, 20));
		menuGUI.quickCut.setPreferredSize(new java.awt.Dimension(107, 15));
		menuGUI.quickCut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuGUI.quickCutActionPerformed(evt);
			}
		});
		menuGUI.popupMenu.add(menuGUI.quickCut);

		menuGUI.quickCopy.setText("Copy");
		menuGUI.quickCopy.setMaximumSize(new java.awt.Dimension(100, 20));
		menuGUI.quickCopy.setMinimumSize(new java.awt.Dimension(107, 20));
		menuGUI.quickCopy.setPreferredSize(new java.awt.Dimension(107, 15));
		menuGUI.quickCopy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuGUI.quickCopyActionPerformed(evt);
			}
		});
		menuGUI.popupMenu.add(menuGUI.quickCopy);

		menuGUI.quickCopyAll.setText("Copy All");
		menuGUI.quickCopyAll.setMaximumSize(new java.awt.Dimension(100, 20));
		menuGUI.quickCopyAll.setMinimumSize(new java.awt.Dimension(107, 20));
		menuGUI.quickCopyAll.setPreferredSize(new java.awt.Dimension(107, 15));
		menuGUI.quickCopyAll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuGUI.quickCopyAllActionPerformed(evt);
			}
		});
		menuGUI.popupMenu.add(menuGUI.quickCopyAll);

		menuGUI.quickPaste.setText("Paste");
		menuGUI.quickPaste.setMaximumSize(new java.awt.Dimension(100, 20));
		menuGUI.quickPaste.setMinimumSize(new java.awt.Dimension(107, 20));
		menuGUI.quickPaste.setPreferredSize(new java.awt.Dimension(107, 15));
		menuGUI.quickPaste.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuGUI.quickPasteActionPerformed(evt);
			}
		});
		menuGUI.popupMenu.add(menuGUI.quickPaste);

		menuGUI.quickSwap.setText("Swap");
		menuGUI.quickSwap.setMaximumSize(new java.awt.Dimension(100, 20));
		menuGUI.quickSwap.setMinimumSize(new java.awt.Dimension(107, 20));
		menuGUI.quickSwap.setPreferredSize(new java.awt.Dimension(107, 15));
		menuGUI.quickSwap.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuGUI.quickSwapActionPerformed(evt);
			}
		});
		menuGUI.popupMenu.add(menuGUI.quickSwap);

		menuGUI.quickClear.setText("Clear");
		menuGUI.quickClear.setMaximumSize(new java.awt.Dimension(100, 20));
		menuGUI.quickClear.setMinimumSize(new java.awt.Dimension(107, 20));
		menuGUI.quickClear.setPreferredSize(new java.awt.Dimension(107, 15));
		menuGUI.quickClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuGUI.quickClearActionPerformed(evt);
			}
		});
		menuGUI.popupMenu.add(menuGUI.quickClear);
		menuGUI.popupMenu.add(menuGUI.quickMenuS2);

		menuGUI.quickSelectAll.setText("Select All");
		menuGUI.quickSelectAll.setMaximumSize(new java.awt.Dimension(100, 20));
		menuGUI.quickSelectAll.setMinimumSize(new java.awt.Dimension(107, 20));
		menuGUI.quickSelectAll.setPreferredSize(new java.awt.Dimension(107, 15));
		menuGUI.quickSelectAll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuGUI.quickSelectAllActionPerformed(evt);
			}
		});
		menuGUI.popupMenu.add(menuGUI.quickSelectAll);
	}

	private BIGNotepad notepad;
	private QuickMenu menuGUI;
}
