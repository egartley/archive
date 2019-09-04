package net.egartley.stlib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * If you are to use any part of this library, please include the license found
 * at http://egartley.net/files/stlib/license.txt/ in each class that uses any
 * method found in STLib.<br>
 * <em>For questions, comments or concerns, please email contact@egartley.net</em>
 * 
 * @author Evan Gartley
 * @version 1.0 internal
 */

public class STLibFile {

	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES";

	/**
	 * Returns the size in bytes of {@code file}.
	 * 
	 * @param file
	 *            {@link java.io.File} representation of the file.
	 * @return The size of {@code file} in bytes.
	 */
	public double getBytes(File file) {
		return file.length();
	}

	/**
	 * Returns the size in bytes of the file at {@code path}.
	 * 
	 * @param path
	 *            The absolute/relative path to the file.
	 * @return The size of file at {@code path} in bytes.
	 */
	public double getBytes(String path) {
		return new File(path).length();
	}

	/**
	 * Returns the number of lines of text in {@code file}.
	 * 
	 * @param file
	 *            The {@link java.io.File} to use.
	 * @return The number of lines in {@code file}. If there was an exception
	 *         thrown, then {@code 0} is returned.
	 */
	public int getLines(File file) {
		int num = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			LineNumberReader lr = new LineNumberReader(br);
			while (lr.readLine() != null) {
				num++;
			}
			lr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * Returns the number of lines of text in the file at {@code path}.
	 * 
	 * @param path
	 *            The absolute/relative path of the file to use.
	 * @return The number of lines in the file at {@code path}. If there was an
	 *         exception thrown, then {@code 0} is returned.
	 */
	public int getLines(String path) {
		int num = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path)));
			LineNumberReader lr = new LineNumberReader(br);
			while (lr.readLine() != null) {
				num++;
			}
			lr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * Moves {@code file} to {@code newPath}.
	 * 
	 * @param file
	 *            The {@link java.io.File} to move.
	 * @param newPath
	 *            The absolute/relative path as to where to move {@code file}.
	 */
	public void moveFile(File file, String newPath) {
		try {
			file = new File(file.getAbsolutePath());
			file.renameTo(new File(newPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Moves the file at {@code currentPath} to {@code newPath}.
	 * 
	 * @param currentPath
	 *            The absolute/relative path of the file to move.
	 * @param newPath
	 *            The absolute/relative path as to where to move file at
	 *            {@code currentPath}.
	 */
	public void moveFile(String currentPath, String newPath) {
		try {
			File file = new File(currentPath);
			file.renameTo(new File(newPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the directory {@code dir}. If {@code dir} already exists or isn't
	 * a directory, then nothing will happen.
	 * 
	 * @param dir
	 *            The {@link java.io.File} of the directory.
	 */
	public void createFolder(File dir) {
		if (!dir.exists() && dir.isDirectory()) {
			File folder = dir;
			folder.mkdir();
		}
	}

	/**
	 * Creates the directory at {@code dir}. If the directory at {@code dir}
	 * already exists or isn't a directory, then nothing will happen.
	 * 
	 * @param dir
	 *            The absolute/relative path of the directory.
	 */
	public void createFolder(String path) {
		if (!new File(path).exists() && !new File(path).isDirectory()) {
			File folder = new File(path);
			folder.mkdir();
		}
	}

	/**
	 * Encrypts content of {@code input} with basic <b>AES</b>.
	 * 
	 * @param key
	 *            Encryption key (character length of <b>at least 16</b>).
	 * @param input
	 *            {@link java.io.File} to encrypt.
	 * @param output
	 *            {@link java.io.File} where to output encrypted {@code input}.
	 *            Can be the same as {@code input}.
	 * @throws Exception
	 *             If anything's wrong, such as an incorrect encrytion key.
	 */
	public void encryptFileContents(String key, File input, File output) throws Exception {
		doCrypto(Cipher.ENCRYPT_MODE, key, input, output);
	}

	/**
	 * Decrypts content of {@code input} with basic <b>AES</b>.
	 * 
	 * @param key
	 *            Decryption key (character length of <b>at least 16</b>).
	 * @param input
	 *            {@link java.io.File} to decrypt.
	 * @param output
	 *            {@link java.io.File} where to output decrypted {@code input}.
	 *            Can be the same as {@code input}.
	 * @throws Exception
	 *             If anything's wrong, such as an incorrect encrytion key.
	 */
	public void decryptFileContents(String key, File input, File output) throws Exception {
		doCrypto(Cipher.DECRYPT_MODE, key, input, output);
	}

	private void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {
		Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
		Cipher cipher = Cipher.getInstance(TRANSFORMATION);
		cipher.init(cipherMode, secretKey);
		FileInputStream inputStream = new FileInputStream(inputFile);
		byte[] inputBytes = new byte[(int) inputFile.length()];
		inputStream.read(inputBytes);
		byte[] outputBytes = cipher.doFinal(inputBytes);
		FileOutputStream outputStream = new FileOutputStream(outputFile);
		outputStream.write(outputBytes);
		inputStream.close();
		outputStream.close();
	}

}
