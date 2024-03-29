package Netty.自定义数据包.code;

import Netty.自定义数据包.constant.ConstantValue;
import Netty.自定义数据包.model.Request;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

/**
 * 请求解码器
 * <pre>
 * 数据包格式
 * +——----——+——-----——+——----——+——----——+——-----——+
 * | 包头          | 模块号        | 命令号      |  长度        |   数据       |
 * +——----——+——-----——+——----——+——----——+——-----——+
 * </pre>
 * 包头4字节
 * 模块号2字节short
 * 命令号2字节short
 * 长度4字节(描述数据部分字节长度)
 *
 *
 */

public class RequestDecoder extends FrameDecoder {
    /**
     * 数据包基本长度
     */
    public static int BASE_LENTH = 4 + 2 + 2 + 4;


    @Override
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer buffer) throws Exception {
        //可读长度必须大于基本长度
        if(buffer.readableBytes() >= BASE_LENTH) {
            //防止socket字节流攻击
            if (buffer.readableBytes() >2048) {
                buffer.skipBytes(buffer.readableBytes());
            }

            //记录包头开始的index
            int  beginReader ;
            while (true) {
                beginReader = buffer.readerIndex();
                buffer.markReaderIndex();
                if (buffer.readInt() == ConstantValue.FLAG) {
                    break;
                }
                //未读到包头，略过一个字节
                buffer.resetReaderIndex();
                buffer.readByte();
                //长度又变的不满足
                if(buffer.readableBytes()< BASE_LENTH) {
                    return null;
                }
            }
            //模块号
            short module = buffer.readShort();
            //命令号
            short cmd = buffer.readShort();
            //长度
            int length =  buffer.readInt();

            //判断请求数据包是否到齐
            if(buffer.readableBytes() < length) {
                //还原读指针
                buffer.readerIndex(beginReader);
                return null;
            }
            byte[] data = new byte[length];
            buffer.readBytes(data);

            Request request = new Request();
            request.setModule(module);
            request.setCmd(cmd);
            request.setData(data);
            //继续往下传递
            return request;
        }
        //数据包不完整，需要等待后面的包来
        return null;
    }
}
