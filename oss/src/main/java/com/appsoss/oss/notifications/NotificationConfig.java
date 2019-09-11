package com.appsoss.oss.notifications;

import android.content.Context;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class NotificationConfig{

    private Context context;
    private Class clase;
    private String channel_id;
    private String name;
    private String channel_description;
    private int icon;
    private boolean lights = false;
    private int led_color;
    private boolean vibration = false;
    private boolean progress = false;
    private String notification_title;
    private String content;
    private boolean auto_cancel = false;
    private boolean sound = false;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Class getClase() {
        return clase;
    }

    public void setClase(Class clase) {
        this.clase = clase;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannel_description() {
        return channel_description;
    }

    public void setChannel_description(String channel_description) {
        this.channel_description = channel_description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isLights() {
        return lights;
    }

    public void setLights(boolean lights) {
        this.lights = lights;
    }

    public int getLed_color() {
        return led_color;
    }

    public void setLed_color(int led_color) {
        this.led_color = led_color;
    }

    public boolean isVibration() {
        return vibration;
    }

    public void setVibration(boolean vibration) {
        this.vibration = vibration;
    }

    public boolean isProgress() {
        return progress;
    }

    public void setProgress(boolean progress) {
        this.progress = progress;
    }

    public String getNotification_title() {
        return notification_title;
    }

    public void setNotification_title(String notification_title) {
        this.notification_title = notification_title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isAuto_cancel() {
        return auto_cancel;
    }

    public void setAuto_cancel(boolean auto_cancel) {
        this.auto_cancel = auto_cancel;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }
}
