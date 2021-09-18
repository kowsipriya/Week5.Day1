package Week5.day1;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.testng.annotations.Test;


	public class CreateIncident  extends CommonClass{
		
		@Test
		public void runCreateIncident() throws InterruptedException {
			System.out.println("Create Incident Method");
			System.out.println("Title of current WebPage : "+driver.getTitle());
			driver.findElement(By.id("sysverb_new")).click();
			
			//To Create Incident
			String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
			driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("sys");
			Thread.sleep(1000);
			driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys(Keys.TAB);
			driver.findElement(By.id("incident.short_description")).sendKeys("Incident creation Selenium");
			driver.findElement(By.id("incident.comments")).sendKeys("Incident creation Selenium");
			//driver.findElement(By.id("sysverb_insert_bottom")).click();
			driver.findElement(By.id("sysverb_insert")).click();
			Thread.sleep(1000);
			System.out.println(incidentNum);
			driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNum, Keys.ENTER);
			//Thread.sleep(3000);
			String searchResult = driver.findElement(By.xpath("//a[contains(text(),'"+incidentNum+"')]")).getText();
			if(incidentNum.equals(searchResult))
				System.out.println("Incident created Successfully: "+searchResult);
			else
				System.out.println("Incident creation is UnSuccessful: "+searchResult);
		}
	}
