package sort;
/**  
 * 归并排序<br/>  
 * <ul>合并方法  
 * <li>申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列</li>  
 * <li>设定两个指针，最初位置分别为两个已经排序序列的起始位置</li>  
 * <li>比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置</li>  
 * <li>重复步骤3直到某一指针达到序列尾</li>  
 * <li>将另一序列剩下的所有元素直接复制到合并序列尾</li>  
 * </ul>  
 *   
 * @param numbers  
 */  


class MergeSort{
	public void mergeSort(int[] array){
		recursive_mergeSort(array, 0, array.length-1);
	}
	private void recursive_mergeSort(int[] array, int begin, int end){
		if(begin>=end)
			return;
		int middle = (begin+end)/2;
		recursive_mergeSort(array, begin, middle);
		recursive_mergeSort(array, middle+1, end);
		merge(array, begin, middle, end);
	}
	private void merge(int[] array, int begin, int middle, int end){
		int[] result = new int[end-begin+1];//临时存放结果
		int i = begin, j=middle+1, resIndex=0;
		
		while(i<=middle && j<=end)//找到较小的存入结果数组 直到一边全部存完
		{
			if(array[i]<=array[j])//注意！！一定要有等号，否则就不稳定了。相等时原来在前的array[i]先放。
				result[resIndex++]=array[i++];
			else
				result[resIndex++]=array[j++];
		}
		
		//将剩余的元素存入结果
		while(j<=end)
			result[resIndex++]=array[j++];
		
		while(i<=middle)
			result[resIndex++]=array[i++];
		
		//将结果数组复制进原数组
		for(int k = begin, p=0;p<result.length;k++, p++)
			array[k]=result[p];
	}
	
	/*非递归方式
	 * 开始以间隔为1的进行归并，也就是说，第一个元素跟第二个进行归并。第三个与第四个进行归并；
	 * 然后，再以间隔为2的进行归并，1-2和3-4进行归并，5-6和7-8进行归并；
	 * 再以2*2的间隔，同理，直到2*k超过数组长度为止。
	 * 
	 * 
	 * */
	public void mergeSort_no_recursive(int[] array)
	{
		int size = 1;//每组元素个数 归并最小单元大小
		while(size < array.length)
		{
			int i=0;//归并第一组的光标
			int j=i+size;//归并第二组的光标
			while(i<array.length && j<array.length)
			{
				merge(array, i, i+size-1, j+size-1 > array.length-1 ? array.length-1 : j+size-1);//合并一对
				i = i+size*2;//移位
				j = j+size*2;//移位
			}
			size*=2;
		}
	}
}