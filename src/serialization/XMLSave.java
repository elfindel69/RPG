package serialization;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLSave {

	public static void saveItem(String file, Object item) {
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File "+file);
		}
		encoder.writeObject(item);
		encoder.close();
		System.out.println("File "+file+" saved!" );
	}

	
}
