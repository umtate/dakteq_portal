package dakteq.com.portal.dakteq_portal.datasource.mock

import dakteq.com.portal.dakteq_portal.datasource.BankDataSource
import dakteq.com.portal.dakteq_portal.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
    val bank = listOf(Bank(accountNumber = "acc1234", trust = 1.3, transactionFee = 1))

    override fun retrieveBanks(): Collection<Bank> = bank


}