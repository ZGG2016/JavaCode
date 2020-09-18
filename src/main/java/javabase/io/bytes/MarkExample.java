package javabase.io.bytes;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
/**
 * public void mark(int readlimit)
 *   在此输入流中标记当前的位置。对 reset 方法的后续调用会在最后标记的位置重新定位此流，以便后续读取重新读取相同的字节。
 *
 *   readlimit 参数：告知此输入流在标记位置失效之前允许读取的字节数。
 *
 *   mark 的常规协定是：
 *         如果方法 markSupported 返回 true，那么输入流总是在调用 mark 之后记录所有读取的字节，
 *         并时刻准备在调用方法 reset 时（无论何时），再次提供这些相同的字节。
 *         但是，如果在调用 reset 之前可以从流中读取多于 readlimit 的字节，则不需要该流记录任何数据。
 *
 *    标记已关闭的流对其无效。
 *
 *    InputStream 的 mark 方法不执行任何操作。
 *
 *
 * public void reset() throws IOException
 *      将此流重新定位到最后一次对此输入流调用 mark 方法时的位置。
 *
 * reset 的常规协定是：
 *        如果方法 markSupported 返回 true，那么：
 *               - 如果创建流以后未调用方法 mark，或最后调用 mark 以后从该流读取的字节数大于最后调用 mark 时
 *                   的参数，则可能抛出 IOException。
 *               - 如果未抛出这样的 IOException，则将该流重新设置为这种状态：最近一次调用 mark 以后
 *               （如果未调用过 mark，则从文件开头开始）读取的所有字节将重新提供给 read 方法的后续调用者，
 *               后跟任何从调用 reset 时起将作为下一输入数据的字节。
 *
 *        如果方法 markSupported 返回 false，那么：
 *              - 对 reset 的调用可能抛出 IOException。
 *
 * 如果未抛出 IOException，则将该流重新设置为一种固定状态，该状态取决于输入流的特定类型及其创建方式。
 * 提供给 read 方法后续调用者的字节取决于特定类型的输入流。
 *
 * 除了抛出 IOException 之外，类 InputStream 的方法 reset 不执行任何操作。
 *
 * 简言之：BufferedInputStream类调用mark(int readlimit)方法后读取多少字节标记才失效，
 *        是取readlimit和BufferedInputStream类的缓冲区大小两者中的最大值，而并非完全由readlimit确定。
 *
 * 简单理解：mark就像书签一样，在这个BufferedReader对应的buffer里作个标记，
 *          以后再调用reset时就可以再回到这个mark过的地方。mark方法有个参数，通过这个整型参数，
 *          你告诉系统，希望在读出这么多个字符之前，这个mark保持有效。读过这么多字符之后，
 *          系统可以使mark不再有效。
 */

public class MarkExample {
    public static void main(String[] args) throws IOException {


        byte [] bytes={ 1 , 2 , 3 , 4 , 5 };

        // 初始化缓冲区大小为2。
        BufferedInputStream bis= new  BufferedInputStream(new  ByteArrayInputStream(bytes), 2 );
        // 读取字节1
        System.out.println(bis.read()+ "," );  //1
        // 在字节2处做标记，同时设置readlimit参数为1
        // 根据JAVA文档mark以后最多只能读取1个字节，否则mark标记失效，但实际运行结果不是这样
        // mark标记
        bis.mark( 1 );

        //连续读取两个字节，超过了readlimit的大小，调用reset方法，未抛异常，说明mark标记仍有效。
        //再看一遍 reset 的常规协定
        System.out.println(bis.read()+ "," );  //2
        System.out.println(bis.read()+ "," );  //3

        // 因为，虽然readlimit参数为1，但是这个BufferedInputStream类的缓冲区大小为2，
        // 所以允许读取2字节
        bis.reset();

        /*
         * 连续读取3个字节，超过了缓冲区大小，mark标记失效。
         * 在这个例子中BufferedInputStream类的缓冲区大小大于readlimit,
         * mark标记由缓冲区大小决定，所以读取3个字节后，mark标记失效
         */
        // reset重置后连续读取3个字节，超过了BufferedInputStream类的缓冲区大小，
        System.out.println(bis.read()+ "," );  //2 。 在字节2处做了标记，所有reset后从次开始读
        System.out.println(bis.read()+ "," );  //3
        System.out.println(bis.read()+ "," );  //4
        // 再次调用reset重置，抛出异常，说明mark后读取3个字节，mark标记失效
        /*
          Exception in thread "main" java.io.IOException: Resetting to invalid mark
          	at java.io.BufferedInputStream.reset(BufferedInputStream.java:448)
          	at javabase.io.bytes.MarkExample.main(MarkExample.java:85)
         */
        bis.reset();

    }
}

//参考：
// https://blog.csdn.net/chuifuhuo6864/article/details/100888978?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param