package model.encryption;

public interface CipherStrategy {

	public String encrypt(String str);
	
	public String decrypt(String str);
	
}
