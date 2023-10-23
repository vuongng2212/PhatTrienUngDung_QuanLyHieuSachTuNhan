package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCustom extends JTable{
	
	public TableCustom() {
		getTableHeader().setDefaultRenderer(new TableHeader());
		getTableHeader().setPreferredSize(new Dimension(0,35));
		setDefaultRenderer(Object.class, new TableDarkCell());
		setRowHeight(30);
	}
	
	public void fixTable(JScrollPane scroll) {
		scroll.setVerticalScrollBar(new ScrollBarCustom());
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30,30,30));
		scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
		scroll.getViewport().setBackground(new Color(30,30,30));
		scroll.setBorder(BorderFactory.createLineBorder(new Color(60,60,60),2));
	}
	
	private class TableHeader extends DefaultTableCellRenderer{
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			Component com =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			 com.setBackground(new Color(30,30,30));
			 com.setForeground(new Color(200,200,200));
			 com.setFont(com.getFont().deriveFont(Font.BOLD,12));
			 
			return com;
		}
	}
	private class TableDarkCell extends DefaultTableCellRenderer{
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component com =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if(isCellSelected(row, column)) {
				if(row%2==0) {
					com.setBackground(new Color(33,103,153 ));
				}else {
					com.setBackground(new Color(29,86,127));
				}
			}else {
				if(row%2==0) {
					com.setBackground(new Color(50,50,50 ));
				}else {
					com.setBackground(new Color(30,30,30));
				}
			}
			com.setBackground(new Color(200,200,200));
			setBorder(new EmptyBorder(0,5,0,5));
			return com;
		}
	}
	public class ModernScrollBarUI extends BasicScrollBarUI{
		private final int THUMB_SIZE = 80;
		
		@Override
		protected Dimension getMaximumThumbSize() {
			if(scrollbar.getOrientation() == JScrollBar.VERTICAL) {
				return new Dimension(0,THUMB_SIZE);
			}else {
				return new Dimension(THUMB_SIZE,0);
			}
		}
		@Override
		protected Dimension getMinimumThumbSize() {
			if(scrollbar.getOrientation() == JScrollBar.VERTICAL) {
				return new Dimension(0,THUMB_SIZE);
			}else {
				return new Dimension(THUMB_SIZE,0);
			}
		}
	}
	public class ScrollBarCustom extends JScrollBar{
		
		public ScrollBarCustom() {
			setUI(new ModernScrollBarUI());
			setPreferredSize(new Dimension(8,8));
			setBackground(new Color(48,144,216));
			setBackground(new Color(30,30,30));
		}
	}
}
