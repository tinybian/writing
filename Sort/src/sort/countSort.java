package sort;

class CountSort{
	public void countSort(int[] array){
		int max = 0;
		//第一遍：找到最大元素o(n)
		for(int i=0;i<array.length;i++)
			if(array[i]>max)
				max=array[i];
		
		//申请计数数组
		int[] count=new int[max+1];
		//第二遍：计数o(n)
		for(int i=0;i<array.length;i++)
			count[array[i]]++;
		
		//第三遍：迭代 使count数组变为记录元素位置o(k)
		for(int i=1;i<count.length;i++)
			count[i]+=count[i-1];
		
		//申请结果数组
		int[] result=new int[array.length];
		//第四遍：根据count数组记录的位置,将array数组依次存入result中的相应位置o(n)
		for(int i=0;i<array.length;i++)
		{
			result[count[array[i]]-1]=array[i];
			count[array[i]]--;
		}
		
		//第五遍：将result数组复制到array里o(n)
		for(int i=0;i<array.length;i++)
			array[i]=result[i];
	}
}