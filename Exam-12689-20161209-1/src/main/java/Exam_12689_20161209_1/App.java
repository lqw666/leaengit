package Exam_12689_20161209_1;

import java.util.ArrayList;

/**
 * 判断101和200之间有多少个素数
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	int x=0;
    	ArrayList<Integer> arrayList=new ArrayList<Integer>();
    	for(int i=101;i<201;i++){
    		boolean b=true;
    		for(int j=2;j<i/2;j++){
    			if((i%j)==0){
    				b=false;
    				break;
    			}
    		}
    		if(b){
    			arrayList.add(i);
    		}
    	}
        System.out.print("101和200间总共有"+arrayList.size()+"个素数，分别是：");
        for (Integer integer : arrayList) {
        	if(arrayList.indexOf(integer)==(arrayList.size()-1)){
        		System.out.print(integer);
        	}else{
			System.out.print(integer+",");
        	}
		}
    }
}
