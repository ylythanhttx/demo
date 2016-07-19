package com_spring_core9$10_$_around;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author thanhnv5
 */

public class FileUtils {

	/**
	 * @param String
	 *            pathDirectory Example: "D:/abc/xyz"
	 */
	public static File createDirectoryIfNotExists(String pathDirectory)
			throws IOException {

		File fileDirectory = new File(pathDirectory);
		if (!fileDirectory.exists()) {
			Files.createDirectory(Paths.get(pathDirectory));
		}
		return fileDirectory;
	}

	/**
	 * @param String
	 *            pathFile Example: "D:/abc/xyz.docx"
	 */
	public static File createFileIfNotExists(String pathFile)
			throws IOException {

		pathFile = pathFile.replaceAll("[\\\\]", "/");

		List<String> strs = Arrays.asList(pathFile.split("[/]"));
		String pathDirectory = "";
		for (int i = 0; i < strs.size() - 1; i++) {
			if (pathDirectory.equals("")) {
				pathDirectory = strs.get(i) + "/";
			} else {
				pathDirectory = pathDirectory + strs.get(i) + "/";
			}
		}

		createDirectoryIfNotExists(pathDirectory);
		if (strs.get(strs.size() - 1).indexOf(".") == -1) {
			return createDirectoryIfNotExists(pathFile);
		}

		File fileFile = new File(pathFile);
		if (!fileFile.exists()) {
			Files.createFile(Paths.get(pathFile));
		}
		return fileFile;
	}

	public static byte[] readfileToBytes(File file) throws IOException {
		return Files.readAllBytes(Paths.get(file.getPath()));
	}

	public static String readfileToString(File file) throws IOException {
		return new String(Files.readAllBytes(Paths.get(file.getPath())),
				StandardCharsets.UTF_8);
	}

	public static File writeBytesToFile(byte[] bytes, File file)
			throws IOException {
		Files.write(Paths.get(file.getPath()), bytes);
		return file;
	}

	public static File writeStringsToFile(String content, File file)
			throws IOException {
		// UTF-8
		Files.write(Paths.get(file.getPath()),
				content.getBytes(StandardCharsets.UTF_8));
		return file;
	}

	public static File writeStringsToFile(String content, String pathFile)
			throws IOException {
		// UTF-8
		File file = createFileIfNotExists(pathFile);
		Files.write(Paths.get(file.getPath()),
				content.getBytes(StandardCharsets.UTF_8));
		return file;
	}

	public static File writeBytesToFile(byte[] bytes, String pathFile)
			throws IOException {
		File file = FileUtils.createFileIfNotExists(pathFile);
		Files.write(Paths.get(file.getPath()), bytes);
		return file;
	}

	public static void moveFileToDirectory(File file, String directory)
			throws IOException {

		createDirectoryIfNotExists(directory);
		createFileIfNotExists(file.getPath());
		file.renameTo(new File(directory + "/" + file.getName()));
	}

	public static String fileGetDirectory(File file) {

		String pathFile = file.getPath();
		String result = pathFile.replace(("\\" + file.getName()), "");
		return result;
	}

	public static void main(String[] args) throws IOException {

		File file = new File("D:/temp/xmlfile2.xml");
		file.renameTo(new File("D:/temp1/xmlfile2.xml"));

	}
}
