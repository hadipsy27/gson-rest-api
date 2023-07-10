package com.labs.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.labs.entity.User;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static final String BASE_URL = "https://64ab73960c6d844abedf61e2.mockapi.io";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    @Override
    public List<User> getAllUsers() {
        String url = BASE_URL + "/user";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String json = response.body().string();
                Type userListType = new TypeToken<List<User>>() {}.getType();
                return gson.fromJson(json, userListType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(String id) {
        String url = BASE_URL + "/user/" + id;
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String json = response.body().string();
                return gson.fromJson(json, User.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User addUser(User user) {
        String url = BASE_URL + "/user";
        String json = gson.toJson(user);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseJson = response.body().string();
                return gson.fromJson(responseJson, User.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(String id, User user) {
        String url = BASE_URL + "/user/" + id;
        String json = gson.toJson(user);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseJson = response.body().string();
                return gson.fromJson(responseJson, User.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        String url = BASE_URL + "/user/" + id;
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
