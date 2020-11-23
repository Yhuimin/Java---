package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入你的姓名 ");
		String name = scan.nextLine();
		System.out.println("请输入你的性别 ");
		String sex = scan.nextLine();
		System.out.println("请输入你的年龄 ");
		int age = scan.nextInt();
		Student student=new Student(name,sex,age);
		
			//读取的文件
			File soursefile=new File("e:\\专升本 Java\\B.txt");						
			//写入的文件
			File targetFile=new File("e:\\专升本 Java\\A.txt");
			//将读取的文件设为只读文件
			Reader r=new FileReader(soursefile);
			//char型数组
			char[] c= new char[(int)255];
			
			String s = ",";
			String s1=".";
			
			//创建指向目的地的输出流
			Writer out=new FileWriter(targetFile,true);
			//创建源的输入流
			Reader in =new FileReader(soursefile);
			out.write(student.toString());
//			int n=-1;
//			while((n=in.read(c))!=-1) {
//				out.write(c,0,n);								
//				out.write(c);
		        for(int i=0;i<c.length;i++){
		        	out.write(r.read());
//		        	out.write(s,0,i);
//		        	System.out.println(",");
					if(i%7==0&&i%14!=0){						
						out.write(",");								               
//						System.out.println("，");
					}
					if(i%14==0){
						out.write("。");
						out.write(System.getProperty("line.separator"));

			}
			}
					//in.close();
					out.flush();
					out.close();
          
          
   } 
}
