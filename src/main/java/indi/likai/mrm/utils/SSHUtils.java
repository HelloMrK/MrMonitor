package indi.likai.mrm.utils;

import com.jcraft.jsch.*;
import indi.likai.mrm.domain.ServerInfo;

import java.io.InputStream;

/**
 * SSH工具类
 */
public class SSHUtils {
    /**
     * 远程执行单条命令
     * @param command
     * @param username
     * @param ip
     * @param port
     * @param password
     * @return
     */
    public static String execCommand(String command,String username,String ip,Integer port,String password){
        String result="";
        try{
            JSch jsch=new JSch();
            Session session = jsch.getSession(username,ip,port);
            session.setPassword(password);
            session.setUserInfo(new MyUserInfo());
            session.connect();

            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);
            InputStream in=channel.getInputStream();
            channel.connect();
            byte[] tmp=new byte[1024];
            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0)break;
                    result+=new String(tmp, 0, i);

                }
                if(channel.isClosed()){
                    if(in.available()>0) continue;
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();

            session.disconnect();
        }
        catch(Exception e){
            //
        }

        return result.trim();
    }

    private static class MyUserInfo implements UserInfo {
        @Override
        public String getPassphrase() {
            System.out.println("getPassphrase");
            return null;
        }
        @Override
        public String getPassword() {
            System.out.println("getPassword");
            return null;
        }
        @Override
        public boolean promptPassword(String s) {
            System.out.println("promptPassword:"+s);
            return false;
        }
        @Override
        public boolean promptPassphrase(String s) {
            System.out.println("promptPassphrase:"+s);
            return false;
        }
        @Override
        public boolean promptYesNo(String s) {
            System.out.println("promptYesNo:"+s);
            return true;//notice here!
        }
        @Override
        public void showMessage(String s) {
            System.out.println("showMessage:"+s);
        }
    }


    public static String execCommand(String command, ServerInfo serverInfo){

        return execCommand(command,serverInfo.getUsername(),serverInfo.getIp(),serverInfo.getPort(),serverInfo.getPassword());
    }
}
