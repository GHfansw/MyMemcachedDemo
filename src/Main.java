import net.spy.memcached.MemcachedClient;
import java.net.*;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        try{
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
            System.out.println("Connection to server successful");

            // 存储数据
            Future fo = mcc.set("runoob", 900, "Free test");

            // 查看存储状态
            System.out.println("set status:" + fo.get());

            // 输出值
            System.out.println("runoob value in cache - " + mcc.get("runoob"));

            //关闭连接
            mcc.shutdown();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
