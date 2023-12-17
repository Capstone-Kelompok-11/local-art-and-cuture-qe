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

WebUI.click(findTestObject('Object Repository/Page_Vite  React/a_Produk'))

WebUI.click(findTestObject('Object Repository/Page_Vite  React/a_Tambahkan Produk'))

WebUI.setText(findTestObject('Object Repository/Page_Vite  React/input_Nama_productName'), 'Silver Queen')

WebUI.setText(findTestObject('Object Repository/Page_Vite  React/input_Kode Batang_kodeBatang'), '')

WebUI.click(findTestObject('Object Repository/Page_Vite  React/input_Kode Batang_kodeBatang'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Vite  React/select_HandMadeFashionBuku3D'), 'fashion', 
    true)

WebUI.setText(findTestObject('Object Repository/Page_Vite  React/input_Kode Batang_kodeBatang'), '3492329349')

WebUI.setText(findTestObject('Object Repository/Page_Vite  React/textarea_Kode Batang_deskripsi'), '234234923424')

WebUI.click(findTestObject('Object Repository/Page_Vite  React/label_Jelajahi gambar'))

WebUI.setText(findTestObject('Object Repository/Page_Vite  React/input_Kode Batang_kodeBatang'), '99798rer')

WebUI.setText(findTestObject('Object Repository/Page_Vite  React/input_Harga_harga'), '75000')

WebUI.click(findTestObject('Object Repository/Page_Vite  React/button_Simpan'))

WebUI.click(findTestObject('Object Repository/Page_Vite  React/button_Unggah Produk'))

