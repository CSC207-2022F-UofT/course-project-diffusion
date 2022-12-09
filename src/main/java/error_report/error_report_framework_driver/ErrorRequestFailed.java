package error_report.error_report_framework_driver;

public class ErrorRequestFailed extends RuntimeException{
    public ErrorRequestFailed(String error){
        super(error);
    }
}
