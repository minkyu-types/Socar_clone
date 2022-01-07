package com.studying.socarclone.sign.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.studying.socarclone.DTO.UserDTO;

import java.util.List;

public class LoginViewModel extends ViewModel {
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