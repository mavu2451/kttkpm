package data;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import helper.XMLConvert;

import java.awt.TextArea;
import javax.swing.JTextField;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Sender2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static final String n = "\n";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sender2 frame = new Sender2();
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
	public Sender2() {
		setTitle("Send 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final TextArea textArea = new TextArea();
		textArea.setBounds(10, 40, 414, 160);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(101, 230, 206, 20);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BasicConfigurator.configure();
					Properties settings = new Properties();
					settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
					settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
					Context ctx = new InitialContext(settings);
					ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
					Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet4");
					Connection con = factory.createConnection("admin", "admin");
					con.start();
					Session session = con.createSession(/* transaction */false, /* ACK */Session.AUTO_ACKNOWLEDGE);
					MessageProducer producer = session.createProducer(destination);
					Message msg = session.createTextMessage(textField.getText().toString());
					producer.send(msg);
					Person p = new Person(1001, "Thân Thị Đẹt", new Date());
					String xml = new XMLConvert<Person>(p).object2XML(p);
					
					session.close();
					con.close();
					System.out.println("Finished...");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setBounds(317, 229, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nhap tin");
		lblNewLabel.setBounds(10, 233, 81, 14);
		contentPane.add(lblNewLabel);
		
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
					Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet3");
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
