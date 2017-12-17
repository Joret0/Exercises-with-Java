package services;

import services.interfaces.NotificationService;

public class OnlineStoreOrder {

    private NotificationService emailNotification;
    private NotificationService smsNotification;

    public OnlineStoreOrder(NotificationService emailNotification, NotificationService smsNotification) {
        this.emailNotification = emailNotification;
        this.smsNotification = smsNotification;
    }

    public void process() {
        if (this.smsNotification.isActive()) {
            this.smsNotification.sendNotification();
        }

        if (this.emailNotification.isActive()) {
            this.smsNotification.sendNotification();
        }
    }
}
