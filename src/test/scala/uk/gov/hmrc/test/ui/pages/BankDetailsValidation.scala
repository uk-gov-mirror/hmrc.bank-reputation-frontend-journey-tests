/*
 * Copyright 2018 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import scala.collection.JavaConversions._

object BankDetailsValidation extends BasePage {

  val url: String = TestConfiguration.url("bank-account-reputation-frontend") + "/bankDetailsValidation"
  val title = "Validate Bank Account"
  val bankDetailsValueLocator = By.cssSelector("td:nth-child(2)")
  val bankDetailsTableLocator = By.cssSelector("table > tbody > tr")

  def validateDetails(sortCode: String, accountNo: String)(implicit driver: WebDriver): Unit = {
    textField("sortCode").value = sortCode
    textField("accountNumber").value = accountNo
    click on CssSelectorQuery("button.govuk-button")
  }

  def getBankDetailForAttribute(attribute: String)(implicit driver: WebDriver) = {
    driver.findElements(bankDetailsTableLocator).filter(_.getText.contains(attribute)).head.findElement(bankDetailsValueLocator).getText
  }
}

