package sort;

/**  
 * ð�ݷ�����<br/>  

 * <li>�Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������</li>  
 * <li>��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ�����һ�㣬����Ԫ��Ӧ�û�����������</li>  
 * <li>������е�Ԫ���ظ����ϵĲ��裬�������һ����</li>  
 * <li>����ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�</li>  

 *   
 * @param numbers  
 */  

class BubbleSort{
	public void bubbleSort(int[] array){
		for(int i=array.length-1;i>0;i--)//���ѭ�� iָʾ�������߽磬��i֮�����������������ٱȽϡ�
		{
			for(int j=0;j<i;j++)//��ѭ�� �Ƚϴ�0��i����������Ԫ�ء�
			{
				if(array[j]>array[j+1]){//���ʱ��Ҫ���� ����Ͳ��ȶ��� ����ȵ�����������������Ч��
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
			for(int j=0;j<i;j++)//��ѭ�� �Ƚϴ�0��i����������Ԫ�ء�
			{
				if(array[j]>array[j+1]){//���ʱ��Ҫ���� ����Ͳ��ȶ���
					array[j+1]=array[j+1]^array[j];
					array[j]=array[j+1]^array[j];
					array[j+1]=array[j+1]^array[j];
					
					flag = false;
				}
			}
			if(flag == true)//��һ�ζ�û���� ˵���Ѿ�������� ���Խ���
				return;
		}
	}
}