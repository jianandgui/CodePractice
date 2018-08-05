package sort;

public class EqualsArr {
    public static void main(String[] args) {
        System.out.println(equals("rac","car"));
    }

    public static boolean equals(String s1, String s2) {
        char[] chars = new char[26];

        int length = s1.length();
        for (int i=0;i<length;i++) {
            chars[s1.charAt(i) - 'a']++;
        }
        for (int j=0;j<length;j++) {
            chars[s2.charAt(j) - 'a']--;
        }
        for (int k=0;k<26;k++) {
            if (chars[k] != 0) {
                return false;
            }
        }
        return true;
    }
}
