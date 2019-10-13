public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> intended = new ArrayDequeSolution<>();
        Integer numOfChar = word.length();
        Integer i = 0;
        while (i < numOfChar) {
            intended.addLast(word.charAt(i));
            i = i + 1;
        }
        return intended;
    }
    public static boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> test = wordToDeque(word);
        Integer len = test.size();
        Integer charTested = len / 2;
        Integer i = 0;
        while (i < charTested) {
            if (test.get(i) != test.get(len - i - 1)) {
                return false;
            }
            i = i + 1;
        }
        return true;
    }
    public static boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> test = wordToDeque(word);
        Integer len = test.size();
        Integer charTested = len / 2;
        Integer i = 0;
        while (i < charTested) {
            if (!cc.equalChars(test.get(i), test.get(len - i - 1))) {
                return false;
            }
            i = i + 1;
        }
        return true;
    }
}
