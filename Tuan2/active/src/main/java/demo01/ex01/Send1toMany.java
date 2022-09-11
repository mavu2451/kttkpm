package demo01.ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import data.Person;
import helper.XMLConvert;

public class Send1toMany extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Send1toMany frame = new Send1toMany();
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
	public Send1toMany() {
		setTitle("Send 1");
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
		textField.setBounds(101, 230, 206, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
					Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet11");
					Destination destination1 = (Destination) ctx.lookup("dynamicQueues/thanthidet12");
					Destination destination2 = (Destination) ctx.lookup("dynamicQueues/thanthidet13");
					Connection con = factory.createConnection("admin", "admin");
					con.start();
					Session session = con.createSession(/* transaction */false, /* ACK */Session.AUTO_ACKNOWLEDGE);
					MessageProducer producer = session.createProducer(destination);
					MessageProducer producer1 = session.createProducer(destination1);
					MessageProducer producer2 = session.createProducer(destination2);
					Message msg = session.createTextMessage(textField.getText().toString());
					producer.send(msg);
					producer1.send(msg);
					producer2.send(msg);
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
	}

}
