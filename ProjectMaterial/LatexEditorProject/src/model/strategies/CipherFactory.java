package model.strategies;

public class CipherFactory {
	
	private CipherStrategy cipherStrategy;
	
	public CipherStrategy createStrategy(String strategy) {
		switch (strategy) {
		case "Atbash":
			cipherStrategy = new AtbashCipher();
			break;
		case "Rot13":
			cipherStrategy = new Rot13Cipher();
			break;
		}
		return cipherStrategy;
	}

}
