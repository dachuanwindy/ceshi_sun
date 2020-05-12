package com.active_mq_sunfch;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * 消息队列
 */
public class productersun {
    private static final String bianliang1 = ActiveMQConnection.DEFAULT_USER;
    private static final String bianliang2 = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String bianliang3 = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENDNUM = 10;
    // AtomicInteger inte = new AtomicInteger();
    Session session;
    ConnectionFactory connectionFactory; //创建工厂连接
    Connection connection;//创建连接
    MessageProducer messageProducer;// 创建消息生产者
    Destination destination;//消息目的位置

    public static void sendmessage(Session session, MessageProducer messageProducer) throws JMSException {
        for (int i = 0; i < SENDNUM; i++) {
            TextMessage message = session.createTextMessage("ddd" + i);
            System.out.println("xiaoxifansong chengong" + i);
            messageProducer.send(message);
            session.commit();
        }
    }

    public static void main(String[] args) {
        productersun productersun = new productersun();
        productersun.init();

    }

    public static void ceshiproducer() throws JMSException {
//        创建连接工厂，并把连接信息输入
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(bianliang1, bianliang2, bianliang3);
//        创建连接 连接工厂信息
        Connection connection = connectionFactory.createConnection();
//        开启连接
        connection.start();
//        创建session， 其应答模式为自动应答
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);  //

        //接下来创建queue，只能创建一个队列
        // Queue queue = (Queue) session.createQueue("sdsdsdsdsds");
//        可以创建多个队列，然后向不同的队列中传消息
        Destination destination = session.createQueue("ded11");

        destination =session.createTopic("sdsdsds");
//        创建消息生产者，其目的是发送数据到队列中
        MessageProducer messageProducer = session.createProducer(destination);
        for (int i = 0; i < 10; i++) {
            TextMessage textMessage = session.createTextMessage("ccsdsds");
            messageProducer.send(textMessage);
        }
        session.commit();
    }

    public static void ceshiconsumer() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(bianliang1, bianliang2, bianliang3);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("ddddd");
        MessageConsumer messageConsumer = session.createConsumer(destination);
        messageConsumer.receive();


    }

    public void init() {
        connectionFactory = new ActiveMQConnectionFactory(bianliang1, bianliang2, bianliang3);//将连接信息加载到工厂中
        try {
            connection = connectionFactory.createConnection();//通过加载到工厂的信息 创建连接，这样就可以连接到activeMQ服务器上了
            connection.start();//启动连接，只有启动连接才能发送消息。
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //     Queue queue =session.createQueue("fefef");
            destination = session.createQueue("sunfengc, DDFDF,FEFEFEFE");//创建消息队列，activemq 可以有不同的队列，只要队列名字能对应上就能从队列中取出自己想要的数据
            messageProducer = session.createProducer(destination);// 创建消息生产者，，消息生产者 然后就发送消息了
            sendmessage(session, messageProducer);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public int publisher() {

        return 0;
    }
}
