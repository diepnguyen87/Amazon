package tests;

public class main {
    public static void main(String[] args) {
        StringBuilder max128 = new StringBuilder("max-128-character");
        StringBuilder result = new StringBuilder("");
        int loop = 128/max128.length();
        for (int i = 0; i < loop; i++) {
           result.append(max128);
        }
        int delta = 128 - result.length();
        if(delta != 0){
            String end = max128.substring(0, delta);
            result.append(end);
        }
        System.out.println(result);
    }
}
