//use Java 8 Streams to filter country names that start with the letter ‘A’ quite easily. Here’s a simple example to get you started:

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountryFilter {
    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Australia", "Brazil", "Argentina", "Canada", "Austria", "India");

        List<String> filteredCountries = countries.stream()
                .filter(country -> country.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(filteredCountries);
    }
}

/* output
[Australia, Argentina, Austria] */
