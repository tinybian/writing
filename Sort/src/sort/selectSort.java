package sort;

/**  
 * 选择排序<br/>  
 * <li>在未排序序列中找到最小元素，存放到排序序列的起始位置</li>  
 * <li>再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。</li>  
 * <li>以此类推，直到所有元素均排序完毕。</li>  

 *   
 * @param numbers  
 */  

class SelectSort{
	public void selectSort(int[] array){
		for(int i=0;i<array.length-1;i++)
		{
			int min = i;
			for(int j = i+1;j<array.length;j++)//找到最小的数的下标
				if(array[min]>array[j])
					min = j;
			
			//交换最小的元素和目标元素
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}