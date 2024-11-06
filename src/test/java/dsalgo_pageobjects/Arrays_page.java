package dsalgo_pageobjects;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsalgo_Utilities.Utils;

public class Arrays_page {
	
	private WebDriver driver;
	Utils utils = new Utils();
	
	// Locators
	@FindBy (xpath = "//a[@href='array']") WebElement getstarted_array;
	@FindBy (xpath = "//a[@href ='arrays-in-python']") WebElement arrays_in_python;
	@FindBy (xpath ="//a[@href ='arrays-using-list']") WebElement arrays_using_list;
	@FindBy (xpath ="//a[@href ='basic-operations-in-lists']") WebElement basic_operations_in_lists;
	@FindBy (xpath ="//a[@href ='applications-of-array']") WebElement applications_of_array;
	@FindBy (xpath ="//a[@href='/tryEditor']") WebElement try_here;
	@FindBy (xpath = "//div[@class = 'CodeMirror-scroll']") WebElement CodeEditor;
	@FindBy (id = "output")WebElement Codeoutput;
	
	@FindBy (xpath = "//a[@href = '/array/practice']") WebElement Practise_Qtns;
	@FindBy (xpath = "//a[@href = '/question/1']") WebElement Question1;
	@FindBy (xpath = "//a[@href = '/question/2']") WebElement Question2;
	@FindBy (xpath = "//a[@href = '/question/3']") WebElement Question3;
	@FindBy (xpath = "//a[@href = '/question/4']") WebElement Question4;
	
//	@FindBy (xpath = "//div[@class = 'CodeMirror-scroll']") WebElement Question_Input;
	@FindBy (xpath = "//textarea[@tabindex='0']")WebElement Question_Input;
	@FindBy (xpath = "//button[text() = 'Run']") WebElement Run;
	@FindBy (xpath = "//input[@type = 'submit']") WebElement Submit;
	@FindBy (id = "output") WebElement QtnOutPut;
	

	public Arrays_page(WebDriver browserDriver) {
		driver = browserDriver;
		PageFactory.initElements(driver,this);
	}
	public void click_getstarted_array() {
		getstarted_array.click();
	}
	
	public String arraytitle() {
		return driver.getTitle();
	}
		
	public void click_arrayOptions(String arrayOptions) {
		System.out.println(arrayOptions);
		switch(arrayOptions) {
		case "Arrays in Python":
			arrays_in_python.click();break;
		case "Arrays Using List":
			arrays_using_list.click();break;
		case "Basic Operations in Lists":
			basic_operations_in_lists.click();break;
		case "Applications of Array":
			applications_of_array.click();break;
		case "Practice Questions":
			Practise_Qtns.click();break;
		default:
			break;
			}
		}
	
	public void click_try_here() {
		try_here.click();
	}
	public void click_Practise_Qtns() {
		Practise_Qtns.click();
	}
	
	public void click_PractiseQtnsOptions(String Questions) {
		System.out.println(Questions);
		switch (Questions) {
		case "Search the array":
			Question1.click();break;
		case "Max Consecutive Ones":
			Question2.click();break;
		case "Find Numbers with Even Number of Digits":
			Question3.click();break;
		case "Squares of  a Sorted Array":
			Question4.click();break;
		default:
			break;
			}
	}
	
	public String practiceqtnstitle() {
		return driver.getTitle();
	}
	public void click_Run() {
		Run.click();
	}
	
	public void click_Submit() {
		Submit.click();
	}
	public String getEditorOutput() {
		return Codeoutput.getText();
	}
	public String getQtnOutPut() {
		return QtnOutPut.getText();
	}
	public String getActualResult() {
		utils.waitForElement(QtnOutPut, driver);
		return QtnOutPut.getText();

	}
	
	public void enterPythonCode(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		Utils utils = new Utils();
		String code = utils.getCodefromExcel(sheetname, rownumber);
		this.enterCode(code, CodeEditor);
	}
	public void enterCode(String code, WebElement element) {
         new Actions(driver).sendKeys(element, code).perform();
	}
	
	public String getCodeoutput(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		
		String result = utils.getOutputFromExcel(sheetname, rownumber);
		return result;
	}	
	
	public void enterPythonCodePractice(String sheetname, int rownumber) throws InvalidFormatException, IOException, InterruptedException {
//		utils.waitForElement(Question_Input,driver);
		String code = utils.getCodefromExcel(sheetname, rownumber);
		utils.enterCodePractice(code, Question_Input, driver);
	}

	
//	public void enterQtnPythonCode(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
//		Utils utils = new Utils();
//		String code = utils.getCodefromExcel(sheetname, rownumber);
////		this.enterQtnCode(code, Question_Input);
//		this.practiceQtnCode(code);
//	}
//	public void enterQtnCode(String code, WebElement element) {
//        new Actions(driver).sendKeys(element, code).perform();
//	}
	
//	public void practiceQtnCode(String code) {
//		By qtnEditorArea = By.xpath("//*[@id=\"answer_form\"]/div/div/div[6]/div[1]");
//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement pythonCode = mywait.until(ExpectedConditions.presenceOfElementLocated(qtnEditorArea));
//		
//		// Use Actions class to clear the contents and send new keys
//		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
//		System.out.println(code);
//
//		// split the python code into separate lines and send the codes line by line
//		String[] str1 = code.split("\n");
//		int totalSpaces = 0;
//		for (int i = 0; i < str1.length; i++) {
//			// Remove all the white spaces and reset the cursor back to the beginning of the
//			// current line
//			for (int s = 0; s < totalSpaces; s++) {
//				new Actions(driver).sendKeys(pythonCode, Keys.BACK_SPACE).perform();
//			}
//
//			// Find out how many white spaces the current line has at the beginning
//			totalSpaces = 0;
//			for (int j = 0; j < str1[i].length(); j++) {
//				// Check if the character is a whitespace character
//				if (Character.isWhitespace(str1[i].charAt(j))) {
//					totalSpaces += 1;
//				} else {
//					break;
//				}
//			}
//
//			// send the current line to the editor text area
//			new Actions(driver).sendKeys(pythonCode, str1[i]).perform();
//
//			// After each line, send "Enter" key to start new line for next line
//			new Actions(driver).sendKeys(pythonCode, Keys.ENTER).perform();
//			// The python editor adds two spaces if the previous line has :
//			if (str1[i].indexOf(':') > -1) {
//				totalSpaces += 2;
//			}
//			// The python editor removes two spaces if the previous line has return
//			// statement
//			if (str1[i].contains("return ")) {
//				totalSpaces -= 2;
//			}
//		}
//	}
	

	
	public String getQtnOutPut(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		Utils utils = new Utils();
		String result = utils.getOutputFromExcel(sheetname, rownumber);
		return result;
	}
}
