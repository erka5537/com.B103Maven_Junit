package day11;

import com.github.javafaker.Faker;


public class C02_JavaFaker {

    public static void main(String[] args) {
//        1. Faker objesi oluştur
        Faker faker = new Faker();

//        2. Faker objesi ile data oluştur

//        first name datası
        String fName = faker.name().firstName();
        System.out.println(fName);

//        last name datası
        String lName = faker.name().lastName();
        System.out.println(lName);

//        kullanıcı adı
        String username = faker.name().username();
        System.out.println(username);

//        meslek ismi
        System.out.println(faker.name().title());

//        sehir
        System.out.println(faker.address().city());

//        eyalet
        System.out.println(faker.address().state());

//        full address
        System.out.println(faker.address().fullAddress());

//        cep telefon numarası
        System.out.println(faker.phoneNumber().cellPhone());

//        email
        System.out.println(faker.internet().emailAddress());

//        posta kodu
        System.out.println(faker.address().zipCode());

//        rastgele 15 haneli numara
        System.out.println(faker.number().digits(15));

/*
TEST DATA : kullanıcı adı, sifre, tel no, email, sehir, kredi kart no...
Test dataları kimden alınır?
1. BA-Business analyst (Acceptance Criteria'ları yazar)
2. Test Lead
3. Manuel Tester
4. Tech Lead & Team Lead & Dev Lead
5. Developer
6. Database
7. API call lar
8. Documantasyonlar. Örneğin, API swagger documanı.
9. Java Faker da fake data almak için kullanıyoruz
NERDEN GELMEZ : end user -kullanicidan, scrum master,
*/

    }
}
