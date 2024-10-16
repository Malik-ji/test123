package com.blogpost.blog.config;


public class TrackDetails {

	
	public  static String setNewTicketTrackingDetails(String time,String status,String AssignedBy,String AssignTo,String  groupName) {
		return "TimeStamp:"+time+"<br> STATUS:"+status+" Assigned By:"+AssignedBy+"AssignTo:"+AssignTo+" Group Name :"+groupName;
	}
}
