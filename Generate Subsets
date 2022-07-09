public class _Q1_2 
{
	public static void generate_subsets(int a[],int k,int n,int value)
	{
		backtrack(a,0,n,value);
	}
	
	static boolean finished=false;
	
	public static void backtrack(int a[],int k,int n,int value)
	{
		int c[]=new int[n];
		
		if(is_a_solution(a,k,n))
		{
			process_solution(a,k,value);
		}
		
		else
		{
			k=k+1;
			
			int p=construct_candidate(a,k,n,c,value);
			
			for(int i=0;i<p;i++)
			{
				a[k]=c[i];
				backtrack(a,k,n,value);
				
				if(finished)
				{
					return;
				}
			}
		}
	}
	
	public static boolean is_a_solution(int a[],int k,int n)
	{
		return k==n;
	}
	
	public static int construct_candidate(int a[],int k,int n,int c[],int value)
	{
		int nc;
		
		c[0]=0;//0=true
		c[1]=1;//1=false
		
		nc=2;	
		
		return nc;
	}
	
	static int sum;
	
	public static void process_solution(int a[],int k,int value)
	{
		sum=0;
		System.out.print("(");		
		for(int i=1;i<=k;i++)
		{
			if(a[i]==0)
			{
				sum+=i;
				System.out.print(i+",");
			}
		}
		System.out.print(")");
		
		if(sum==value)
		{
			System.out.print("= Correct sum");
		}
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		int a[]= {0,1,2,3,4,5};
		
		int value=6;
		
		generate_subsets(a,0,a.length-1,value);
	}

}
