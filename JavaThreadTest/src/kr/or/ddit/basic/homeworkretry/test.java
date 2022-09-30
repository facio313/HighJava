package kr.or.ddit.basic.homeworkretry;

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
    	horse fir = new horse("■",1);
    	horse sec = new horse("●",2);
    	horse thr = new horse("◆",3);
    	horse fou = new horse("♥",4);
    	horse fiv = new horse("▶",5);
    	Exception numerror = new Exception("[숫자 이외의 문자 입력]");
    	while(true)
    	{
    		try
    		{
    			num=input("1~5번 경주마중 하나를 고르세요(숫자만 입력하세요)");
    			
    			if(num<1 || num>5)
    			{
    				output("경주마를 제대로 입력하여주세요","오류",0);
    				throw new Exception();
    			}
    			
    			money=input("경주마에 거실 돈을 입력하세요(숫자만 입력하세요)");
    			
    			if(money<=0)
    			{
    				output("돈을 제대로 입력하여주세요","오류",0);
    				throw new Exception();
    			}
    		
    		}
    		catch(java.lang.NumberFormatException e) 
    		{
    			output("에러 메세지:"+numerror.getMessage(),"오류",0);
    			System.exit(0);
    		}
    		catch(Exception e) {temp=0;}
    		if(temp==0) {continue;}
    		
        	temp=JOptionPane.showConfirmDialog(null,("선택하신 경주마"+num+"번, 거신 돈:"+money+"원이 맞습니까?"),"확인",0,3);
    		
    		if(temp==0)
    			break;
    	}
    	for(ready=0;ready<5;ready++)
    	{
    		System.out.println("준비:"+(5-ready));
    		try {Thread.sleep(1000);}catch(Exception e) {}
    	}
    	row.add(fir.arr);
    	row.add(sec.arr);
    	row.add(thr.arr);
    	row.add(fou.arr);
    	row.add(fiv.arr);
    	
    	fir.start();
    	sec.start();
    	thr.start();
    	fou.start();
    	fiv.start();
		try {Thread.sleep(100);}catch(Exception e) {}
    	
    	while(true)
    	{
    		if(full(grade))
    			break;
    		else
    		{
    			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    			for(int i=0;i<5;i++)
    			{
    				String str="";
    				LinkedList clone = new LinkedList<String>();
    				clone.addAll((LinkedList<String>)(row.get(i)));
    				str=LtS(str,clone);
    				System.out.println(str);
    			}
    		}
    		try{Thread.sleep(100);}catch(Exception e) {}
    	}
		for(int i=0;i<5;i++)
			if(num==grade[i])
				temp=i+1;
		
		output("1등: ["+grade[0]+"번 경주마]\n2등: ["+grade[1]+"번 경주마]\n"
				+ "3등: ["+grade[2]+"번 경주마]\n\n당신이 선택한 경주마:"+temp+"등","경기 끝남",-1);
		
		output("당신이 건 돈: "+money+"\n배당금: "+(temp<0 ? 0 : 4-temp)+"배\n총 수입: "+(money*(temp<0 ? 0 : 4-temp)-money)+"원"
				+ "","배당액",-1);
		
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
	final int track_length=99;
	LinkedList arr = new LinkedList<String>();
	String str;
	int num;
	public void run()
	{
		arr.add(str);
		for(int i=0;i<track_length;i++)
			arr.add("-");
		
		while(true)
			if(test.ready==5)
				break;
		
		for(int i=0;i<track_length;i++)
		{
			try{horse.sleep((int)(Math.random()*5+1)*100);}catch(Exception e) {}
			arr.remove(track_length);
			arr.add(0,"-");
		}
		for(int i=0;i<5;i++)
		{
			if(test.grade[i]==0)
			{
				test.grade[i]=num;
				break;
			}
		}
		
	}
	horse(String str,int num)
	{
		this.str=str;
		this.num=num;
	}
}