package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.StratagemMap;

public class FileHelper {

	public static void writeIniFile(String fileName, StratagemMap stratagemMap) {

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			// Write objects to file
			objectOutputStream.writeObject(stratagemMap);

			objectOutputStream.close();
			fileOutputStream.close();

			System.out.println("Saved to .ini file");

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		}

	}

	public static StratagemMap readIniFile(String fileName) {

		try {
			StratagemMap stratagemMap;

			FileInputStream fileInputStream = new FileInputStream(new File(fileName));
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			// Read objects
			stratagemMap = (StratagemMap) objectInputStream.readObject();

			objectInputStream.close();
			fileInputStream.close();

			System.out.println("Read from .ini file OK");

			return stratagemMap;

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		}

		return null;

	}

}
