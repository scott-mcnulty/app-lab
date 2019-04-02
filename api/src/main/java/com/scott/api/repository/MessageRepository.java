package com.scott.api.repository;

import com.scott.api.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {

    Message findById(String id);
    Page<Message> findAll(Pageable pageable);

//    https://www.baeldung.com/spring-data-jpa-pagination-sorting
}
