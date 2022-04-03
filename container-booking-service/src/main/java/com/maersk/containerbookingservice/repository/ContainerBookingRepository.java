package com.maersk.containerbookingservice.repository;

import com.maersk.containerbookingservice.bean.BookingContainerBean;
import com.maersk.containerbookingservice.bean.ContainerInfo;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContainerBookingRepository extends CassandraRepository<BookingContainerBean, UUID> {

}
