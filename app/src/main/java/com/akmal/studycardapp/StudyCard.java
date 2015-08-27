package com.akmal.studycardapp;

import android.os.Parcel;
import android.os.Parcelable;

public class StudyCard implements Parcelable {

    String question;
    String[] choices;
    int answerIndex;

    public StudyCard(String question, String[] choices, int answerIndex) {
        this.question = question;
        this.choices = choices;
        this.answerIndex = answerIndex;
    }

    @Override
    public String toString() {
        return question;
    }

    public static final Parcelable.Creator<StudyCard> CREATOR = new Parcelable.Creator<StudyCard>() {
        public StudyCard createFromParcel(Parcel in) {
            return new StudyCard(in);
        }

        public StudyCard[] newArray(int size) {
            return new StudyCard[size];
        }
    };

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(question);
        out.writeStringArray(choices);
        out.writeInt(answerIndex);
    }

    public StudyCard(Parcel in) {
        question = in.readString();
        choices = new String[4];
        in.readStringArray(choices);
        answerIndex = in.readInt();
    }

    public int describeContents() {
        return 0;
    }
}
