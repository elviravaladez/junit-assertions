public class CodeupCrypt {
    public static double version = 1.2; //when initialized a double defaults to 0.0 IF NOT ASSIGNED A VALUE

    public static String hashPassword(String name){
        String hash = "";

        for(char character : name.toCharArray()){
            switch (character){
                case 'a':
                case 'A':
                    hash += 4;
                    break;
                case 'e':
                case 'E':
                    hash += 3;
                    break;
                case 'i':
                case 'I':
                    hash += 1;
                    break;
                case 'o':
                case 'O':
                    hash += 0;
                    break;
                case 'u':
                case 'U':
                    hash += 9;
                    break;
                default:
                    hash += character;
            }
        }
        return hash;
    }

    public static boolean checkPassword(String pass, String hash) {
        return hash.equals(hashPassword(pass));
    }
}
