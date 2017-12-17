package recharge.models;

import recharge.interfaces.Rechargeable;

public class RechargeStation {

    public void recharge(Rechargeable rechargeable) {
        rechargeable.recharge();
    }
}
