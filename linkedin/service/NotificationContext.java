package linkedin.service;

import linkedin.entity.Notification;

public class NotificationContext {

    private NotificationStrategy notificationStrategy;

    public void setNotificationStrategy(NotificationStrategy notificationStrategy){
        this.notificationStrategy=notificationStrategy;
    }

    public void sendNotification(Notification notification) throws Exception {
        if(notificationStrategy==null)
            throw new Exception("Notification Strategy");
        notificationStrategy.sendNotification(notification);
    }
}
