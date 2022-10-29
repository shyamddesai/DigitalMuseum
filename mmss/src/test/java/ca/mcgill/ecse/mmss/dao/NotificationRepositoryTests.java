package ca.mcgill.ecse.mmss.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ca.mcgill.ecse.mmss.model.Communication;
import ca.mcgill.ecse.mmss.model.Notification;

@ExtendWith(SpringExtension.class)
@SpringBootTest

public class NotificationRepositoryTests {
  
  // repository we are testing
  @Autowired
  private NotificationRepository notificationRepository; 
  
  // communication repository
  @Autowired
  private CommunicationRepository communicationRepository;
  
  @AfterEach
  public void clearDatabase() {
	  
	  // empty notification repository
	  notificationRepository.deleteAll(); 
	      
	  // empty communication repository
	  communicationRepository.deleteAll();     
  }

  @Test 
  public void testPersistAndLoadManager() { 
    
	// create communication that holds notification
	Communication communication = new Communication();
	
	// create Notification to be added
	Notification notification = new Notification();
	String message = "Taco Tuesday is around the corner!";
	notification.setMessage(message);	
	Date date = Date.valueOf("2022-10-28");
	notification.setDate(date);
	notification.setSentNotification(communication);
	
	// save the notification and communication
	communicationRepository.save(communication);
	notificationRepository.save(notification);

    // get notification id
	int notificationId = notification.getNotificationId();
    
	// set notification to null
	notification = null;
	
    // get the notification from the database using the notification ID
    notification = notificationRepository.findNotificationByNotificationId(notificationId); 
    
    // make sure that notification and its communication are not null
    assertNotNull(notification);
    assertNotNull(notification.getSentNotification());
    
    // check the primary keys and foreign key constraints of the notification class
    assertEquals(notificationId, notification.getNotificationId());
    assertEquals(communication.getCommunicationId(), notification.getSentNotification().getCommunicationId());
    
    // check an attribute is stored properly
    assertEquals(message, notification.getMessage()); 
  }
}