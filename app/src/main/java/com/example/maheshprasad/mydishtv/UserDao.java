package com.example.maheshprasad.mydishtv;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert
    void insertAll(User... users);

}
