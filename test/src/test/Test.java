package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.BufferUnderflowException;

public class Test {
	public static void main(String[] args) {
	File file=new File("servlet.mp4");
	File file2=new File("copy.mp4");
	copy(file,file2);
		}
	
	public static void copy(File file1,File file2){
		try {
			FileInputStream in=new FileInputStream(file1);
			BufferedInputStream bin=new BufferedInputStream(in);
			FileOutputStream out=new FileOutputStream(file2);
			BufferedOutputStream bou=new BufferedOutputStream(out);
			
			byte[] bs=new byte[50*1024];
			int length;
			long before=System.currentTimeMillis();
			int count=0;
			while((length=bin.read(bs))!=-1){				
				bou.write(bs, 0, length);
				count++;
			}
			System.out.println("复制完成");
			in.close();
			out.close();
			System.out.println(System.currentTimeMillis()-before);
			System.out.println("读取了"+count+"次");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

