package com.kejichu.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kejichu.common.annotation.Excel;
import com.kejichu.common.core.domain.BaseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 教师信息对象 kjc_user
 * 
 * @author sxl
 * @date 2021-08-30
 */
@RestControllerAdvice
public class KjcUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教师表id */
    private Long userId;

    /** 教师工号 */
    @Excel(name = "教师工号")
    private Long userJsgh;

    /** 姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 学院 */
    @Excel(name = "学院", readConverterExp =
            "1=计算机科学与信息工程学院,2=化工与环境工程学院,3=材料科学与工程学院," +
                    "4=城市建设与安全工程学院,5=机械工程学院,6=电气与电子工程学院," +
                    "7=经济与管理学院,8=人文学院,9=艺术与设计学院,10=生态技术与工程学院," +
                    "11=外国语学院,12=理学院,13=香料香精化妆品学部（香料香精技术与工程学院）," +
                    "14=轨道交通学院,15=体育教育部,16=工程创新学院,17=高等职业学院,18=继续教育学院，" +
                    "19=马克思主义学院,20=国际教育中心,21=香料香精化妆品学部（国际化妆品学院）," +
                    "22=香料香精化妆品学部（东方美谷研究院）,23=香料香精化妆品省部共建协同创新中心")
    private String userCollege;

    /** 出生年月 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生年月", width = 30, dateFormat = "yyyy-MM-dd")
    private Date userBirth;

    /** 职称 教授,1
     副教授,3
     讲师,5
     助教,6
     高级工程师,2
     工程师,4
     */
    @Excel(name = "职称", readConverterExp ="1=教授,2=高级工程师,3=副教授,4=工程师,5=讲师,6=助教")
    private String userZhicheng;

    /** 毕业学校 */
    @Excel(name = "毕业学校")
    private String userSchool;

    /** 最高学位 */
    @Excel(name = "最高学位", readConverterExp ="1=博士,2=硕士,3=学士")
    private String userDegree;

    /** 状态（离职、在岗） */
    @Excel(name = "状态", readConverterExp = "0=离职,1=在岗")
    private String userStatus;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserJsgh(Long userJsgh) 
    {
        this.userJsgh = userJsgh;
    }

    public Long getUserJsgh() 
    {
        return userJsgh;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserCollege(String userCollege) 
    {
        this.userCollege = userCollege;
    }

    public String getUserCollege() 
    {
        return userCollege;
    }
    public void setUserBirth(Date userBirth) 
    {
        this.userBirth = userBirth;
    }

    public Date getUserBirth() 
    {
        return userBirth;
    }
    public void setUserZhicheng(String userZhicheng) 
    {
        this.userZhicheng = userZhicheng;
    }

    public String getUserZhicheng() 
    {
        return userZhicheng;
    }
    public void setUserSchool(String userSchool) 
    {
        this.userSchool = userSchool;
    }

    public String getUserSchool() 
    {
        return userSchool;
    }
    public void setUserDegree(String userDegree) 
    {
        this.userDegree = userDegree;
    }

    public String getUserDegree() 
    {
        return userDegree;
    }
    public void setUserStatus(String userStatus) 
    {
        this.userStatus = userStatus;
    }

    public String getUserStatus() 
    {
        return userStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("userJsgh", getUserJsgh())
            .append("userName", getUserName())
            .append("userCollege", getUserCollege())
            .append("userBirth", getUserBirth())
            .append("userZhicheng", getUserZhicheng())
            .append("userSchool", getUserSchool())
            .append("userDegree", getUserDegree())
            .append("userStatus", getUserStatus())
            .toString();
    }
}
