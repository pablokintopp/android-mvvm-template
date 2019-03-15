package com.kintopp.pablo.androidmvvmtemplate.data.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kintopp.pablo.androidmvvmtemplate.data.model.User;

import java.lang.reflect.Type;

import androidx.room.TypeConverter;

public class UserTypeConverter {

    @TypeConverter
    public User fromString(String value) {
        Type type = new TypeToken<User>() {}.getType();
        User user = new Gson().fromJson(value, type);
        return user;
    }

    @TypeConverter
    public String fromUser(User user) {
        return new Gson().toJson(user);
    }
}
