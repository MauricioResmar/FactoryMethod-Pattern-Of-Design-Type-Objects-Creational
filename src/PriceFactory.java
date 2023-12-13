public class PriceFactory {

    Price price;

    // Private Constructor to avoid direct instantiation
    private PriceFactory() {}

    // Public Constructor with parameters: Modularization by specialized creator according to the parameter

    public PriceFactory (String country) {

        if (country.equalsIgnoreCase("Espain")) {
            System.out.println("Spain, price in Eur");
            price = new PriceEur();
        } else if (country.equalsIgnoreCase("UK")) {
            System.out.println("We are at Uk");
            price = new PriceGbp();
        } else {
            System.out.println("Other Country, price in Usd");
            price = new PriceUsd();
        }
    }

    public double getPrecio() {
        return price.getPrice();
    }
}
