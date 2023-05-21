package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    //We can start locating web elements using @FindBy annotation

    @FindBy(name = "q")
    public WebElement searchBox;


    @FindBy(xpath = "(//div[@class='QS5gu sy4vM'])[2]")
    public WebElement acceptButton;


}
