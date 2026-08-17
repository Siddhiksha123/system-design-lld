package linkedin.service;

import linkedin.entity.Notification;

public class PushNotification implements NotificationStrategy {

    @Override
    public void sendNotification(Notification notification) {
        System.out.println(notification+"This is from Push Noti");
    }
    
}
