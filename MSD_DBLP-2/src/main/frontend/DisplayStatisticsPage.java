package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import frontend.utils.FavoriteAuthorUtils;
import resources.personrecord.FavoriteStat;
import resources.personrecord.IPerson;

public class DisplayStatisticsPage {

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JButton btnBack;
	private JLabel lblDisplayStatistics;
	private JScrollPane scroller;
	private JPanel statisticsDisplayArea;
	private DefaultTableModel model;
	private JTable statisticsTable;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayStatisticsPage window = new DisplayStatisticsPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayStatisticsPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(0, 0, 1350, 750);
		frame.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		lblDisplayStatistics = new JLabel("DISPLAY STATISTICS");
		lblDisplayStatistics.setForeground(new Color(0, 0, 102));
		lblDisplayStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayStatistics.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 30));
		lblDisplayStatistics.setBounds(485, 45, 380, 75);
		frame.getContentPane().add(lblDisplayStatistics);

		btnBack = new JButton("BACK");
		btnBack.setForeground(new Color(0, 0, 102));
		btnBack.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FavoriteAuthorPage fap = new FavoriteAuthorPage();
				JFrame favoriteAuthorPageFrame = fap.getFrame();

				if(favoriteAuthorPageFrame != null){
					favoriteAuthorPageFrame.setVisible(true);
					getFrame().setVisible(false);
				}

			}
		});
		btnBack.setBounds(485, 140, 380, 40);
		frame.getContentPane().add(btnBack);

		List<IPerson> statisticsList = FavoriteAuthorUtils.getFavriteAuthorStatistics();

		if ( statisticsList.size() > 0 ){

			statisticsDisplayArea = new JPanel();
			statisticsDisplayArea.setLayout(new BoxLayout(statisticsDisplayArea, BoxLayout.Y_AXIS));

			scroller = new JScrollPane(statisticsDisplayArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroller.setBounds(150, 260, 1000, 410);
			frame.getContentPane().add(scroller);

			model = new DefaultTableModel(){

				@Override
				public boolean isCellEditable(int i, int i1) {
					return false; //To change body of generated methods, choose Tools | Templates.
				}

			};

			statisticsTable = new JTable(model);
			statisticsDisplayArea.add(statisticsTable);

			// change from here
			model.addColumn("Person Name");
			model.addColumn("Total publications");
			model.addColumn("Max Publications");
			model.addColumn("Max Publication Title");

			Font font = new Font("Microsoft JhengHei UI", Font.BOLD, 11);

			AttributedString personName = new AttributedString("PERSON NAME");
			personName.addAttribute(TextAttribute.FONT, font);

			AttributedString totalPublicationCount = new AttributedString("TOTAL PUBLICATIONS");
			totalPublicationCount.addAttribute(TextAttribute.FONT, font);

			AttributedString maxPublicationCount = new AttributedString("MAX PUBLICATIONS");
			maxPublicationCount.addAttribute(TextAttribute.FONT, font);

			AttributedString maxPublicationTitle = new AttributedString("MAX PUBLICATION TITLE");
			maxPublicationTitle.addAttribute(TextAttribute.FONT, font);

			model.addRow(new Object[]{personName, totalPublicationCount, maxPublicationCount, maxPublicationTitle});

			for( int i = 0; i < statisticsList.size() ; i++ ){

				FavoriteStat stat = (FavoriteStat) statisticsList.get(i);

				model.addRow(new Object[]{stat.getPersonName(), stat.getTotalPublications(), stat.getMostPublications(), stat.getPublicationTitle()});
				
			}

		}
		else
			model.addRow(new Object[]{"NO RESULTS TO DISPLAY"});

		frame.repaint();


	}

}
