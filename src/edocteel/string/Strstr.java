package edocteel.string;

/**
 * Created by chace on 5/15/14.
 */
public class Strstr {
    public String strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 == 0 && len2 == 0) {
            return "";
        }
        for (int i = 0; i <= len1 - len2; i++) {
            int a = i;
            int b = 0;
            while (b < len2) {
                if (haystack.charAt(a) != needle.charAt(b)) {
                    break;
                } else {
                    a++;
                    b++;
                }
            }
            if (b == len2) {
                return haystack.substring(i);
            }
        }
        return null;
    }

    public String strStrKMP(String haystack, String needle) {
        if(needle.length()==0) return haystack;

        int[] overLay = getOverLay(needle);
        int big = 0, small = 0;
        while(big<haystack.length() && small<needle.length()){
            if(haystack.charAt(big)==needle.charAt(small)){
                big++;
                small++;
            } else if(small == 0) big++;
            else small = overLay[small-1]+1;
        }
        if(small==needle.length()) return haystack.substring(big-small);
        else return null;
    }

    private int[] getOverLay(String needle){
        char[] pat = needle.toCharArray();
        int[] overLay = new int[pat.length];
        overLay[0] = -1;
        int index = -1;
        for(int i = 1; i < pat.length; i++){
            index = overLay[i-1];
            while(index>=0 && pat[index+1]!=pat[i])
                index = overLay[index];
            if(pat[i] == pat[index+1])
                overLay[i] = index+1;
            else
                overLay[i] = -1;
        }
        return overLay;
    }

    public static void main(String[] args) {
        Strstr test = new Strstr();
        System.out.println(test.strStrKMP("babcfgcabcz", "abc"));
    }
}
