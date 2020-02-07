/*********************************************************************************************************************
     **
     **  Implemenet 
     **		1. Straight Selection Sort
	 **		2. Straight Insertion Sort
	 **		3. Shell Sort
	 **		4. Bubble Sort
	 **		5. Quick Sort
	 **		6. Merge Sort
	 **
     **  Input in the form of array
     **  Output is printed in listed manner
	 **  Output is taken by considering single sort at a time while others are commented.
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

public class Sort
{

	static int []a={15,5,24,8,1,3,16,10,20};
	static int []b=new int[a.length];

	public static void main(String[] args) 
	{	
		Sort x=new Sort();
		//x.straightSelectionSort();
		//System.out.println("Straight Selection Sort :");

		//x.straightInsertionSort();
		//System.out.println("Straight Insertion Sort :");

		//x.shellSort();
		//System.out.println("Shell Sort :");

		//x.bubbleSort();
		//System.out.println("Bubble Sort :");
				
		//x.quickSort(0,a.length-1);
		//System.out.println("Quick Sort :");
		
		x.mergeSort(0,a.length-1);
		System.out.println("Merge Sort :");

		x.print();
	}

	private static void straightSelectionSort()
	{
	    for(int i=0;i<a.length;i++)
	    {
	        int small=i;
	        for(int j=i;j<a.length;j++)
	        {
	            small=a[small]<a[j]?small:j;
	        }
	        swap(small,i);     
	    }
	}
	
	private static void straightInsertionSort()
	{
		for(int i=1;i<a.length;i++)
		{
			int current=i;
			int tmp=i-1;

			while(a[tmp]>a[current] && tmp>=0)
			{
				swap(tmp,current);
				current=tmp;
				tmp=current-1;
			}
		}
	}

	private static void shellSort()
	{
		int incre=a.length/2;

		while(incre>0)
		{
			
			for(int i=a.length-1;i>=0;i--)
			{
				int hold=a[i];
				int tmp=i-incre;
				while(tmp>=0 && hold < a[tmp] )
				{
					a[tmp+incre]=a[tmp];
					tmp-=incre;
				}
				a[tmp+incre]=hold;
			}
			incre/=2;
		}
	}

	private static void  bubbleSort()
	{
		boolean sort=true;
		for(int i=0;i<a.length && sort;i++)
		{
			int last=a.length-1;
			sort=false;
			while(last>i)
			{
				if(a[last]<a[last-1])
				{
					sort=true;
					swap(last,last-1);
				}
				last--;
			}
		}
	}

	private static void quickSort(int first,int last)
	{
		if(first<last)
		{
			int location = partition(first,last);
			quickSort(location+1,last);
			quickSort(first,location-1);
		}
	}

	private static int partition(int first, int last)
	{
		int start=first;
		int end=last;
		int pivot=a[first];		
		while(start<end)
		{
			while(a[start]<=pivot && start<end)
				start++;

			while(a[end]>pivot)
				end--;
		
			if(start<end)
				swap(start,end);
			
		}
		swap(first,end);
		return end;
	}

	private static void mergeSort(int first,int last)
	{
		if(first<last)
		{
			int mid=(first+last)/2;
			mergeSort(first,mid);
			mergeSort(mid+1,last);
			merge(first,mid,last);
		}
	}

	private static void merge(int first,int mid, int last)
	{
		int i=first;
		int j=mid+1;
		int k=first;

		while(i<=mid && j<=last)
		{
			if(a[i]>a[j])
				b[k++]=a[j++];
			else
				b[k++]=a[i++];
		}

		if(i>mid)
		{
			while(j<=last)
				b[k++]=a[j++];
		}
		else
		{
			while(i<=mid)
				b[k++]=a[i++];
		}

		for(k=first;k<=last;k++)
			a[k]=b[k];

	}

	private static void swap(int i,int j)
	{
	    int tmp=a[i];
	    a[i]=a[j];
	    a[j]=tmp;
	}

	private static void print()
	{
	    System.out.print("Sorted data : ");
	    for(int i=0;i<a.length;i++)
	        System.out.print(a[i]+" ");
	    System.out.println();
	}

}
