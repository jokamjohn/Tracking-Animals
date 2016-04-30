package johnkagga.me.alex_farm.model;

public class TrackData {

    public String Area;

    public String Location;

    public long CapturedTag;

    public TrackData() {
    }

    public TrackData(String area, long capturedTag, String location) {
        Area = area;
        CapturedTag = capturedTag;
        Location = location;
    }

    public String getArea() {
        return Area;
    }

    public long getCapturedTag() {
        return CapturedTag;
    }

    public String getLocation() {
        return Location;
    }
}
