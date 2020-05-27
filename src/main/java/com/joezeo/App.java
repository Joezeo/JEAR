package com.joezeo;

import com.joezeo.zookeeper.ZookeeperConnection;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final CountDownLatch connectedSignal = new CountDownLatch(1);

    public static void main( String[] args ) throws IOException, InterruptedException, KeeperException {
        ZookeeperConnection connection = new ZookeeperConnection();
        ZooKeeper zoo = connection.connect("192.168.2.113");
        byte[] buf = zoo.getData("/javaNode", (event) -> {
            if (event.getType() == Watcher.Event.EventType.None) {
                switch (event.getState()) {
                    case Expired:
                        connectedSignal.countDown();
                        break;
                }

            } else {
                String path = "/firstNode";

                try {
                    byte[] bn = zoo.getData(path,
                            false, null);
                    String data = new String(bn,
                            "UTF-8");
                    System.out.println(data);
                    connectedSignal.countDown();

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }, null);
        System.out.println(new String(buf, "UTF-8"));
        zoo.close();
    }
}
