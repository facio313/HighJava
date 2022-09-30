package kr.or.ddit.basic;
import java.util.*;
import javax.swing.JOptionPane;

public class test
{
	public static int ready=0;
	static int num=0,money=0,temp=1;
	static int[] grade = {0,0,0,0,0};
    static LinkedList row = new LinkedList<LinkedList>();
    public static void main(String[] args) throws Exception
    {
    	horse fir = new horse(">",1);
    	horse sec = new horse(">",2);
    	horse thr = new horse(">",3);
    	horse fou = new horse(">",4);
    	horse fiv = new horse(">",5);
    	horse six = new horse(">",6);
    	horse sev = new horse(">",7);
    	horse eig = new horse(">",8);
    	horse nin = new horse(">",9);
    	horse ten = new horse(">",10);
    	for(ready=0;ready<1;ready++)
    	{
    		try {Thread.sleep(1000);}catch(Exception e) {}
    	}
    	//말의 개수만큼 행 추가
    	row.add(fir.arr);
    	row.add(sec.arr);
    	row.add(thr.arr);
    	row.add(fou.arr);
    	row.add(fiv.arr);
    	row.add(six.arr);
    	row.add(sev.arr);
    	row.add(eig.arr);
    	row.add(nin.arr);
    	row.add(ten.arr);
    	//말달리기 시작
    	fir.start();
    	sec.start();
    	thr.start();
    	fou.start();
    	fiv.start();
    	six.start();
    	sev.start();
    	eig.start();
    	nin.start();
    	ten.start();
		try {Thread.sleep(100);}catch(Exception e) {}
    	
    	while(true)
    	{
    		if(full(grade))
    			break;
    		else
    		{
    			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    			for(int i=0;i<10;i++)
    			{
    				String str="";
    				LinkedList clone = new LinkedList<String>();
    				clone.addAll((LinkedList<String>)(row.get(i)));
    				str=LtS(str,clone);
    				System.out.println((i+1) + "번째 말" + str);
    			}
    		}
    		try{Thread.sleep(100);}catch(Exception e) {}
    	}
		for(int i=0;i<5;i++)
			if(num==grade[i])
				temp=i+1;
		
		output("1등: ["+grade[0]+"번 경주마]\n2등: ["+grade[1]+"번 경주마]\n"
				+ "3등: ["+grade[2]+"번 경주마]\n\n당신이 선택한 경주마:"+temp+"등","경기 끝남",-1);
		
		
    	System.exit(0);
    }
    static void output(String mess,String name,int type)
    {
    	JOptionPane.showMessageDialog(null,mess,name,type);
    }
    static int input(String str) 
    {
    	return Integer.valueOf(JOptionPane.showInputDialog(null,str,"입력",3));
    }
    static boolean full(int[] list)
    {
    	int none=0;
    	for(int i=0;i<5;i++)
    		if(list[i]==0)
    			none++;
    	if(none==0)
    		return true;
    	return false;
    }
    static String LtS(String input,LinkedList<String> list)
	{
		input="";
		while(!(list.isEmpty()))
			input+=String.valueOf(list.remove());
		return input;
	}
}
class horse extends Thread
{
	final int track_length=50;
	LinkedList arr = new LinkedList<String>();
	//str : >
	String str;
	//num : #번째 말
	int num;
	public void run()
	{
		arr.add(str);
		//track_length : 50
		for(int i=0;i<track_length;i++) {
			//LinkedList arr
			arr.add("-");
		}
			
		while(true)
			if(test.ready==1)
				break;
		
		//50회 반복
		for(int i=0;i<track_length;i++)
		{
			try{horse.sleep((int)(Math.random()*5+1)*100);}catch(Exception e) {}
			arr.remove(track_length);
			arr.add(0,"-");
		}
		//순위 메기기
		for(int i=0;i<5;i++)
		{
			if(test.grade[i]==0)
			{
				test.grade[i]=num;
				break;
			}
		}
		
	}
	//str : >
	//num : #번째 말	
	horse(String str,int num)
	{
		this.str=str;
		this.num=num;
	}
}