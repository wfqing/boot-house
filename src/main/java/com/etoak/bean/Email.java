package com.etoak.bean;

import lombok.Data;

/**
 * Created by wfqing on 2020/4/24.
 */
@Data
public class Email {
    //邮件主题
    private String subject;
    //收件人
    private String receiver;

    //邮件内容
    private String content;

}
