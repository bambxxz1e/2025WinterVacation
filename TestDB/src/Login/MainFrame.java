package Login;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
	JPanel basePanel = new JPanel(new BorderLayout());
	JPanel centerPanel = new JPanel(new BorderLayout());
	JPanel westPanel = new JPanel();
	JPanel eastPanel = new JPanel();
	JPanel southPanel = new JPanel();

	JLabel idL = new JLabel("아이디");
	JLabel pwL = new JLabel("비밀번호");

	JTextField id = new JTextField();
	JPasswordField pw = new JPasswordField();

	JButton loginBtn = new JButton("로그인");
	JButton joinBtn = new JButton("회원가입");
	JButton exitBtn = new JButton("프로그램 종료");

	Operator o = null;

	public MainFrame(Operator oo) {
		o = oo;

		setTitle("로그인");

		// 패널 크기
		centerPanel.setPreferredSize(new Dimension(260, 80));
		westPanel.setPreferredSize(new Dimension(210, 75));
		eastPanel.setPreferredSize(new Dimension(90, 75));
		southPanel.setPreferredSize(new Dimension(290, 40));

		// 라벨 크기
		idL.setPreferredSize(new Dimension(50, 30));
		pwL.setPreferredSize(new Dimension(50, 30));

		// 텍스트필드 크기
		id.setPreferredSize(new Dimension(140, 30));
		pw.setPreferredSize(new Dimension(140, 30));

		// 버튼 크기
		loginBtn.setPreferredSize(new Dimension(75, 63));
		joinBtn.setPreferredSize(new Dimension(135, 25));
		exitBtn.setPreferredSize(new Dimension(135, 25));

		setContentPane(basePanel); // panel 기본 컨테이너 설정

		// 베이스패널에 센터, 아래 패널 넣고 센터패널 안에 동 서 패널
		basePanel.add(centerPanel, BorderLayout.CENTER);
		basePanel.add(southPanel, BorderLayout.SOUTH);
		centerPanel.add(westPanel, BorderLayout.WEST);
		centerPanel.add(eastPanel, BorderLayout.EAST);

		westPanel.setLayout(new FlowLayout());
		eastPanel.setLayout(new FlowLayout());
		southPanel.setLayout(new FlowLayout());

		// west panel 컴포넌트
		westPanel.add(idL);
		westPanel.add(id);
		westPanel.add(pwL);
		westPanel.add(pw);

		// east panel 컴포넌트
		eastPanel.add(loginBtn);

		// south panel 컴포넌트
		southPanel.add(exitBtn);
		southPanel.add(joinBtn);
		
		// 버튼 이벤트 리스너 추가
		ButtonListener bl = new ButtonListener();
		
		loginBtn.addActionListener(bl);
		exitBtn.addActionListener(bl);
		joinBtn.addActionListener(bl);
		
		setSize(310, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false); // 사이즈 고정 기본값 true
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			// 텍스트필드에 입력된 아이디, 비번 변수에 초기화
			String uid = id.getText();
			String upass = "";
			
			for(int i = 0; i < pw.getPassword().length; i++) {
				upass = upass + pw.getPassword()[i];
			}
			
			// 종료버튼 이벤트
			if(b.getText().equals("프로그램 종료")) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			// 회원가입 버튼 이벤트
			else if(b.getText().equals("회원가입")) {
				System.out.println("회원 가입");
			}
			// 로그인 버튼 이벤트
			else if(b.getText().equals("로그인")) {
				if(uid.equals("") || upass.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
					System.out.println("로그인 실패 > 로그인 정보 미입력");
				}
				else if(uid != null && upass != null) {
					if(o.db.logincheck(uid, upass)) { // 데이터베이스에 접속해 로그인 정보확인
						System.out.println("로그인 성공");
						JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.");
					}
					else {
						System.out.println("로그인 실패 > 로그인 정보 불일치");
						JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
					}
				}
			}
		}
	}
}
