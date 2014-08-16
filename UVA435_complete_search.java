import java.io.*;
import java.util.*;

public class UVA435_complete_search{
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int t = Integer.parseInt(in.readLine()); //t is the number of test cases
        int [] memb = new int[20];
        int [] powidx = new int[20];
        int sum =0;
        while(t!=0){
            String line = in.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int p = Integer.parseInt(st.nextToken());   // p is the number of parties
            int total = 0;
            for(int i =0; i<p;i++){
                memb[i]= Integer.parseInt(st.nextToken());
                powidx[i]=0;
                total+= memb[i];
                
            }
            total/=2;
            for(int s =0;s<(1<<p);s++){
                sum =0;
                // s is a subset, this loop sums the members in this subset
                for(int z=0;z<p;z++){
                    if((s&(1<<z))!=0){   // contains party z
                        sum+= memb[z];
                    }
                }
                if(sum>total){
                    continue;
                }
                //less then majority
                else{
                    for(int k =0;k<p;k++){
                        if((s&(1<<k))==0 && sum+memb[k]> total)
                            powidx[k]++;
                    }
                }
            }
            t--;
            for (int j = 0; j < p; j++) {
                output.append("party "+ (j+1) + " has power index "+ powidx[j] + "\n");
            }
            output.append("\n");

        }
        System.out.print(output);   
    }
}
