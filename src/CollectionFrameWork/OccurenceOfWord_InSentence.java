package CollectionFrameWork;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class OccurenceOfWord_InSentence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Sentence :-  ");
        String sentence = input.nextLine();
        String []word =sentence.split("[,.?;'{}()~`!\n \t\r]");
        Map<String,Integer> map = new TreeMap<String, Integer>();
        for (int i = 0; i < word.length; i++) {
            String key = word[i].toLowerCase();
            if (word[i].length()>1){
                if (map.get(key) == null){
                    map.put(key,1);
                }
                else {
                    int value = map.get(key).intValue();
                    value++;
                    map.put(key,value);
                }
            }
        }

        Set <Map.Entry<String,Integer>> entrySet = map.entrySet();

        for (Map.Entry<String,Integer> entry :entrySet)
            System.out.println("' "+entry.getKey()+" ' repeated  "+ entry.getValue()+"  times.");
    }
}
