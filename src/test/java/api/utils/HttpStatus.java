package api.utils;

public enum HttpStatus {

    CONTINUE_CODE_100(100, "Continue"),
    SWITCHING_PROTOCOL_CODE_101(101, "Switching Protocols"),
    PROCESSING_CODE_102(102, "Processing"),

    OK_CODE_200(200, "OK"),
    CREATED_CODE_201(201, "Created"),
    ACCEPTED_CODE_202(202, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION_CODE_203(203, "Non-Authoritative Information"),
    NO_CONTENT_CODE_204(204,  "No Content"),
    RESET_CONTENT_CODE_205(205, "Reset Content"),
    PARTIAL_CONTENT_CODE_206(206, "Partial Content"),
    MULTI_STATUS_CODE_207(207, "Multi-Status (WebDAV; RFC 4918"),
    ALREADY_REPORTED_CODE_208(208, "Already Reported (WebDAV; RFC 5842)" ),
    IM_USED_CODE_226(226, "IM Used (RFC 3229)"),

    MULTIPLE_CHOICES_CODE_300(300, "Multiple Choices"),
    MOVED_PERMANENTLY_CODE_301(301, "Moved Permanently"),
    FOUND_CODE_302(302, "Found"),
    SEE_OTHER_CODE_303(303, "See Other (since HTTP/1.1)"),
    NOT_MODIFIED_CODE_304(304, "Not Modified"),
    USE_PROXY_CODE_305(305, "Use Proxy (since HTTP/1.1)"),
    SWITCH_PROXY_CODE_306(306, "Switch Proxy"),
    TEMPORARY_REDIRECT_CODE_307(307, "Temporary Redirect (since HTTP/1.1)"),
    PERMANENT_REDIRECT_CODE_308(308, "Permanent Redirect (approved as experimental RFC)[12]"),

    BAD_REQUEST_CODE_400(400, "Bad Request"),
    UNAUTHORIZED_CODE_401(401, "Unauthorized"),
    PAYMENT_REQUIRED_CODE_402(402, "Payment Required"),
    FORBIDDEN_CODE_403(403, "Forbidden"),
    NOT_FOUND_CODE_404(404, "Not Found"),
    METHOD_NOT_ALLOWED_CODE_405(405, "Method Not Allowed"),
    NOT_ACCEPTABLE_CODE_406(406, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED_CODE_407(407, "Proxy Authentication Required"),
    REQUEST_TIMEOUT_CODE_408(408, "Request Timeout"),
    CONFLICT_CODE_409(409, "Conflict"),
    GONE_CODE_410(410, "Gone"),
    LENGTH_REQUIRED_CODE_411(411, "Length Required"),
    PRECONDITION_FAILED_CODE_412(412, "Precondition Failed"),
    REQUEST_ENTITY_TOO_LARGE_CODE_413(413, "Request Entity Too Large"),
    REQUEST_URI_TOO_LONG_CODE_414(414, "Request-URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE_CODE_(415, "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE_CODE_(416, "Requested Range Not Satisfiable"),
    EXPECTATION_FAILED_CODE_(417, "Expectation Failed"),

    INTERNAL_SERVER_ERROR_CODE_500(500, "Internal Server Error"),
    NOT_IMPLEMENTED_CODE_501(501, "Not Implemented"),
    BAD_GATEWAY_CODE_502(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE_CODE_503(503, "Service Unavailable"),
    GATEWAY_TIMEOUT_CODE_504(504, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED_CODE_505(505, "HTTP Version Not Supported"),
    VARIANT_ALSO_NEGOTIATES_CODE_506(506, "Variant Also Negotiates (RFC 2295)"),
    INSUFFICIENT_STORAGE_CODE_507(507, "Insufficient Storage (WebDAV; RFC 4918)"),
    LOOP_DETECTED_CODE_508(508, "Loop Detected (WebDAV; RFC 5842)"),
    BANDWIDTH_LIMIT_EXCEEDED_CODE_509(509, "Bandwidth Limit Exceeded (Apache bw/limited extension)"),
    NOT_EXTEND_CODE_510(510, "Not Extended (RFC 2774)"),
    NETWORK_AUTHENTICATION_REQUIRED_CODE_511(511, "Network Authentication Required (RFC 6585)"),
    CONNECTION_TIMED_OUT_CODE_522(522, "Connection timed out"),
    PROXY_DECLINED_REQUEST_CODE_523(523, "Proxy Declined Request"),
    TIMEOUT_OCCURRED_CODE_524(524, "A timeout occurred")
    ;

    private int code;
    private String desc;
    private String text;

    HttpStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
        this.text = Integer.toString(code);
    }

    public int getCode() {
        return code;
    }


    public String asText() {
        return text;
    }

    public String getDesc() {
        return desc;
    }

}
