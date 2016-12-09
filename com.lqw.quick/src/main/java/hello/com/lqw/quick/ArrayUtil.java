package hello.com.lqw.quick;

public class ArrayUtil {

	//交换数组内的两个元素
	public static int[] swap(int[] ints,int x,int y){
		int temp=ints[x];
		ints[x]=ints[y];
		ints[y]=temp;
		return ints;
	}
	
	/**冒泡排序----相邻两元素进行比较  性能：比较次数O(n^2),,n^2/2,交换次数
	O(n^2),n^2/4
	**/
	public static int[] bubbleSort(int[] source){
		for(int i=1;i<source.length;i++){
			for(int j=0;j<i;j++){
				if(source[j]>source[j+1]){
					swap(source,j,j+1);
				}
			}
		}
		return source;
	}
	/**直接选择排序法-----每一趟从待排序的数组里选出一个最大或最小的元素，顺序放在已排序
	 * 好的数列最后，直到全部数据元素排完
	 * 性能：比较次数(O^2),n^2/2,交换次数O(n),n
	 * 
	 * **/
	public static int[] selectSort(int[] source){
			for(int i=0;i<source.length;i++){
				for(int j=i+1;j<source.length;j++){
					if(source[i]>source[j]){
						swap(source,i,j);
					}
				}
			}
			return source;
		}
	/**
	 * 插入排序------将一个记录插入到已排序好的有序表中
	 * 性能：比较次数O(n^2),n^2/4
	 */
	public static int[] insterSort(int[] source){
		for(int i=1;i<source.length;i++){
			for(int j=i;(j>0)&&(source[j]<source[j-1]);j--){
				swap(source,j,j-1);
			}
		}
		return source;
	}
}
