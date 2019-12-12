package com.gk;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class TestPdf {
	public final static byte[] USER = "Virtusa_149679".getBytes();
	public final static byte[] OWNER = "swapnil_pawar123".getBytes();
	
	public  void encryptPdf(String src, String dest) throws IOException, DocumentException {
		PdfReader reader = new PdfReader(src);
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
		stamper.setEncryption(USER, OWNER, PdfWriter.ALLOW_PRINTING,
				PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
		stamper.close();
		reader.close();
		System.out.println("Write file");
	}

	public static void main(String[] args) throws IOException, DocumentException {
       String src = "D:\\gk.pdf";
       String dest = "D:\\123.pdf";
       System.out.println("START PROGRAM...");
       
       new TestPdf().encryptPdf(src, dest);
       
	}
}
