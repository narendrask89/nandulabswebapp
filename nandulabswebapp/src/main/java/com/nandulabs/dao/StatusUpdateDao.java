package com.nandulabs.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nandulabs.model.StatusUpdate;

public interface StatusUpdateDao extends PagingAndSortingRepository<StatusUpdate, Long>{

	StatusUpdate findFirstByOrderByAddedDesc();
}
