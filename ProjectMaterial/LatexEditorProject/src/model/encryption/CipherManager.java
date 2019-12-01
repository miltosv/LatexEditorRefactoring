package model.encryption;

import java.util.HashMap;

import model.Document;

public class CipherManager {
	
	private CipherFactory ciphFactory = new CipherFactory();
	private HashMap<String, CipherStrategy> ciphers = new HashMap<String, CipherStrategy>();
	private CipherStrategy cipherStrategy;
	
	

	public CipherManager(){
		
		ciphers.put("Atbash", ciphFactory.createStrategy("Atbash"));
		ciphers.put("Rot13", ciphFactory.createStrategy("Rot13"));
		 
	}
	
	
	//TODO not sure how to set the 'current' cipher strategy
	public CipherStrategy getCipherStrategy() {
		return cipherStrategy;
	}

	public void setCipherStrategy(CipherStrategy cipherStrategy) {
		this.cipherStrategy = cipherStrategy;
	}
	
	
	// probably throw this away 
	public String encryptDocument(Document doc) {
		
		String encryptedDocumentContents;
		
		encryptedDocumentContents = cipherStrategy.encrypt(doc.getContents());
		return encryptedDocumentContents;
	}
	
	public String encryptString(String str) {
		String encryptedString;
		
		encryptedString = cipherStrategy.encrypt(str);
		return encryptedString;
	}
	
	public String decryptString(String str) {
		
		String decryptedString;
		
		decryptedString = cipherStrategy.decrypt(str);
		return decryptedString;
	}
	
	public void changeCipherStratgyTo(String newCipher) {
		
		cipherStrategy = ciphers.get(newCipher);
	}
	
	

}
