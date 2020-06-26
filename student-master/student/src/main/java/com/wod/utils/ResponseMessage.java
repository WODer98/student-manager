package com.wod.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：童达
 * @date：2020/6/5 16:14
 */
public class ResponseMessage {
   private String errorCode;
   private String errorMsg;
   private Map<String ,Object> objectMap = new HashMap<>();

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Map<String, Object> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, Object> objectMap) {
        this.objectMap = objectMap;
    }

    public ResponseMessage addObject(String key,Object value){
        this.objectMap.put(key,value);
        return this;
    }

    public static ResponseMessage success(){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setErrorCode("100");
        responseMessage.setErrorMsg("处理成功！");
        return responseMessage;
    }

    public static ResponseMessage error(){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setErrorCode("200");
        responseMessage.setErrorMsg("处理失败！");
        return responseMessage;
    }
}
