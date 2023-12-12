//package lv.dong.Dev.common;
//
//import cn.hutool.core.io.file.FileReader;
//import cn.hutool.core.text.csv.CsvUtil;
//import cn.hutool.core.text.csv.CsvWriter;
//import cn.hutool.core.util.CharsetUtil;
//import cn.hutool.db.Db;
//import cn.hutool.db.Entity;
//import com.alibaba.fastjson2.JSON;
//import com.alibaba.fastjson2.JSONObject;
//import com.github.javafaker.Faker;
//import com.jayway.jsonpath.JsonPath;
//import lombok.extern.slf4j.Slf4j;
//import org.jetbrains.annotations.NotNull;
//import java.nio.charset.StandardCharsets;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import static cn.data.Generator.utils.RSAUtil.GetSign;
//
///**
// * @author Donglee
// * @version 1.0
// * @description: TODO
// * @date 2023/11/6 15:05
// */
//@Slf4j
//public class Common {
//    private static final String FILE_PATH = "\\src\\main\\java\\cn\\iui\\autoTest\\";
//
//    private Common() {
//    }
//
//    /***
//     /**
//     * @description:获取用例路径
//     * @author: DongLee
//     */
//    @NotNull
//    public static String getFilePath(String path) {
////        var filePath = System.getProperty("user.dir" + FILE_PATH);
//        String filePath = System.getProperty("user.dir");
//        String filePath1 = filePath + FILE_PATH;
//        log.info("获取参数化文件路径" + filePath1);
//        return filePath1;
//    }
//
//    @NotNull
//    public static String getFilePath(String path, String name) {
//        String filePath = System.getProperty("user.dir");
//        String filePath1 = filePath + FILE_PATH + path + name;
//        log.info("获取参数化文件路径" + filePath1 + path + name);
//        return filePath1;
//    }
//
//    /***
//     /**
//     * @description:数据生成器
//     * @author: DongLee
//     */
//    public static Faker faker() {
//        return new Faker(new Locale("zh-CN"));
//    }
//
//    // 字节加解密
//    public static String zjj(JSONObject jsonObj, String FILEPATH, String shouxinURL) throws Exception {
//
//        String shouxinstr = JSON.toJSONString(jsonObj);
//        byte[] shouxinbyte = shouxinstr.getBytes(StandardCharsets.UTF_8);
//        // 加密报文体
//        String encryptBizContent = new String(cn.data.Generator.utils.RSAUtil.encrypt(shouxinbyte, FILEPATH + "gt_bytedance_public_key.pem"));
//        TreeMap<String, String> postbody = new TreeMap<>();
//        postbody.put("merchantId", "10000225");
//        postbody.put("transSeqNo", "123456");
//        postbody.put("transReqTime", "20060102150405");
//        postbody.put("version", "1.0");
//        postbody.put("bizContent", encryptBizContent);
//        String SALT = "xjyQELjGDUV0kEbqwFGHdcI3VZ7d1nZ9";
//        // 抖音月付
//        String salt = "xjyQELjGDUV0kEbqwFGHdcI3VZ7d1nZ9";
//        postbody.put("sign", GetSign(postbody, SALT));
//        String postbodystr = JSON.toJSONString(postbody);
//        String res = cn.data.Generator.utils.HpUtils.doPost(postbodystr, shouxinURL);
//        Object bizContentv = JSON.parseObject(res).get("bizContent");
//        String encryptedData = JSON.toJSONString(bizContentv);
//        String dres = new String(cn.data.Generator.utils.RSAUtil.decrypt(encryptedData.getBytes(StandardCharsets.UTF_8), FILEPATH + "gt_bytedance_privite_key.pem"));
//        return dres;
//    }
//
//    //读取报文
//    public static JSONObject getBody(String filepath) {
//        FileReader fileReader = new FileReader(filepath);
//        String bodystr = fileReader.readString();
//        return JSON.parseObject(bodystr);
//    }
//
//    /*
//     * csv生成器
//     * */
//    public static CsvWriter gencsv(String fielPathcsv, String filenamecsv) {
//        return CsvUtil.getWriter(fielPathcsv + filenamecsv, CharsetUtil.CHARSET_UTF_8);
//    }
//
//    /*
//     * 根据k获取报文v
//     *
//     * */
//    public static Object getB(String filepathgetb, String filename, String keyname) {
//        JSONObject body = Common.getBody(filepathgetb + filename);
//        Object read = JsonPath.read(body, keyname);
//        return read;
//    }
//
//    //    获取日期
//    public static String getdata() {
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//        return simpleDateFormat.format(date);
//    }
//
//    // 插入sql，用实体
//    public static int insertEntity(Object pojo) throws SQLException {
//        Entity interestRateentity = Entity.parse(pojo);
//        return Db.use().insertOrUpdate(interestRateentity);
//    }
//}
//
//
