/* powerset
   bubble sort */

import java.util.*;

public class UVA574{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
         while(flag!=false){
             StringBuilder output = new StringBuilder();
             int t = sc.nextInt();
             int n = sc.nextInt();
             if(n==0){
                 flag= false;
                 continue;
             }
             output.append("Sums of ").append(t).append(":\n");
             ArrayList<Integer> al = new ArrayList<Integer>(n);
             while(n!=0){
                 al.add(sc.nextInt());
                 n--;
             }
             Set<List<Integer>> total  = powerset(al);
             List<List<Integer>> sub = new ArrayList<List<Integer>>();
             for(List<Integer> s : total){
                 if(sum(s)==t){
                     sub.add(s);
                 }
             }
             //System.out.println("before sorting: "+ sub);   
             // bubble sort
             for(int j = 0;j<sub.size();j++){
                 for(int x=1;x<sub.size()-j;x++){
                     int size1 = sub.get(x-1).size();
                     int size2 = sub.get(x).size();
                     int small = Math.min(size1,size2);
                     //index go backwards
                     for(int idx=small-1;idx>=0;idx--){
                         if(sub.get(x-1).get(idx)<sub.get(x).get(idx)){
                            //do a switch
                            List<Integer> temp = sub.get(x-1);
                            sub.set(x-1, sub.get(x));
                            sub.set(x,temp);
                        }
                     }
                 }
             }
             if(sub.isEmpty()){
                 output.append("NONE\n");
             }
             else{
                 for(List<Integer> a:sub){
                     for(int index=0;index<(a.size()-1);index++){
                         output.append(a.get(index)).append("+");
                     }
                     output.append(a.get(a.size()-1)).append("\n");
                 }
             }
             System.out.print(output.toString());
             
         }

    }
    public static <T> Set<List<T>> powerset(List<T> l) {
        Set<List<T>> sets = new HashSet<List<T>>();
        if (l.isEmpty()) {
            sets.add(new ArrayList<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(l);
        T head = list.get(0);
        List<T> rest = new ArrayList<T>(list.subList(1, list.size())); 
        for (List<T> set : powerset(rest)) {
            List<T> newSet = new ArrayList<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }		
        return sets;
    }
    public static int sum(List<Integer> list) {
        int sum= 0; 
        for (int i:list)
            sum = sum + i;
        return sum;
   }
}
