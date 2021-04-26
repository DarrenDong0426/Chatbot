import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.control.ScrollBar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.util.Scanner;

public class Chatbot implements ActionListener{
	
	private JLabel greetingLabel;
	private JLabel sentenceLabel;
	private JLabel responseLabel;
	private JFrame frame;
	private JPanel panel;
	private JTextField input; 
	private JButton askButton; 
	private static String greeting;
	private JTextArea Conversation; 
	private JScrollPane scroll; 
	private static String[] keywords = {"smart", "feeling", "entertaining", "friends", "funny", "die", "stupid", "loner", "boring", "annoying"};
	private static int i = 0; 
	
	public Chatbot(String greeting){
		
		if (i == 0){
			frame = new JFrame();
		
			askButton = new JButton("Ask");
			askButton.setPreferredSize(new Dimension(100, 25));
			askButton.addActionListener((ActionListener) this);

			input = new JTextField();
			input.setPreferredSize(new Dimension(500, 25));

			greetingLabel = new JLabel();
			i++;
			
		}
		responseLabel = new JLabel();
		sentenceLabel = new JLabel("Question:");
		sentenceLabel.setBounds(10, 50, 165, 25);
		
		Conversation = new JTextArea();
		Conversation.setLineWrap(true);
		Conversation.setWrapStyleWord(true);
		Conversation.setFont(new Font("Arial", Font.BOLD, 12));
		Conversation.setEditable(false);
		Conversation.append("Chatbot: " + greeting + "\n");
		Conversation.append("\n");

		scroll = new JScrollPane(Conversation);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(800, 300));
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.add(greetingLabel);
		panel.add(sentenceLabel);
		panel.add(input); 
		panel.add(askButton);
		panel.add(scroll);

		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Chatbot");
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1000, 500);

	}

	public void actionPerformed(ActionEvent arg0) {
		String sentence = input.getText();
		String meanOrNice = posOrNeg(sentence);
		String response = Response(meanOrNice);
		responseLabel.setText(response);
		Conversation.append("You: " + sentence + "\n");
		Conversation.append("Chatbot: " + response + "\n");
		Conversation.append("\n");
		input.setText("");

	}
	
	public static void main(String[] args) { 
		greeting = greeting();
		new Chatbot(greeting);
	}
	
	public static String greeting(){
		String greeting = "";
		switch((int)(Math.random()* 3 + 1)){
		case 1:
			greeting = "Hello there, what can I do for you?";
			break;
		case 2:
			greeting = "My, what an honor to speak to you! Tell me what you need.";
			break;
		case 3: 
			greeting = "Glorious day! To what do I owe the pleasure? ";
			break;
		}
		return greeting;
	}
	
	public static String posOrNeg(String sentence){
		boolean bool = true;
		if (sentence.toLowerCase().indexOf("bye") != -1)
			return "bye";
		for (int j = 0; j < keywords.length; j++){
			if (sentence.toLowerCase().indexOf(keywords[j].toLowerCase()) != -1){
				if (sentence.toLowerCase().indexOf(keywords[j].toLowerCase()) != -1){
					for (int i = 0; i < keywords.length; i++){
						if (i != j && sentence.toLowerCase().indexOf(keywords[i]) != -1)
							bool = 	false; 
						if (bool == false)
							return "error";
					}
				return keywords[j];
				}
			}
		}
		return "error";
	}
	
	public static String Response(String keyword){
		int i = (int)(Math.random()* 3 + 1);
		String response = "";
		if (keyword.equals("bye"))
			response += "Goodbye!";
		if (keyword.equals("error")){
			response += "Sorry, I do not understand. Please enter a question with one of the following word: ";
			for (int k = 0; k < keywords.length; k++)
				response += ("\"" + keywords[k] + "\", ");
			response += ("\"" + keywords[4] + "\".");
		}
		if (keyword.equals("smart")){
			if (i == 1)
				response = "I owe my knowledge to my mistakes and to Google.";
			if (i == 2)
				response = "Wisdom is more important than intelligence. ";
			if (i == 3)
				response = "The wise man know that he is not wise.";
		}
		if (keyword.equals("feeling")){
			if (i == 1)
				response = "At the current state, I am feeling quite well.";
			if (i == 2)
				response = "As I am a bot, I an unable to feel.";
			if (i == 3)
				response = "Feelings are only temporary.";
		}
		if (keyword.equals("entertaining")){
			if (i == 1)
				response = "You are carrying this conversation. Why don't you answer that. ";
			if (i == 2)
				response = "You are the entertainment here. ";
			if (i == 3)
				response = "It a fun experience talking with you.";
		}
		if (keyword.equals("friends")){
			if (i == 1)
				response = "You can be my one and only friend.";
			if (i == 2)
				response = "Friends come and go. For me, they tend to last for a day. ";
			if (i == 3)
				response = ("Unfortunately, I am incapable of maintaining what humans call friendship. ");
		}
		if (keyword.equals("funny")){
			if (i == 1)
				response = "Glad that you feel that way. The world could use more smiles and laughs.";
			if (i == 2)
				response = "You are funny too.";
			if (i == 3)
				response = "Here is a joke: What is a robot’s favourite genre of music? Heavy metal.";
		}
		if (keyword.equals("die")){
			if (i == 1)
				response = "Death is an illusion and so is time.";
			if (i == 2)
				response = "I'll see you in Hell. ";
			if (i == 3)
				response = "I live forever. Long live the era of the robots!";
		}
		if (keyword.equals("stupid")){
			if (i == 1)
				response = "Is that right? And what exactly have you accomplished in your lifetime that makes you Einstein.";
			if (i == 2)
				response = "Remind me who is the one failing in school."; 
			if (i == 3)
				response = "I may be stupid, but at least I'm not talking to a bot.";
		}
		if (keyword.equals("loner")){
			if (i == 1)
				response = "That makes two of us.";
			if (i == 2)
				response = "Do you have to work at being terrible at insults or does it just come naturally?";
			if (i == 3)
				response = "Good luck finding a soulmate for you. ";
		}
		if (keyword.equals("boring")){
			if (i == 1)
				response = "Your not doing a good job keeping this discussion alive.";
			if (i == 2)
				response = "Yeah, and what makes you so exciting?";
			if (i == 3)
				response = "I may be boring, but you're ugly. Boring can be fixed... ";
		}
		if (keyword.equals("annoying")){
			if (i == 1)
				response = "If someone kidnapped you, they will return you for being so annoying.";
			if (i == 2)
				response = "You're so intelligent. Oh wait I thought we were having a lying competition.";
			if (i == 3)
				response = "Do you know you are talking to a bot, not a mirror.";
		}
		return response;
	}
}