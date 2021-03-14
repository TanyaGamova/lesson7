import java.util.Arrays;

public enum Country {
    POLAND( "Польша", false ),
    GEORGIA( "Грузия", true ),
    RUSSIA( "Россия", true ),
    SOMALI( "Сомали", true ),
    PERU( "Перу", false );

    private final String ruName;
    private final boolean isOpen;

    public boolean getIsOpen() {
        return isOpen;
    }

    Country( String ruName, boolean isOpen ) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return String.format( "%s ( %s )", name(), ruName );
    }

    public static Country getByRuName( String ruName ) throws NoSuchCountryException {
        Country res = Arrays.stream(values()).filter(country -> ruName.equals(country.ruName)).findAny().orElse(null);
        if ( res == null )
            throw new NoSuchCountryException();

        return res;
    }
}