package org.suleiman.DataJpaWithVertx.Utility;

public enum Device {
    LAPTOP("Laptop"),
    SERVER("Server"),
    PHONE("Phone"),
    ELECTRICAL_TOOLS("Electrical_tools");

    private String deviceType;
    private Device(String device) {
        this.deviceType = device;
    }

    @Override
    public String toString() {
        return deviceType;
    }
}
