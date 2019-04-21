package edu.mum.ui;

import java.awt.Component;
import java.awt.Point;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class MDIDesktopPane extends JDesktopPane {
	private static int FRAME_OFFSET = 20;

	public MDIDesktopPane() {
	}

	public void setBounds(int x, int y, int w, int h) {
		super.setBounds(x, y, w, h);
	}

	public Component add(JInternalFrame frame) {
		JInternalFrame[] array = getAllFrames();
		Point p;

		Component retval = super.add(frame);

		if (array.length > 0) {
			p = array[0].getLocation();
			p.x = p.x + FRAME_OFFSET;
			p.y = p.y + FRAME_OFFSET;
		} else {
			p = new Point(0, 0);
		}
		frame.setLocation(p.x, p.y);

		moveToFront(frame);
		frame.setVisible(true);
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			frame.toBack();
		}
		return retval;
	}

}