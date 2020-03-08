package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.*;
import java.util.List;


public class MainPage extends BasePage {

    @FindBy(xpath = "/html/body/div[3]/header/div/navbar/div[2]/ul/li/a")
    List<WebElement> leftMenu;



    public static void usingBufferedWritter(String data) throws IOException      {

        BufferedWriter writer = new BufferedWriter(
                new FileWriter("/home/junozay/os.txt", true)
        );
        writer.newLine();
        writer.write(data);
        writer.close();
    }



    public MainPage(WebDriver webDriver)  {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }




    public void openLeft() {
        for (int i = 0; i < leftMenu.size(); i++) {
            WebElement eachMenuPoint = leftMenu.get(i);
            Actions newTab = new Actions(webDriver);
            newTab.keyDown(Keys.CONTROL).click(eachMenuPoint).keyUp(Keys.CONTROL).build().perform();

        }

        try {
            for(String winHandle : webDriver.getWindowHandles()){
                webDriver.switchTo().window(winHandle);
                String act = webDriver.getCurrentUrl();
                usingBufferedWritter(act);

            }

        }catch(Exception e){
            System.out.println("fail");
        }


    }
}






