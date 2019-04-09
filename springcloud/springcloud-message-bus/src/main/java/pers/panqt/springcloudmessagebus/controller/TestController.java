package pers.panqt.springcloudmessagebus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.panqt.springcloudmessagebus.service.RabbitmqService;

/**  @author panqt 2019/04/10 2:02
 *   
 */
@Slf4j
//@RefreshScope
@RestController
public class TestController {

    @Autowired
    RabbitmqService rabbitmqService;

    @GetMapping("rabbitmq/{id}")
    public ResponseEntity getOne(@PathVariable("id") String id){
        rabbitmqService.sendToDirect(id);
        return ResponseEntity.ok("OK");
    }
}
