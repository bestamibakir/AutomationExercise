package base;

import net.datafaker.providers.base.*;

public class RandomContactUsData {

    public String name;
    public String email;
    public String subject;
    public String message;
    public String filePath;

    public RandomContactUsData() {
        Name name = new BaseFaker().name();
        Lorem lorem = new BaseFaker().lorem();

        this.name = name.fullName();
        this.email = name.firstName().toLowerCase() + "." + name.lastName().toLowerCase() + "@mail.com";
        this.subject = lorem.sentence(4);
        this.message = lorem.paragraph(2);
        this.filePath = System.getProperty("user.dir") + "/src/main/resources/contact-us.txt";
    }
}