package services;

import services.impl.BaseNotificationService;

public class SmsNotificationService extends BaseNotificationService{

    private static final boolean IS_ACTIVE_DEFAULT = false;

    public SmsNotificationService() {
        super(IS_ACTIVE_DEFAULT);
    }

    @Override
    public boolean isActive() {
        return super.isActive;
    }
}
