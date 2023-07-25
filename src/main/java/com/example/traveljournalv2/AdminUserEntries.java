package com.example.traveljournalv2;

public class AdminUserEntries {
    private String Flagging_Email;

    private int Flagged_Journal_ID;

    private int Harassment;

    private int Explicit;
    private int Topic;

    public String getFlagging_Email() {
        return Flagging_Email;
    }
    public void setFlagging_Email(String Flagging_Email) {
        this.Flagging_Email = Flagging_Email;
    }

    public int getFlagged_Journal_ID() {
        return Flagged_Journal_ID;
    }

    public void setFlagged_Journal_ID(int Flagged_Journal_ID) {

        this.Flagged_Journal_ID = Flagged_Journal_ID;
    }

    public int getHarassment() {
        return Harassment;
    }

    public void setHarassment(int Harassment) {
        this.Harassment = Harassment;
    }

    public int getExplicit() {
        return Explicit;
    }

    public void setExplicit(int Explicit) {
        this.Explicit = Explicit;
    }

    public int getTopic() {
        return Topic;
    }

    public void setTopic(int Topic) {
        this.Topic = Topic;
    }


    public AdminUserEntries(String Flagging_Email, int Flagged_ID, int Harassment, int Explicit, int Topic) {
        this.Flagging_Email = Flagging_Email;
        this.Flagged_Journal_ID = Flagged_ID;
        this.Harassment = Harassment;
        this.Explicit = Explicit;
        this.Topic = Topic;
    }
}
