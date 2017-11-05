package com.socialnetwork.tests;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.socialnetwork.App;
import com.socialnetwork.model.entity.StatusUpdate;
import com.socialnetwork.model.repository.StatusUpdateDao;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
@Transactional
public class StatusTest {

	@Autowired
	private StatusUpdateDao statusUpdateDao;

	@Test
	public void testSave() {
		StatusUpdate status = new StatusUpdate("This is a test status update");
		statusUpdateDao.save(status);
		StatusUpdate retrieved = statusUpdateDao.findOne(status.getId());
		assertNotNull("Non-null ID", retrieved.getId());
		assertEquals("Matcing status update", status, retrieved);
	}
	
	@Test
	public void testFindLatest(){
		Calendar calendar = Calendar.getInstance();
		StatusUpdate lastStatusUpdate = null;
		for(int i = 1;i<10;i++){
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			StatusUpdate status = new StatusUpdate("Status"+i,calendar.getTime());
			statusUpdateDao.save(status);
			lastStatusUpdate = status;
		}
		
		StatusUpdate retrieved = statusUpdateDao.findFirstByOrderByAddedDesc();
		assertNotNull("Non-null last status update", retrieved);
		assertEquals("Matcing last status update", lastStatusUpdate, retrieved);
	}
	
	
	
}
