package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Wind
import internal.GlobalVariable

public class QuickOrderValidations {

	/***
	 * Verify Stock Input Placeholder
	 * @author Yasmeen
	 */
	public static void verifyStockInputPlaceholder() {
		List<WebElement> stockInputs = WebUI.findWebElements(findTestObject('Object Repository/QuikOrderPage/TableContent/input_stock'),10);
		String expectedPlaceHolder = GlobalVariable.stockInputPlaceholder;
		for(WebElement elm : stockInputs) {
			String actualPlaceholder = elm.getAttribute("placeholder");
			assert actualPlaceholder.equals(expectedPlaceHolder)
		}
	}

	/***
	 * Verify Enter Invalid Stock 
	 * @author Yasmeen
	 */
	public static void verifyErrorMessageDisplay() {
		TestObject errorMessage = findTestObject("Object Repository/QuikOrderPage/TableContent/h3_ErrorMessage")
		WebUI.verifyElementVisible(errorMessage)
		WebUI.refresh()
	}
	/***
	 * verify Focusing over stock input field
	 * @param stockInput: the TestObject of the stock input field
	 * @author Yasmeen
	 */
	public static void verifyFocusingOnStockInput(TestObject stockInput) {
		String focusedBorderColor = WebUI.getCSSValue(stockInput, "border-color")
		assert focusedBorderColor.equals("rgb(99, 99, 99)")
	}

	/***
	 * verify reflected value of stock input
	 * @param stockInput: the TestObject of the stock input field
	 * @param value: the entered value in the field
	 * @author Yasmeen
	 */
	public static void verifyTheEnterdValueReflectedInStockInput(TestObject stockInput, String value) {
		String actualValue = WebUI.getAttribute(stockInput, "value")
		assert value.contains(actualValue)
	}

	/***
	 * verify reflected value of stock input
	 * @param stockInput: the TestObject of the stock input field
	 * @param value: the entered value in the field
	 * @author Yasmeen
	 */
	public static void verifyPalceholderRemovedAfterFilling(TestObject stockInput) {
		String actualValue = WebUI.getAttribute(stockInput, "placeholder")
		//assert !actualValue.equals("Enter Stock #")
	}

	/***
	 * verify reflected value of product quantity
	 * @param quantityInput: the TestObject of the stock input field
	 * @param value: the entered value in the field
	 * @author Yasmeen
	 */
	public static void verifyTheEnterdValueReflectedInQuantityInput(TestObject quantityInput, String value) {
		String actualValue = WebUI.getAttribute(quantityInput, "value")
		assert actualValue.equals(value)
	}

	/***
	 * verify product suggestions drop down menu is displayed
	 * @param quantityInput: the TestObject of the dropDown menu
	 * @author Yasmeen
	 */
	public static void verifyDropDownMenuIsDisplayed(TestObject dropDownElm) {
		boolean isVisibleElm = WebUI.verifyElementVisible(dropDownElm)
		assert isVisibleElm == true
	}
	/***
	 * verify that correct products data filled in the table
	 * @author Yasmeen
	 */
	public static void verifyCorrectProductDetails() {
		List<WebElement> products = WebUI.findWebElements(findTestObject("Object Repository/QuikOrderPage/TableContent/tr_producTableRows"),2)
		verifyProductRowDetails(products.get(0), GlobalVariable.productImage1, GlobalVariable.productName1, GlobalVariable.productPrice1)
	}

	/***
	 * verify that correct products data filled in the table
	 * @author Yasmeen
	 */
	public static void verifyCorrectProductDetails1() {
		List<WebElement> products = WebUI.findWebElements(findTestObject("Object Repository/QuikOrderPage/TableContent/tr_producTableRows"),2)
		for(int i = 0 ; i < products.size(); ++i) {
			if(i == 0 ) {
				verifyProductRowDetails(products[i], GlobalVariable.productImage1, GlobalVariable.productName1, GlobalVariable.productPrice1)
			}else if(i == 1) {
				verifyProductRowDetails(products[i], GlobalVariable.productImage2, GlobalVariable.productName2, GlobalVariable.productPrice2)
			}else if(i == 2) {
				verifyProductRowDetails(products[i], GlobalVariable.productImage3, GlobalVariable.productName3, GlobalVariable.productPrice3)
			}else if(i == 3) {
				verifyProductRowDetails(products[i], GlobalVariable.productImage4, GlobalVariable.productName4, GlobalVariable.productPrice4)
			}else if(i == 4) {
				verifyProductRowDetails(products[i], GlobalVariable.productImage5, GlobalVariable.productName5, GlobalVariable.productPrice5)
			}
		}
	}


	/***
	 * verify that correct products data filled in the table row
	 * @param row: the webElement of the Row
	 * @param image: the expected image src value
	 * @param name: the expected name value
	 * @param price: the expected price value
	 * @author Yasmeen
	 */
	public static verifyProductRowDetails(WebElement row, String image, String name, String price) {
		WebElement quantity = row.findElement(By.cssSelector(".product-table__quantity input"))
		assert quantity.getAttribute("value").equals("1")

		WebElement nameElm = row.findElement(By.cssSelector(".product-item__details a.product-title"))
		assert nameElm.getText().toLowerCase().equals(name.toLowerCase())

		WebElement stockElm = row.findElement(By.cssSelector(".stock-notification"))
		assert stockElm.getText().toLowerCase().contains("In Stock!".toLowerCase())


		WebElement imageElm = row.findElement(By.cssSelector(".product-table__image img"))
		assert imageElm.getAttribute("src").contains(image)

		WebElement priceElm = row.findElement(By.cssSelector(".price-holder"))
		assert priceElm.getText().equals(price)

		WebElement totalElm = row.findElement(By.cssSelector(".product-table__total.hidden-sm span"))
		assert totalElm.getText().equals(price)
	}

	/***
	 * verify quick order product quantity reflected value
	 * @param value: the entered quantity value
	 * @param quantityObject: the TestObject of the quantity fiels
	 * @author Yasmeen
	 */
	public static void verifyQuantityValueIsReflected(TestObject quantityObject , String value) {
		String actualValue = WebUI.getAttribute(quantityObject, "value")
		assert actualValue.equals(value)
	}

	/***
	 * verify total price for each quick order product
	 * @author Yasmeen
	 */
	public static void verifyTotalPriceForProduct() {
		List<WebElement> products = WebUI.findWebElements(findTestObject("Object Repository/QuikOrderPage/TableContent/tr_producTableRows"),2)
			WebElement quantityElm = products.get(0).findElement(By.cssSelector(".product-table__quantity input"))
			double quantity = Double.parseDouble(quantityElm.getAttribute("value").replace('$', ''))

			WebElement priceElm = products.get(0).findElement(By.cssSelector(".price-holder"))
			double price = Double.parseDouble(priceElm.getText().replace('$', ''))

			WebElement totalElm = products.get(0).findElement(By.cssSelector(".product-table__total.hidden-sm span"))
			double total = Double.parseDouble(totalElm.getText().replace('$', '').replace(',', ''))
			assert total == Double.parseDouble(String.format("%.2f", price*quantity))
	}

	/***
	 * verify hovering over add to cart button
	 * @author Yasmeen
	 */
	public static void verifyHoveringOverAddToCartButton() {
		TestObject addToCartButton = findTestObject("Object Repository/QuikOrderPage/Buttons Section/button_addToCart")
		assert WebUI.getCSSValue(addToCartButton, "box-shadow").equals("rgba(0, 0, 0, 0.3) 0px 0px 10px 2px")
	}
}
