/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class MsgBox {
    	public static void showMessageDialog(Component parent, String content, String title) {
		JOptionPane.showMessageDialog(parent, content, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showErrorDialog(Component parent, String content, String title) {
		JOptionPane.showMessageDialog(parent, content, title, JOptionPane.ERROR_MESSAGE);
	}

	public static int showConfirmDialog(Component parent, String content, String title) {
		int choose = JOptionPane.showConfirmDialog(parent, content, title, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		return choose;
	}

	public static String showInputDialog(Component parent, String content, String title) {
		String choose = JOptionPane.showInputDialog(parent, content, title, JOptionPane.INFORMATION_MESSAGE);
		return choose;
	}
}
