package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class fileSaver {
	
	public void save(String filename,String contents) {
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(filename));
			
			printWriter.write(contents);
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problem with Saving File, check if you have rights, free space, quota etc");
			e.printStackTrace();
		}
	}

}
