//here i will be using backtracking to solve this problem
//To calculate all the permutations it will take n! time and to calculate each indiviual permutation it will take n time
//T.C=O(n*n!)
public class totalPermutations {
    public static void main(String [] args)
    {
        String str="abc";
        String ans=new String();
        findPerm(str,ans);
    }
    public static void findPerm(String str,String ans)
    {
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++)
        {
            char curr=str.charAt(i);
            String NewStr=str.substring(0,i)+str.substring(i+1);
            findPerm(NewStr, ans+curr);
        }
    }
}
