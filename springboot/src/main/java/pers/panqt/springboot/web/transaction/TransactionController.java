package pers.panqt.springboot.web.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.entry.User;

/**  @author panqt 2019/03/23 5:37
 *   
 */
@Slf4j
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    
    /** @auther panqt 2019/3/23 5:38
     *  @description 新增 Transaction
     */
    @PostMapping("transaction/insert")
    public ResultVo<String> insert(ResultVo<String> resultVo){
        transactionService.insert();
        
        return resultVo;
    }
}
