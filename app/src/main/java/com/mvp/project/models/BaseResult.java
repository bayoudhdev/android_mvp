package com.mvp.project.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bayoudh on 25/10/2016.
 */

public class BaseResult implements Parcelable {
    public static final Creator<BaseResult> CREATOR = new Creator<BaseResult>() {
        @Override
        public BaseResult createFromParcel(Parcel in) {
            return new BaseResult(in);
        }

        @Override
        public BaseResult[] newArray(int size) {
            return new BaseResult[size];
        }
    };
    private int status;
    private String textStatus;

    protected BaseResult(Parcel in) {
        status = in.readInt();
        textStatus = in.readString();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTextStatus() {
        return textStatus;
    }

    public void setTextStatus(String textStatus) {
        this.textStatus = textStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(status);
        dest.writeString(textStatus);
    }
}
