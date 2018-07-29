package org.galileo1.bdd.pageobj;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.cucumber.listener.Reporter;

import org.galileo1.bdd.datamodel.RetirementCalFields;
import org.galileo1.bdd.datamodel.UserDataModel;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
// @ConfigurationProperties(prefix = "kiwisaverpage")
@PropertySource("classpath:application.properties")
public class KiwiSaverCalculator extends AbstractBasePage {

    @Value("${app.kiwisaverurl}")
    private String baseurl ;
  
    
    @Autowired
    private WebDriver driver;

    private String title = "KiwiSaver Retirement Calculator - Westpac NZ";
    
    @FindBy(css = "div.wpnib-field-current-age")
    private WebElement currentAgeBlock;
    
    @FindBy(css = "div.wpnib-field-current-age input")
    private WebElement currentAgeTextField;
    
    @FindBy(css = "div.wpnib-field-current-age div.field-info button")
    private WebElement currentAgeInformatioIcon;
    
    @FindBy(css = "div.wpnib-field-current-age div.message-row")
    private WebElement currentAgeFieldMessageContainer;
    
    @FindBy(css = "div.wpnib-field-current-age div.message-row div.field-message.message-info.ng-binding.ng-hide")
    private WebElement currentAgeFieldMessageBlock;
    
    @FindBy(css = "div.wpnib-field-current-age div.message-row p")
    private WebElement currentAgeFieldMessageText;
    
    @FindBy(css = "div.wpnib-field-employment-status")
    private WebElement empStatusBlock;
    
    @FindBy(css = "div.wpnib-field-employment-status div.control-well")
    private WebElement empStatusDropDown;
    
    @FindBy(css = "div.wpnib-field-employment-status div.field-info button")
    private WebElement empStatusInformatioIcon;
    
    @FindBy(css = "div.wpnib-field-employment-status div.message-row")
    private WebElement empStatusFieldMessageContainer;
    
    @FindBy(css = "div.wpnib-field-employment-status div.message-row div.field-message.message-info.ng-binding.ng-hide")
    private WebElement empStatusFieldMessageBlock;
    
    @FindBy(css = "div.wpnib-field-employment-status div.message-row p")
    private WebElement empStatusMessageText;
    
    @FindBy(css = "div.wpnib-field-pir-rate")
    private WebElement pirBlock;
    
    @FindBy(css = "div.wpnib-field-pir-rate div.control-well")
    private WebElement pirDropDown;
    
    @FindBy(css = "div.wpnib-field-pir-rate button")
    private WebElement pirInformatioIcon;
    
    @FindBy(css = "div.wpnib-field-pir-rate div.message-row")
    private WebElement pirFieldMessageContainer;
    
    @FindBy(css = "div.wpnib-field-pir-rate div.message-row div.field-message.message-info.ng-binding.ng-hide")
    private WebElement pirFieldMessageBlock;
    
    @FindBy(css = "div.wpnib-field-pir-rate div.message-row p")
    private WebElement pirMessageText;

    @FindBy(css = "div.wpnib-field-annual-income")
    private WebElement annualIncomeBlock;
    
    @FindBy(css = "div.wpnib-field-annual-income input")
    private WebElement annualIncomeTextField;
    
    @FindBy(css = "div.wpnib-field-annual-income button")
    private WebElement annualIncomeInformatioIcon;
    
    @FindBy(css = "div.wpnib-field-annual-income div.message-row")
    private WebElement annualIncomeMessageContainer;
    
    @FindBy(css = "div.wpnib-field-annual-income div.message-row div.field-message.message-info.ng-binding.ng-hide")
    private WebElement annualIncomeMessageBlock;
    
    @FindBy(css = "div.wpnib-field-annual-income div.message-row p")
    private WebElement annualIncomeMessageText;

    @FindBy(css = "div.wpnib-field-kiwisaver-member-contribution")
    private WebElement memberContributionBlock;
    
    @FindBy(css = "div.wpnib-field-kiwisaver-member-contribution input")
    private List<WebElement> memberContributionTextField;
    
    @FindBy(css = "div.wpnib-field-kiwisaver-member-contribution button")
    private WebElement memberContributionInformatioIcon;
    
    @FindBy(css = "div.wpnib-field-kiwisaver-member-contribution div.message-row")
    private WebElement memberContributionMessageContainer;
    
    @FindBy(css = "div.wpnib-field-kiwisaver-member-contribution div.message-row div.field-message.message-info.ng-binding.ng-hide")
    private WebElement memberContributionMessageBlock;
    
    @FindBy(css = "div.wpnib-field-kiwisaver-member-contribution div.message-row p")
    private WebElement memberContributionMessageText;
    
    @FindBy(css = "div.wpnib-field-kiwi-saver-balance")
    private WebElement kiwiSaverBalanceBlock;
    
