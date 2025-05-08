package Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validate_prace {

    public static void main(String[] args) {
    	
    	// Q.  Open  the filpkart  search  the under 100 items   and print the title with price which product  price under in 100

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();

       
        driver.get("https://www.flipkart.com");

       

        WebElement searchbox = driver.findElement(By.xpath("//input[@name='q']"));
        searchbox.sendKeys("under 100 items");

        WebElement searchButton = driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']"));
        searchButton.click();


       
        List<WebElement> allproduct = driver.findElements(By.xpath("//a[@class='wjcEIp']")); // Product title links
        List<WebElement> productprize = driver.findElements(By.xpath("//div[@class='Nx9bqj']")); // Price elements

        System.out.println("Total products found: " + allproduct.size());

         for(int i=0;i<40 && i< allproduct.size() && i< productprize.size();i++) {
        	 
        	 String name=allproduct.get(i).getText();
        	 String pricetext = productprize.get(i).getText().replaceAll("[^0-9]","");
        	 
        	 try {
        		 
        		 int price=Integer.parseInt(pricetext);
        		 if(price<=100) {
        			 System.out.println(name+" = "+price);
        		 }
        	 }catch(NumberFormatException e) {
        		 
        	 }
         }
       
    }
}
