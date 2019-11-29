package model.strategies;

public class Rot13Cipher implements CipherStrategy {
	
	private static final int CIPHERKEY = 13;
	
	@Override
	public String encrypt(String str) {
		
		char strCh;
		String encryptedString = "";
		
		
		for( int i = 0; i < str.length(); i++){
			strCh = str.charAt(i);
			
			if(strCh >= 'a' && strCh <= 'z'){
	            strCh = (char)(strCh + CIPHERKEY);
	            
	            if(strCh > 'z'){
	            	strCh = (char)(strCh - 'z' + 'a' - 1);
	            }
	            
	            encryptedString += strCh;
	        }
	        else if(strCh >= 'A' && strCh <= 'Z'){
	        	strCh = (char)(strCh + CIPHERKEY);
	            
	            if(strCh > 'Z'){
	            	strCh = (char)(strCh - 'Z' + 'A' - 1);
	            }
	            
	            encryptedString += strCh;
	        }
	        else {
	        	// char other than letter
	        	encryptedString += strCh;
	        }
		}
		
		
		return encryptedString;
	}

	@Override
	public String decrypt(String str) {
		
		char strCh;
		String decryptedString = "";
		
		
		for( int i = 0; i < str.length(); i++){
			strCh = str.charAt(i);
			
			if(strCh >= 'a' && strCh <= 'z'){
	            strCh = (char)(strCh - CIPHERKEY);
	            
	            if(strCh < 'a'){
	            	strCh = (char)(strCh + 'z' - 'a' + 1);
	            }
	            
	            decryptedString += strCh;
	        }
	        else if(strCh >= 'A' && strCh <= 'Z'){
	        	strCh = (char)(strCh - CIPHERKEY);
	            
	            if(strCh < 'A'){
	            	strCh = (char)(strCh + 'Z' - 'A' + 1);
	            }
	            
	            decryptedString += strCh;
	        }
	        else {
	        	// char other than letter
	        	decryptedString += strCh;
	        }
		}
		
		
		return decryptedString;
	}
	
	
}
