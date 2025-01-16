package Login;

public class Operator {
	Database db = null;
	MainFrame mf = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operator opt = new Operator();
		opt.db = new Database();
		opt.mf = new MainFrame(opt);
	}
}
