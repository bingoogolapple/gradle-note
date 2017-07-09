package cn.bingoogol.gradle.m1.dto;

import java.io.Serializable;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/9 下午12:08
 * 描述:
 */
public class AjaxObj implements Serializable {
    /**
     * 是否成功
     */
    private boolean success = false;
    /**
     * 提示信息
     */
    private String msg = "";
    /**
     * 附加对象，用来存储一些特定的返回信息
     */
    private Object obj = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
