package com.maersk.containerbookingservice.bean;

public enum ContainerTypeEnum {

    DRY, REEFER;

    public ContainerTypeEnum getName() {
        return ContainerTypeEnum.valueOf(this.name());
    }
}
