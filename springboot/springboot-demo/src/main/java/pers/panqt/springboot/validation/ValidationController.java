package pers.panqt.springboot.validation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pers.panqt.springboot.entry.Person;

import javax.validation.Valid;

/**
 *  @time       2019年02月01日	19:01
 *	@author     panqt
 *
 *	@comment    参数校验
 */
@RestController
public class ValidationController {

    @PostMapping("validation")
    public String validation(@RequestBody @Valid Person person){
        System.out.println(person);
        return person.toString();
    }
}
