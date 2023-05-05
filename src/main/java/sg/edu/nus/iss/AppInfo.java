package sg.edu.nus.iss;

public class AppInfo {
    private String appName;
    private String category;
    private Float rating;

    public AppInfo(String appName, String category, Float rating) {
        this.appName = appName;
        this.category = category;
        this.rating = rating;
    }

    public String getAppName() {
        return appName;
    }

    public String getCategory() {
        return category;
    }

    public Float getRating() {
        return rating;
    }

    public String toString() {
        return "[AppName: " + this.appName + ", Category: " + this.category + ", Rating: " + this.rating + "]"; 
    }
}
