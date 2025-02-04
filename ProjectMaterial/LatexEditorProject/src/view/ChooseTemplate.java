package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import controller.LatexEditorController;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseTemplate {

	private JFrame frame;
	private String previous;
	private LatexEditorController editorController;

	/**
	 * Create the application.
	 * @param latexEditorView 
	 */
	public ChooseTemplate( LatexEditorController editorController, String previous) {
		
		this.previous = previous;
		this.editorController = editorController;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void diselectRadioButtons(JRadioButton radioButton1, JRadioButton radioButton2, JRadioButton radioButton3,JRadioButton radioButton4) {
		if(radioButton1.isSelected()) {
			radioButton2.setSelected(false);
			radioButton3.setSelected(false);
			radioButton4.setSelected(false);
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton book = new JRadioButton("Book");
		JRadioButton article = new JRadioButton("Article");
		JRadioButton report = new JRadioButton("Report");
		JRadioButton letter = new JRadioButton("Letter");
		
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diselectRadioButtons(book, article, report, letter);
			}
		});
		book.setBounds(42, 51, 127, 25);
		frame.getContentPane().add(book);
		
		JLabel lblChooseTemplate = new JLabel("Choose template. (Leave empty for blank document)");
		lblChooseTemplate.setBounds(42, 13, 332, 16);
		frame.getContentPane().add(lblChooseTemplate);
		
		
		article.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diselectRadioButtons(article, book, report, letter);

			}
		});
		article.setBounds(42, 137, 127, 25);
		frame.getContentPane().add(article);
		
		
		report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diselectRadioButtons(report, article, book, letter);
				
			}
		});
		report.setBounds(213, 51, 127, 25);
		frame.getContentPane().add(report);
		
		
		letter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diselectRadioButtons( letter, report, article, book);
			}
		});
		letter.setBounds(213, 137, 127, 25);
		frame.getContentPane().add(letter);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(book.isSelected()) {
					editorController.setTypeOfDocument("bookTemplate");
				}
				else if(report.isSelected()) {
					editorController.setTypeOfDocument("reportTemplate");
				}
				else if(article.isSelected()) {
					editorController.setTypeOfDocument("articleTemplate");
				}
				else if(letter.isSelected()) {
					editorController.setTypeOfDocument("letterTemplate");
				}
				else {
					editorController.setTypeOfDocument("emptyTemplate");
				}

				editorController.enact("create");
				
				editorController.getMainWindow().startMainWindow();
				frame.dispose();
			}
		});
		btnCreate.setBounds(213, 196, 97, 25);
		frame.getContentPane().add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(previous.equals("main")) {
					editorController.getMainWindow().startMainWindow();
					frame.dispose();
				}
				else {
					OpeningWindow openingWindow = new OpeningWindow();
					frame.dispose();
				}
			}
		});
		btnBack.setBounds(46, 196, 97, 25);
		frame.getContentPane().add(btnBack);
	}
}
