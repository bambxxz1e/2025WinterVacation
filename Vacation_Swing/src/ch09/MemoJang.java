package ch09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MemoJang extends JFrame {
	private JTextArea textArea;

	public MemoJang() {
		setTitle("메모장");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 위치 중앙 고정

		textArea = new JTextArea();
		add(new JScrollPane(textArea), BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");

		JMenuItem saveItem = new JMenuItem("저장");
		JMenuItem openItem = new JMenuItem("열기");

		saveItem.addActionListener(new SaveAction());
		openItem.addActionListener(new OpenAction());

		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		menuBar.add(fileMenu);

		setJMenuBar(menuBar);
	}

	private class SaveAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			// chooser 윈도우 파일창 다이얼로그 생성

			if (fileChooser.showSaveDialog(MemoJang.this) == JFileChooser.APPROVE_OPTION) {
				// 파일창 다이얼로그 띄움 , 파일 경로 반환
				File file = fileChooser.getSelectedFile();
				try (PrintWriter writer = new PrintWriter(file)) {
					writer.write(textArea.getText());
					// 텍스트 입력창 읽어들이기
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private class OpenAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();

			if (fileChooser.showOpenDialog(MemoJang.this) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
					textArea.setText("");
					String line;
					while((line = reader.readLine()) != null) {
						// 라인 하나씩 읽어라
						textArea.append(line + "\n");
						// 그거 출력하고 엔터
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> { // 익명 함수, 충돌 방지, 이벤트를 순차적으로 차근차근 처러할수잇게, 이벤트를 이벤트 스레드에 등록하고 다음 작업을 실행
			MemoJang notepad = new MemoJang();
			notepad.setVisible(true);
		});
	}

}
