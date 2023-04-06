package cscd212classes.lab2;

import java.util.*;

public class Television implements Comparable<Television> {
    private String make, model;
    private int screenSize, resolution;
    private boolean smart, fourK;

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {
        if (make == null || make.isEmpty() || model == null || model.isEmpty() ||screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        this.fourK = (resolution == 2160);
        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
    }
    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        new Television(make, model, smart, screenSize, resolution);
    }
    public int getScreenSize() {
        return screenSize;
    }
    public int getResolution() {
        return resolution;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public String toString() {
        return (make+"-"+model+", "+screenSize+" inch "+(smart?"smart ":"")+"tv with "+(fourK?"4K":resolution)+" resolution");
    }
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Television that = (Television) o;
        return screenSize == that.screenSize && resolution == that.resolution && smart == that.smart && fourK == that.fourK && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }
    @Override
    public int hashCode() {
        return make.hashCode() + model.hashCode() + resolution + Boolean.hashCode(smart) + Boolean.hashCode(fourK);
    }
    @Override
    public int compareTo(final Television another) {
        if (another == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }
        int x = this.make.compareTo(another.make);
        if (x == 0) {
            x = this.model.compareTo(another.model);
        }
        if (x == 0) {
            x = this.screenSize - another.screenSize;
        }
        return x;
    }
}
