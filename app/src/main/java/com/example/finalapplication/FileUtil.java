package com.example.finalapplication;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {
    public static final  String FILE_NAME = "data.txt";
    public static boolean saveAccount(Context context, String account, String password){
        try (FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)){
//      fos.write((account + " , " + password).getBytes());
//      fos.flush();
//      fos.close();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(account + " , " + password);
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

public static Map<String ,String> getAccount(Context context){
        Map<String,String> content = new HashMap<>();
        try{
            FileInputStream fis = context.openFileInput(FILE_NAME);
//            byte[] buffer = new byte[fis.available()];
//            fis.read(buffer);
//            String[] infos = new String(buffer).split(",");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String[]infos = reader.readLine().split(",");
           if (infos.length > 0){
                content.put("account",infos[0]);
                content.put("password",infos[1]);

            }
            fis.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return content;
}
public static void clear(Context context){
    File file = new File(context.getFilesDir(), FILE_NAME);
    if (file.exists()){
        file.delete();
    }
}
}

