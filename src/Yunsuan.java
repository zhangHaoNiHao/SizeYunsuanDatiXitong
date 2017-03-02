import java.util.Scanner;

public class Yunsuan {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in); 
		int t=1,n=0;
		while(t!=0)
		{
			System.out.println("请选择：  1.整数运算    2.分数运算    0.退出");
			t=sc.nextInt();
			switch(t)
			{
			case 1:{zhengshu();
				break;
			}
			case 2:{fenshu();
			break;
			}
			
		}
		
	}
	}
	//化简分数；
	public static int simple(int a,int b)
	{
		int c=0;
		if(a>b)
		{		
			while(a!=b)
			{
				c=a-b;
				if(b>=c)
				{
					a=b;
					b=c;
				}
				if(c>b)
				{
					a=c;
				}
			}
			return a;
		}
		else
		{
			while(a!=b)
			{
				c=b-a;
				if(a>=c)
				{
					b=a;
					a=c;
				}
				if(c>a)
				{
					b=c;
				}
				
			}
			return a;
		}
	}
	
	public static int gongbei(int a,int b)
	{
		int t=simple(a,b);
		return a*b/t;
	}
	public static void zhengshu()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入题目数量：");
		int n=sc.nextInt();
		String a[]={"+","-","*","/"};
		int b[]=new int [n]; 
		int c[]=new int [n];
		int d[]=new int [n];
		for(int i=0;i<n;i++)
		{
			b[i]=(int) (Math.random()*100);
			c[i]=(int) (Math.random()*100);
			d[i]=(int) (Math.random()*4);
			boolean f = false;
			for(int j=i-1;j>=0;j--)
			{
				if(b[i]==b[j]&&c[i]==c[j]&&d[i]==d[j])
				{
					f = true;
					break;			
				}
			}
			if(f == true||(d[i]==1&&b[i]<c[i])||(d[i]==3&&c[i]==0))
				i--;
			else
				{
				   System.out.print("第"+(i+1)+"题"+": "+b[i]+" "+a[d[i]]+" "+c[i]+" =");
				   String q=sc.next();
				   String w1=""+(b[i]+c[i]);
				   String w2=""+(b[i]-c[i]);
				   String w3=""+(b[i]*c[i]);
				   String w4=""+(b[i]/c[i]);
				   
				   if(d[i]==0&&q.equals(w1))
					   System.out.println("恭喜你，回答正确！");
				   else if(d[i]==0&&!(q.equals(w1)))
					   System.out.println("回答错误！ 正确结果为："+w1);
				   
				   if(d[i]==1&&q.equals(w2))
					   System.out.println("恭喜你，回答正确！");
				   else if(d[i]==1&&!(q.equals(w2)))
					   System.out.println("回答错误！ 正确结果为："+w2);
				   
				   if(d[i]==2&&q.equals(w3))
					   System.out.println("恭喜你，回答正确！");
				   else if(d[i]==2&&!(q.equals(w3)))
					   System.out.println("回答错误！ 正确结果为："+w3);
				  
				   if(d[i]==3)
				   {
					   if((b[i]%c[i]==0&&q.equals(w4)))
					   {
						   System.out.println("恭喜你，回答正确！");
					   }
					   else if(b[i]%c[i]!=0)
					   {
						   int t=simple(b[i],c[i]);
						   b[i]/=t;c[i]/=t;
						   w4=""+b[i]+"/"+c[i];
						   if(q.equals(w4))
						   {
							   System.out.println("恭喜你，回答正确！");
						   }
					   }
				   }
				   else if(d[i]==3)
					   System.out.println("回答错误！ 正确结果为："+w4);
				   
				}
			
		}
	}
	public static void fenshu()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入题目数量：");
		int n=sc.nextInt();
		String a[]={"+","-","*","/"};
		int b1[]=new int [n]; 
		int b2[]=new int [n];
		int c1[]=new int [n];
		int c2[]=new int [n];
		int d[]=new int [n];
		for(int i=0;i<n;i++)
		{
			b1[i]=(int) (Math.random()*100);
			b2[i]=(int) (Math.random()*100);
			c1[i]=(int) (Math.random()*100);
			c2[i]=(int) (Math.random()*100);
			d[i]=(int) (Math.random()*4);
			boolean f = false;
			for(int j=i-1;j>=0;j--)
			{
				if(b1[i]==b1[j]&&b2[i]==b2[j]&&c1[i]==c1[j]&&c2[i]==c2[j]&&d[i]==d[j])
				{
					f=true;
		            break;
				}		
			}
			if(f==true||(b1[i]>=b2[i])||(c1[i]>=c2[i])||(b2[i]==0)||(c2[i]==0)||(b1[i]==0)||(c1[i]==0))
			{
				i--;
			}
			else
			{
				int t1=simple(b1[i],b2[i]);
				int t2=simple(c1[i],c2[i]);
				b1[i] /= t1;
				b2[i] /= t1;
				c1[i] /= t2;
				c2[i] /= t2;
				//System.out.println("第"+(i+1)+"题：   "+"("+b1[i]+"/"+b2[i]+")"+" "+a[d[i]]+" "+"("+c1[i]+"/"+c2[i]+")"+" "+"=");
				int t=gongbei(b2[i],c2[i]);
				b1[i]*=(t/b2[i]);
				c1[i]*=(t/c2[i]);
				int p1=b1[i]+b2[i];
				int p2=b1[i]-b2[i];
				if(p1>=t||p2<=0||(b1[i]*c1[i]>=b2[i]*c2[i])||(b1[i]*c2[i]>=b2[i]*c1[i]))
					i--;
				else
				{
					System.out.println("第"+(i+1)+"题：   "+"("+b1[i]+"/"+b2[i]+")"+" "+a[d[i]]+" "+"("+c1[i]+"/"+c2[i]+")"+" "+"=");
					String q=sc.next();
					if(d[i]==0)
					{
						int t3=simple(p1,t);
						p1 /=t3;
						t /=t3;
						String w1=""+p1+"/"+t;
						if(q.equals(w1))
							System.out.println("恭喜你，回答正确！");
						else
							System.out.println("回答错误！ 正确结果为："+w1);
					}
					else if(d[i]==1)
					{
						int t3=simple(p2,t);
						p2 /=t3;
						t /=t3;
						String w1=""+p2+"/"+t;
						if(q.equals(w1))
							System.out.println("恭喜你，回答正确！");
						else
							System.out.println("回答错误！ 正确结果为："+w1);
					}
					else if(d[i]==2)
					{
						b1[i] *=c1[i];
						b2[i] *=c2[i];
						int t3=simple(b1[i],b2[i]);
						b1[i] /=t3;
						b2[i] /=t3;
						String w1=""+b1[i]+"/"+b2[i];
						if(q.equals(w1))
							System.out.println("恭喜你，回答正确！");
						else
							System.out.println("回答错误！ 正确结果为："+w1);
					}
					else if(d[i]==3)
					{
						b1[i] *=c2[i];
						b2[i] *=c1[i];
						int t3=simple(b1[i],b2[i]);
						b1[i] /=t3;
						b2[i] /=t3;
						String w1=""+b1[i]+"/"+b2[i];
						if(q.equals(w1))
							System.out.println("恭喜你，回答正确！");
						else
							System.out.println("回答错误！ 正确结果为："+w1);
					}
				}
			}
		}
	}

}
