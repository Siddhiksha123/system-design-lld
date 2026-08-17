package linkedin.service;

import linkedin.entity.Notification;

public interface NotificationStrategy {
    void sendNotification(Notification notification);
}
