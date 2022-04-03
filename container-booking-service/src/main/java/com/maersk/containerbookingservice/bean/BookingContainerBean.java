package com.maersk.containerbookingservice.bean;

import com.maersk.containerbookingservice.validator.OneOf;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;
@Table("bookings")
public class BookingContainerBean {

    @PrimaryKey
    private UUID id;
    @OneOf({20,40})
    private Integer containerSize;
    private ContainerTypeEnum containerType;
    @Size(min = 5,max = 20 ,message="origin should have minimum 5 and maximum 20")
    private String origin;
    @Size(min = 5,max = 20 ,message="destination should have minimum 5 and maximum 20")
    private String destination;
    @Max(100)
    @Range(min= 1, max= 100)
    private Integer quantity;
    private LocalDateTime timestamp=LocalDateTime.now();
    public BookingContainerBean() {
    }

    public BookingContainerBean(Integer containerSize, ContainerTypeEnum containerType, String origin, String destination, Integer quantity) {
        this.containerSize = containerSize;
        this.containerType = containerType;
        this.origin = origin;
        this.destination = destination;
        this.quantity = quantity;
    }

    public Integer getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(Integer containerSize) {
        this.containerSize = containerSize;
    }

    public ContainerTypeEnum getContainerType() {
        return containerType;
    }

    public void setContainerType(ContainerTypeEnum containerType) {
        this.containerType = containerType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
