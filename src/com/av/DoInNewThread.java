package com.av;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DoInNewThread extends Thread{
    String port;
    boolean exit;
    String result;
//    File fileIndex ;
//    File file ;
    public DoInNewThread(String port) {
        this.port = port;
        exit=false;
        result= null;
//        fileIndex = new File("D:\\AIRDROP\\AUTOIT\\HIBS_REG\\HIBS_REG\\output\\index.txt");
//        file = new File("D:\\AIRDROP\\AUTOIT\\HIBS_REG\\HIBS_REG\\output\\account_Thanhcong_0.txt");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Theard:"+port);
        while (!exit){try {
            ProcessExecutor.exec(port,"pm clear io.hiblocks.app");
            Thread.sleep(3000);
            ProcessExecutor.exec(port,"monkey -p io.hiblocks.app -c android.intent.category.LAUNCHER 1");
            getID();
            Thread.sleep(20000);
            ProcessExecutor.exec(port,"input touchscreen swipe 249 255 14 242 500");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input touchscreen swipe 249 255 14 242 500");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input touchscreen swipe 249 255 14 242 500");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input touchscreen swipe 249 255 14 242 500");
            Thread.sleep(2000);
            // click nút bắt đầu
            ProcessExecutor.exec(port,"input tap 132 455");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input tap 141 319");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input tap 204 107");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input tap 65 182");
            Thread.sleep(2000);
            // lấy và nhập username
//            $file = @ScriptDir & '\output\account_Thanhcong_'&$index&'.txt'
//            $userid  = FileReadLine($file, $i)
//            _CoProc_SuperGlobalSet('data'&$index&'1',$userid)
//            line = Files.readAllLines(Paths.get(path)).get(index);

            ProcessExecutor.exec(port,"input text "+ result);
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input tap 75 243");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input text Napoleong112@");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input tap 132 455");
            Thread.sleep(5000);

            //tắt thông báo
            ProcessExecutor.exec(port,"input tap 130 411");
            Thread.sleep(3000);
            ProcessExecutor.exec(port,"input tap 203 377");
            Thread.sleep(3000);
            ProcessExecutor.exec(port,"input tap 167 369");
            //rút tiền

            Thread.sleep(3000);
            ProcessExecutor.exec(port,"input tap 235 455");
            Thread.sleep(9000);
            ProcessExecutor.exec(port,"input tap 252 288");
            Thread.sleep(5000);

            ProcessExecutor.exec(port,"input touchscreen swipe 153 467 144 87 500");
            Thread.sleep(2000);

            ProcessExecutor.exec(port,"input tap 234 444");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input text 100");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input tap 132 455");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input tap 225 290");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input tap 118 363");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input text 0x682b95b2ddf84c7c50d9705a148a0911f9374bef");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input tap 132 455");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input tap 132 455");

            Thread.sleep(2000);

            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(2000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);

            ProcessExecutor.exec(port,"input tap 137 273");
            Thread.sleep(2000);

            ProcessExecutor.exec(port,"input tap 132 455");
            Thread.sleep(2000);


            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(1000);
            ProcessExecutor.exec(port,"input text 1");
            Thread.sleep(10000);

            ProcessExecutor.exec(port,"input tap 132 455");
            Thread.sleep(10000);

        } catch (IOException e ) {
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }}
    public void stopThread(){
        exit= true;
    }
    public synchronized String getID(){
        String ind = null;
        //result= null;
        //Thread.sleep(1000);
            try {
                FileReader fr = new FileReader(AVForm.fileIndex);
                BufferedReader br= new BufferedReader(fr);
                ind= br.readLine();
//                System.out.println(ind);
                fr= new FileReader(AVForm.file);
                br = new BufferedReader(fr);
                result=br.readLine();

                if(ind!=null){while (!result.equals(ind)){
                    result=br.readLine();
                }
                    result= br.readLine();
                    if(result==null) return null;
                };


//                System.out.println(ind);
//                System.out.println(result);
                br.close();
                FileWriter writer = new FileWriter(AVForm.fileIndex);
                BufferedWriter buffer = new BufferedWriter(writer);
                buffer.write(result);
                buffer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return result;
    }
}
