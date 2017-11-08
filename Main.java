import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kozlov_sv on 08.11.2017
 *
 * This program shows how to use Stream API to operating with collections and even classes
 * In first instance we merely find max value , min value, and max value, bur less than 50
 * In second instance we create a collection of cars, convert it to Map, using country values as keys, then we find the most powerful ones from each country.
 *
 */
public class Main {

    public static void main(String[] args) {
/**
 * Instance one
 */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(120);
        list.add(50);
        list.add(1);
        list.add(500);

        Optional<Integer> maxValue = list.stream().max(Integer::compareTo);
        Optional<Integer> minValue = list.stream().min(Integer::compareTo);
        Optional<Integer> filteredMax = list.stream().filter((p -> p <= 50)).max(Integer::compareTo);

        System.out.println("Max value: " + maxValue);
        System.out.println("Min value: " + minValue);
        System.out.println("Filtered Max: " + filteredMax);
        System.out.println("");

        /***
         * Instance two
         */
        List<Auto> cars = new ArrayList<>();

        cars.add(new Auto(125, "Ford Focus",           "USA", true, false));
        cars.add(new Auto(210, "Chevrolet Camaro",     "USA", true, false));
        cars.add(new Auto(115, "Seat Ibiza",           "Spain", true, false));
        cars.add(new Auto(250, "Alfa Romeo 159",       "Italy", false, true));
        cars.add(new Auto(550, "Lamborghini Gallardo", "Italy", false,true));
        cars.add(new Auto(220, "Fiat Punto Abarth",    "Italy", false,true));
        cars.add(new Auto(180, "Renault Megane RS",    "France", false, true));
        cars.add(new Auto(210, "Vokswagen Scirocco",   "Germany", false, true));
        cars.add(new Auto(330, "Porche Cayenne",       "Germany", false, true));

        Map<String, List<Auto>> carsMap = cars.stream().collect(Collectors.groupingBy(Auto::getCountry));
        List<Auto> result = new ArrayList<>();
        List<Auto> convert = new ArrayList<>();
        for(String country : carsMap.keySet()) {

            List<Auto> test = carsMap.get(country);
            convert = test.stream().map(auto -> new Auto(auto.gethP(),
                    auto.getName(),
                    auto.getCountry(),
                    auto.isSport,
                    auto.isAwd
            )).collect(Collectors.toList());

            convert.sort(Comparator.comparingInt(Auto::gethP).reversed());
            result.add(convert.get(0));
        }

        for(Auto auto: result){

       System.out.println("The fastest car from " + auto.getCountry()+" : "
                                                  + auto.getName() +" "
                                                  + auto.gethP() +" hP.");

        }
    }

}
