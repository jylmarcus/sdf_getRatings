package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    private Map<String, ArrayList<AppInfo>> categorySorted = new HashMap<String, ArrayList<AppInfo>>();

    public FileHandler() throws IOException {
        File f = new File("googleplaystore.csv");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        
        while((line=br.readLine()) != null) {

            String[] rawInfo = line.split(",");
            AppInfo appinfo = new AppInfo(rawInfo[0], rawInfo[1], Float.parseFloat(rawInfo[2]));

            //sort into hashmap by categories
            categorySorted.putIfAbsent(rawInfo[1], new ArrayList<AppInfo>());
            ArrayList<AppInfo> tempList = categorySorted.get(rawInfo[1]);
            tempList.add(appinfo);
            categorySorted.put(rawInfo[1], tempList);
        } 

        br.close();
        fr.close();
    }

    public Map<String, ArrayList<AppInfo>> getCategorySorted() {
        return categorySorted;
    }

    public void setCategorySorted(Map<String, ArrayList<AppInfo>> categorySorted) {
        this.categorySorted = categorySorted;
    }

    public AppInfo getHighest(String category) {
        ArrayList<AppInfo> temp = categorySorted.get(category);
        AppInfo highestRated = new AppInfo(null, null, 0f);
        for(AppInfo app : temp) {
            if(app.getRating() > highestRated.getRating()) {
                highestRated = app;
            }
        }

        return highestRated;
    }

    public AppInfo getLowest(String category) {
        ArrayList<AppInfo> temp = categorySorted.get(category);
        AppInfo lowestRated = new AppInfo(null, null, 10f);
        for(AppInfo app : temp) {
            if(app.getRating() < lowestRated.getRating()) {
                lowestRated = app;
            }
        }

        return lowestRated;
    }

    public Float getAverage(String category) {
        ArrayList<AppInfo> temp = categorySorted.get(category);
        Float sum = 0f;
        int size = temp.size();
        for(AppInfo app: temp) {
            if(!app.getRating().isNaN()){
                sum += app.getRating();
            } else {
                size -= 1;
            }
        }

        return sum/size;
    }

}
