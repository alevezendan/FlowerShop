package report;

public class ReportFactory {
    public Report getReport(String reportType){
        if(reportType == null){
            return null;
        }
        if(reportType.equalsIgnoreCase("CSV")){
            return new CSVReport();

        } else if(reportType.equalsIgnoreCase("JSON")) {
            System.out.println("JSON");
            return new JSONReport();
        }
        return null;
    }
}
