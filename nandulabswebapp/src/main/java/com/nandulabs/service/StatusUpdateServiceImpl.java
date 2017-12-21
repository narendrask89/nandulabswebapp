package com.nandulabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nandulabs.dao.StatusUpdateDao;
import com.nandulabs.model.StatusUpdate;

@Service
public class StatusUpdateServiceImpl implements StatusUpdateService {

	@Autowired
	private StatusUpdateDao statusUpdateDao;

	public void save(StatusUpdate statusUpdate) {
		statusUpdateDao.save(statusUpdate);
	}

	public StatusUpdate getLatest() {
		return statusUpdateDao.findFirstByOrderByAddedDesc();
	}
}
