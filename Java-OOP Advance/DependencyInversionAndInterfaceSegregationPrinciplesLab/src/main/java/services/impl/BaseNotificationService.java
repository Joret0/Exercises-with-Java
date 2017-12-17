package services.impl;

import services.interfaces.NotificationService;

public abstract class BaseNotificationService implements NotificationService{

    protected boolean isActive;

    public BaseNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public void sendNotification() {

    }
}
