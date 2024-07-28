package com.github.paradoxshub.prandellablog.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.paradoxshub.prandellablog.entity.User;

import java.sql.Timestamp;

public class UpdateUserOutput {
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String email;
    private Long created_by;
    private Long updated_by;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
    private int gender;
    private int age;
    private boolean admin;
    private boolean ban;
    private String avatar;

    public UpdateUserOutput() {
    }


    public UpdateUserOutput(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.avatar = user.getAvatar();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Long created_by) {
        this.created_by = created_by;
    }

    public Long getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Long updated_by) {
        this.updated_by = updated_by;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }

    public void fromUser(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setNickname(user.getNickname());
        this.setEmail(user.getEmail());
        this.setGender(user.getGender());
        this.setAge(user.getAge());
        this.setCreated_at(user.getCreated_at());
        this.setUpdated_at(user.getUpdated_at());
        this.setDeleted_at(user.getDeleted_at());
        this.setAdmin(user.isAdmin());
        this.setBan(user.isBan());
        this.setAvatar(user.getAvatar());
    }

    public static UpdateUserOutput of(User user) {
        UpdateUserOutput output = new UpdateUserOutput();
        if(user == null) {
            return output;
        }
        output.setId(user.getId());
        output.setUsername(user.getUsername());
        output.setNickname(user.getNickname());
        output.setEmail(user.getEmail());
        output.setGender(user.getGender());
        output.setAge(user.getAge());
        output.setCreated_at(user.getCreated_at());
        output.setUpdated_at(user.getUpdated_at());
        output.setDeleted_at(user.getDeleted_at());
        output.setAdmin(user.isAdmin());
        output.setBan(user.isBan());
        output.setAvatar(user.getAvatar());
        return output;
    }
}