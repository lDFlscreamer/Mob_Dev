package com.kpi.lab3;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWorker {


    private final static String _SEPARATOR = System.getProperty("line.separator");

    final static String TAG = FileRead.class.getName();
    final static String fileName = "data.ColorText";
    final static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/lab3/";

    public static String ReadFile(Context context) {
        String line = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path + fileName));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + _SEPARATOR);
            }
            fileInputStream.close();
            line = stringBuilder.toString();

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        } catch (IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        return line;
    }

    public static boolean saveToFile(String data) {
        try {
            new File(path).mkdir();
            File file = new File(path + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write((data + _SEPARATOR).getBytes());

            return true;
        } catch (FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        } catch (IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        return false;


    }

    public static boolean deleteFile() {

        new File(path).mkdir();
        File file = new File(path + fileName);
        if (file.exists()) {
            return file.delete();
        }
        return true;

    }
}
