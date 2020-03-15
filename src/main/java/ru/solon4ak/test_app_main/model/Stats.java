package ru.solon4ak.test_app_main.model;

public class Stats {
    private int deviceCount;
    private int deviceWithErrors;
    private int stableDevices;

    public Stats(int deviceCount, int deviceWithErrors, int stableDevices) {
        this.deviceCount = deviceCount;
        this.deviceWithErrors = deviceWithErrors;
        this.stableDevices = stableDevices;
    }

    public int getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }

    public int getDeviceWithErrors() {
        return deviceWithErrors;
    }

    public void setDeviceWithErrors(int deviceWithErrors) {
        this.deviceWithErrors = deviceWithErrors;
    }

    public int getStableDevices() {
        return stableDevices;
    }

    public void setStableDevices(int stableDevices) {
        this.stableDevices = stableDevices;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "deviceCount=" + deviceCount +
                ", deviceWithErrors=" + deviceWithErrors +
                ", stableDevices=" + stableDevices +
                '}';
    }
}
