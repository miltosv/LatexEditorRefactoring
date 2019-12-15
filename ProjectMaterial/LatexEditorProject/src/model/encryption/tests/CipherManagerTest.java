package model.encryption.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.encryption.CipherManager;

public class CipherManagerTest {

	@Test
	public void test() {
		
		CipherManager cipherManager = new CipherManager();
		
		// someone has to setup cipherManagers strategy   
		assertNull(cipherManager.getCipherStrategy());
		
		// setup Strategy as Rot13
		cipherManager.changeCipherStratgyTo("Rot13");
		
		assertEquals("Rot13",cipherManager.getCipherStrategy());
		
		
		testEncryptionAndDecryption(cipherManager);
		
		// switch to Atbash
		
		cipherManager.changeCipherStratgyTo("Atbash");
		
		testEncryptionAndDecryption(cipherManager);
		
		
		
	}
	
	
	private void testEncryptionAndDecryption(CipherManager cipherManager) {
		String fakeText = "Hello World!";
		
		String encryptedText = cipherManager.encryptString(fakeText);
		
		assertNotEquals(fakeText, encryptedText);
		
		String decryptedText = cipherManager.decryptString(encryptedText);
		
		assertEquals(fakeText, decryptedText);
	}

}
