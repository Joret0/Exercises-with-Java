package services;

import services.impl.BaseNotificationService;

public class EmailNotificationService extends BaseNotificationService{

    public EmailNotificationService(boolean isActive) {
        super(isActive);
    }

    public void sendNotification() {

    }

    @Override
    public boolean isActive() {
        return super.isActive;
    }
}
