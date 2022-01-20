package helpers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.GlobalActions
import actions.QuickOrderActions
import internal.GlobalVariable
import validations.QuickOrderValidations
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
public class QuickOrderHelpers {

	/***
	 * Enter invalid Stock Number
	 * @author Yasmeen
	 */
	public static void enterInvalidStockNumber() {
		TestObject invalidStockInput = QuickOrderActions.fillInvalidStockId()
		QuickOrderValidations.verifyFocusingOnStockInput(invalidStockInput)
		QuickOrderValidations.verifyPalceholderRemovedAfterFilling(invalidStockInput)
		//GlobalActions.clearItem(invalidStockInput)
		GlobalActions.clearItem(invalidStockInput)
		WebUI.sendKeys(invalidStockInput, Keys.chord(Keys.TAB))
	}
	
//	public static void verifyAddProductWithInvalidSku() {
//		List<WebElement> quickOrders = WebUI.findWebElements(QuickOrderItems.productsList , GlobalVariable.elementsVisibiltyTimeOut)
//
//		for(WebElement row : quickOrders) {
//			// fill sku field with invalid data
//			TestObject skuInput  = WebUI.convertWebElementToTestObject(row.findElement(By.tagName("input")))
//			QuickOrderActions.fillInputField(skuInput, GeneralHelpers.genarateRandomString(10))
//			GeneralValidations.verifyInputFocus(skuInput)
////			assert WebUI.getAttribute("Object Repository/QuikOrderPage/TableContent/div_DropdownOfSkuInput", "style").equals("display: none;")
//			
//			// verify error message visibility
//			WebElement errorMessage  = row.findElement(By.cssSelector("h3.mandatory-sign"))
//			assert errorMessage.getCssValue("color").contains("rgba(237, 28, 36, 1)")
//			assert errorMessage.getText().equals(AppConstants.QUICK_ORDER_INVALID_PRODUCT)
//
//			// verify remove button visibility
//			TestObject buttonRemove  = WebUI.convertWebElementToTestObject(row.findElement(By.cssSelector("td.product-table__button button")))
//			GeneralValidations.verifyButtonShadowHover(buttonRemove)
//		}
//	}
	/***
	 * Entering Quick order products
	 * @author Yasmeen
	 */
	public static void enterQuickOrderProducts() {
		TestObject firstStockInput = QuickOrderActions.fillFirstStockId()
		QuickOrderValidations.verifyFocusingOnStockInput(firstStockInput)
		WebUI.sendKeys(firstStockInput, Keys.chord(Keys.TAB))
		QuickOrderValidations.verifyPalceholderRemovedAfterFilling(firstStockInput)
		TestObject ProductMenu1 = findTestObject("Object Repository/QuikOrderPage/TableContent/ul_productMenu1")
		//QuickOrderValidations.verifyDropDownMenuIsDisplayed(ProductMenu1)
		//QuickOrderActions.chooseProductFromMenuDropDown(ProductMenu1)
		QuickOrderValidations.verifyTheEnterdValueReflectedInStockInput(firstStockInput, GlobalVariable.productId1)
	}

