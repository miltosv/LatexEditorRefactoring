package model.encryption.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.encryption.AtbashCipher;
import model.encryption.CipherStrategy;

public class AtbashTest {

	@Test
	public void test() {
		
		CipherStrategy atbashCipher = new AtbashCipher();
		
		String fakeText = "Hello World!";
		
		String encryptedText = atbashCipher.encrypt(fakeText);
		
		// text is encrypted
		assertNotEquals(encryptedText,fakeText);
	
		
		// decrypt text
		
		String decryptedText = atbashCipher.decrypt(encryptedText);
		
		// text is correctly decrypted
		assertEquals(fakeText,decryptedText);
		
		
	}

}
