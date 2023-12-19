import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://lokasani.vercel.app/adminUMKM')

WebUI.click(findTestObject('Object Repository/Page_Lokasani/a_Tambahkan Produk'))

WebUI.setText(findTestObject('Object Repository/Page_Lokasani/input_Nama_name'), 'Patung Kuda')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Lokasani/select_HandMadeFashionBuku3D'), 'handmade', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Lokasani/select_HandMadeFashionBuku3D'), '3D', true)

WebUI.setText(findTestObject('Object Repository/Page_Lokasani/input_Jumlah Product_total_product'), '20')

WebUI.setText(findTestObject('Object Repository/Page_Lokasani/input_Harga_price'), '342000')

WebUI.setText(findTestObject('Object Repository/Page_Lokasani/textarea_Patung kuda yang dibuat dengan tek_d52c7f_1'), 'Patung kuda yang dibuat dengan teknologi 3D Printing terkini. Dengan detail sempurna.')

// WebUI.uploadFile(findTestObject('Object Repository/Page_Lokasani/div_Seret dan lepas gambar anda disini atau_fc3e02'), 'C:\\Users\\User\\Pictures\\cbe3243d4afad51d9c7e9570526e83ff79f1862e_449_599_48642.jpeg')
WebUI.uploadFile(findTestObject('Object Repository/Page_Lokasani/label_Jelajahi gambar'), 'C:\\Users\\User\\Pictures\\cbe3243d4afad51d9c7e9570526e83ff79f1862e_449_599_48642.jpeg')

WebUI.click(findTestObject('Object Repository/Page_Lokasani/button_Unggah Product'))

WebUI.closeBrowser()

