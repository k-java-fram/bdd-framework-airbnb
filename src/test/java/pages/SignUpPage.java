package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id ="username")
    private WebElement username;

    @FindBy(id ="firstName")
    private WebElement firstName;

    @FindBy(id ="lastName")
    private WebElement lastName;

    @FindBy(id ="email")
    private WebElement email;

    @FindBy(id ="email2")
    private WebElement email2;

    @FindBy(id ="password")
    private WebElement password;

    @FindBy(id ="password2")
    private WebElement password2;

    @FindBy(name ="registerButton")
    private WebElement registerButton;

    public void signUpWithRandomData(){
        Faker faker = new Faker();
        username.sendKeys(faker.name().username());
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        this.email.sendKeys(email);
        email2.sendKeys(email);
        String password = faker.internet().password();
        this.password.sendKeys(password);
        password2.sendKeys(password);
        registerButton.click();
    }

    public void signUp(String user, String f, String l, String em, String pass ){

        username.sendKeys(user);
        firstName.sendKeys(f);
        lastName.sendKeys(l);
        this.email.sendKeys(em);
        email2.sendKeys(em);
        this.password.sendKeys(pass);
        password2.sendKeys(pass);
        registerButton.click();
    }



}