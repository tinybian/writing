package sort;

/**  
 * ѡ������<br/>  
 * <li>��δ�����������ҵ���СԪ�أ���ŵ��������е���ʼλ��</li>  
 * <li>�ٴ�ʣ��δ����Ԫ���м���Ѱ����СԪ�أ�Ȼ��ŵ���������ĩβ��</li>  
 * <li>�Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ�</li>  

 *   
 * @param numbers  
 */  

class SelectSort{
	public void selectSort(int[] array){
		for(int i=0;i<array.length-1;i++)
		{
			int min = i;
			for(int j = i+1;j<array.length;j++)//�ҵ���С�������±�
				if(array[min]>array[j])
					min = j;
			
			//������С��Ԫ�غ�Ŀ��Ԫ��
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}