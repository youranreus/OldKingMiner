package com.company.controller;

import com.company.utils.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetController extends Thread{

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
     * 默认构造器
     */
    public NetController() {
        if(config.online == 2) {
            try {
                socket = new Socket(config.server, config.port);
                os = new PrintWriter(socket.getOutputStream());
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("连接至" + config.server + ":" + config.port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (config.online == 1) {
            try {
                server = new ServerSocket(config.port);
                System.out.println("监听端口: " + config.port);
                connected = false;
                while(!connected)
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
        if(config.online == 1) {
            try {
                System.out.println("等待连接");
                socket = server.accept();
                System.out.println("连接成功");
                connected = true;
            } catch (Exception e) {
                System.out.println("Error." + e);
            }
        }
    }

    /**
     * 是否已经连接
     * @return boolean
     */
    public boolean isConnected() {
        return connected;
    }

    @Override
    public void run() {
        super.run();
    }
}
