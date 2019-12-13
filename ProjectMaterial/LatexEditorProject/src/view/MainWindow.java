package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;

import controller.LatexEditorController;
import model.Document;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class MainWindow {

	private JFrame frame;
	private JEditorPane editorPane = new JEditorPane();
	private LatexEditorController editorController;
	private String currentCommand;
	
	
	public int getCaret() {
		return editorPane.getCaretPosition();
	}
	
	public void editContents(String type) {
		currentCommand=type;
		
		editorController.enact("addLatex");
		editorPane.setText(editorController.getCurrentDocument().getContents());
	}
	
	public String getPaneText() {
		return editorPane.getText();
	}
	
	/**
	 * Launch the application.
	 */
	

	public String getCurrentCommand() {
		return currentCommand;
	}

	/**
	 * Create the application.
	 *
	 */
	public MainWindow(LatexEditorController editorController) {
		System.out.println("MainWindow here");

		this.editorController = editorController;
		System.out.println("MainWindow here");
		/**
		 * keep these methods below in the program they are needed for windowbuilder to run properly so we can add stuff. if you have them uncommented
		 * then crashes with null pointer exception
		 */
	//	initialize(); 
	//	frame.setVisible(true);
	}
	
	
	public void startMainWindow() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 823, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 805, 26);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewFile = new JMenuItem("New file");
		mntmNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseTemplate chooseTemplate = new ChooseTemplate(editorController, "main");
				frame.dispose();
			}
		});
		mnFile.add(mntmNewFile);
		
		JMenuItem takeSnapshot = new JMenuItem("Take Snapshot");
		takeSnapshot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//latexEditorView.setText(editorPane.getText());
				editorController.enact("edit");
			}
		});
		mnFile.add(takeSnapshot);
		JMenuItem addChapter = new JMenuItem("Add chapter");
		JMenu mnCommands = new JMenu("Commands");
		JMenuItem mntmLoadFile = new JMenuItem("Load file");
		mntmLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechooser = new JFileChooser();
				int option = filechooser.showOpenDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) {
					String filename = filechooser.getSelectedFile().toString();
					
					
					editorController.setFilePathName(filename);
					editorController.enact("load");
					mnCommands.setEnabled(true);
					addChapter.setEnabled(true);
					if(editorController.getTypeOfDocument().equals("letterTemplate")) {
						mnCommands.setEnabled(false);
					}
					if(editorController.getTypeOfDocument().equals("articleTemplate")) {
						addChapter.setEnabled(false);
					}
					editorPane.setText(editorController.getCurrentDocument().getContents());
				}
			}
		});
		mnFile.add(mntmLoadFile);
		
		JMenuItem mntmSaveFile = new JMenuItem("Save file");
		mntmSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser filechooser = new JFileChooser();
				int option = filechooser.showSaveDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) {
					String filename = filechooser.getSelectedFile().toString();
					if(filename.endsWith(".tex") == false) {
						filename = filename+".tex";
					}
					
					editorController.setFilePathName(filename);
					editorController.enact("save");
				}
				
			}
		});
		mnFile.add(mntmSaveFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		
		
		menuBar.add(mnCommands);
		if(editorController.getTypeOfDocument().equals("letterTemplate")) {
			mnCommands.setEnabled(false);
		}
		
		addChapter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editContents("chapter");
			}
		});
		mnCommands.add(addChapter);
		if(editorController.getTypeOfDocument().equals("articleTemplate")) {
			addChapter.setEnabled(false);
		}
		
		JMenu addSection = new JMenu("Add Section");
		mnCommands.add(addSection);
		
		JMenuItem mntmAddSection = new JMenuItem("Add section");
		mntmAddSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editContents("section");
			}
		});
		addSection.add(mntmAddSection);
		
		JMenuItem mntmAddSubsection = new JMenuItem("Add subsection");
		mntmAddSubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editContents("subsection");
			}
		});
		addSection.add(mntmAddSubsection);
		
		JMenuItem mntmAddSubsubsection = new JMenuItem("Add subsubsection");
		mntmAddSubsubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editContents("subsubsection");
			}
		});
		addSection.add(mntmAddSubsubsection);
		
		JMenu addEnumerationList = new JMenu("Add enumeration list");
		mnCommands.add(addEnumerationList);
		
		JMenuItem mntmItemize = new JMenuItem("Itemize");
		mntmItemize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editContents("itemize");
			}
		});
		addEnumerationList.add(mntmItemize);
		
		JMenuItem mntmEnumerate = new JMenuItem("Enumerate");
		mntmEnumerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editContents("enumerate");
			}
		});
		addEnumerationList.add(mntmEnumerate);
		
		JMenuItem addTable = new JMenuItem("Add table");
		addTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editContents("table");
			}
		});
		mnCommands.add(addTable);
		
		JMenuItem addFigure = new JMenuItem("Add figure");
		addFigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editContents("figure");
			}
		});
		mnCommands.add(addFigure);
		
		JMenu mnVersioning = new JMenu("Versioning");
		menuBar.add(mnVersioning);
		
		JMenu mnEnable = new JMenu("Enable");
		mnVersioning.add(mnEnable);
		
		JCheckBoxMenuItem menuVolatile = new JCheckBoxMenuItem("Volatile");
		JCheckBoxMenuItem menuStable = new JCheckBoxMenuItem("Stable");
		menuStable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//latexEditorView.setStrategy("stable");
				editorController.getVersionsManager().setStrategyType("stable");
				if(editorController.getVersionsManager().isEnabled() == false) {
					editorController.enact("enableVersionsManagement");
				}
				else {
					editorController.enact("changeVersionsStrategy");
				}
				menuVolatile.setSelected(false);
				menuStable.setEnabled(false);
				menuVolatile.setEnabled(true);
			}
		});

		menuVolatile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//latexEditorView.setStrategy("volatile");
				editorController.getVersionsManager().setStrategyType("volatile");
				if(editorController.getVersionsManager().isEnabled() == false) {
					editorController.enact("enableVersionsManagement");
				}
				else {
					editorController.enact("changeVersionsStrategy");
				}
				menuStable.setSelected(false);
				menuVolatile.setEnabled(false);
				menuStable.setEnabled(true);
			}
		});
		mnEnable.add(menuVolatile);
		
		mnEnable.add(menuStable);
		
		JMenuItem mntmDisable = new JMenuItem("Disable");
		mntmDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorController.enact("disableVersionsManagement");
			}
		});
		mnVersioning.add(mntmDisable);
		
		JMenuItem mntmRollback = new JMenuItem("Rollback");
		mntmRollback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editorController.enact("rollbackToPreviousVersion");
				Document doc = editorController.getCurrentDocument();
				editorPane.setText(doc.getContents());
			}
		});

		mnVersioning.add(mntmRollback);
		
		JMenu mnEncryption = new JMenu("Encryption");
		menuBar.add(mnEncryption);
		
		JMenu mnChooseCipher = new JMenu("Choose strategy...");
		mnEncryption.add(mnChooseCipher);
		
		JCheckBoxMenuItem mntmAtbashCipher = new JCheckBoxMenuItem("Atbash");
		
		JCheckBoxMenuItem mntmRot13Cipher = new JCheckBoxMenuItem("Rot13");
		mntmRot13Cipher.setEnabled(false); // its the default
		
		mntmAtbashCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editorController.getCipherManager().setCipherStrategy("Atbash");
				editorController.enact("changeCipherStrategy");
				mntmRot13Cipher.setSelected(false);
				mntmAtbashCipher.setEnabled(false);
				mntmRot13Cipher.setEnabled(true);
			}
		});
		
		mntmRot13Cipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editorController.getCipherManager().setCipherStrategy("Rot13");
				editorController.enact("changeCipherStrategy");
				mntmAtbashCipher.setSelected(false);
				mntmRot13Cipher.setEnabled(false);
				mntmAtbashCipher.setEnabled(true);
			}
		});
		
		
		
		
		
		mnChooseCipher.add(mntmAtbashCipher);
		
		mnChooseCipher.add(mntmRot13Cipher);
		
		
		JMenuItem mntmSaveEncryptedFile = new JMenuItem("Save Encrypted");
	
		mntmSaveEncryptedFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser filechooser = new JFileChooser();
				int option = filechooser.showSaveDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) {
					String filename = filechooser.getSelectedFile().toString();
					/*if(filename.endsWith(".tex") == false) {
						filename = filename+".tex";
					}*/
					
					editorController.setFilePathName(filename);
					editorController.enact("saveEncrypted");
				}
				
			}
		});
		mnEncryption.add(mntmSaveEncryptedFile);
		
		
		
		JMenuItem mntmLoadEncryptedFile = new JMenuItem("Load Encrypted");
		mntmLoadEncryptedFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechooser = new JFileChooser();
				int option = filechooser.showOpenDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) {
					String filename = filechooser.getSelectedFile().toString();
					
					
					editorController.setFilePathName(filename);
					editorController.enact("loadEncrypted");
				}
			}
		});
		mnEncryption.add(mntmLoadEncryptedFile);
		
		
		
		
		editorPane.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyTyped(KeyEvent e) {
				editorController.enact("edit");
			} //TODO forget UPDATE current document ON EDIT ADD TO LATEX COMMAND KEEP PREVIOUS CARET POSITION
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 783, 467);
		frame.getContentPane().add(scrollPane);
		editorPane.setEditable(true);
		scrollPane.setViewportView(editorPane);
		
//		System.out.println(latexEditorView.getCurrentDocument().getContents());
		editorPane.setText(editorController.getCurrentDocument().getContents());
	}

	public void update(String contents) {
		editorPane.setText(contents);
		System.out.println(contents);
	}
}
