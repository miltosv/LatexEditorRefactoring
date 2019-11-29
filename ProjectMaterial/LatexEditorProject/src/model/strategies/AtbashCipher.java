package model.strategies;

public class AtbashCipher implements CipherStrategy {

	@Override
	public String encrypt(String str) {
		
		char strCh;
		String encryptedString = "";
		
		
		for( int i = 0; i < str.length(); i++){
			strCh = str.charAt(i);
			
			if(strCh >= 'a' && strCh <= 'z'){
	            strCh = (char)(strCh + 'a');
	            
	            if(strCh > 'z'){
	            	strCh = (char)(strCh - 'z' + 'a' - 1);
	            }
	            
	            encryptedString += strCh;
	        }
	        else if(strCh >= 'A' && strCh <= 'Z'){
	        	strCh = (char)(strCh + 'A');
	            
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
		// TODO Auto-generated method stub
		return null;
	}

}
