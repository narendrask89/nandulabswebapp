package com.nandulabs.dao;

import org.springframework.data.repository.CrudRepository;

import com.nandulabs.model.StatusUpdate;

public interface StatusUpdateDao extends CrudRepository<StatusUpdate, Long>{

	StatusUpdate findFirstByOrderByAddedDesc();
}
