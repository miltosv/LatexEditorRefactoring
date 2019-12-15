package model.encryption;

import static org.junit.Assert.*;

import org.junit.Test;

public class Rot13Test {

	@Test
	public void test() {
		
		CipherStrategy rot13Cipher = new Rot13Cipher();
		
		String fakeText = "Hello World!";
		
		String encryptedText = rot13Cipher.encrypt(fakeText);
		
		// text is encrypted
		assertNotEquals(encryptedText,fakeText);
	
		
		// decrypt text
		
		String decryptedText = rot13Cipher.decrypt(encryptedText);
		
		// text is correctly decrypted
		assertEquals(fakeText,decryptedText);
	}

}
