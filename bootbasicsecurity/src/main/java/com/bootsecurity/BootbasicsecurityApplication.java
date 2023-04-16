package com.bootsecurity;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class BootbasicsecurityApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BootbasicsecurityApplication.class, args);

    		int[] arr = { 0, 5,5,4, 7,7, 2, 9, 1 };
		Integer index = null;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		int num = 6;

		if (arr[arr.length-1]<num) {System.out.println(arr[arr.length-1]);}
		else if (arr[0]>num) System.out.println(arr[0]);
		else  
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				index = i;
				break;
			}
			if (arr[i] > num) {
				index = i;
				break;
			}

		}
		
		

		//System.out.println(arr[index]);
		if (arr[index]==arr[index-1]) {
			System.out.println(arr[index]);
		}
		else {
			if (arr[index]-num < num-arr[index-1]) {
				System.out.println(arr[index]);
			}
			else if (arr[index]-num > num-arr[index-1]) System.out.println(arr[index-1]);
			else System.out.println(arr[index]+" and "+arr[index-1]);
			
		}
		
		
		

	}

}
