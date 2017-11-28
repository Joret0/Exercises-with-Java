package Pr3CoffeeMachine;

public enum Coin {
    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50);

    private int coin;

    Coin(int coin) {
        this.coin = coin;
    }

    public int getCoin() {
        return this.coin;
    }
}
