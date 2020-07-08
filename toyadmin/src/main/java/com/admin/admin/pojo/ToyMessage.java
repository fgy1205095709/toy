package com.admin.admin.pojo;

import java.util.Date;

public class ToyMessage {
    private Integer mId;

    private Integer mType;

    private Integer mSendmId;

    private String mTitle;

    private String mContent;

    private Date mTime;

    private Integer mBsendId;

    private Integer mState;

    private Integer mParent;

    private String mMessage;

    private String mMark;

    private String mOne;

    private String mTwo;

    private String mThree;
    private ToyAdmin toyAdmin;
    public ToyAdmin getToyAdmin() {
        return toyAdmin;
    }
    public void setToyAdmin(ToyAdmin toyAdmin) {
        this.toyAdmin = toyAdmin;
    }

    private ToyUser toyUser;
    public ToyUser getToyUser() {
        return toyUser;
    }
    public void setToyUser(ToyUser toyUser) {
        this.toyUser = toyUser;
    }



    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getmType() {
        return mType;
    }

    public void setmType(Integer mType) {
        this.mType = mType;
    }

    public Integer getmSendmId() {
        return mSendmId;
    }

    public void setmSendmId(Integer mSendmId) {
        this.mSendmId = mSendmId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle == null ? null : mTitle.trim();
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent == null ? null : mContent.trim();
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public Integer getmBsendId() {
        return mBsendId;
    }

    public void setmBsendId(Integer mBsendId) {
        this.mBsendId = mBsendId;
    }

    public Integer getmState() {
        return mState;
    }

    public void setmState(Integer mState) {
        this.mState = mState;
    }

    public Integer getmParent() {
        return mParent;
    }

    public void setmParent(Integer mParent) {
        this.mParent = mParent;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage == null ? null : mMessage.trim();
    }

    public String getmMark() {
        return mMark;
    }

    public void setmMark(String mMark) {
        this.mMark = mMark == null ? null : mMark.trim();
    }

    public String getmOne() {
        return mOne;
    }

    public void setmOne(String mOne) {
        this.mOne = mOne == null ? null : mOne.trim();
    }

    public String getmTwo() {
        return mTwo;
    }

    public void setmTwo(String mTwo) {
        this.mTwo = mTwo == null ? null : mTwo.trim();
    }

    public String getmThree() {
        return mThree;
    }

    public void setmThree(String mThree) {
        this.mThree = mThree == null ? null : mThree.trim();
    }
}