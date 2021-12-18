package com.company.controller;

import com.company.utils.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class NetController extends Thread {

    /**
     * socket，用于建立连接
     */
    public Socket socket;

    /**
     * server，用于建立主机
     */
    public ServerSocket server;

    /**
     * 用于发送消息
     */
    PrintWriter os;

    /**
     * 用于读取消息
     */
    BufferedReader is;

    /**
     * 是否已经建立连接
     */
    boolean connected;

    /**
     * 地图是否已经接受
     */
    boolean mapReceived;

    /**
     * 图形界面控制器
     */
    GUIController gui;

    /**
     * 默认构造器
     */
    public NetController(GUIController g) {
        this.gui = g;
        if (config.online == 2) {
            try {
                socket = new Socket(config.server, config.port);
                os = new PrintWriter(socket.getOutputStream());
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("连接至" + config.server + ":" + config.port);
                while (!connected)
                    wait4connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (config.online == 1) {
            try {
                server = new ServerSocket(config.port);
                System.out.println("监听端口: " + config.port);
                connected = false;
                while (!connected)
                    wait4connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 等待连接
     */
    public void wait4connect() {
        if (config.online == 1) {
            try {
                System.out.println("等待连接");
                socket = server.accept();
                System.out.println("连接成功");
                //建立输出流printer
                os = new PrintWriter(socket.getOutputStream());
                os.println("connected");
                os.flush();
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                connected = true;
            } catch (Exception e) {
                System.out.println("Error." + e);
            }
        } else if (config.online == 2) {
            try {
                if(socket.isConnected()) {
                    is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    os = new PrintWriter(socket.getOutputStream());
                    if (Objects.equals(is.readLine(), "connected")) {
                        connected = true;
                        System.out.println("成功连接至" + config.server + ":" + config.port);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.start();
    }

    /**
     * 模拟点击
     */
    public void sendClick() {
        os.println("click");
        os.flush();
    }

    /**
     * 是否已经连接
     *
     * @return boolean
     */
    public boolean isConnected() {
        return connected;
    }

    @Override
    public void run() {
        System.out.println("监听指令中");
        while(true) {
            try {
                String s = is.readLine();
                if(Objects.equals(s, "click")){
                    this.gui.anotherClick();
                } else {
                    System.out.println("同步角度数据");
                    String[] arr = s.split(" ");
                    double[] rad = new double[2];
                    rad[0] = Double.parseDouble(arr[0]);
                    rad[1] = Double.parseDouble(arr[1]);
                    this.gui.players[0].line.rad = rad[0];
                    this.gui.players[1].line.rad = rad[1];
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(config.online == 1) {
                System.out.println("发送角度数据");
                os.println(this.gui.players[0].line.rad+" "+this.gui.players[1].line.rad);
                os.flush();
            }
        }
    }
}
