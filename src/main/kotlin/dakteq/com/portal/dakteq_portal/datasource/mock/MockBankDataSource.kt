package dakteq.com.portal.dakteq_portal.datasource.mock

import dakteq.com.portal.dakteq_portal.datasource.BankDataSource
import dakteq.com.portal.dakteq_portal.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    val bank = listOf(
            Bank(accountNumber = "acc1234", trust = 1.3, transactionFee = 1),
            Bank(accountNumber = "acc1236", trust = 10.3, transactionFee = 1),
            Bank(accountNumber = "acc1235", trust = 0.3, transactionFee = 1),
    )

    override fun retrieveBanks(): Collection<Bank> = bank

    override fun retrieveBank(accountNumber: String) : Bank {
        return bank.firstOrNull() { it.accountNumber == accountNumber}
                ?: throw  NoSuchElementException("Could not find a bank with account number $accountNumber")
    }


}