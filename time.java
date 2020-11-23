package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class time {

	//从文件（e:\\专升本 Java\\A.txt）中查出字符串”御”出现的次数？	
		public static void main(String[] args) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader("e:\\专升本 Java\\A.txt"));
				StringBuffer sb = new StringBuffer();
				String str = null;
				while((str = br.readLine()) != null) {
					sb.append(str);
				}
				
				String regex = "御";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(sb);
				
				int num = 0;
				while(matcher.find()) {
					num++;
				}
				
				System.out.println("次数为： " + num);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(null != br) {
						//关闭资源
						br.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}


