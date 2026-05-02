package base;

import net.datafaker.providers.base.*;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class RandomPersonForRegistration {

    public String gender;
    public String firstName;
    public String lastName;
    public String fullName;
    public String email;
    public String password;
    public String companyName;
    public String phoneNumber;
    public String fullAddress;
    public String address2;
    public String city;
    public String state;
    public String zipcode;
    public String countryName;
    public LocalDate birthDate;
    public String birthDay;
    public String birthMonth;
    public String birthYear;

    private static final Map<String, Locale> COUNTRY_LOCALES = Map.of(
            "India",         Locale.of("en", "IN"),
            "United States", Locale.of("en", "US"),
            "Canada",        Locale.of("en", "CA"),
            "Australia",     Locale.of("en", "AU"),
            "New Zealand",   Locale.of("en", "NZ"),
            "Singapore",     Locale.of("en", "SG")
    );
    List<String> countries = new ArrayList<>(COUNTRY_LOCALES.keySet());

    public RandomPersonForRegistration() {

        Name name = new BaseFaker().name();
        PhoneNumber phone = new BaseFaker().phoneNumber();
        TimeAndDate dateOfBirth = new BaseFaker().timeAndDate();
        Gender gender = new BaseFaker().gender();
        Credentials credentials = new BaseFaker().credentials();
        Company company = new BaseFaker().company();

        this.gender = gender.binaryTypes();
        this.firstName = name.firstName().toLowerCase();
        this.lastName =  name.lastName().toLowerCase();
        this.fullName = firstName + " " + lastName;
        this.email = firstName + "." + lastName + "@mail.com";
        this.password = credentials.password(8,16,true,true,true);
        this.phoneNumber = phone.phoneNumberNational();
        randomCountrySelector();
        this.companyName = company.name();
        this.birthDate = dateOfBirth.birthday(18,65);
        randomDateOfBirthSelector();
    }

    private void randomCountrySelector(){
        this.countryName = countries.get(new Random().nextInt(countries.size()));
        Locale selectedLocale = COUNTRY_LOCALES.get(this.countryName);
        BaseFaker localeFaker = new BaseFaker(selectedLocale);
        Address localAddress = localeFaker.address();
        this.fullAddress = localAddress.fullAddress();
        this.address2 = localAddress.secondaryAddress();
        this.state = localAddress.state();
        this.city = localAddress.city();
        this.zipcode = localAddress.zipCode();
    }

    private void randomDateOfBirthSelector(){
        this.birthDay = String.valueOf(birthDate.getDayOfMonth());
        this.birthMonth = birthDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        this.birthYear = String.valueOf(birthDate.getYear());
    }
}
