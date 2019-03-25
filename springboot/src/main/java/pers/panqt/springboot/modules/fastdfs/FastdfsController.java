package pers.panqt.springboot.modules.fastdfs;

import com.github.tobato.fastdfs.conn.FdfsWebServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.entry.FastdfsFile;
import pers.panqt.springboot.modules.mybatis.FastdfsFileMapper;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *  @time       2019年03月14日	3:31
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
@RequestMapping("/fastdfs")
public class FastdfsController {

    public String webServerUrl;
    @Autowired
    public void setWebServerUrl(FdfsWebServer fdfsWebServer){
        webServerUrl = fdfsWebServer.getWebServerUrl();
    }

    @Autowired
    FastdfsFileMapper fastdfsFileMapper;

    @Autowired
    private FastdfsClient fdfsClient;


    /**  MultipartFile 文件上传
     */
    @PostMapping("/upload-mu")
    public ResultVo<String> upload(@RequestParam("file") MultipartFile file) throws Exception {

        String visitUrl = fdfsClient.uploadFile(file);

        fastdfsFileMapper.insert(visitUrl.substring(webServerUrl.length()));

        return new ResultVo(visitUrl);
    }

    /**  base64 格式的文件上传
     */
    @PostMapping("/upload-base64")
    public ResultVo<String> uploadBase64(@RequestBody FastdfsFile image) {

        String visitUrl = fdfsClient.uploadFile(image.getBase64Text(),image.getExName());

        fastdfsFileMapper.insert(visitUrl.substring(webServerUrl.length()));

        return new ResultVo(visitUrl);
    }

    /**  base64 格式的文件下载
     */
    @PostMapping("/download-base64")
    public ResultVo<String> downloadase64(@RequestBody FastdfsFile image, HttpServletResponse response) throws Exception{

        byte[] data = fdfsClient.download(image.getVisitUrl().substring(image.getVisitUrl().indexOf("group")));

        return new ResultVo(new String(data,StandardCharsets.UTF_8));
        //return new ResultVo(new String(data,"utf-8"));
    }


    /**  删除 fastdfs所有文件 与 数据库的所有 fileid
     */
    @PostMapping("/deleteAll")
    public ResultVo<String> deleteAll(){
        List<FastdfsFile> list =  fastdfsFileMapper.findAll();
        for (FastdfsFile s : list){
            fdfsClient.deleteFile(s.getFileId());
            fastdfsFileMapper.delete(s.getFileId());
        }
        return new ResultVo("delete complete");
    }


}