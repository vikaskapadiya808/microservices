package com.example.demo;

public class Loop {
  public static void main(String[] args) {
	int arr[]= {1,2,3,4,5,6,7,8,9,10};
	int i = 0; 
	do {
		System.out.println(arr[i]);
		i++;
	}while(i<arr.length);
}
}
