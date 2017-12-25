package com.nandulabs.service;

import org.springframework.data.domain.Page;

import com.nandulabs.model.StatusUpdate;

public interface StatusUpdateService {

	void save(StatusUpdate statusUpdate);

	StatusUpdate getLatest();

	Page<StatusUpdate> viewStatus(int pageNumber);

	void deleteStatus(Long id);

	StatusUpdate retrieveStatus(Long id);

}
