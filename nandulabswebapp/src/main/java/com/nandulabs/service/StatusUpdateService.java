package com.nandulabs.service;

import com.nandulabs.model.StatusUpdate;

public interface StatusUpdateService {

	void save(StatusUpdate statusUpdate);

	StatusUpdate getLatest();

}
