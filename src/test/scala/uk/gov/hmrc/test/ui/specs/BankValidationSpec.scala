package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages.BankAccountReputationFEHome
import uk.gov.hmrc.test.ui.pages.BankDetailsValidation._

class BankValidationSpec extends BaseSpec {

  scenario("should be able to validate bank details when sort code and account number are well formed") {

    Given("A user visiting the Validate Bank Details")
    go to BankAccountReputationFEHome
    click on linkText("Validate Bank Details")
    pageTitle shouldBe title

    When("a well formed sort code and account number are used ")
    validateDetails("401003", "71201948")

    Then("the validation of the bank details is successful")
    getBankDetailForAttribute("IBAN") shouldBe "GB78 HBUK 4010 0371 2019 48"
    getBankDetailForAttribute("Account Number") shouldBe "71201948"
    getBankDetailForAttribute("Sort Code") shouldBe "401003"
    getBankDetailForAttribute("Account Number/Sort Code Valid") shouldBe "true"
    getBankDetailForAttribute("Bank Code") shouldBe "0919"
    getBankDetailForAttribute("BIC Bank Code") shouldBe "HBUKGB41"
    getBankDetailForAttribute("Bank Name") shouldBe "HSBC UK BANK PLC"
    getBankDetailForAttribute("Address") shouldBe """1 New Market
                                                              |Morpeth
                                                              |UNITED KINGDOM
                                                              |NE611PX""".stripMargin
    getBankDetailForAttribute("BACS Office Status") shouldBe "The bank office of a Bacs member; accepts Bacs payments"
    getBankDetailForAttribute("CHAPS Sterling Status") shouldBe "Indirect"
    getBankDetailForAttribute("Branch Name") shouldBe "Morpeth"
    getBankDetailForAttribute("DDI Voucher Flag") shouldBe "N"
    getBankDetailForAttribute("Transaction Types") shouldBe """(DR) Direct Debits - ALLOWED
                                                                        |(CR) BACS Credits - ALLOWED
                                                                        |(AU) AUDDIS - ALLOWED""".stripMargin
  }
}