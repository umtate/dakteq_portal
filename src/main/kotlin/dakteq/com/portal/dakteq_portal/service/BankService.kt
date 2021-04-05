package dakteq.com.portal.dakteq_portal.service

import dakteq.com.portal.dakteq_portal.datasource.BankDataSource
import dakteq.com.portal.dakteq_portal.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks() : Collection<Bank> {
        return dataSource.retrieveBanks()
    }

    fun getBank(accountNumber: String) : Bank {
        return  dataSource.retrieveBank(accountNumber)
    }
}