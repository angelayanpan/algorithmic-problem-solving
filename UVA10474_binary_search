/* binary search
   UVA10474 Where is the Marble  */

import java.io.*;
import java.util.*;

public class UVA10474 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        int count =0;
        while(flag!=false){
            String line = in.readLine();
            StringBuilder output = new StringBuilder();
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            if(n==0 && q==0){
                flag = false;
                continue;
            }
            count++;
            output.append("CASE# ").append(count).append(":\n");
            ArrayList<Integer> al = new ArrayList<Integer>(n);
            for(int i=0;i<n;i++){
                al.add(Integer.parseInt(in.readLine()));
            }
            // sort the array
            Collections.sort(al);
            for(int j=0;j<q;j++){
                int t = Integer.parseInt(in.readLine());
                int index = bs(al,0,n-1,t);
                if(index==-1){
                    output.append(t).append(" not found\n");
                }
                else{
                    output.append(t).append(" found at ").append(index).append("\n");
                }
            }
            System.out.print(output.toString());      
        }

    }
    public static int bs(ArrayList<Integer> al,int start, int end,int t){
        if(end<start) return -1;
        if(al.get(start) >t) return -1;
        if(al.get(end) <t) return -1;
        int mid = (start+end)/2;
        if(al.get(mid)==t){
            int leftIndex = bs(al, start, mid-1,t);
            return leftIndex==-1?mid+1:leftIndex;
        }
        else if(al.get(mid)>t){
            return bs(al,start,mid-1,t);
        }
        else{
            return bs(al,mid+1,end,t);
        }
        
    }
    
}
