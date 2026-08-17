package linkedin;

import linkedin.constants.NotificationType;
import linkedin.entity.Notification;
import linkedin.service.EmailNotification;
import linkedin.service.NotificationContext;
import linkedin.service.NotificationStrategy;
import linkedin.service.PushNotification;

public class Main {

    public static void main(String[] args) throws Exception {
        NotificationStrategy notification=new EmailNotification();
        NotificationContext notificationContext=new NotificationContext();

        notificationContext.setNotificationStrategy(notification);

        Notification notification1=new Notification("Hello There","Hello There", NotificationType.CONNECTION_REQUEST);
        notificationContext.sendNotification(notification1);

        notification=new PushNotification();
        notificationContext.setNotificationStrategy(notification);

        notificationContext.sendNotification(notification1);
    }
    
}
