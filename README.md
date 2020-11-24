# Java---
给《长恨歌》加标点符号
## 计G201游慧敏2020322070 
## 实验目的
> 掌握字符串String及其方法的使用<br>
> 掌握文件的读取/写入方法<br>
> 掌握异常处理结构<br>
## 实验内容
> 在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。<br>
> 文件A包括两部分内容：<br>
>> 一是学生的基本信息；<br>
>> 二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：<br>
>> 1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”；<br>
>> 2.允许提供输入参数，统计古诗中某个字或词出现的次数；<br>
>> 3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A；<br>
>> 4.考虑操作中可能出现的异常，在程序中设计异常处理程序。<br>
>>
>>> 输入：汉皇重色思倾国御宇多年求不得······<未完，待续><br>
>>> 输出：<br>
>>> 汉皇重色思倾国，御宇多年求不得。<br>
>>> 杨家有女初长成，养在深闺人未识。<br>
>>> 天生丽质难自弃，一朝选在君王侧。<br>
>>> ······<br>
## 实验要求
>1.设计学生类（可利用之前的）；<br>
>2. 采用交互式方式实例化某学生；<br>
>3. 设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。<br>
## 实验过程
>1. 创建一个封装类：即学生类Student，
>>     定义学生的基本属性name、sex、age，
>>     利用super设置有参和无参的构造方法，
>>     设置set()、get()方法以及toString()方法；
>2. 创建一个统计古诗中某个汉字出现的次数的类time（即从字符串中提取子字符串，需要用到正则表达式）
>>     创建BufferedReader对象读取文本文件A；
>>     初始化StringBuffer对象；
>>     创建一个空字符串；
>>     利用while方法，写入readLine()方法判断每一行的内容有没有被读取到；
>>     再用append()方法将实例化的StringBuffer对象和字符串拼接在一起；
>>     声明要统计的汉字；
>>     利用正则表达式中的两个类：Pattern和Matcher的相关方法以及find()方法统计所求汉字出现的次数。
>3. 创建测试类Test，
>>     用Scanner相关方法实现运行时交互式输入，即实例化学生；
>>     利用文件字符的输入输出流写出读取和写入的文件；
>>     利用FileReader方法将读取的文件设为只读文件;
>>     定义一个char型数组；
>>     利用Writer流的子类FileWriter创建指向目的地的输出流和Reader流的子类FileReader创建源的输入流；
>>    (输出流的目的是提供一个通往目的地的通道，输入流的目的是提供一个读取源中数据的通道)
>>     利用write方法把学生类的基本信息写入到缓冲区；
>>     利用for循环和if判断方法添加“，”和“。”；
>>     利用flush()方法将当前缓冲区的内容写入到目的地；
>>     最后利用close()方法关闭所有打开的流。
>4. 类中的异常处理，根据具体情况而定（方法多样）。<br>
>>     方法一：
>>     使用try-catch语句：
>>     将可能出现异常的语句放在try部分，一旦try部分抛出异常对象，那么try部分将立刻结束执行
>>     （如果try部分没有抛出异常，则继续执行try部分的语句。即try部分不受任何影响。）
>>     转而执行相应的catch部分，异常后的处理放在catch部分。
>>     方法二：
>>     直接在main方法之后添加throws IOException，即public static void main(String[] args) throws IOException 
## 核心代码
```
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
				e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			} finally {
				try {
					if(null != br) {
						//关闭资源
						br.close();
					}
				} catch (IOException e) {				
					e.printStackTrace();
				}		
```
```
Scanner scan = new Scanner(System.in);
		System.out.println("请输入你的姓名 ");
		String name = scan.nextLine();
		System.out.println("请输入你的性别 ");
		String sex = scan.nextLine();
		System.out.println("请输入你的年龄 ");
		int age = scan.nextInt();
		Student student=new Student(name,sex,age);
```
```
 //读取的文件
			File soursefile=new File("e:\\专升本 Java\\B.txt");						
			//写入的文件
			File targetFile=new File("e:\\专升本 Java\\A.txt");
			//将读取的文件设为只读文件
			Reader r=new FileReader(soursefile);
			//char型数组
			char[] c= new char[(int)255];
   //创建指向目的地的输出流
			Writer out=new FileWriter(targetFile,true);
			//创建源的输入流
			Reader in =new FileReader(soursefile);
			out.write(student.toString());
   for(int i=0;i<c.length;i++){
		        	out.write(r.read());
           if(i%7==0&&i%14!=0){						
						     out.write(",");	
           }
					if(i%14==0){
						out.write("。");
						out.write(System.getProperty("line.separator"));
			}
			}
     out.flush();
					out.close();
```	

## 运行结果
![img]()
## 编程感想
> 通过此次试验，我学会了字符串String及其方法的使用;<br>
> 理解了文件的读取/写入方法；<br>
> 学习了异常处理结构。
