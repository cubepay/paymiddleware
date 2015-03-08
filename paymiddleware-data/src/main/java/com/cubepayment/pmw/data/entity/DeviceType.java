package com.cubepayment.pmw.data.entity;


public enum DeviceType {

    WEB,
    MOBILE;

    public static DeviceType getDeviceType(String name) {
        for (DeviceType deviceType : DeviceType.values()) {
            if (deviceType.name().equals(name)) {
                return deviceType;
            }
        }
        return null;
    }
}
