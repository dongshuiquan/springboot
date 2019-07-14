package dsq.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by aa on 2019/7/14.
 */
@Entity
@Table(name = "t_logger_info")
public class LoggerEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ali_id")
    private Long id;

    @Column(name = "ali_client_ip")
    private String clientIp;

    @Column(name = "ali_uri")
    private String url;

    @Column(name = "ali_type")
    private String type;

    @Column(name = "ali_method")
    private String method;

    @Column(name = "ali_param_data")
    private String paramData;

    @Column(name = "ali_session_id")
    private String sessoinId;

    @Column(name = "ali_time", insertable = false)
    private Timestamp time;

    @Column(name = "ali_return_time")
    private String returnTime;

    @Column(name = "ali_return_data")
    private String returnData;

    @Column(name = "ali_time_consuming")
    private String timeConsuming;

    @Column(name = "ali_http_status_code")
    private String httpStatusCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getSessoinId() {
        return sessoinId;
    }

    public void setSessoinId(String sessoinId) {
        this.sessoinId = sessoinId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public String getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(String timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}
