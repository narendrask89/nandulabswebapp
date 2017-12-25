package com.nandulabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nandulabs.dao.StatusUpdateDao;
import com.nandulabs.model.StatusUpdate;

@Service
public class StatusUpdateServiceImpl implements StatusUpdateService {

	private static final int PAGE_SIZE = 4;

	@Autowired
	private StatusUpdateDao statusUpdateDao;

	public void save(StatusUpdate statusUpdate) {
		statusUpdateDao.save(statusUpdate);
	}

	public StatusUpdate getLatest() {
		return statusUpdateDao.findFirstByOrderByAddedDesc();
	}

	@Override
	public Page<StatusUpdate> viewStatus(int pageNumber) {

		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "id");

		return statusUpdateDao.findAll(request);
	}

	@Override
	public void deleteStatus(Long id) {
		this.statusUpdateDao.delete(id);
	}

	@Override
	public StatusUpdate retrieveStatus(Long id) {
		StatusUpdate statusUpdate = this.statusUpdateDao.findOne(id);
		return statusUpdate;
	}
}
