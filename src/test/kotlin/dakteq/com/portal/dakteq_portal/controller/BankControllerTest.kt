package dakteq.com.portal.dakteq_portal.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should return all banks`(){
        //act
        mockMvc.get("/api/banks")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].accountNumber"){
                        value("acc1234")
                    }
                }

        //arrange

        //assert

    }

    @Test
    fun `should return selected bank`(){
        //act
        val accountNumber = "acc1234"

        //arrange
        mockMvc.get("/api/banks/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType((MediaType.APPLICATION_JSON)) }
                    jsonPath("$.trust"){value("1.3")}
                    jsonPath("$.transactionFee"){value("1")}
                }

        //assert

    }
    
    @Test
    fun `should return NOT FOUND if the account number does not exist`(){
        //act
        val accountNumber = "does_not_exist"
        
        //arrange
        mockMvc.get("/api/banks/$accountNumber")
                .andDo { print() }
                .andExpect { status { isNotFound() } }
        
        //assert
    
    }
}