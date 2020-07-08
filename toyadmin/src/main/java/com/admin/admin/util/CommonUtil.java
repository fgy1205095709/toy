package com.admin.admin.util;


import com.github.pagehelper.PageHelper;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommonUtil {

    public static void startPage(HttpServletRequest request){

        int pageNum=Integer.valueOf(request.getParameter("page"));
        int pageSize=Integer.valueOf(request.getParameter("limit"));
        if (pageSize>0){
            PageHelper.startPage(pageNum, pageSize);
        }
    }
    public static void startPage(Map<String, Object> params) {
        if (null != params) {
            Integer pageNum = (Integer) params.get("page");
            Integer pageSize = (Integer) params.get("limit");
            if (null != pageNum && null != pageSize && pageSize > 0)
                PageHelper.startPage(pageNum, pageSize);
        }
    }

    /**
     * layui 开关值有on,off转为1,0
     * @return
     */
    public static String convertSwitch(String str){
        if ("on".equals(str)){
            return "1";
        }else if ("off".equals(str)){
            return "0";
        }
        return str;
    }

    public static void inScope(String value,String msg,String ...arr){
        boolean isOk=false;
        for(int i=0;i<arr.length;i++){
            if (arr[i].equals(value)){
                isOk=true;
                break;
            }
        }
        if (!isOk){
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * APP端访问地址
     * @param request
     * @param params
     */
    public static void setAccessUrl(HttpServletRequest request, Map<String, Object> params) {
        String url=request.getRequestURL().toString();
        int index=url.indexOf("/qmis/");
        params.put("accessUrl",url.substring(0,index)+"/qmis/common/viewOnline?url=");
    }
    /**
     * web端访问地址
     * @param request
     */
    public static String getWebAccessUrl(HttpServletRequest request) {
        String url=request.getRequestURL().toString();
        url = url.replace("/WEB-INF/views","/a");
        int index=url.indexOf("/qmis/");
        return url.substring(0,index)+"/qmis/common/download?url=";
    }

    /**
     * 判断是否需要清空上下限制
     * 10:文字描述 20：合格判定 30：时间记录 40：时间记录（段时）
     * 50：定值参数 60：范围参数（区间）70：范围参数（有上限）80：范围参数（有下限）
     * @param standardType
     * @return
     */
    public static boolean isNeedClearLimit(String standardType){
        //范围参数（区间）需要上下限值
        if ("60".equals(standardType)){
            return false;
        }
        return true;
    }

    /**
     * 判断是否需要清空参数值
     * @param standardType
     * @return
     */
    public static boolean isNeedClearCertain(String standardType){
        //范围参数（区间）需要上下限值
        if ("40".equals(standardType) || "50".equals(standardType)
                || "60".equals(standardType) || "70".equals(standardType)
                || "80".equals(standardType)){
            return false;
        }
        return true;
    }

    /**
     * 将字符串加上某个数值返回,例：字符串"00123"加1后返回"00124"，仍有前缀0
     * @param string 可以转为数值的字符串,支持超长数值字符串
     * @return
     */
    public static String stringPlusNum(String string,int offset){
        if(string==null)return "";
        int length = string.length();
        if (length >18){//后半部分调用，再拼接前半部分
            String preStr = string.substring(0,length-18);
            String backStr = string.substring(length-18);
            return preStr+strPlusNum(backStr,offset);
        }
        return strPlusNum(string,offset);
    }

    /**
     * 同stringPlusNum，当参数大于Long的最大值时会报错
     * @param str
     * @param offset
     * @return
     */
    public static String strPlusNum(String str,int offset){
        StringBuilder result= new StringBuilder(str);
        try {
            result = new StringBuilder(String.valueOf(Long.parseLong(str) + offset));
            if (result.length()<str.length()){
                while (result.length()<str.length()){
                    result.insert(0, "0");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 根据http前缀和图片名生成照片信息
     * @param pre
     * @param imgStr
     * @return
     */

    /**
     * 将时间转为:1天1时1分形式
     * @param date
     * @return
     */
    public static String timeToDuration(Date date){
        LocalDateTime now=LocalDateTime.now();
        Duration duration = Duration.between(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()), now);
        long mss=duration.toMillis();
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        return days+"天"+hours+"时"+ minutes+"分";
    }

    /**
     * 打印字体设置
     * @return
     * @throws Exception
     */

}
