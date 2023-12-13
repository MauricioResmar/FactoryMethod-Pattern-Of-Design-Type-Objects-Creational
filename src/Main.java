
public class Main {

    public static void main(String[] args) {
        PriceFactory priceFactory = new PriceFactory("espain");
        System.out.println(priceFactory.getPrecio());

        PriceFactory priceFactory2 = new PriceFactory("usa");
        System.out.println(priceFactory.getPrecio());

        PriceFactory priceFactory3 = new PriceFactory("uk");
        System.out.println(priceFactory.getPrecio());

    }
}