public class Television {
    public static char[][] feld = new char[9][40];
    public static String text = "Apfelmarmelade";

    public static void main(String[] args){
        getFeld();
        insertText();

        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                System.out.print(feld[i][j]);
            }
            System.out.println();
        }
    }

    public static void getFeld(){
        for(int i=0;i<feld.length;i++){
            for(int j=0;j<feld[i].length;j++){
                if (i == 0 || i == feld.length - 1){
                    feld[i][j] = '#';
                }
                else if (j == 0 || j == feld[i].length - 1){
                    feld[i][j] = '#';
                }
                else{
                    feld[i][j] = ' ';
                }
            }
        }
    }

    public static void insertText(){
        for (int i = 0; i < text.length(); i++) {
            feld[(feld.length / 2)][((feld[0].length - text.length()) / 2) + i] = text.charAt(i);
        }
    }
}
