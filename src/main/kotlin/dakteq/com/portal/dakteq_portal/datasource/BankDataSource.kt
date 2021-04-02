package dakteq.com.portal.dakteq_portal.datasource

import dakteq.com.portal.dakteq_portal.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>
}