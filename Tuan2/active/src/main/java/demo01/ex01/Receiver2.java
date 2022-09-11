package demo01.ex01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

public class Receiver2 extends JFrame {

	private JPanel contentPane;
	public static final String n = "\n";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receiver2 frame = new Receiver2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Receiver2() {
		setTitle("Receive 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final TextArea textArea = new TextArea();
		textArea.setBounds(10, 40, 414, 160);
		contentPane.add(textArea);
		
		Button button = new Button("Receive");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BasicConfigurator.configure();
					Properties settings = new Properties();
					settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
					settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
					Context ctx = new InitialContext(settings);
					Object obj = ctx.lookup("ConnectionFactory");
					ConnectionFactory factory = (ConnectionFactory) obj;
					Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet12");
					Connection con = factory.createConnection("admin", "admin");
					con.start();
					Session session = con.createSession(/* transaction */false, /* ACK */Session.CLIENT_ACKNOWLEDGE);
					MessageConsumer receiver = session.createConsumer(destination);
					System.out.println("Tý was listened on queue...");
					receiver.setMessageListener(new MessageListener() {

						public void onMessage(Message msg) {
							try {
								if (msg instanceof TextMessage) {
									TextMessage tm = (TextMessage) msg;
									String txt = tm.getText();
									System.out.println("Nhận được " + txt);
									textArea.setText(txt + n);
								} else if (msg instanceof ObjectMessage) {

								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button.setBounds(10, 10, 70, 22);
		contentPane.add(button);
	}

}
