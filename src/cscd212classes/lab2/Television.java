package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television> {
    private String make, model;
    private int screenSize, resolution;
    private boolean smart, fourK;

    public Television(final String make, final String model, final boolean smart,
                      final int screenSize, final int resolution) {
        if (make == null || make.isEmpty() || model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        if (screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        this.fourK = (resolution == 2160);
        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
    }
    public Television(final String model, final boolean smart, final int screenSize,
                      final int resolution, final String make) {
        this(make, model, smart, screenSize, resolution);
    }
    public int getScreenSize() {
        return this.screenSize;
    }
    public int getResolution() {
        return this.resolution;
    }
    public String getMake() {
        return this.make;
    }
    public String getModel() {
        return this.model;
    }
    public String toString() {
        return (this.make + "-" + this.model + ", " + this.screenSize + " inch " + (this.smart ? "smart " : "")
                + "tv with " + (this.fourK ? "4K" : this.resolution) + " resolution");
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
        return this.screenSize == that.screenSize && this.resolution == that.resolution
                && this.smart == that.smart && this.fourK == that.fourK
                && Objects.equals(this.make, that.make) && Objects.equals(this.model, that.model);
    }
    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution
        + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
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
