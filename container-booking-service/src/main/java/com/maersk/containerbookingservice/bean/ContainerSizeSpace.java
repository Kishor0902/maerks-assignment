package com.maersk.containerbookingservice.bean;

public class ContainerSizeSpace {

    private Integer availableSpace;
    private String available;

    public ContainerSizeSpace(){}

    public ContainerSizeSpace(Integer availableSpace, String available) {
        this.availableSpace = availableSpace;
        this.available = available;
    }

    public Integer getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(Integer availableSpace) {
        this.availableSpace = availableSpace;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
