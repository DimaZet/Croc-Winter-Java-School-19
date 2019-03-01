public class ReverseVowels {

    public static void main(String []args) {
        String test1 = "abcdefghi";
        String test2 = "aaaiuiooo";
        String test3 = "bvcnmm";
        test1 = reverse(test1);
        System.out.println(test1);
        System.out.println(reverse(test2));
        System.out.println(reverse(test3));
    }

    public static String reverse(String word) {
        char[] _word = word.toCharArray();
        String dictionary = "eyuioa";
        String vowels = "";

        for(int i=0;i<word.length();++i)
            if( dictionary.indexOf( _word[i] ) != -1 ) {
                vowels += _word[i];
                _word[i] = '_';
            }

        int count = vowels.length()-1;
        for(int i=0;i<word.length();++i)
            if( _word[i] == '_')
                _word[i] = vowels.charAt(count--);

        return new String(_word);
    }
}
