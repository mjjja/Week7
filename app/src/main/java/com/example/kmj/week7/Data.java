package com.example.kmj.week7;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KMJ on 2017-04-06.
 */

public class Data implements Parcelable {
    public String Name;
    public String Category;
    public String Tel;
    public String Menu1;
    public String Menu2;
    public String Menu3;
    public String Homepage;
    public String Date;
    public Data (String Name, String Category, String Tel, String Menu1, String Menu2, String Menu3, String Homepage, String Date) {
        this.Name = Name;
        this.Tel = Tel;
        this.Menu1 = Menu1;
        this.Menu2 = Menu2;
        this.Menu3 = Menu3;
        this.Homepage = Homepage;
        this.Date = Date;
        this.Category = Category;
    }

    protected Data(Parcel in) {
        Name = in.readString();
        Category = in.readString();
        Tel = in.readString();
        Menu1 = in.readString();
        Menu2 = in.readString();
        Menu3 = in.readString();
        Homepage = in.readString();
        Date = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Category);
        dest.writeString(Tel);
        dest.writeString(Menu1);
        dest.writeString(Menu2);
        dest.writeString(Menu3);
        dest.writeString(Homepage);
        dest.writeString(Date);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getMenu1() {
        return Menu1;
    }

    public void setMenu1(String menu1) {
        Menu1 = menu1;
    }

    public String getMenu2() {
        return Menu2;
    }

    public void setMenu2(String menu2) {
        Menu2 = menu2;
    }

    public String getMenu3() {
        return Menu3;
    }

    public void setMenu3(String menu3) {
        Menu3 = menu3;
    }

    public String getHomepage() {
        return Homepage;
    }

    public void setHomepage(String homepage) {
        Homepage = homepage;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return Name;
    }
}
