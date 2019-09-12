import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//Source URL :http://klaue.net16.net/programme/ownprogs/java/visualcryptography.en.php
public class VisualCryptography extends JFrame implements ActionListener {
	private static final long	serialVersionUID			= 1L;
	private JPanel				mainPanel					= new JPanel();

	private JButton				btnAbout					= new JButton("About");
	private JButton				btnGenerateKey				= new JButton("Generate Key");
	private JButton				btnEncrypt					= new JButton("Encrypt Image");
	private JButton				btnGenerateKeyAndEncrypt	= new JButton("<html><center>Generate Key & Encrypt Image at the same time</center></html>");
	private JButton				btnDecrypt					= new JButton("Decrypt Image");

	public static void main(String[] args) {
		new VisualCryptography();
	}

	public VisualCryptography() {
		setTheme();
		// alignment
		btnAbout.setAlignmentX(CENTER_ALIGNMENT);
		btnGenerateKey.setAlignmentX(CENTER_ALIGNMENT);
		btnEncrypt.setAlignmentX(CENTER_ALIGNMENT);
		btnGenerateKeyAndEncrypt.setAlignmentX(CENTER_ALIGNMENT);
		btnDecrypt.setAlignmentX(CENTER_ALIGNMENT);

		// maximize the width
		btnAbout.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnAbout.getMaximumSize().height));
		btnGenerateKey.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnGenerateKey.getMaximumSize().height));
		btnEncrypt.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnEncrypt.getMaximumSize().height));
		btnGenerateKeyAndEncrypt.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnGenerateKeyAndEncrypt.getMaximumSize().height));
		btnDecrypt.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnDecrypt.getMaximumSize().height));

		// action listener
		btnAbout.addActionListener(this);
		btnGenerateKey.addActionListener(this);
		btnEncrypt.addActionListener(this);
		btnGenerateKeyAndEncrypt.addActionListener(this);
		btnDecrypt.addActionListener(this);

		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(btnAbout);
		mainPanel.add(Box.createVerticalStrut(btnAbout.getPreferredSize().height));
		mainPanel.add(btnGenerateKey);
		mainPanel.add(btnEncrypt);
		mainPanel.add(btnGenerateKeyAndEncrypt);
		mainPanel.add(btnDecrypt);

		getContentPane().add(mainPanel);
		setSize(280, 210);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Visual Cryptography");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(btnAbout.getText()))
		{
			new AboutDialog(this);
		}
		else if (e.getActionCommand().equals(btnGenerateKey.getText()))
		{
			new KeyGenFrame(this);
		}
		else if (e.getActionCommand().equals(btnEncrypt.getText()))
		{
			new EncryptFrame(this);
		}
		else if (e.getActionCommand().equals(btnGenerateKeyAndEncrypt.getText()))
		{
			new KeyGenNEncryptFrame(this);
		}
		else if (e.getActionCommand().equals(btnDecrypt.getText()))
		{
			new DecryptFrame(this);
		}
	}

	private void setTheme() {
		try
		{
			javax.swing.UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");

		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
		{

			try
			{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch (Exception err)
			{
				System.err.println("Error In set Theme " + err);
			}
		}
	}

}
