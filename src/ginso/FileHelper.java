package ginso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class FileHelper {
	
	public static BufferedReader getReader(File file) {
		try {
			return new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedReader getReader(String path) {
		return getReader(new File(path));
	}
	
	public static FileWriter getWriter(String path) {
		try {
			return new FileWriter(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static FileWriter getWriter(File dir, String path) {
		try {
			return new FileWriter(new File(dir, path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void readFile(File file, Consumer<String> callback) {
		try {
			BufferedReader reader = getReader(file);
			while(true) {
				String line = reader.readLine();
				if(line == null) break;
				callback.accept(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFile(String path, Consumer<String> callback) {
		readFile(new File(path), callback);
	}
	
	public static String readFile(File file) {
		final StringBuilder s = new StringBuilder();
		readFile(file, (line) -> {s.append(line);});
		return s.toString();
	}
	
	public static String readFile(String path) {
		final StringBuilder s = new StringBuilder();
		readFile(path, (line) -> {s.append(line);});
		return s.toString();
	}
	

	public static List<String> readFileLines(File file) {
		final List<String> list = new ArrayList<String>();
		readFile(file, (line) -> {list.add(line);});
		return list;
	}
	
	public static List<String> readFileLines(String path) {
		final List<String> list = new ArrayList<String>();
		readFile(path, (line) -> {list.add(line);});
		return list;
	}
	
	
	public static void writeToFile(String text, File file) {
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(text);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeToFile(String text, String path) {
		writeToFile(text, new File(path));
	}
	
	public static void writeToFile(List<String> lines, File file) {
		try {
			FileWriter fw = new FileWriter(file);
			for(String line:lines) fw.write(line + "\r\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToFile(List<String> lines, String path) {
		writeToFile(lines, new File(path));
	}
	
	
}
