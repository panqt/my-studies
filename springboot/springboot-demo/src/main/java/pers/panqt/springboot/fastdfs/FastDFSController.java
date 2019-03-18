package pers.panqt.springboot.fastdfs;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.panqt.springboot.mybatis.FastdfsFileMapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @time       2019年03月14日	3:31
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
@RequestMapping("/fdfs")
public class FastDFSController {

    @Value("${fdfs.web-server-url}")
    public String webServerUrl;

    @Autowired
    FastdfsFileMapper fastdfsFileMapper;

    @Autowired
    private FastDFSClient fdfsClient;

    @PostMapping("/upload-base64")
    public Map<String, Object> uploadBase64(@RequestBody File image) throws Exception {

        String url = fdfsClient.uploadFile(image.getBase65Text(),image.getExName());

        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "上传成功");
        result.put("url", url);

        return result;
    }

    /**
     * 文件下载
     * @param fileUrl  url 开头从组名开始
     */
    @GetMapping("/download")
    public void download(String fileUrl, HttpServletResponse response) throws Exception {

        byte[] data = fdfsClient.download(fileUrl);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("test.jpg", "UTF-8"));

        // 写出
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.write(data, outputStream);
    }


    @GetMapping("/deleteAll")
    public String deleteAll(){
        List<File> list =  fastdfsFileMapper.findAll();
        for (File s : list){
            fdfsClient.deleteFile(s.getFileId());
        }
        return "delete complete";
    }


    //页面
    @PostMapping("/upload")
    public String upload(@RequestParam("fileName")MultipartFile file, Model model) throws Exception {

        String visitUrl = fdfsClient.uploadFile(file);

        fastdfsFileMapper.insert(visitUrl.substring(webServerUrl.length()));

        return "success";
    }
}