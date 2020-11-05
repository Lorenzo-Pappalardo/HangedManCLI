package src;

public class HiddenWord {
    public String word;
    public int[] triggers;

    HiddenWord(String word) {
        this.word = word;
        triggers = new int[word.length()];
        for (int i = 0; i < word.length(); i++)
            triggers[i] = 0;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < word.length(); i++) {
            if (triggers[i] == 0)
                res += "-";
            else
                res += word.charAt(i);
        }
        return res;
    }

    public boolean cleared(){
        for(int i=0;i<triggers.length;i++){
            if(triggers[i]==0) return false;
        }
        return true;
    }

    public int checkLetter(char letter){
        int res=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==letter) {
                triggers[i]=1;
                res=1;
            }
        }
        return res;
    }
}
