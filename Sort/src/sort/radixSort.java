package sort;

class RadixSort{
	public void radixSort(int[] array, int digit){
		for(int i=0;i<digit;i++)
			countSort(array, i);
	}
	private void countSort(int[] array, int dig){
			
		//申请计数数组
		int[] count=new int[10];
		
		int op = 1;
		for(int i=0;i<dig;i++)
			op*=10;
		
		for(int i=0;i<array.length;i++)
			count[array[i]/op%10]++;
		
		//第三遍：迭代 使count数组变为记录元素位置o(k)
		for(int i=1;i<count.length;i++)
			count[i]+=count[i-1];
		
		//申请结果数组
		int[] result=new int[array.length];
		//第四遍：根据count数组记录的位置,将array数组依次存入result中的相应位置o(n)
		for(int i=array.length-1;i>=0;i--)
		{
			result[count[array[i]/op%10]-1]=array[i];
			count[array[i]/op%10]--;
		}
		
		//第五遍：将result数组复制到array里o(n)
		for(int i=0;i<array.length;i++)
			array[i]=result[i];
	}
}