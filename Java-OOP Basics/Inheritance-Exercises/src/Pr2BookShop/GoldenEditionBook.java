package Pr2BookShop;

class GoldenEditionBook extends Book{

    GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    protected double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }
}
