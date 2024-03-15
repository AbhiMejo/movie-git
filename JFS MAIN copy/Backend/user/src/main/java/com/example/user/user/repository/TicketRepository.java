package com.example.user.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.user.user.entity.TicketDetails;
@Repository
public interface TicketRepository extends CrudRepository<TicketDetails, Long>{

}