	/***
	 * Entering Quick order products
	 * @author Yasmeen
	 */
	public static void enterQuickOrderProductsAll() {
		TestObject firstStockInput = QuickOrderActions.fillFirstStockId()
		//QuickOrderValidations.verifyFocusingOnStockInput(firstStockInput)
		QuickOrderValidations.verifyPalceholderRemovedAfterFilling(firstStockInput)
		TestObject ProductMenu1 = findTestObject("Object Repository/QuikOrderPage/TableContent/ul_productMenu1")
		QuickOrderValidations.verifyDropDownMenuIsDisplayed(ProductMenu1)
		//QuickOrderActions.chooseProductFromMenuDropDown(ProductMenu1)
		QuickOrderValidations.verifyTheEnterdValueReflectedInStockInput(firstStockInput, GlobalVariable.productId1)


		TestObject secondStockInput = QuickOrderActions.fillSecondStockId()
		//QuickOrderValidations.verifyFocusingOnStockInput(secondStockInput)
		QuickOrderValidations.verifyPalceholderRemovedAfterFilling(secondStockInput)
		TestObject ProductMenu2 = findTestObject("Object Repository/QuikOrderPage/TableContent/ul_productMenu2")
		QuickOrderValidations.verifyDropDownMenuIsDisplayed(ProductMenu2)
		//QuickOrderActions.chooseProductFromMenuDropDown(ProductMenu2)
		QuickOrderValidations.verifyTheEnterdValueReflectedInStockInput(secondStockInput, GlobalVariable.productId2)


		TestObject thirdStockInput = QuickOrderActions.fillThirdStockId()
		//QuickOrderValidations.verifyFocusingOnStockInput(thirdStockInput)
		QuickOrderValidations.verifyPalceholderRemovedAfterFilling(thirdStockInput)
		TestObject ProductMenu3 = findTestObject("Object Repository/QuikOrderPage/TableContent/ul_productMenu3")
		QuickOrderValidations.verifyDropDownMenuIsDisplayed(ProductMenu3)
		//QuickOrderActions.chooseProductFromMenuDropDown(ProductMenu3)
		QuickOrderValidations.verifyTheEnterdValueReflectedInStockInput(thirdStockInput, GlobalVariable.productId3)


		TestObject fourthStockInput = QuickOrderActions.fillFourthStockId()
		//QuickOrderValidations.verifyFocusingOnStockInput(fourthStockInput)
		QuickOrderValidations.verifyPalceholderRemovedAfterFilling(fourthStockInput)
		TestObject ProductMenu4 = findTestObject("Object Repository/QuikOrderPage/TableContent/ul_productMenu4")
		QuickOrderValidations.verifyDropDownMenuIsDisplayed(ProductMenu4)
		//QuickOrderActions.chooseProductFromMenuDropDown(ProductMenu4)
		QuickOrderValidations.verifyTheEnterdValueReflectedInStockInput(fourthStockInput, GlobalVariable.productId4)


		TestObject fifthStockInput = QuickOrderActions.fillFifthStockId()
		//QuickOrderValidations.verifyFocusingOnStockInput(fifthStockInput)
		QuickOrderValidations.verifyPalceholderRemovedAfterFilling(fifthStockInput)
		TestObject ProductMenu5 = findTestObject("Object Repository/QuikOrderPage/TableContent/ul_productMenu5")
		QuickOrderValidations.verifyDropDownMenuIsDisplayed(ProductMenu5)
		//QuickOrderActions.chooseProductFromMenuDropDown(ProductMenu5)
		QuickOrderValidations.verifyTheEnterdValueReflectedInStockInput(fifthStockInput, GlobalVariable.productId5)
	}

	public static void enterProductsQuantity() {
		String firstRandomQuantity = getRandomNumber()
		TestObject firstQuantityElm = QuickOrderActions.fillFirstQuantity(firstRandomQuantity)
		QuickOrderValidations.verifyQuantityValueIsReflected(firstQuantityElm, firstRandomQuantity)
		GlobalVariable.productQuantity1 = firstRandomQuantity
		}
	/***
	 * Entering Quick order products quantity
	 * @author Yasmeen
	 */
	public static void enterProductsQuantityAll() {
		String firstRandomQuantity = getRandomNumber()
		TestObject firstQuantityElm = QuickOrderActions.fillFirstQuantity(firstRandomQuantity)
		QuickOrderValidations.verifyQuantityValueIsReflected(firstQuantityElm, firstRandomQuantity)
		GlobalVariable.productQuantity1 = firstRandomQuantity

		String secondRandomQuantity = getRandomNumber()
		TestObject secondQuantityElm = QuickOrderActions.fillSecondQuantity(secondRandomQuantity)
		QuickOrderValidations.verifyQuantityValueIsReflected(secondQuantityElm, secondRandomQuantity)
		GlobalVariable.productQuantity2 = secondRandomQuantity

		String thirdRandomQuantity = getRandomNumber()
		TestObject thirdQuantityElm = QuickOrderActions.fillThirdQuantity(thirdRandomQuantity)
		QuickOrderValidations.verifyQuantityValueIsReflected(thirdQuantityElm, thirdRandomQuantity)
		GlobalVariable.productQuantity3 = thirdRandomQuantity

		String fourthRandomQuantity = getRandomNumber()
		TestObject fourthQuantityElm = QuickOrderActions.fillFourthQuantity(fourthRandomQuantity)
		QuickOrderValidations.verifyQuantityValueIsReflected(fourthQuantityElm, fourthRandomQuantity)
		GlobalVariable.productQuantity4 = fourthRandomQuantity

		String fifthRandomQuantity = getRandomNumber()
		TestObject fifthQuantityElm = QuickOrderActions.fillFifthQuantity(fifthRandomQuantity)
		QuickOrderValidations.verifyQuantityValueIsReflected(fifthQuantityElm, fifthRandomQuantity)
		GlobalVariable.productQuantity5 = fifthRandomQuantity

		WebUI.click(findTestObject("Object Repository/QuikOrderPage/TableContent/div_tempElm"));
	}

	/**
	 * Get Ranndom number between 5 - 50
	 * @author Yasmeen
	 */
	public static String getRandomNumber() {
		int randomQuantity = (int) (Math.random() * (50 - 5)) + 5;
		return randomQuantity.toString()
	}
}
