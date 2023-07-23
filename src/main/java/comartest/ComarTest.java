package comartest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComarTest {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Navigate to the URL
            driver.get("https://www.comar.tn/");

            // Step 2: Click on the "Actualités" link
            driver.findElement(By.linkText("Actualités")).click();

            // Step 3: Verify the existence of "ACTUALITÉS" text on the page
        	WebElement actualitesText = driver.findElement(By.xpath("//*[@id=\"edit-searchmeta\"]"));
            if (actualitesText.isDisplayed()) {
                System.out.println("ACTUALITÉS page is opened.");
            } else {
                System.out.println("ACTUALITÉS page is NOT opened.");
            }

            // Step 4: Enter "COMAR Assurances partenaire" in the search form and submit the search
            WebElement searchBox = driver.findElement(By.name("searchMeta"));
            searchBox.sendKeys("COMAR");
            searchBox.submit();

            // Step 5: Verify the appearance of "COMAR Assurances partenaire du Semi-Marathon Ulysse Djerba" text
            WebElement searchResultText = driver.findElement(By.xpath("//*[contains(text(), 'COMAR Assurances partenaire du Semi-Marathon Ulysse Djerba')]"));
            if (searchResultText.isDisplayed()) {
                System.out.println("Search result found.");
            } else {
                System.out.println("Search result NOT found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the browser
            driver.quit();
        }
    }
}
