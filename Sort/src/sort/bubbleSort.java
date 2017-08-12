package sort;

/**  
 * 冒泡法排序<br/>  

 * <li>比较相邻的元素。如果第一个比第二个大，就交换他们两个。</li>  
 * <li>对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。</li>  
 * <li>针对所有的元素重复以上的步骤，除了最后一个。</li>  
 * <li>持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。</li>  

 *   
 * @param numbers  
 */  

class BubbleSort{
	public void bubbleSort(int[] array){
		for(int i=array.length-1;i>0;i--)//外层循环 i指示有序区边界，即i之后是有序区，不必再比较。
		{
			for(int j=0;j<i;j++)//内循环 比较从0到i的所有相邻元素。
			{
				if(array[j]>array[j+1]){//相等时不要交换 否则就不稳定了 不相等的数交换可用异或提高效率
					array[j+1]=array[j+1]^array[j];
					array[j]=array[j+1]^array[j];
					array[j+1]=array[j+1]^array[j];
				}
			}
		}
	}
	
	public void improve_bubbleSort(int[] array){
		boolean flag = true;
		for(int i=array.length-1;i>0;i--)
		{
			flag = true;
			for(int j=0;j<i;j++)//内循环 比较从0到i的所有相邻元素。
			{
				if(array[j]>array[j+1]){//相等时不要交换 否则就不稳定了
					array[j+1]=array[j+1]^array[j];
					array[j]=array[j+1]^array[j];
					array[j+1]=array[j+1]^array[j];
					
					flag = false;
				}
			}
			if(flag == true)//若一次都没交换 说明已经排序完毕 可以结束
				return;
		}
	}
}