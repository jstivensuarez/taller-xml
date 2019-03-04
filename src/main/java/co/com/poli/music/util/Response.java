package co.com.poli.music.util;

public class Response {

    private Object body;
    private String message;
    private int code;
    private boolean status;

    public Response() {
        code = 200;
        status = true;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object responseBody) {
        this.body = responseBody;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int codeResponse) {
        this.code = codeResponse;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
