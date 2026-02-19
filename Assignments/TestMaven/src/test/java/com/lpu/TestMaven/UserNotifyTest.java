package com.lpu.TestMaven;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserNotifyTest {
	
	
	@Mock
	NotificationService notificationService;
	
	@InjectMocks
	UserNotify userNotificationService;
	
	@Test
	void shouldSendWelcomeNotification() {
		//stub void method(doNothing is default for void methods, but we can explicitly specify it for clarity) 
		doNothing().when(notificationService).sendNotification(anyString());
		
		//call method under test
		userNotificationService.registerUser("Sumit");
		
		//verify that the notification service was called with the expected message
		verify(notificationService).sendNotification("Welcome Sumit");
	}
	
}
