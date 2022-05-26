package indi.likai.mrm.constant;

/**
 * 常用命令
 */
public class CommandConstant {

    /**
     * 查询服务器使用情况结果为通过 \n 来分割
     * [0]总内存 [1]已用内存 [2]硬盘总大小 [3]硬盘已用大小 [4]硬盘使用率
     * */
    public static final String SERVER_STATUS_BASH="  free -m|grep Mem|awk '{print $2}' && free -m|grep Mem|awk '{print $3}'&&top -bn 1 -i -c|awk NR==3'{print $2}'&&df -B 1g  /|awk 'NR==2{print $2}'&&df -B 1g /|awk 'NR==2{print $3}'&&df  /|awk 'NR==2{print $5}' ";


}
