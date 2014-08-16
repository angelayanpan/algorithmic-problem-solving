/* Knapsack problem with path recovery
   UVA 990 Diving for Gold */ 

import java.io.*;
import java.util.*;

public class UVA990_knapsack_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder output = new StringBuilder();
        while((line=in.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line);
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int nItems = Integer.parseInt(in.readLine());
            int matrix[][] = new int[nItems][t+1];
            int picks [][] = new int[nItems][t+1];
            int[] weight = new int[nItems];
            int[] value = new int[nItems];
            for(int index=0;index<nItems;index++){
                StringTokenizer trea = new StringTokenizer(in.readLine());
                int dep = Integer.parseInt(trea.nextToken());
                weight[index]= 3*w*dep;
                value[index]= Integer.parseInt(trea.nextToken());       
            }
            output.append(knapsack(nItems-1,t, weight,value, matrix,picks)).append("\n");
            ArrayList<Integer> path = printPicks(nItems-1,t,weight,picks);
            Collections.sort(path);
            output.append(path.size()).append("\n");
            for(int j=0;j<path.size();j++){
                output.append(weight[path.get(j)]/(3*w)).append(" ").append(value[path.get(j)]).append("\n");
            }
            String nextCase;
            if((nextCase=in.readLine())!=null){
                output.append("\n");
                continue;
            }
        }
        System.out.append(output);
    }
    public static int knapsack(int i, int t, int[] weight, int[] value, int[][] matrix,int[][] picks){
        int take =0;
        int dontTake =0;
        if(matrix[i][t]!=0){
            return matrix[i][t];
        }
        if(i==0){
            if(weight[0]<=t){
                matrix[i][t]=value[0];
                picks[i][t]=1;
                return value[0];
            }else{
                matrix[i][t]= 0;
                picks[i][t]=-1;
                return 0;
            }
        }
        if(weight[i]<=t){
            take = value[i]+knapsack(i-1,t-weight[i],weight,value,matrix,picks);
        }
        dontTake = knapsack(i-1,t,weight,value, matrix,picks);
        matrix[i][t]= Math.max(take, dontTake);
        if (take>dontTake){
            picks[i][t]=1;
        }else{
            picks[i][t]=-1;
        }
        return matrix[i][t];
    } 
    static ArrayList<Integer> printPicks(int item, int size, int weights[], int[][] picks){
        ArrayList<Integer> al = new ArrayList<Integer>();
        while (item>=0){
            if (picks[item][size]==1){
                al.add(item);
                size -= weights[item];
                item--;
            }
            else{
                item--;
            }
        }
        return al;
    }   
}
