package gui;

public class AboutDialogComponents {

    protected AboutDialogComponents(AboutDialog aboutDialog) {
        this.aboutDialog = aboutDialog;
    }
	
	protected void initComponents(){
		
		aboutDialog.aboutDialog = new javax.swing.JDialog();
		
		aboutDialog.clickable = new javax.swing.JLabel();
		aboutDialog.aboutPane = new javax.swing.JTabbedPane();
		aboutDialog.aboutAuthorPanel = new javax.swing.JPanel();
		aboutDialog.aboutAuthorP = new javax.swing.JScrollPane();
		aboutDialog.aboutAuthorText = new javax.swing.JTextArea();
		aboutDialog.aboutSoftwarePanel = new javax.swing.JPanel();
		aboutDialog.aboutSoftwareP = new javax.swing.JScrollPane();
		aboutDialog.aboutSoftwareText = new javax.swing.JTextArea();
		
		aboutDialog.aboutDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		aboutDialog.aboutDialog.setTitle("About the author and this software..");
		aboutDialog.aboutDialog.setMinimumSize(new java.awt.Dimension(615, 405));
		aboutDialog.aboutDialog.setModal(true);
		aboutDialog.aboutDialog.setResizable(false);
		aboutDialog.aboutDialog.setType(java.awt.Window.Type.POPUP);
		aboutDialog.aboutDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent evt) {
				aboutDialog.aboutDialogComponentShown(evt);
			}
		});
		aboutDialog.aboutDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		aboutDialog.clickable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		aboutDialog.clickable.setForeground(new java.awt.Color(0, 102, 102));
		aboutDialog.clickable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		aboutDialog.clickable.setText("x");
		aboutDialog.clickable.setMaximumSize(new java.awt.Dimension(30, 20));
		aboutDialog.clickable.setMinimumSize(new java.awt.Dimension(30, 20));
		aboutDialog.clickable.setPreferredSize(new java.awt.Dimension(30, 20));
		aboutDialog.aboutDialog.getContentPane().add(aboutDialog.clickable, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

		aboutDialog.aboutPane.setBackground(new java.awt.Color(0, 51, 51));
		aboutDialog.aboutPane.setForeground(new java.awt.Color(204, 204, 204));
		aboutDialog.aboutPane.setMaximumSize(new java.awt.Dimension(590, 350));
		aboutDialog.aboutPane.setMinimumSize(new java.awt.Dimension(590, 350));
		aboutDialog.aboutPane.setOpaque(true);
		aboutDialog.aboutPane.setPreferredSize(new java.awt.Dimension(590, 350));

		aboutDialog.aboutAuthorPanel.setBackground(new java.awt.Color(0, 51, 51));
		aboutDialog.aboutAuthorPanel.setForeground(new java.awt.Color(204, 204, 204));
		aboutDialog.aboutAuthorPanel.setLayout(new java.awt.CardLayout());

		aboutDialog.aboutAuthorP.setBackground(new java.awt.Color(0, 51, 51));
		aboutDialog.aboutAuthorP.setBorder(null);
		aboutDialog.aboutAuthorP.setForeground(new java.awt.Color(204, 204, 204));
		aboutDialog.aboutAuthorP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		aboutDialog.aboutAuthorP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		aboutDialog.aboutAuthorText.setEditable(false);
		aboutDialog.aboutAuthorText.setBackground(new java.awt.Color(0, 51, 51));
		aboutDialog.aboutAuthorText.setColumns(20);
		aboutDialog.aboutAuthorText.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		aboutDialog.aboutAuthorText.setForeground(new java.awt.Color(204, 204, 204));
		aboutDialog.aboutAuthorText.setLineWrap(true);
		aboutDialog.aboutAuthorText.setRows(5);
		aboutDialog.aboutAuthorText.setWrapStyleWord(true);
		aboutDialog.aboutAuthorText.setBorder(null);
		aboutDialog.aboutAuthorText.setMargin(new java.awt.Insets(4, 4, 4, 4));
		aboutDialog.aboutAuthorText.setMaximumSize(new java.awt.Dimension(3600, 3000));
		aboutDialog.aboutAuthorText.setMinimumSize(new java.awt.Dimension(500, 300));
		aboutDialog.aboutAuthorP.setViewportView(aboutDialog.aboutAuthorText);
		
		aboutDialog.aboutAuthorPanel.add(aboutDialog.aboutAuthorP, "card3");

		aboutDialog.aboutPane.addTab("About Author  ", aboutDialog.aboutAuthorPanel);

		aboutDialog.aboutSoftwarePanel.setBackground(new java.awt.Color(0, 51, 51));
		aboutDialog.aboutSoftwarePanel.setForeground(new java.awt.Color(204, 204, 204));
		aboutDialog.aboutSoftwarePanel.setLayout(new java.awt.CardLayout());

		aboutDialog.aboutSoftwareP.setBackground(new java.awt.Color(0, 51, 51));
		aboutDialog.aboutSoftwareP.setBorder(null);
		aboutDialog.aboutSoftwareP.setForeground(new java.awt.Color(204, 204, 204));
		aboutDialog.aboutSoftwareP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		aboutDialog.aboutSoftwareText.setEditable(false);
		aboutDialog.aboutSoftwareText.setBackground(new java.awt.Color(0, 51, 51));
		aboutDialog.aboutSoftwareText.setColumns(20);
		aboutDialog.aboutSoftwareText.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		aboutDialog.aboutSoftwareText.setForeground(new java.awt.Color(204, 204, 204));
		aboutDialog.aboutSoftwareText.setLineWrap(true);
		aboutDialog.aboutSoftwareText.setRows(5);
		aboutDialog.aboutSoftwareText.setWrapStyleWord(true);
		aboutDialog.aboutSoftwareText.setBorder(null);
		aboutDialog.aboutSoftwareText.setMargin(new java.awt.Insets(4, 4, 4, 4));
		aboutDialog.aboutSoftwareText.setMaximumSize(new java.awt.Dimension(3600, 3000));
		aboutDialog.aboutSoftwareText.setMinimumSize(new java.awt.Dimension(500, 300));
		aboutDialog.aboutSoftwareP.setViewportView(aboutDialog.aboutSoftwareText);

		aboutDialog.aboutSoftwarePanel.add(aboutDialog.aboutSoftwareP, "card3");

		aboutDialog.aboutPane.addTab("About Software  ", aboutDialog.aboutSoftwarePanel);

		aboutDialog.aboutDialog.getContentPane().add(aboutDialog.aboutPane, //
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 590, 360));
	}
	
	private AboutDialog aboutDialog;
}
