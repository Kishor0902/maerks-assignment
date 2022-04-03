package com.maersk.containerbookingservice.bean;

import java.util.UUID;

public class BookingRefIdBean {

    private UUID bookingRefId;

    public BookingRefIdBean() {
    }

    public UUID getBookingRefId() {
        return bookingRefId;
    }

    public void setBookingRefId(UUID bookingRefId) {
        this.bookingRefId = bookingRefId;
    }
}
