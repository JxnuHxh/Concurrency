package banker.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @author: Hxh
 * @date: 2019/11/29
 * @description:
 */
public abstract class AbstractServer {
    private ServerSocket checkServer;
    abstract void onData(int id, List<Socket> sockets, String data);



}
