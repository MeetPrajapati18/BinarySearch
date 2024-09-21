public class countVowels {
    public static void main(String[] args) {

    }

    static int countAllVowels(String input){
        int count = 0;

        for (int i = 0; i < input.length(); i++){
            char c = Character.toLowerCase(input.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                count++;
            }
        }
        return count;
    }
}
