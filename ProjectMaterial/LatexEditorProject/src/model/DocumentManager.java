package model;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class DocumentManager {
	private HashMap<String, Document> templates;
	private static final int ID=0;
	private static final int CONTENTS=1;
	private static final String TemplateFilePath ="src\\resources\\settings\\templateSettings";
	
	public DocumentManager() {
		templates = new HashMap<String, Document>();
		this.dynamicallyCreateDocuments();
		
	}
	
	public Document createDocument(String type) {
		return templates.get(type).clone();
	}
	
	private void dynamicallyCreateDocuments(){
		
		try {
			BufferedReader DocumentSpecsReader = new BufferedReader(
					new FileReader (TemplateFilePath)
					);
			
			String currrentSpec;
			while ((currrentSpec = DocumentSpecsReader.readLine()) != null) {
				String keyStateConfigPair[] = currrentSpec.split(" ");
				String contents=(new String(readAllBytes(get(keyStateConfigPair[CONTENTS]))));
				String key=keyStateConfigPair[ID];
				Document doc = new Document();
				doc.setContents(contents);
				templates.put(key,doc);				
			}
			DocumentSpecsReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/*
	public String getContents(String type) {
		if(type.equals("articleTemplate")){
			
			return "\\documentclass[11pt,twocolumn,a4paper]{article}\n\n"+

					"\\begin{document}\n"+
					"\\title{Article: How to Structure a LaTeX Document}\n"+
					"\\author{Author1 \\and Author2 \\and ...}\n"+
					"\\date{\\today}\n\n"+

					"\\maketitle\n\n"+

					"\\section{Section Title 1}\n\n"+

					"\\section{Section Title 2}\n\n"+

					"\\section{Section Title.....}\n\n"+

					"\\section{Conclusion}\n\n"+

					"\\section*{References}\n\n"+

					"\\end{document}\n";
			
		}
		else if(type.equals("bookTemplate")) {
			return "\\documentclass[11pt,a4paper]{book}\n\n"+

					"\\begin{document}\n"+
					"\\title{Book: How to Structure a LaTeX Document}\n"+
					"\\author{Author1 \\and Author2 \\and ...}\n"+
					"\\date{\\today}\n\n"+

					"\\maketitle\n\n"+

					"\\frontmatter\n\n"+

					"\\chapter{Preface}\n"+
					"% ...\n\n"+

					"\\mainmatter\n"+
					"\\chapter{First chapter}\n"+
					"\\section{Section Title 1}\n"+
					"\\section{Section Title 2}\n\n"+

					"\\section{Section Title.....}\n\n"+

					"\\chapter{....}\n\n"+

					"\\chapter{Conclusion}\n\n"+

					"\\chapter*{References}\n\n\n"+


					"\\backmatter\n"+
					"\\chapter{Last note}\n\n"+

					"\\end{document}\n";
		}
		else if(type.equals("letterTemplate")) {
			return "\\documentclass{letter}\n"+
					"\\usepackage{hyperref}\n"+
					"\\signature{Sender's Name}\n"+
					"\\address{Sender's address...}\n"+
					"\\begin{document}\n\n"+

					"\\begin{letter}{Destination address....}\n"+
					"\\opening{Dear Sir or Madam:}\n\n"+

					"I am writing to you .......\n\n\n"+


					"\\closing{Yours Faithfully,}\n"+

					"\\ps\n\n"+

					"P.S. text .....\n\n"+

					"\\encl{Copyright permission form}\n\n"+

					"\\end{letter}\n"+
					"\\end{document}\n";
		}
		else {
			return "\\documentclass[11pt,a4paper]{report}\n\n"+

					"\\begin{document}\n"+
					"\\title{Report Template: How to Structure a LaTeX Document}\n"+
					"\\author{Author1 \\and Author2 \\and ...}\n"+
					"\\date{\\today}\n"+
					"\\maketitle\n\n"+

					"\\begin{abstract}\n"+
					"Your abstract goes here...\n"+
					"...\n"+
					"\\end{abstract}\n\n"+

					"\\chapter{Introduction}\n"+
					"\\section{Section Title 1}\n"+
					"\\section{Section Title 2}\n"+
					"\\section{Section Title.....}\n\n"+

					"\\chapter{....}\n\n"+

					"\\chapter{Conclusion}\n\n\n"+


					"\\chapter*{References}\n\n"+

					"\\end{document}\n";
		}
	}*/
}
