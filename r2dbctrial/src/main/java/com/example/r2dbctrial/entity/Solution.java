package com.example.r2dbctrial.entity;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static void printFunction(int[] houses){
        System.out.println("Printing Houses");
        for(int h:houses){
            System.out.print(h+" ");
        }

    }
    private static int distance(int[] houses){
        int n= houses.length;;
        int[] left=new int[n];
        int[] right=new int[n];
       if(houses[0]==1){
           left[0]=0;
       }
       else {
           left[0]=-1;
       }
        if(houses[n-1]==1){
            right[n-1]=0;
        }
        else {
            right[n-1]=-1;
        }

        for(int i=1;i<n;i++){
                if(houses[i]==1){
                    left[i]=0;
                }else{
                    if(left[i-1]==-1){
                        left[i]=-1;
                    }
                    else{
                        left[i]=left[i-1]+1;
                    }
                }
        }
        for(int i=n-2;i>=0;i--){
            if(houses[i]==1){
                right[i]=0;
            }else{
                if(right[i+1]==-1){
                    right[i]=-1;
                }
                else{
                    right[i]=right[i+1]+1;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(left[i]!=-1 && right[i]!=-1){
                count+=Math.min(left[i],right[i]);
            }else{
                if(left[i]==-1){
                    count+=right[i];
                }
                else if(right[i]==-1){
                    count+=left[i];
                }
                else {
                    System.out.println("Some edge case occured");
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bf.readLine());

        while(t>0){
            int n=Integer.parseInt(bf.readLine());

            String h=bf.readLine();

            int[] houses=new int[n];
            for(int i=0;i<n;i++){
                houses[i]=Integer.valueOf(h.charAt(i)-'0');
            }


             //   printFunction(houses);
            System.out.println(distance(houses));
            t--;
        }
    }
}
