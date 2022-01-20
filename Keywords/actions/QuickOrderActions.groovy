package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class QuickOrderActions {
	/***
	 * fill the stock id with invalid number
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillInvalidStockId() {
		TestObject invalidStock = findTestObject("Object Repository/QuikOrderPage/TableContent/input_stock1")
		WebUI.setText(invalidStock, GlobalVariable.invalidText)
		//WebUI.sendKeys(invalidStock, Keys.chord(Keys.SPACE))
		return invalidStock
		WebUI.click(findTestObject("Object Repository/QuikOrderPage/TableContent/section_pageSection"))
		WebUI.sendKeys(invalidStock, Keys.chord(Keys.TAB))

	}
	public static void fillInputField(TestObject input, String text) {

		WebUI.setText(input, text)
	}
	/***
	 * fill the stock id for first product
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillFirstStockId() {
		TestObject firstStock = findTestObject("Object Repository/QuikOrderPage/TableContent/input_stock1")
		WebUI.setText(firstStock, GlobalVariable.productId1)
		//WebUI.sendKeys(firstStock, Keys.chord(Keys.TAB))
		return firstStock
	}

	/***
	 * fill the stock id for second product
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillSecondStockId() {
		TestObject secondStock = findTestObject("Object Repository/QuikOrderPage/TableContent/input_stock2")
		WebUI.setText(secondStock, GlobalVariable.productId2)
		WebUI.sendKeys(secondStock, Keys.chord(Keys.TAB))
		return secondStock
	}


	/***
	 * fill the stock id for third product
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillThirdStockId() {
		TestObject thirdStock = findTestObject("Object Repository/QuikOrderPage/TableContent/input_stock3")
		WebUI.setText(thirdStock, GlobalVariable.productId3)
		WebUI.sendKeys(thirdStock, Keys.chord(Keys.TAB))
		return thirdStock
	}


	/***
	 * fill the stock id for fourth product
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillFourthStockId() {
		TestObject fourthStock = findTestObject("Object Repository/QuikOrderPage/TableContent/input_stock4")
		WebUI.setText(fourthStock, GlobalVariable.productId4)
		WebUI.sendKeys(fourthStock, Keys.chord(Keys.TAB))
		return fourthStock
	}


	/***
	 * fill the stock id for fifth product
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillFifthStockId() {
		TestObject fifthStock = findTestObject("Object Repository/QuikOrderPage/TableContent/input_stock5")
		WebUI.setText(fifthStock, GlobalVariable.productId5)
		WebUI.sendKeys(fifthStock, Keys.chord(Keys.TAB))
		return fifthStock
	}

	/***
	 *
	 * @param menuObject
	 */
	public static void chooseProductFromMenuDropDown(TestObject menuObject) {
		TestObject menuTestObject = findTestObject("Object Repository/QuickOrderPage/span_loadingProducts")
		WebUI.waitForElementNotVisible(menuTestObject, 1)
		WebUI.click(menuObject)
	}


	/***
	 * fill the first product quantity
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillFirstQuantity(String quantity) {
		TestObject firstQuantity = findTestObject("Object Repository/QuikOrderPage/TableContent/input_quantity1")
		WebUI.sendKeys(firstQuantity, Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(firstQuantity, quantity)
		WebUI.sendKeys(firstQuantity, Keys.chord(Keys.TAB))

		return firstQuantity
	}

	/***
	 * fill the second product quantity
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillSecondQuantity(String quantity) {
		TestObject secondQuantity = findTestObject("Object Repository/QuickOrderPage/input_quantity2")
		WebUI.sendKeys(secondQuantity, Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(secondQuantity, quantity)
		return secondQuantity
	}


	/***
	 * fill third product quantity
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillThirdQuantity(String quantity) {
		TestObject thirdQuantity = findTestObject("Object Repository/QuickOrderPage/input_quantity3")
		WebUI.sendKeys(thirdQuantity, Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(thirdQuantity, quantity)
		return thirdQuantity
	}


	/***
	 * fill fourth product Quantity
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillFourthQuantity(String quantity) {
		TestObject fourthQuantity = findTestObject("Object Repository/QuickOrderPage/input_quantity4")
		WebUI.sendKeys(fourthQuantity, Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(fourthQuantity, quantity)
		return fourthQuantity
	}


	/***
	 * fill fifth product quantity
	 * @return the test object of the input
	 * @author Yasmeen
	 */
	public static TestObject fillFifthQuantity(String quantity) {
		TestObject fifthQuantity = findTestObject("Object Repository/QuickOrderPage/input_quantity5")
		WebUI.sendKeys(fifthQuantity, Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(fifthQuantity, quantity)
		return fifthQuantity
	}

	/***
	 * hover over add to cart button
	 * @author Yasmeen
	 */
	public static void hoverbOverAddToCart() {
		TestObject addToCartButton = findTestObject("Object Repository/QuikOrderPage/Buttons Section/button_addToCart")
		WebElement addToCartButtonElm = WebUI.findWebElement(addToCartButton)
		WebUI.mouseOver(addToCartButton)
	}
	

	/***
	 * click on add to cart button
	 * @author Yasmeen
	 */
	public static void clickOnAddToCartButton() {
		TestObject addToCartButton = findTestObject("Object Repository/QuikOrderPage/Buttons Section/button_addToCart")
		WebUI.click(addToCartButton)
	}
	public static double formatPriceAndTotal(String elm){
		return Double.parseDouble(elm.replace('$', '').replace(',', ''))
	}
}
