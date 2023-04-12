package az.orient.com.enums;

public enum ErrorCodeEnum {


    EMPLOYYE_NOT_FOUND(101,"can not find employee with given id"),

    VALIDATION_ERROR(102,"Validation errors");




    private final String message;
    private final int code;

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    ErrorCodeEnum(int code ,String message) {
        this.message = message;
        this.code=code;
    }
}
