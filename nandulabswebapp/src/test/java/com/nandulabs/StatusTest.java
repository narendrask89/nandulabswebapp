package com.nandulabs;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nandulabs.dao.StatusUpdateDao;
import com.nandulabs.model.StatusUpdate;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
@WebAppConfiguration
@Transactional
public class StatusTest {

	@Autowired
	private StatusUpdateDao statusUpdateDao;

	@Test
	public void testSave() {
		StatusUpdate status = new StatusUpdate("This is test status");
		status = statusUpdateDao.save(status);
		
		Assert.assertNotNull("Not null date",status.getId());
		
		StatusUpdate retrieveStatus = statusUpdateDao.findOne(status.getId());
		
		Assert.assertEquals("Matching status update", status, retrieveStatus);
		
		StatusUpdate findStatus = statusUpdateDao.findFirstByOrderByAddedDesc();
		
		Assert.assertEquals("Matching status update", status, findStatus);
	}

}
