package Week5.day1;

	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

	public class DeleteIncident  extends CommonClass{

		@Test
		public void runDeleteIncident() throws InterruptedException {
			System.out.println("Delete Incident");
			String incidentNum="INC0010024";
			System.out.println("Title of current WebPage : "+driver.getTitle());
			driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNum, Keys.ENTER);
			String searchResult = driver.findElement(By.xpath("//a[contains(text(),'"+incidentNum+"')]")).getText();
			driver.findElement(By.xpath("//a[contains(text(),'"+incidentNum+"')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("sysverb_delete")).click();
			Thread.sleep(3000);
			driver.switchTo().activeElement();
			driver.findElement(By.id("ok_button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNum, Keys.ENTER);
			WebElement webTable = driver.findElement(By.id("incident_table"));
			List<WebElement> rowList = webTable.findElements(By.tagName("tr"));
			int rows=rowList.size();
			System.out.println("No. of rows returned : "+rows);
			if(rows<=3)
				System.out.println("Incident deleted successfully");
			else
				System.out.println("Incident deletion is unsuccessful");
		}

	}

