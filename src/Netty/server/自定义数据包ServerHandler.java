package Netty.server;

import Netty.自定义数据包.model.Request;
import Netty.自定义数据包.model.Response;
import Netty.自定义数据包.model.StateCode;
import Netty.自定义数据包.module.副本.request.FightRequest;
import Netty.自定义数据包.module.副本.response.FightResponse;
import org.jboss.netty.channel.*;

public class 自定义数据包ServerHandler extends SimpleChannelHandler {
    /**
     * 接收消息
     */
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

        Request message = (Request)e.getMessage();

        if(message.getModule() == 1){

            if(message.getCmd() == 1){

                FightRequest fightRequest = new FightRequest();
                fightRequest.readFromBytes(message.getData());

                System.out.println("fubenId:" +fightRequest.getFubenId() + "   " + "count:" + fightRequest.getCount());

                //回写数据
                FightResponse fightResponse = new FightResponse();
                fightResponse.setGold(9999);

                Response response = new Response();
                response.setModule((short) 1);
                response.setCmd((short) 1);
                response.setStateCode(StateCode.SUCCESS);
                response.setData(fightResponse.getBytes());
                ctx.getChannel().write(response);
            }else if(message.getCmd() == 2){

            }

        }else if (message.getModule() == 1){


        }
    }

    /**
     * 捕获异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        System.out.println("exceptionCaught");
        super.exceptionCaught(ctx, e);
    }

    /**
     * 新连接
     */
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelConnected");
        super.channelConnected(ctx, e);
    }

    /**
     * 必须是链接已经建立，关闭通道的时候才会触发
     */
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelDisconnected");
        super.channelDisconnected(ctx, e);
    }

    /**
     * channel关闭的时候触发
     */
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelClosed");
        super.channelClosed(ctx, e);
    }
}
