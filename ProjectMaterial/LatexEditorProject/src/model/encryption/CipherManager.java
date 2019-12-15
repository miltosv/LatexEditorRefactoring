package model.encryption;

import java.util.HashMap;

public class CipherManager {
	
	private CipherFactory ciphFactory = new CipherFactory();
	private HashMap<String, CipherStrategy> ciphers = new HashMap<String, CipherStrategy>();
	private CipherStrategy cipherStrategy;
	private String cipherStrategyType;
	
	

	public CipherManager(){
		
		ciphers.put("Atbash", ciphFactory.createStrategy("Atbash"));
		ciphers.put("Rot13", ciphFactory.createStrategy("Rot13"));
		 
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
	
	public void setCipherStrategy(String ciphStrategy) {
		this.cipherStrategyType = ciphStrategy;
	}
	
	public String getCipherStrategy() {
		return this.cipherStrategyType;
	}
	
	public void changeCipherStratgyTo(String newCipher) {
		
		this.cipherStrategyType = newCipher;
		cipherStrategy = ciphers.get(newCipher);
	}
	
	

}
