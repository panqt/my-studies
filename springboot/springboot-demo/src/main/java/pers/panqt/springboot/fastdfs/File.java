package pers.panqt.springboot.fastdfs;

/**
 *  @time       2019年03月18日	5:13
 *	@author     panqt
 *
 *	@comment    
 */
public class File {
    //图片base64字符串
    private String base65Text;
    //图片后缀
    private String exName;

    private String visitUrl;

    private String fileId;

    public String getBase65Text() {
        return base65Text;
    }

    public void setBase65Text(String base65Text) {
        this.base65Text = base65Text;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
