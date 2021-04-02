package dakteq.com.portal.dakteq_portal.datasource.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest{

    private val mockDataSource = MockBankDataSource()

   @Test fun`should provide a list of banks`(){
   //act
       val banks = mockDataSource.retrieveBanks()
   
   
   //assert
       Assertions.assertThat(banks).isNotEmpty
   }
    
    @Test fun`should provide some mock data`(){

    //act
    val banks = mockDataSource.retrieveBanks()
    
    //assert
    Assertions.assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
    Assertions.assertThat(banks).anyMatch { it.transactionFee != 0 }
        Assertions.assertThat(banks).anyMatch { it.trust != 0.0 }
    
    }
}