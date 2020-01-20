package PayHost;

public class PayHost {
    private String url = "";
    private String nameSpace = "";

    public PayHost(String url, String nameSpace) {
        this.url = url;
        this.nameSpace = nameSpace;
    }

    public String getUrl() {
        return this.url;
    }

    public String getNameSpace() {
        return this.nameSpace;
    }
}
