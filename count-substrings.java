// Recursive solution to count substrings with same first and last characters

//CODE -->
//This code is recursive , just understand what each of these recursive function does in the first step, rest can be checked using chatGPT.
public class countBinaryStrings {

     public static void main(String [] args)
     {
        String str="abcab";
        int i=0;
        int j=str.length()-1;
        int n=str.length();
        System.out.println(checkChar(str, i, j, n));
     }
     public static int checkChar(String str,int i,int j,int n)
     {
        if(n==1)
        {
            return 1;
        }
        if(n<=0)
        {
            return 0;
        }

        int res=checkChar(str, i+1, j, n-1)+checkChar(str, i, j-1, n-1)-checkChar(str, i+1, j-1, n-2);

        if(str.charAt(i)==str.charAt(j))
        {
            res++;
        }
        return res;
     }
}



#Explaination
      Initial Call (i=0, j=4, n=5):
        Check the base cases: n is not 1, and n is not less than or equal to 0.
        Calculate res:
            Call 1: countSubstrs("bcab", 1, 4, 4) (i+1, j, n-1)
            Call 2: countSubstrs("abca", 0, 3, 4) (i, j-1, n-1)
            Call 3: countSubstrs("bca", 1, 3, 3) (i+1, j-1, n-2)
        Check if the first and last characters are the same: str.charAt(0) == str.charAt(4) (a == b) - not the same.
  
# each step of Call 1: countSubstrs("bcab", 1, 4, 4) (i+1, j, n-1)
// Call 1: countSubstrs("bcab", 1, 4, 4)
// i = 1, j = 4, n = 4

int res = countSubstrs("bcab", 2, 4, 3) +
          countSubstrs("bcab", 1, 3, 3) -
          countSubstrs("bcab", 2, 3, 2);

// Breakdown of each recursive call:

// Subcall 1: countSubstrs("cab", 2, 4, 3)
// i = 2, j = 4, n = 3

    int res1 = countSubstrs("cab", 3, 4, 2) +
               countSubstrs("cab", 2, 3, 2) -
               countSubstrs("cab", 3, 3, 1);

    // Subcall 1.1: countSubstrs("ab", 3, 4, 2)
    // i = 3, j = 4, n = 2

        int res1_1 = countSubstrs("ab", 4, 4, 1) +
                     countSubstrs("ab", 3, 3, 1) -
                     countSubstrs("ab", 4, 3, 0);

        // Base cases reached, return 1 (n == 1)
        // res1_1 = 1

    // Subcall 1.2: countSubstrs("ca", 2, 3, 2)
    // i = 2, j = 3, n = 1

        int res1_2 = 1;  // Base case reached (n == 1)

        // res1_2 = 1

    // Subcall 1.3: countSubstrs("cab", 3, 3, 1)
    // i = 3, j = 3, n = 0

        int res1_3 = 0;  // Base case reached (n <= 0)

        // res1_3 = 0

    // res1 = 1 + 1 - 0 = 2

// Subcall 2: countSubstrs("bcab", 1, 3, 3)
// i = 1, j = 3, n = 3

    int res2 = countSubstrs("bcab", 2, 3, 2) +
               countSubstrs("bcab", 1, 2, 2) -
               countSubstrs("bcab", 2, 2, 1);

    // Subcall 2.1: countSubstrs("cab", 2, 3, 2)
    // i = 2, j = 3, n = 1

        int res2_1 = 1;  // Base case reached (n == 1)

        // res2_1 = 1

    // Subcall 2.2: countSubstrs("bca", 1, 2, 2)
    // i = 1, j = 2, n = 1

        int res2_2 = 1;  // Base case reached (n == 1)

        // res2_2 = 1

    // Subcall 2.3: countSubstrs("bcab", 2, 2, 1)
    // i = 2, j = 2, n = 0

        int res2_3 = 0;  // Base case reached (n <= 0)

        // res2_3 = 0

    // res2 = 1 + 1 - 0 = 2

// Subcall 3: countSubstrs("bcab", 2, 3, 2)
// i = 2, j = 3, n = 1

    int res3 = 1;  // Base case reached (n == 1)

    // res3 = 1

// Combine results
// res = 2 + 2 - 1 = 3

// Return res = 3
