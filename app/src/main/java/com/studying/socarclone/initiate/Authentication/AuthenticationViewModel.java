package com.studying.socarclone.initiate.Authentication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.studying.socarclone.DTO.UserDTO;

import java.util.List;

public class AuthenticationViewModel {
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
