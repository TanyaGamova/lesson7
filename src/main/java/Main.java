import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for (Country ctr : Country.values())
            System.out.println(ctr.toString());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Country foundCountry = null;

        try {
            foundCountry = Country.valueOf(input);
        } catch (NullPointerException e) {
            System.out.println("Введена невалидная строка");
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
            try {
                foundCountry = Country.getByRuName( input );
            }
            catch (NoSuchCountryException innerEx) {
                System.out.printf( "Страны '%s' не существует.", input );
            }
        }

        if ( foundCountry != null )
        {
            String opened = foundCountry.getIsOpen() ? "открыта" : "закрыта";
            System.out.printf( "Страна [%s] %s для посещения.", foundCountry.toString(), opened );
        }
    }
}