package com.lpu.TestMaven;

public class UserNotify {
	private NotificationService notificationService;
	
	public UserNotify(NotificationService noitificationService) {
		this.notificationService = noitificationService;
	}
	public void registerUser(String username) {
		notificationService.sendNotification("Welcome " + username);
	}
}
