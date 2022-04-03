package com.maersk.containerbookingservice.controller;

import com.maersk.containerbookingservice.bean.ContainerSizeSpace;
import org.springframework.stereotype.Component;

@Component
public class ContainerBookingService {
        private  static final Integer availableSize=40;
    public ContainerSizeSpace checkContainerAvailableSize(Integer custRequiredSize){

        Integer calculatedSpace=availableSize-custRequiredSize;
        ContainerSizeSpace containerSizeSpace=new ContainerSizeSpace();
        if(calculatedSpace!=null && calculatedSpace>0){
            containerSizeSpace.setAvailableSpace(calculatedSpace);
            containerSizeSpace.setAvailable("true");
        }else{
            containerSizeSpace.setAvailableSpace(0);
            containerSizeSpace.setAvailable("false");
        }
        return containerSizeSpace;
    }
}
