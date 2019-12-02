package model.strategies;



public class AtbashCipher implements CipherStrategy {
	
	
	
	public AtbashCipher() {
		
	}

	@Override
	public String encrypt(String str) {
		
		char strCh;
		String encryptedString = "";
		
		for( int i = 0; i < str.length(); i++){
			strCh = str.charAt(i);
			
			if(strCh >= 'a' && strCh <= 'z'){
				
				encryptedString += (char)(( ( 25 * (strCh-'a') + 25) % 26) + 'a');
			}
			else if(strCh >= 'A' && strCh <= 'Z'){
				
				encryptedString += (char)(( ( 25 * (strCh-'A') + 25) % 26) + 'A'); 
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
	            
				strCh= Character.toUpperCase(strCh);
				strCh= (char) (( 25 *(strCh + 'A' - 25) % 26) + 'A');
				strCh = Character.toLowerCase(strCh);
				decryptedString += strCh;
	        }
	        else if(strCh >= 'A' && strCh <= 'Z'){
	        	
	            decryptedString += (char) (( 25 *(strCh + 'A' - 25) % 26) + 'A'); 
	        }
	        else {
	        	// char other than letter
	        	decryptedString += strCh;
	        }
		}
		
		
		return decryptedString;
	}

}
