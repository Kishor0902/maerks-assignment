package com.maersk.containerbookingservice.controller;

import com.maersk.containerbookingservice.bean.BookingContainerBean;
import com.maersk.containerbookingservice.bean.BookingRefIdBean;
import com.maersk.containerbookingservice.bean.ContainerInfo;
import com.maersk.containerbookingservice.bean.ContainerSizeSpace;
import com.maersk.containerbookingservice.repository.ContainerBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class BookingController {

    @Autowired
    private ContainerBookingService containerBookingService;
    @Autowired
    private ContainerBookingRepository repository;

    @GetMapping("api/bookings/checkAvailable/{requiredContainerSize}")
    public ContainerSizeSpace checkRequiredContainerSpace(@PathVariable Integer requiredContainerSize){
        return containerBookingService.checkContainerAvailableSize(requiredContainerSize);
    }

    @PostMapping("api/bookings")
    public ResponseEntity<ContainerSizeSpace> ContainerValidation(@Valid @RequestBody ContainerInfo containerInfo){
        ContainerInfo containerObject=new ContainerInfo();
        Map<String, Integer> uriVariables = new HashMap<>();
        uriVariables.put("requiredContainerSize", containerInfo.getContainerSize());
        ResponseEntity<ContainerSizeSpace> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8080/api/bookings/checkAvailable/{requiredContainerSize}", ContainerSizeSpace.class,
                uriVariables);
                containerObject.setContainerSize(containerInfo.getContainerSize());
                containerObject.setContainerType(containerInfo.getContainerType().getName());
                containerObject.setOrigin(containerInfo.getOrigin());
                containerObject.setDestination(containerInfo.getDestination());
                containerObject.setQuantity(containerInfo.getQuantity());
        return responseEntity;
    }

    @PostMapping("api/bookings/save")
    public BookingRefIdBean bookContainer(@Valid @RequestBody BookingContainerBean containerBean){
        BookingRefIdBean bookRef=new BookingRefIdBean();
        containerBean.setTimestamp(LocalDateTime.now());
        containerBean.setId(UUID.randomUUID());
         repository.save(containerBean);
        bookRef.setBookingRefId(containerBean.getId());
        return bookRef;
    }
    @GetMapping("api/bookings")
    public List<BookingContainerBean> getAllBookings(){
        return  repository.findAll();
    }
}
