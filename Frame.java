import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Frame extends JFrame{
    public int lifespan = 7;
    public Frame(){
        String choosenword = words();
        char[][] words = blankandletter(choosenword);
        StringBuilder blankword = space(words[0]);

        System.out.println(blankword.toString().trim());

        setSize(600,500);
        setTitle("hello");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JPanel back = new JPanel();
        back.setBackground(Color.LIGHT_GRAY);
        back.setSize(500,400);
        back.setBounds(30,30,500,400);
        back.setLayout(null);

        JLabel Guessword = new JLabel("<html><div style='width:350px;text-align:center;border:2px solid black; color:red;font-size:30px;'>GUESSWORD</div></html>");
        JLabel worddisplay = new JLabel("<html><div style='text-align:center;width:350px;font-size:30px;color:blue;border:2px solid black;'>"+blankword+"</div></html>");
        worddisplay.setBounds(15,120,500,50);
        Guessword.setBounds(15,1,500,100);

        JLabel enter_here = new JLabel("Enter Here:");
        enter_here.setFont(new Font("Ariel",Font.PLAIN,25));
        enter_here.setBounds(15,220,200,30);
        

        JTextField input = new JTextField();
        input.setFont(new Font("Ariel",Font.PLAIN,30));
        input.setBounds(150,220,40,40);

        JPanel scoringbord = new JPanel();
        scoringbord.setBackground(new Color(135,206,235));
        scoringbord.setBounds(200,200,250,180);
        scoringbord.setLayout(null);

        JLabel textscore = new JLabel("LIFE:");
        textscore.setFont(new Font("Ariel",Font.PLAIN,20));
        textscore.setBounds(100,5,100,20);

        String convert = Integer.toString(lifespan);

        JLabel life = new JLabel(convert);
        life.setFont(new Font("Ariel",Font.PLAIN,70));
        life.setBounds(105,10,130,130);


        JButton ok = new JButton("ENTER");
        ok.setFont(new Font("Ariel",Font.PLAIN,20));
        ok.setBounds(20,270,150,50);
        ok.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                String texxt = input.getText().toUpperCase();
				char Letter = texxt.charAt(0);
                boolean chck = false;
				if(Character.isLetter(Letter)) {
				
					for(int i = 0; i < words[1].length;i++) { 
						if(Letter == words[1][i]) {
							words[0][i]=Letter;
							StringBuilder word = space(words[0]);
							String newletter = word.toString().trim();
                            worddisplay.setText("<html><div style='text-align:center;width:350px;font-size:30px;color:blue;border:2px solid black;'>"+newletter+"</div></html>");
                            chck = true;
							
						}		
            
					}

                    

                    if(!chck){
                        Guessword.setText("<html><div style='width:350px;text-align:center;border:2px solid black; color:red;font-size:30px;'>WRONG ANG FERSON</div></html>");
                        lifespan -= 1;
                        life.setText(Integer.toString(lifespan));
                    }else{
                        Guessword.setText("<html><div style='width:350px;text-align:center;border:2px solid black; color:red;font-size:30px;'>SHEESH MALA DIWATA</div></html>");
                    }
					System.out.println(lifespan);
					if(Arrays.equals(words[0], words[1])){
						back.setVisible(false);
                        JLabel win = new JLabel("YOU WIN");
                        win.setFont(new Font("Ariel", Font.PLAIN, 30));
                        win.setBounds(200,50,400,60);
            
                        StringBuilder ans = new StringBuilder();
                        for(int i = 0; i < words[1].length; i++){
                            ans.append(words[1][i]);
                        }
            
                        JLabel answer = new JLabel("YOU GUESS:"+ans.toString());
                        answer.setFont(new Font("Ariel", Font.PLAIN, 30));
                        answer.setBounds(130,200,400,60);
                        add(win);
                        add(answer);

					}
					
                    input.setText("");

                    if(lifespan < 1){
                        back.setVisible(false);
                        JLabel gameover = new JLabel("GAME OVER");
                        gameover.setFont(new Font("Ariel", Font.PLAIN, 30));
                        gameover.setBounds(200,30,400,60);
            
                        StringBuilder ans = new StringBuilder();
                        for(int i = 0; i < words[1].length; i++){
                            ans.append(words[1][i]);
                        }
            
                        JLabel answer = new JLabel("THE ANSWER:"+ans.toString());
                        answer.setFont(new Font("Ariel", Font.PLAIN, 30));
                        answer.setBounds(130,200,400,60);
                        add(gameover);
                        add(answer);
                    }
				
				}else {
					JOptionPane.showMessageDialog(null,"cant proceed must be letter");
                    input.setText("");
				}

            }
        });
        scoringbord.add(life);
        scoringbord.add(textscore);
        back.add(scoringbord);
        back.add(enter_here);
        back.add(input);
        back.add(Guessword);
        back.add(worddisplay);
        back.add(ok);

        add(back);

        

        setVisible(true);
    }

    public static String words(){
        String[] words = {"HATDOG","HELLO","COCONUT","WAWAYOT","MAMAMO"};		
		String word = words[(int) (Math.random() * words.length)];
        return word;
    }

    private static char[][] blankandletter(String word){
		char[]blank = new char[word.length()];
        char[]letter = new char[word.length()];
		for(int i = 0; i < word.length(); i++) {
			blank[i] = '_';	
            letter[i] = word.charAt(i);
		}

        char[][] arrays= {blank,letter};
		return arrays;
	}

    private static StringBuilder space(char[] any) {
		StringBuilder whole = new StringBuilder();
		for(int i = 0; i < any.length;i++) {
			whole.append(any[i] + " ");
		}
		return whole;
	}

}