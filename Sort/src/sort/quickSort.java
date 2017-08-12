package sort;

/**  
 * 快速排序<br/>  
 * <ul>  
 * <li>从数列中挑出一个元素，称为“基准”</li>  
 * <li>重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，  
 * 该基准是它的最后位置。这个称为分割（partition）操作。</li>  
 * <li>递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。</li>  
 * </ul>  
 * 
 */

class QuickSort{
	public void quickSort(float[] a, int start, int end){
		if(start<end)
		{
			int middle = partition(a, start, end);
			quickSort(a, start, middle-1);//不能将Middle递归进去 否则当分割失败时 可能死循环
			quickSort(a, middle+1, end);
		}
	} 
	private int partition(float[] a, int start, int end)
	{
		float temp = a[start];//取出中轴
		while(start<end)
		{
			while(start<end && a[end]>=temp)//从右向左找到比中轴小的
				end--;
			a[start]=a[end];//赋值给左侧元素
			while(start<end && a[start]<=temp)//从左向右找到比中轴大的
				start++;
			a[end]=a[start];//赋值给右侧元素
		}//直到start==end
		a[start]=temp;//将中轴赋值给当前位置
		return start;
	}
}

