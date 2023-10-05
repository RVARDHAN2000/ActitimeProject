package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewBtn;	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newCustomerOption;	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement enterCustomerName;
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement enterCustomerDescription;
	@FindBy(xpath="(//div[text()='- Select Customer -'])[1]")
	private WebElement selectCustomerDD;
	@FindBy(xpath="//div[text()='Big Bang Company'   and @class='itemRow cpItemRow ']")
	private WebElement bigBangCompany;
	@FindBy(xpath="//div[text()='Create Customer']")
	private WebElement createCustomerBtn;
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[1]")
	private WebElement actualCustomerLoct;
	
	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddNewBtn() {
		return addNewBtn;
	}
	public WebElement getNewCustomerOption() {
		return newCustomerOption;
	}
	public WebElement getEnterCustomerName() {
		return enterCustomerName;
	}
	public WebElement getEnterCustomerDescription() {
		return enterCustomerDescription;
	}
	public WebElement getSelectCustomerDD() {
		return selectCustomerDD;
	}
	public WebElement getBigBangCompany() {
		return bigBangCompany;
	}
	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}
	public WebElement getActualCustomerLoct() {
		return actualCustomerLoct;
	}
	
}





