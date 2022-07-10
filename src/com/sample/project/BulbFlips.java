package com.sample.project;

public class BulbFlips {

	public static void main(String[] args) {
		int A[]= {1,1,1,1};
		System.out.println(bulbs( A));
		int N[]= {0, 1, 0};
		System.out.println(bulbs( N));
	}
	
	public static int bulbs(int[] A) {
		int flipCounts =0;
		for(int counter=0;counter<A.length;++counter)
		{
			if( flipCounts%2==0){
                if(A[counter] ==1) continue;
                if(A[counter] ==0) ++flipCounts;
                System.out.println(flipCounts +"in 0");
            }
            else{
                if(A[counter] ==0) continue;
                if(A[counter] ==1) ++flipCounts;
                System.out.println(flipCounts +"in 1");
            }
            
				
			
		}
		return flipCounts; 
    }
}
