package com.nandulabs.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nandulabs.model.StatusUpdate;

@Repository
public interface StatusUpdateDao extends PagingAndSortingRepository<StatusUpdate, Long>{

	StatusUpdate findFirstByOrderByAddedDesc();
}
