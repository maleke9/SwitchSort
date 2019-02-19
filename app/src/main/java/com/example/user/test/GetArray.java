package com.example.user.test;

import android.os.Parcel;
import android.os.Parcelable;

class Array implements Parcelable{

    int[] numbers;



    public Array(int[] numbers,String pass,int ac){
        numbers=numbers;
    }


    //parcel part
    public Array(Parcel in){
        int[] data= new int[5];

        in.readIntArray(data);
        this.numbers= data;
    }
    @Override
    public int describeContents() {
// TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
// TODO Auto-generated method stub

        dest.writeIntArray(this.numbers);
    }

    public static final Parcelable.Creator<Array> CREATOR= new Parcelable.Creator<Array>() {

        @Override
        public Array createFromParcel(Parcel source) {
// TODO Auto-generated method stub
            return new Array(source);  //using parcelable constructor
        }

        @Override
        public Array[] newArray(int size) {
// TODO Auto-generated method stub
            return new Array[size];
        }
    };

}