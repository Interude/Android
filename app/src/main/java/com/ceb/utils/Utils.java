package com.ceb.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liyong on 2018/1/12.
 */

public class Utils {

    public static String getStorageFilePath(Context mContext, String fileName){
        File file ;
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            file = Environment.getExternalStorageDirectory();
        } else {
            file = mContext.getFilesDir();
        }
        return file  + File.separator + fileName;
    }

    public static String digestFile(File file) throws FileNotFoundException {
        String digest = null;
        byte array[] = new byte[1024];
        if (file == null || !file.exists())
        {
            throw new FileNotFoundException();
        }
        MessageDigest md = null;
        BufferedInputStream in = null;
        try {
            md = MessageDigest.getInstance("MD5");
            in = new BufferedInputStream(new FileInputStream(file));
            int len = 0;
            while ((len = in.read(array, 0, 1024)) > 0)
            {
                md.update(array, 0, len);
            }
            byte[] theDigest;
            theDigest = md.digest();
            digest = Base64.encodeToString(theDigest, Base64.NO_WRAP);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return digest;
    }

    public static String wrapJson(String reCode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("returnCode", reCode);
        return new Gson().toJson(jsonObject, JsonObject.class);
    }
}
