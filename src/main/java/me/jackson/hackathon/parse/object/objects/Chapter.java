package me.jackson.hackathon.parse.object.objects;

import me.jackson.hackathon.parse.object.ParsedObject;

/**
 * An object that will be parsed from the CSV file to act as a container to a chapter.
 *
 * @author Jackson Ellsworth
 * @since 11/15/2019
 */
public class Chapter implements ParsedObject {

    /**
     * The chapter's unique key.
     *
     * <p>
     * Immutable because the type is an authentication measure.
     * </p>
     */
    private final int chapterID;

    /**
     * The name of the chapter's school.
     */
    private String school;

    /**
     * The addresses of the school.
     */
    private String mainAddress, alternateAddress;

    /**
     * The school phone number.
     */
    private String phone;

    /**
     * The adviser information for the chapter.
     */
    private String primaryAdviser, primaryAdviserEmail, secondaryAdviser, secondaryAdviserEmail, tertiaryAdviser, tertiaryAdviserEmail;

    public Chapter(int chapterID, String school, String mainAddress, String alternateAddress, String phone, String primaryAdviser, String primaryAdviserEmail, String secondaryAdviser, String secondaryAdviserEmail, String tertiaryAdviser, String tertiaryAdviserEmail) {
        this.chapterID = chapterID;
        this.school = school;
        this.mainAddress = mainAddress;
        this.alternateAddress = alternateAddress;
        this.phone = phone;
        this.primaryAdviser = primaryAdviser;
        this.primaryAdviserEmail = primaryAdviserEmail;
        this.secondaryAdviser = secondaryAdviser;
        this.secondaryAdviserEmail = secondaryAdviserEmail;
        this.tertiaryAdviser = tertiaryAdviser;
        this.tertiaryAdviserEmail = tertiaryAdviserEmail;
    }

    public Chapter(int chapterID, String school, String mainAddress, String alternateAddress, String phone, String primaryAdviser, String primaryAdviserEmail, String secondaryAdviser, String secondaryAdviserEmail) {
        this.chapterID = chapterID;
        this.school = school;
        this.mainAddress = mainAddress;
        this.alternateAddress = alternateAddress;
        this.phone = phone;
        this.primaryAdviser = primaryAdviser;
        this.primaryAdviserEmail = primaryAdviserEmail;
        this.secondaryAdviser = secondaryAdviser;
        this.secondaryAdviserEmail = secondaryAdviserEmail;
    }

    public Chapter(int chapterID, String school, String mainAddress, String alternateAddress, String phone, String primaryAdviser, String primaryAdviserEmail) {
        this.chapterID = chapterID;
        this.school = school;
        this.mainAddress = mainAddress;
        this.alternateAddress = alternateAddress;
        this.phone = phone;
        this.primaryAdviser = primaryAdviser;
        this.primaryAdviserEmail = primaryAdviserEmail;
    }

    public int getChapterID() {
        return chapterID;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String getAlternateAddress() {
        return alternateAddress;
    }

    public void setAlternateAddress(String alternateAddress) {
        this.alternateAddress = alternateAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrimaryAdviser() {
        return primaryAdviser;
    }

    public void setPrimaryAdviser(String primaryAdviser) {
        this.primaryAdviser = primaryAdviser;
    }

    public String getPrimaryAdviserEmail() {
        return primaryAdviserEmail;
    }

    public void setPrimaryAdviserEmail(String primaryAdviserEmail) {
        this.primaryAdviserEmail = primaryAdviserEmail;
    }

    public String getSecondaryAdviser() {
        return secondaryAdviser;
    }

    public void setSecondaryAdviser(String secondaryAdviser) {
        this.secondaryAdviser = secondaryAdviser;
    }

    public String getSecondaryAdviserEmail() {
        return secondaryAdviserEmail;
    }

    public void setSecondaryAdviserEmail(String secondaryAdviserEmail) {
        this.secondaryAdviserEmail = secondaryAdviserEmail;
    }

    public String getTertiaryAdviser() {
        return tertiaryAdviser;
    }

    public void setTertiaryAdviser(String tertiaryAdviser) {
        this.tertiaryAdviser = tertiaryAdviser;
    }

    public String getTertiaryAdviserEmail() {
        return tertiaryAdviserEmail;
    }

    public void setTertiaryAdviserEmail(String tertiaryAdviserEmail) {
        this.tertiaryAdviserEmail = tertiaryAdviserEmail;
    }
}