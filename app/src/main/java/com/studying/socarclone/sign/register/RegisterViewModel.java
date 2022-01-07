package com.studying.socarclone.sign.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.studying.socarclone.DTO.UserDTO;

import java.util.List;

public class RegisterViewModel {
    private MutableLiveData<List<UserDTO>> users;
    public LiveData<List<UserDTO>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<List<UserDTO>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
    }
}
