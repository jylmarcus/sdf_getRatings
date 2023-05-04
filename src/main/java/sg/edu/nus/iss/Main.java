package sg.edu.nus.iss;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        FileHandler fh = new FileHandler();
        System.out.println(fh.getCategorySorted().size());
        System.out.println(fh.getCategorySorted().keySet());
        System.out.println(fh.getCategorySorted().get("1.9"));
        System.out.println(fh.getHighest("EVENTS").toString());
        System.out.println(fh.getLowest("FOOD_AND_DRINK").toString());
        System.out.printf("%.1f%n",fh.getAverage("PERSONALIZATION"));
    }
}
