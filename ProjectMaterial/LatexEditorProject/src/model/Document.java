package model;


public class Document {
	private String author;
	private String date;
	private String copyright;
	private String versionID = "0";
	private String contents;
	
	public Document(String author, String date, String copyright, String versionID, String contents) {
		this.author = author;
		this.date = date;
		this.copyright = copyright;
		this.versionID = versionID;
		this.contents = contents;
	}
	
	
	public Document() {
		// TODO Auto-generated constructor stub
		this.contents = "";
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}
	
	@Override
	public Document clone() {
		return new Document(author, date, copyright, versionID,new String (contents));
	}

	public void changeVersion() {
		int n = Integer.parseInt(versionID);
		versionID = (n + 1) + "";
	}


	public String getVersionID() {
		// TODO Auto-generated method stub
		return versionID;
	}
	
}