    @FindBy(css = "div.wpnib-field-kiwi-saver-balance input")
    private WebElement kiwiSaverBalanceTextField;
    
    @FindBy(css = "div.wpnib-field-kiwi-saver-balance button")
    private WebElement kiwiSaverBalanceInformatioIcon;
    
    @FindBy(css = "div.wpnib-field-kiwi-saver-balance div.message-row")
    private WebElement kiwiSaverBalanceMessageContainer;
    
    @FindBy(css = "div.wpnib-field-kiwi-saver-balance div.message-row div.field-message.message-info.ng-binding.ng-hide")
    private WebElement kiwiSaverBalanceMessageBlock;
    
    @FindBy(css = "div.wpnib-field-kiwi-saver-balance div.message-row p")
    private WebElement kiwiSaverBalanceMessageText;
    
    @FindBy(css = "div.wpnib-field-voluntary-contributions")
    private WebElement voluntaryContributionBlock;
    
    @FindBy(css = "div.wpnib-field-voluntary-contributions input")
    private WebElement voluntaryContributionTextField;

    @FindBy(css = "div.wpnib-field-voluntary-contributions  div.control-well[ng-click]")
    private WebElement voluntaryContributionFrequency;
    
    @FindBy(css = "div.wpnib-field-voluntary-contributions button")
    private WebElement voluntaryContributionInformatioIcon;
    
    @FindBy(css = "div.wpnib-field-voluntary-contributions div.message-row")
    private WebElement voluntaryContributionMessageContainer;
    
    @FindBy(css = "div.wpnib-field-voluntary-contributions div.message-row div.field-message.message-info.ng-binding.ng-hide")
    private WebElement voluntaryContributionMessageBlock;
    
    @FindBy(css = "div.wpnib-field-voluntary-contributions div.message-row p")
    private WebElement voluntaryContributionMessageText;

    @FindBy(css = "div.wpnib-field-risk-profile")
    private WebElement riskProfileBlock;
    
    @FindBy(css = "div.wpnib-field-risk-profile input")
    private List<WebElement> riskProfileTextField;
    
    @FindBy(css = "div.wpnib-field-risk-profile button")
    private WebElement riskProfileInformatioIcon;
    
    @FindBy(css = "div.wpnib-field-risk-profile div.message-row")
    private WebElement riskProfileMessageContainer;
    
    @FindBy(css = "div.wpnib-field-risk-profile div.message-row div.field-message.message-info.ng-binding.ng-hide")
    private WebElement riskProfileMessageBlock;
    
    @FindBy(css = "div.wpnib-field-risk-profile div.message-row p")
    private WebElement riskProfileMessageText;

    @FindBy(css = "div.wpnib-field-savings-goal")
    private WebElement savingsGoalBlock;
    
    @FindBy(css = "div.wpnib-field-savings-goal input")
    private WebElement savingsGoalTextField;
    
    @FindBy(css = "div.wpnib-field-savings-goal button")
    private WebElement savingsGoalInformatioIcon;
    
    @FindBy(css = "div.wpnib-field-savings-goal div.message-row")
    private WebElement savingsGoalMessageContainer;
    
    @FindBy(css = "div.wpnib-field-savings-goal div.message-row div.field-message.message-info.ng-binding.ng-hide")
    private WebElement savingsGoalMessageBlock;
    
    @FindBy(css = "div.wpnib-field-savings-goal div.message-row p")
    private WebElement savingsGoalMessageText;

    //TODO: Nasty to understand but works like a charm
    @FindBy(xpath = "//div[contains(@class, 'field-message message-info ng-binding') and not(contains(@class, 'field-message message-info ng-binding ng-hide'))]/child::*[not(name()='strong' or name()='a')]")
    private List<WebElement> displayedInformation;

    @FindBy(css = "button.btn-results-reveal")
    private WebElement calculateButton;

    @FindBy(css = "div.results-field-group-set")
    private WebElement projectedNumbers;

    @PostConstruct
    public void init() {
      PageFactory.initElements(driver, this);
    }

    public void enterCurrentAge(final String text) {
      enterText(currentAgeTextField,text);
    } 

    public void enterEmpStatus(final String text) {
      selectFromDropDowns(empStatusDropDown,text);
    } 

    public void enterAnnualIncome(final String text) {
      enterText(annualIncomeTextField,text);
    } 

    public void selectMemberContribution(final String text) {
      selectFromRadioButtons(memberContributionTextField,text); 
    } 

    public void selectPIR(final String text) {
      selectFromDropDowns(pirDropDown,text);
    } 

    public void enterKiwiSaveBalance(final String text) {
      enterText(kiwiSaverBalanceTextField,text); 
    } 

