package com.actitime.testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass{	
	@Test
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
	Reporter.log("Create Customer",true);	
	FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String customerName = wb.getSheet("CreateCustomer").getRow(1).getCell(2).getStringCellValue();
	String customerDesc = wb.getSheet("CreateCustomer").getRow(1).getCell(3).getStringCellValue();
	HomePage h=new HomePage(driver);
	h.setTasksTab();
	TaskListPage t=new TaskListPage(driver);
	t.getAddNewBtn().click();
	t.getNewCustomerOption().click();
	t.getEnterCustomerName().sendKeys(customerName);
	t.getEnterCustomerDescription().sendKeys(customerDesc);
	t.getSelectCustomerDD().click();
	t.getBigBangCompany().click();
	t.getCreateCustomerBtn().click();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomerLoct(), customerName));
	String actualCustomerText = t.getActualCustomerLoct().getText();
	Assert.assertEquals(actualCustomerText, customerName);
	}
}
