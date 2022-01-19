package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.testng.Assert


public class HeaderValidations {
	/***
	 * Verify Quick order page heading and the style for it
	 * @author Yasmeen
	 */
	public static void verifyPageHeading() {
		TestObject quickHeader = findTestObject('Object Repository/QuikOrderPage/Heading/a_pageHeading')
		String expectedHeading = ""
		String actualHeading = WebUI.getText(quickHeader)
		Assert.assertTrue(actualHeading.contains(expectedHeading))

		assert WebUI.getCSSValue(quickHeader, "background-color").equals("rgba(82, 36, 127, 1)")
		assert WebUI.getCSSValue(quickHeader, "color").equals("rgba(255, 255, 255, 1)")
		TestObject quickIcon = findTestObject('Object Repository/QuikOrderPage/Heading/span_quickOrderIcon')
		WebUI.verifyElementVisible(quickIcon)
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
