package pers.panqt.springboot.fastdfs;

import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;

/**
 *  @time       2019年03月18日	8:33
 *	@author     panqt
 *
 *	@comment    
 */
public class FastdfsTest extends BaseTest {

    @Autowired
    DefaultFastFileStorageClient generateStorageClient;

    @Test
    public void delete(){
        generateStorageClient.deleteFile("group1/M00/00/00/wKjIZVyOvnyADug2AACBq5mm_zk347.jpg");
    }
}
