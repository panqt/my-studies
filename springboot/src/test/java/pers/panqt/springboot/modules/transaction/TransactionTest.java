package pers.panqt.springboot.modules.transaction;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.web.transaction.TransactionService;

/**  @author panqt 2019/03/23 5:17
 *   
 */
@Slf4j
public class TransactionTest extends BaseTest {

    @Autowired
    private TransactionService transactionService;

    /** 测试 {@link TransactionService#insert()}*/
    @Test
    public void testTransaction() {
        transactionService.insert();
    }
}
