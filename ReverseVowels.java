public class ReverseVowels {

    public static void main(String []args) {
        String test1 = "abcdefghi";
        String test2 = "aaaiuiooo";
        String test3 = "bvcnmm";
        String test4 = "eyuio";
        test1 = reverse(test1);
        System.out.println(test1);
        System.out.println(reverse(test2));
        System.out.println(reverse(test3));
        System.out.println(reverse(test4));
    }

    public static String reverse(String word) {
        char[] _word = word.toCharArray();
        String dictionary = "eyuioa";
        String vowels = "";
        int end = word.length()-1;
        for(int i=0;i<=end;++i)
            if( dictionary.indexOf( _word[i] ) != -1 ) {
                for(int j=end;j>i;--j) {
                    if( dictionary.indexOf( _word[j] ) != -1  && i != j) {
                        char temp = _word[i];
                        _word[i] = _word[j];
                        _word[j] = temp;
                        end = --j;
                        break;
                    }
                }
            }

        return new String(_word);
    }
}
