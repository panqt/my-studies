package pers.panqt.springboot.cluster;

import com.github.tobato.fastdfs.conn.FdfsWebServer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.entry.RabbitMqMessage;
import pers.panqt.springboot.entry.User;
import pers.panqt.springboot.modules.fastdfs.FastdfsClient;
import pers.panqt.springboot.modules.mybatis.FastdfsFileMapper;
import pers.panqt.springboot.modules.mybatis.UserMapper;
import pers.panqt.springboot.modules.rabbitmq.RabbitmqService;
import pers.panqt.springboot.modules.redis.RedisService;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**  @author panqt 2019/03/27 21:00
 *   集群高可用测试
 */
@Slf4j
public class ClusterHaTest extends BaseTest {
    public String webServerUrl;
    @Autowired
    public void setWebServerUrl(FdfsWebServer fdfsWebServer){
        webServerUrl = fdfsWebServer.getWebServerUrl();
    }

    @Autowired
    RedisService redisService;

    @Autowired
    FastdfsClient fastdfsClient;

    @Autowired
    FastdfsFileMapper fastdfsFileMapper;

    @Autowired
    private RabbitmqService rabbitmqService;


    /** 测试 FastDFS 下载
     */
    @Test
    public void fastdfs() {
        int i = 0;
        while (true){
            try {
                i++;
                Thread.sleep(1000);
                byte[] bytes = fastdfsClient.download("group1/M00/00/01/wKhkZFybXeKAeCHFAAu7l3qCNkw231.jpg");
                System.out.println(i);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

    }

    /** 测试 FastDFS 上传
     */
    @Test
    public void uploadBase64(){
        int i = 0;
        String base64Text = getBase64Str();
        String exName = "jpeg";
        while (true){
            try {
                i++;
                Thread.sleep(500);
                String visitUrl = fastdfsClient.uploadFile(base64Text,exName);
                System.out.println(visitUrl);
                fastdfsFileMapper.insert(visitUrl.substring(webServerUrl.length()));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /** 测试 Redis
     */
    @Test
    public void testRedis()throws Exception{
        int i = 100000;
        while (true) {
            try {
                i++;
                Thread.sleep(1000);
                redisService.setValue(i+"", i);
                System.out.println(i+": "+redisService.getValue(i+""));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /** 测试 Jedis 连接 Redis
     */
    @Test
    public void testJedis(){
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("centos-100", 6379));
        jedisClusterNodes.add(new HostAndPort("centos-101", 6379));
        jedisClusterNodes.add(new HostAndPort("centos-102", 6379));
        jedisClusterNodes.add(new HostAndPort("centos-103", 6379));
        jedisClusterNodes.add(new HostAndPort("centos-100", 6380));
        jedisClusterNodes.add(new HostAndPort("centos-102", 6380));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);

        int i = 100000;
        while (true) {
            try {
                i++;
                Thread.sleep(200);
                jc.set(i+"", i+"");
                System.out.println(i+": "+jc.get(i+""));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /** 测试 Rabbitmq
     */
    @Test
    public void sendTotopic() throws Exception{
        int i = 0;
        while (true){
            try {
                i++;
                Thread.sleep(200);
                rabbitmqService.sendTotopic(new RabbitMqMessage(i+": 广州有个大新闻", "guangzhou.news"));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    /** 测试 ElasticSearch 储存
     */
    @Autowired
    TxtElasticRepository txtElasticRepository;
    @Test
    public void esSave()throws Exception{
        FileReader fileReader = new FileReader("C:\\Users\\panqt\\Desktop\\1.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileReader fileReader2 = new FileReader("C:\\Users\\panqt\\Desktop\\2.txt");
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        String line;
        String line2;
        int id = 0;
        int lineNo = 0;
        while ((line = bufferedReader.readLine()) != null && (line2 = bufferedReader2.readLine()) != null){
            try {
                lineNo++;
                if(StringUtils.isEmpty(line))continue;
                //Thread.sleep(100);

                line = line.trim();
                line2 = line2.trim();
                line.replace("\\r","");
                line.replace("\\t","");
                line2.replace("\\r","");
                line2.replace("\\t","");


                id++;
                Txt txt = new Txt();
                txt.setId(id);
                txt.setLineNo(lineNo);
                txt.setTxt(line);
                txt.setTxt2(line2);
                txt.setSummary(line.substring(0,line.length()>20?10:line.length()/2+1));

                System.out.println(line.substring(0,line.length()>20?10:line.length()/2+1));
                txtElasticRepository.save(txt);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /** 测试 ElasticSearch 查找
     */
    @Test
    public  void esFind(){
        try {
            long start = System.currentTimeMillis();
            System.out.println();
            List<Txt> txts= txtElasticRepository.findByTxtLike("抬腿便往外走");
            System.out.println(System.currentTimeMillis()-start);
            for(Txt txt : txts){
                System.out.println(txt);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /** 测试 mysql insert
     */
    @Autowired
    UserMapper userMapper;
    @Test
    public void mysqlinsert()throws Exception{
        int i = 0;
        while (i<35000){
            try {
                i++;
                //Thread.sleep(50);
                Optional<Txt> optional = txtElasticRepository.findById(i);
                if(optional.isPresent()){
                    User user = new User();
                    user.setUserName(optional.get().getSummary().trim());
                    user.setCreateTime(new Timestamp(System.currentTimeMillis()));
                    user.setDepartmentId(i%20 +1);
                    user.setRoleId(i%10 +1);
                    userMapper.insert(user);
                    System.out.println(user);
                }else {
                    System.out.println("等等。。。");
                    Thread.sleep(5000);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /** 测试 mysql Select
     */
    @Test
    public void mysqlSelect()throws Exception{
        while (true){
            try {
                //Thread.sleep(100);
                User user = userMapper.selectById(2*(int)(Math.random()*17500));
                System.out.println(user);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public String getBase64Str(){
        return "data:image/jpeg;base64,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";
    }
}
