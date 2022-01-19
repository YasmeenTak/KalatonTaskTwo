package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


public class HeaderValidations {
	/***
	 * Verify Quick order page heading and the style for it
	 * @author Yasmeen
	 */
	public static void verifyPageHeading() {
		TestObject quickHeader = findTestObject('Object Repository/QuikOrderPage/Heading/a_pageHeading')
		String expectedHeading = WebUI.getText(quickHeader)
		println(expectedHeading)
		String actualHeading1 ="QUICK"
		String actualHeading2 ="ORDER"
		Assert.assertTrue(expectedHeading.contains(actualHeading1))
		Assert.assertTrue(expectedHeading.contains(actualHeading2))
		
		
		assert WebUI.getCSSValue(quickHeader, "background-color").equals("rgba(82, 36, 127, 1)")
		assert WebUI.getCSSValue(quickHeader, "color").equals("rgba(255, 255, 255, 1)")
		TestObject quickIcon = findTestObject('Object Repository/QuikOrderPage/Heading/span_quickOrderIcon')
		WebUI.verifyElementVisible(quickIcon)

		TestObject quickOrderLink = findTestObject('Object Repository/QuikOrderPage/Heading/a_QuickOrder')
		//WebUI.verifyElementClickable(quickOrderLink)
		System.out.println( quickOrderLink)
		//WebUI.verifyElementClickable(quickOrderLink, FailureHandling.STOP_ON_FAILURE)
	}
	/***
	 * verify quick order page sub heading
	 * @author Yasmeen
	 */
	public static void verifyPageSubHeading() {
		TestObject pageSubHeading = findTestObject("Object Repository/QuikOrderPage/Heading/p_pageSubHeading")
		String expectedSubHeading = GlobalVariable.subHeadingText
		String acutalSubHeading = WebUI.getText(pageSubHeading)
		Assert.assertTrue(acutalSubHeading.contains(expectedSubHeading))
	}
}
