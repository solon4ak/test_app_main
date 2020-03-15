package ru.solon4ak.test_app_main.model;

public class SummaryInfo {
    private int eventCount;
    private int warningCount;
    private int errorCount;

    public SummaryInfo(int eventCount, int warningCount, int errorCount) {
        this.eventCount = eventCount;
        this.warningCount = warningCount;
        this.errorCount = errorCount;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public int getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(int warningCount) {
        this.warningCount = warningCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    @Override
    public String toString() {
        return "SummaryInfo{" +
                "eventCount=" + eventCount +
                ", warningCount=" + warningCount +
                ", errorCount=" + errorCount +
                '}';
    }
}
