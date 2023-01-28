package driver;

public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    SAFARI("safari"),
    EDGE("edge");

    private String name;

    BrowserType(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
