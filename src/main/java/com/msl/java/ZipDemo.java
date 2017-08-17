package com.msl.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDemo {

	public static void main(String[] args) throws Exception {
		ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("d:/temp/io/out.zip"));
		String[] fNames = new String[] {"d:/temp/io/f1.txt","d:/temp/io/f2.txt"};
		for (String name:fNames) {
			ZipEntry entry = new ZipEntry(name);
			FileInputStream fin = new FileInputStream(name);
			try {
				zipOut.putNextEntry(entry);
				zipOut.finish();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