    public void enterVoluntaryContribution(final String text) {
      enterText(voluntaryContributionTextField,text); 
    } 

    public void selectVoluntaryContributionFrequncy(final String text) {
      selectFromDropDowns(voluntaryContributionFrequency,text); 
    } 

    public void selectRiskProfile(final String text) {
      selectFromRadioButtons(riskProfileTextField,text);
    } 

    public void enterSavingsGoal(final String text) {
      enterText(savingsGoalTextField,text); 
    }

    public void calculateRetirementProjections() {
      safeClick(calculateButton);
    }

    public String getInformationMessage() {
      return getTextFromElementList(displayedInformation);
    }

    public void selectAgeInformationIcon() {
      safeClick(currentAgeInformatioIcon);
    }

    public void selectEmpStatusInformationIcon() {
      safeClick(empStatusInformatioIcon);
    }

    public void selectPIRInformationIcon() {
      safeClick(pirInformatioIcon);
    }

    public void selectCurrentBalanceInformationIcon() {
      safeClick(kiwiSaverBalanceInformatioIcon);
    }

    public void selectVoluntaryContributionInformationIcon() {
      safeClick(voluntaryContributionInformatioIcon);
    }

    public void selectRiskProfileInformationIcon() {
      safeClick(riskProfileInformatioIcon);
    }

    public void selectSavingsGoalInformationIcon() {
      safeClick(savingsGoalInformatioIcon);
    }

    //Actions 

    public KiwiSaverCalculator toPage() {
      navigateTo(baseurl);
      assertThat(getPageTitle(), is(equalTo(title)));
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
      e.printStackTrace();
      }
      return this;
    }

    public void switchToSelectedFrame() {
      switchToIframe(0);
    }

    public void switchBackToDefault() {
      switchToDefault();
    }

    public void checkResultsArePresent() {
      assertTrue(elementIsDisplayed(projectedNumbers));
      switchToDefault();
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(final String title) {
      this.title = title;
    }

    public List<UserDataModel> mapTo(List<List<String>> inputData) {
      List<UserDataModel> memberDetails = inputData.stream()
                .map(p-> new UserDataModel(p.get(0), 
                    p.get(1), p.get(2), p.get(3), 
                    p.get(4), p.get(5), p.get(6), 
                    p.get(7), p.get(8), p.get(9)))
                    .collect(Collectors.toList());
      return memberDetails;
    }

    public UserDataModel mapToUserDataModel(List<String> inputData) {
        UserDataModel memberDetails = new UserDataModel(inputData.get(0), 
                                      inputData.get(1),inputData.get(2),inputData.get(3),
                                      inputData.get(4), inputData.get(5),inputData.get(6),
                                      inputData.get(7), inputData.get(8),inputData.get(9));
      return memberDetails;
    }

    private Map<RetirementCalFields, Runnable> typeMap = new HashMap<RetirementCalFields, Runnable>() {
      {
          put(RetirementCalFields.AGE, () -> selectAgeInformationIcon());
          put(RetirementCalFields.EMPSTATUS, () -> selectEmpStatusInformationIcon());
          put(RetirementCalFields.CURRENTBALANCE, () -> selectCurrentBalanceInformationIcon());
          put(RetirementCalFields.PIR, () -> selectPIRInformationIcon());
          put(RetirementCalFields.RISKPROFILE, () -> selectRiskProfileInformationIcon());
          put(RetirementCalFields.SAVINGSGOAL, () -> selectSavingsGoalInformationIcon());
          put(RetirementCalFields.VOLUNTARYCONTRIBUTIONS, () -> selectVoluntaryContributionInformationIcon());
      }
    };

    public void clickOnInformationIcon(String value) {
      switchToIframe(0);
      RetirementCalFields infoIcon = RetirementCalFields.valueOf(value);
      if (!typeMap.containsKey(infoIcon)) {
          throw new IllegalArgumentException(String.format("%s is not supported", infoIcon));
      }

      typeMap.get(infoIcon).run();
    }

    public void checkInfoMessage(String expectedMessage, String label) {
      String actualMessage  = getInformationMessage();
      assertTrue(actualMessage.trim().equals(expectedMessage.trim()));
      switchToDefault();
    }

    public void takeScreenshot() {
      
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
        getScreenshotAs(OutputType.BASE64);

        //Attach the base64Screenshot to extent report
        try {
            Reporter.addScreenCaptureFromPath(base64Screenshot);
          } catch (IOException e) {
            e.printStackTrace();
          }
    }

    public void captureBrowserLogs() {
      Reporter.addScenarioLog("=========== Browser Logs ===================");
      
      //Add browser logs  
      LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
      for (LogEntry entry : logEntries) {
          Reporter.addScenarioLog(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
      }
    }
}
