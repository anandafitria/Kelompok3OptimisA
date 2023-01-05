package com.example.kelompok3optimisa.datamodels;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListLogbookResponse{

    @SerializedName("report_title")
    private String reportTitle;

    @SerializedName("end_at")
    private String endAt;

    @SerializedName("link_seminar")
    private Object linkSeminar;

    @SerializedName("proposal_id")
    private int proposalId;

    @SerializedName("attendees_list")
    private Object attendeesList;

    @SerializedName("supervisor_id")
    private Object supervisorId;

    @SerializedName("news_event")
    private String newsEvent;

    @SerializedName("seminar_room_id")
    private int seminarRoomId;

    @SerializedName("certificate")
    private Object certificate;

    @SerializedName("logbooks")
    private List<LogbooksItem> logbooks;

    @SerializedName("student_id")
    private int studentId;

    @SerializedName("created_at")
    private Object createdAt;

    @SerializedName("start_at")
    private Object startAt;

    @SerializedName("cancellation_reason")
    private String cancellationReason;

    @SerializedName("internship_score")
    private Object internshipScore;

    @SerializedName("seminar_date")
    private String seminarDate;

    @SerializedName("report_receipt")
    private Object reportReceipt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("grade")
    private String grade;

    @SerializedName("work_report")
    private Object workReport;

    @SerializedName("seminar_deadline")
    private Object seminarDeadline;

    @SerializedName("id")
    private int id;

    @SerializedName("activity_report")
    private Object activityReport;

    @SerializedName("status")
    private int status;

    public String getReportTitle(){
        return reportTitle;
    }

    public String getEndAt(){
        return endAt;
    }

    public Object getLinkSeminar(){
        return linkSeminar;
    }

    public int getProposalId(){
        return proposalId;
    }

    public Object getAttendeesList(){
        return attendeesList;
    }

    public Object getSupervisorId(){
        return supervisorId;
    }

    public String getNewsEvent(){
        return newsEvent;
    }

    public int getSeminarRoomId(){
        return seminarRoomId;
    }

    public Object getCertificate(){
        return certificate;
    }

    public List<LogbooksItem> getLogbooks(){
        return logbooks;
    }

    public int getStudentId(){
        return studentId;
    }

    public Object getCreatedAt(){
        return createdAt;
    }

    public Object getStartAt(){
        return startAt;
    }

    public String getCancellationReason(){
        return cancellationReason;
    }

    public Object getInternshipScore(){
        return internshipScore;
    }

    public String getSeminarDate(){
        return seminarDate;
    }

    public Object getReportReceipt(){
        return reportReceipt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public String getGrade(){
        return grade;
    }

    public Object getWorkReport(){
        return workReport;
    }

    public Object getSeminarDeadline(){
        return seminarDeadline;
    }

    public int getId(){
        return id;
    }

    public Object getActivityReport(){
        return activityReport;
    }

    public int getStatus(){
        return status;
    }
}