package model.encryption;

import static org.junit.Assert.*;

import org.junit.Test;

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
